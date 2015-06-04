/*
 *  This file is part of the SIRIUS library for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2013-2015 Kai Dührkop
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with SIRIUS.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.unijena.bioinf.sirius.cli;

import com.lexicalscope.jewel.cli.CliFactory;
import com.lexicalscope.jewel.cli.HelpRequestedException;
import de.unijena.bioinf.ChemistryBase.chem.*;
import de.unijena.bioinf.ChemistryBase.ms.*;
import de.unijena.bioinf.ChemistryBase.ms.utils.SimpleSpectrum;
import de.unijena.bioinf.FragmentationTreeConstruction.computation.FragmentationPatternAnalysis;
import de.unijena.bioinf.FragmentationTreeConstruction.computation.tree.DPTreeBuilder;
import de.unijena.bioinf.FragmentationTreeConstruction.computation.tree.TreeBuilder;
import de.unijena.bioinf.IsotopePatternAnalysis.IsotopePattern;
import de.unijena.bioinf.IsotopePatternAnalysis.IsotopePatternAnalysis;
import de.unijena.bioinf.babelms.GenericParser;
import de.unijena.bioinf.babelms.MsExperimentParser;
import de.unijena.bioinf.babelms.SpectralParser;
import de.unijena.bioinf.babelms.dot.FTDotWriter;
import de.unijena.bioinf.babelms.json.FTJsonWriter;
import de.unijena.bioinf.babelms.ms.AnnotatedSpectrumWriter;
import de.unijena.bioinf.sirius.IdentificationResult;
import de.unijena.bioinf.sirius.Sirius;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLI {

    protected Sirius sirius;
    protected final boolean shellMode;
    protected ShellProgress progress;

    public static void main(String[] args) {
        final CLI cli = new CLI();
        cli.setArgs(args);
        cli.compute();
    }

    public CLI() {
        this.shellMode = System.console()!=null;
        this.progress = new ShellProgress(System.out, shellMode);
    }

    SiriusOptions options;

    public void compute() {
        try {
            sirius.setProgress(progress);
            final Iterator<Instance> instances = handleInput(options);
            while (instances.hasNext()) {
                final Instance i = instances.next();
                progress.info("Compute '" + i.file.getName() + "'");
                final boolean doIdentify;
                final List<IdentificationResult> results;

                final List<String> whitelist = options.getFormula();
                final Set<MolecularFormula> whiteset = new HashSet<MolecularFormula>();
                if (whitelist==null && (options.getNumberOfCandidates()==null) && i.experiment.getMolecularFormula()!=null) {
                    whiteset.add(i.experiment.getMolecularFormula());
                } else if (whitelist!=null) for (String s :whitelist) whiteset.add(MolecularFormula.parse(s));
                if (whiteset.size()!=1) {
                    results = sirius.identify(i.experiment, getNumberOfCandidates(), !options.isNotRecalibrating(), options.getIsotopes(), whiteset);
                    doIdentify=true;
                } else {
                    doIdentify=false;
                    results = Arrays.asList(sirius.compute(i.experiment, whiteset.iterator().next(), !options.isNotRecalibrating()));
                }

                if (doIdentify) {
                    int rank=1;
                    int n = Math.max(1,(int)Math.ceil(Math.log10(results.size())));
                    for (IdentificationResult result : results) {
                        printf("%"+n+"d.) %s\tscore: %.2f\ttree: %+.2f\tiso: %.2f\tpeaks: %d\t%.2f %%\n", rank++, result.getMolecularFormula().toString(), result.getScore(), result.getTreeScore(), result.getIsotopeScore(), result.getTree().numberOfVertices(), sirius.getMs2Analyzer().getIntensityRatioOfExplainedPeaks(result.getTree())*100);
                    }
                    output(i, results);
                } else {
                    outputSingle(i, results.get(0), whiteset.iterator().next());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer getNumberOfCandidates() {
        return options.getNumberOfCandidates()!=null ? options.getNumberOfCandidates() : 5;
    }

    private void output(Instance instance, List<IdentificationResult> results) throws IOException {
        final int c = getNumberOfCandidates();
        final File target = options.getOutput();
        String format = options.getFormat();
        if (format==null) format = "dot";
        for (IdentificationResult result : results) {
            if (target!=null) {
                final File name = getTargetName(target, instance, result, format,c);
                if (format.equalsIgnoreCase("json")) {
                    new FTJsonWriter().writeTreeToFile(name, result.getTree());
                } else if (format.equalsIgnoreCase("dot")) {
                    new FTDotWriter(!options.isNoHTML(), !options.isNoIon()).writeTreeToFile(name, result.getTree());
                } else {
                    throw new RuntimeException("Unknown format '" + format + "'");
                }
            }
            if (options.isAnnotating()) {
                final File anoName = getTargetName(target!=null ? target : new File("."), instance, result, "csv",c);
                new AnnotatedSpectrumWriter().writeFile(anoName, result.getTree());
            }
        }

    }

    protected void cite() {
        System.out.println("Please cite the following paper when using our method:");
        System.out.println(Sirius.CITATION);
    }

    protected void outputSingle(Instance instance, IdentificationResult result, MolecularFormula formula) throws IOException {
        if (result==null || result.getTree()==null) {
            System.out.println("Cannot find valid tree with molecular formula '" + formula + "' that supports the data. You might try to increase the allowed mass deviation with parameter --ppm-max");
            return;
        }
        result.getTree().normalizeStructure();
        File target = options.getOutput();
        if (target==null) target = new File(".");
        String format;
        final String n = target.getName();
        final int i = n.lastIndexOf('.');
        if (i >= 0) {
            final String ext = n.substring(i+1);
            if (ext.equals("json") || ext.equals("dot")) {
                format = ext;
            } else format = "dot";
        } else {
            if (!target.exists()) target.mkdirs();
            format = "dot";
        }
        if (options.getFormat() != null) {
            format = options.getFormat();
        }

        if (target.isDirectory()) {
            target = getTargetName(target, instance, result, format, 1);
        }

        if (format.equalsIgnoreCase("json")) {
            new FTJsonWriter().writeTreeToFile(target, result.getTree());
        } else if (format.equalsIgnoreCase("dot")) {
            new FTDotWriter(!options.isNoHTML(), !options.isNoIon()).writeTreeToFile(target, result.getTree());
        } else {
            throw new RuntimeException("Unknown format '" + format + "'");
        }
        if (options.isAnnotating()) {
            final File anoName = getTargetName(target, instance, result, "csv", 1);
            new AnnotatedSpectrumWriter().writeFile(anoName, result.getTree());
        }

    }

    private File getTargetName(File target, Instance i, IdentificationResult result, String format, int n) {
        if (!target.isDirectory()) {
            final String name = target.getName();
            final int j = name.lastIndexOf('.');
            if (j>=0) return new File(target.getParentFile(), name.substring(0, j) + "." + format);
            else return new File(target.getParentFile(), name + "." + format);
        } else {
            final String inputName = i.fileNameWithoutExtension();
            final File name;
            if (n<=1) {
                name = new File(target, inputName + "." + format);
            } else {
                name = new File(target, inputName + "_" + result.getRank() + "_" + result.getMolecularFormula().toString() + "." + format);
            }
            return name;
        }
    }

    public void setArgs(String[] args) {
        try {
            this.options = CliFactory.createCli(SiriusOptions.class).parseArguments(args);
            if (options.isCite()) {
                cite();
                System.exit(0);
            }
        } catch (HelpRequestedException e) {
            System.out.println(e.getMessage());
            System.out.println("");
            cite();
            System.exit(0);
        }
        if (options.isVersion()) {
            System.out.println(Sirius.VERSION_STRING);
            cite();
            System.exit(0);
        }
        setup(options);
        // validate
        final File target = options.getOutput();
        if (target != null) {
            if (target.exists() && !target.isDirectory()) {
                System.err.println("Specify a directory name as output directory");
                System.exit(1);
            } else if (target.getName().indexOf('.') < 0){
                target.mkdirs();
            }
        }

        final String format = options.getFormat();
        if (format!=null && !format.equalsIgnoreCase("json") && !format.equalsIgnoreCase("dot")) {
            System.err.println("Unknown file format '" + format + "'. Available are 'dot' and 'json'");
            System.exit(1);
        }
    }

    public void setup(SiriusOptions opts) {
        try {
            this.sirius = new Sirius(opts.getProfile());
            final FragmentationPatternAnalysis ms2 = sirius.getMs2Analyzer();
            final IsotopePatternAnalysis ms1 = sirius.getMs1Analyzer();
            final MutableMeasurementProfile ms1Prof = new MutableMeasurementProfile(ms1.getDefaultProfile());
            final MutableMeasurementProfile ms2Prof = new MutableMeasurementProfile(ms2.getDefaultProfile());

            if (opts.getMedianNoise()!=null) {
                ms2Prof.setMedianNoiseIntensity(opts.getMedianNoise());
            }
            if (opts.getPPMMax() != null) {
                ms2Prof.setAllowedMassDeviation(new Deviation(opts.getPPMMax()));
                ms1Prof.setAllowedMassDeviation(new Deviation(opts.getPPMMax()));
            }
            final TreeBuilder builder = sirius.getMs2Analyzer().getTreeBuilder();
            if (builder instanceof DPTreeBuilder) {
                System.err.println("Cannot load ILP solver. Please read the installation instructions.");
                System.exit(1);
            }
            System.out.println("Compute trees using " + builder.getDescription());

            sirius.getMs2Analyzer().setDefaultProfile(ms2Prof);
            sirius.getMs1Analyzer().setDefaultProfile(ms1Prof);

            /*
            sirius.getMs2Analyzer().setValidatorWarning(new Warning() {
                @Override
                public void warn(String message) {
                    progress.info(message);
                }
            });
            */
        } catch (IOException e) {
            System.err.println("Cannot load profile '" + opts.getProfile() + "':\n");
            e.printStackTrace();
            System.exit(1);
        }
    }

    protected Ms2Experiment extendInput(Ms2Experiment experiment, SiriusOptions opts) {
        final MutableMs2Experiment exp = new MutableMs2Experiment(experiment);
        if (exp.getIonization()==null) {
            exp.setIonization(getIonFromOptions(opts));
        }
        final MutableMeasurementProfile prof;
        if (exp.getMeasurementProfile()==null) {
            prof = new MutableMeasurementProfile();
        } else prof = new MutableMeasurementProfile(exp.getMeasurementProfile());
        if (prof.getFormulaConstraints()==null && experiment.getMolecularFormula()!=null) {
            prof.setFormulaConstraints(getDefaultElementSet(opts, exp.getIonization()).getExtendedConstraints(experiment.getMolecularFormula().elementArray()));
        }
        if (opts.getParentMz() != null && Math.abs(opts.getParentMz() - exp.getIonMass()) < 1e-3) {
            exp.setIonMass(opts.getParentMz());
        }
        if (opts.getMedianNoise() != null) {
            prof.setMedianNoiseIntensity(opts.getMedianNoise());
        }
        if (opts.getPPMMax() != null) {
            prof.setAllowedMassDeviation(new Deviation(opts.getPPMMax()));
        }
        exp.setMeasurementProfile(prof);
        if (opts.getElements()==null) {
            if (exp.getMolecularFormula()!=null) {
                prof.setFormulaConstraints(prof.getFormulaConstraints().getExtendedConstraints(exp.getMolecularFormula().elementArray()));
            } else if (opts.getFormula()!=null && !opts.getFormula().isEmpty()) {
                final HashMap<Element, Integer> bounds = new HashMap<Element, Integer>();
                for (String s : opts.getFormula()) {
                    final MolecularFormula f = MolecularFormula.parse(s);
                    for (Element e : f) {
                        final int i = f.numberOf(e);
                        final Integer I = bounds.get(e);
                        if (I == null || I < i) {
                            bounds.put(e, i);
                        }
                    }
                }
                final FormulaConstraints fc = new FormulaConstraints(new ChemicalAlphabet(bounds.values().toArray(new Element[bounds.size()])));
                for (Map.Entry<Element, Integer> e : bounds.entrySet()) {
                    fc.setUpperbound(e.getKey(), e.getValue());
                }
            } else {
                prof.setFormulaConstraints(prof.getFormulaConstraints().getExtendedConstraints(sirius.predictElements(exp)));
            }
        } else {
            prof.setFormulaConstraints(opts.getElements());
        }
        if (opts.isAutoCharge()) {
            addAdducts(exp, prof, opts);
        }
        return exp;
    }

    private void addAdducts(Ms2Experiment exp, MutableMeasurementProfile prof, SiriusOptions opts) {
        final Ionization ion = exp.getIonization();
        final FormulaConstraints fcOld = prof.getFormulaConstraints();
        FormulaConstraints fcNew = fcOld;
        if (ion instanceof Charge && opts.isAutoCharge()) {
            final PeriodicTable tb = PeriodicTable.getInstance();
            final Element Na = tb.getByName("Na"), K = tb.getByName("K"), Cl = tb.getByName("Cl");
            if (ion.getCharge() > 0) {
                fcNew = fcOld.getExtendedConstraints(Na, K);
                fcNew.setUpperbound(Na, Math.max(1, fcOld.getUpperbound(Na)));
                fcNew.setUpperbound(K, Math.max(1, fcOld.getUpperbound(K)));
            } else {
                fcNew = fcOld.getExtendedConstraints(Cl);
                fcNew.setUpperbound(Cl, Math.max(1, fcOld.getUpperbound(Cl)));
            }
            prof.setFormulaConstraints(fcNew);
        }
    }


    protected void println(String msg) {
        System.out.println(msg);
    }
    protected void printf(String msg, Object... args) {
        System.out.printf(Locale.US, msg, args);
    }

    public Iterator<Instance> handleInput(final SiriusOptions options) throws IOException {
        final ArrayDeque<Instance> instances = new ArrayDeque<Instance>();
        final MsExperimentParser parser = new MsExperimentParser();
        // two different input modes:
        // general information that should be used if this fields are missing in the file
        final Double defaultParentMass = options.getParentMz();
        Ionization ion = getIonFromOptions(options);
        if (ion instanceof Charge) {
            if (!options.isAutoCharge()) {
                ion = (ion.getCharge()>0) ? PeriodicTable.getInstance().ionByName("[M+H]+") : PeriodicTable.getInstance().ionByName("[M-H]-");
            }
        }
        final FormulaConstraints constraints = options.getElements() == null ? null/*getDefaultElementSet(options, ion)*/ : options.getElements();
        // direct input: --ms1 and --ms2 command line options are given
        if (options.getMs2()!=null && !options.getMs2().isEmpty()) {
            final MutableMeasurementProfile profile = new MutableMeasurementProfile();
            profile.setFormulaConstraints(constraints);
            final MutableMs2Experiment exp = new MutableMs2Experiment();
            exp.setMeasurementProfile(profile);
            exp.setIonization(ion);
            exp.setMs2Spectra(new ArrayList<Ms2Spectrum<Peak>>());
            for (File f : foreachIn(options.getMs2())) {
                final Iterator<Ms2Spectrum<Peak>> spiter = SpectralParser.getParserFor(f).parseSpectra(f);
                while (spiter.hasNext()) {
                    final Ms2Spectrum<Peak> spec = spiter.next();
                    if (spec.getIonization()==null || spec.getPrecursorMz()==0 || spec.getMsLevel()==0) {
                        final MutableMs2Spectrum ms;
                        if (spec instanceof MutableMs2Spectrum) ms = (MutableMs2Spectrum)spec;
                        else ms = new MutableMs2Spectrum(spec);
                        if (ms.getIonization()==null) ms.setIonization(ion);
                        if (ms.getMsLevel()==0) ms.setMsLevel(2);
                        if (ms.getPrecursorMz()==0) {
                            if (defaultParentMass==null) {
                                if (exp.getMs2Spectra().size()>0) {
                                    ms.setPrecursorMz(exp.getMs2Spectra().get(0).getPrecursorMz());
                                } else {
                                    final MolecularFormula formula;
                                    if (exp.getMolecularFormula()!=null) formula = exp.getMolecularFormula();
                                    else if (options.getFormula()!=null && options.getFormula().size()==1) formula = MolecularFormula.parse(options.getFormula().get(0)); else formula=null;
                                    if (formula != null) {
                                        ms.setPrecursorMz(ms.getIonization().addToMass(formula.getMass()));
                                    } else ms.setPrecursorMz(0);
                                }
                            } else {
                                ms.setPrecursorMz(defaultParentMass);
                            }
                        }
                    }
                    exp.getMs2Spectra().add(spec);
                }
            }
            if (exp.getMs2Spectra().size() <= 0) throw new IllegalArgumentException("SIRIUS expect at least one MS/MS spectrum. Please add a MS/MS spectrum via --ms2 option");

            if (options.getMs2()!=null &&  options.getMs1() != null && !options.getMs1().isEmpty()) {
                exp.setMs1Spectra(new ArrayList<Spectrum<Peak>>());
                for (File f : options.getMs1()) {
                    final Iterator<Ms2Spectrum<Peak>> spiter = SpectralParser.getParserFor(f).parseSpectra(f);
                    while (spiter.hasNext()) {
                        exp.getMs1Spectra().add(new SimpleSpectrum(spiter.next()));
                    }
                }
            }

            final double expPrecursor;
            if (options.getParentMz()!=null) {
                expPrecursor = options.getParentMz();
            }else if (exp.getMolecularFormula()!=null) {
                expPrecursor = exp.getIonization().addToMass(exp.getMolecularFormula().getMass());
            } else {
                double prec=0d;
                for (int k=1; k < exp.getMs2Spectra().size(); ++k) {
                    final double pmz = exp.getMs2Spectra().get(k).getPrecursorMz();
                    if (pmz!=0 && Math.abs(pmz - exp.getMs2Spectra().get(0).getPrecursorMz()) > 1e-3) {
                        throw new IllegalArgumentException("The given MS/MS spectra have different precursor mass and cannot belong to the same compound");
                    } else if (pmz != 0) prec = pmz;
                }
                if (prec == 0) {
                    if (exp.getMs1Spectra().size()>0) {
                        final List<IsotopePattern> patterns = sirius.getMs1Analyzer().deisotope(exp);
                        if (patterns.size()>0) {
                            double pmz2 = patterns.get(0).getMonoisotopicMass();
                            for (IsotopePattern pat : patterns) {
                                if (Math.abs(pmz2-pat.getMonoisotopicMass()) > 1e-3) {
                                    throw new IllegalArgumentException("SIRIUS cannot infer the parentmass of the measured compound from MS1 spectrum. Please provide it via the -z option.");
                                }
                            }
                            prec = pmz2;
                        } else throw new IllegalArgumentException("SIRIUS expects the parentmass of the measured compound as parameter. Please provide it via the -z option.");
                    }
                }
                expPrecursor=prec;
            }


            exp.setIonMass(expPrecursor);
            instances.add(new Instance(extendInput(exp, options), options.getMs2().get(0)));
        } else if (options.getMs1()!=null && !options.getMs1().isEmpty()) {
            throw new IllegalArgumentException("SIRIUS expect at least one MS/MS spectrum. Please add a MS/MS spectrum via --ms2 option");
        }
        // batch input: files containing ms1 and ms2 data are given
        if (options.getInput()!=null && !options.getInput().isEmpty()) {
            final Iterator<File> fileIter;
            final ArrayList<File> infiles = new ArrayList<File>();
            for (String f : options.getInput()) {
                final File g = new File(f);
                if (g.isDirectory()) {infiles.addAll(Arrays.asList(g.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.isFile();
                    }
                })));} else {
                    infiles.add(g);
                }
            }
            fileIter=infiles.iterator();
            return new Iterator<Instance>() {
                Iterator<Ms2Experiment> experimentIterator = fetchNext();
                File currentFile;
                @Override
                public boolean hasNext() {
                    return !instances.isEmpty();
                }

                @Override
                public Instance next() {
                    fetchNext();
                    Instance c = instances.poll();
                    return new Instance(extendInput(c.experiment,options), c.file);
                }

                private Iterator<Ms2Experiment> fetchNext() {
                    while (true) {
                        if (experimentIterator==null || !experimentIterator.hasNext()) {
                            if (fileIter.hasNext()) {
                                currentFile = fileIter.next();
                                try {
                                    GenericParser<Ms2Experiment> p = parser.getParser(currentFile);
                                    if (p==null) {
                                        System.err.println("Unknown file format: '" + currentFile + "'");
                                    } else experimentIterator = p.parseFromFileIterator(currentFile);
                                } catch (IOException e) {
                                    System.err.println("Cannot parse file '" + currentFile + "':\n");
                                    e.printStackTrace();
                                }
                            } else return null;
                        } else {
                            instances.push(new Instance(experimentIterator.next(), currentFile));
                            return experimentIterator;
                        }
                    }
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        } else {
            return instances.iterator();
        }
    }

    private List<File> foreachIn(List<File> ms2) {
        final List<File> queue = new ArrayList<File>();
        for (File f : ms2) {
            if (f.isDirectory()) {
                for (File g : f.listFiles())
                    if (!g.isDirectory())
                        queue.add(g);
            } else queue.add(f);
        }
        return queue;
    }


    private static final Pattern CHARGE_PATTERN = Pattern.compile("(\\d+)[+-]?");
    private static final Pattern CHARGE_PATTERN2 = Pattern.compile("[+-]?(\\d+)");

    protected static Ionization getIonFromOptions(SiriusOptions opt) {
        String ionStr = opt.getIon();
        if (ionStr==null) {
            if (opt.isAutoCharge()) return new Charge(1);
            else return PeriodicTable.getInstance().ionByName("[M+H]+");
        }
        final Matcher m1 = CHARGE_PATTERN.matcher(ionStr);
        final Matcher m2 = CHARGE_PATTERN2.matcher(ionStr);
        final Matcher m = m1.matches() ? m1 : (m2.matches() ? m2 : null);
        if (m != null) {
            if (m.group(1)!=null && ionStr.contains("-")) {
                return new Charge(-Integer.parseInt(m.group(1)));
            } else {
                return new Charge(Integer.parseInt(m.group(1)));
            }
        } else {
            final Ionization ion = PeriodicTable.getInstance().ionByName(ionStr);
            if (ion==null)
                throw new IllegalArgumentException("Unknown ionization mode '" + ionStr + "'");
            else return ion;
        }
    }
    private final static FormulaConstraints DEFAULT_ELEMENTS = new FormulaConstraints("CHNOP[5]S");
    public FormulaConstraints getDefaultElementSet(SiriusOptions opts, Ionization ion) {
        final FormulaConstraints cf = (opts.getElements()!=null) ? opts.getElements() : DEFAULT_ELEMENTS;
        return cf;
    }
}
