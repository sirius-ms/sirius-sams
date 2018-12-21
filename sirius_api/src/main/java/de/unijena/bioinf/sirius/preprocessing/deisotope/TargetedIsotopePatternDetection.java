package de.unijena.bioinf.sirius.preprocessing.deisotope;

import com.google.common.collect.Range;
import de.unijena.bioinf.ChemistryBase.chem.ChemicalAlphabet;
import de.unijena.bioinf.ChemistryBase.chem.Element;
import de.unijena.bioinf.ChemistryBase.chem.FormulaConstraints;
import de.unijena.bioinf.ChemistryBase.chem.PeriodicTable;
import de.unijena.bioinf.ChemistryBase.ms.*;
import de.unijena.bioinf.ChemistryBase.ms.ft.Ms1IsotopePattern;
import de.unijena.bioinf.ChemistryBase.ms.ft.model.FormulaSettings;
import de.unijena.bioinf.ChemistryBase.ms.utils.SimpleMutableSpectrum;
import de.unijena.bioinf.ChemistryBase.ms.utils.SimpleSpectrum;
import de.unijena.bioinf.ChemistryBase.ms.utils.Spectrums;
import de.unijena.bioinf.FragmentationTreeConstruction.model.ProcessedInput;
import de.unijena.bioinf.ms.annotations.Provides;
import de.unijena.bioinf.ms.annotations.Requires;

import java.util.ArrayList;

@Requires(MergedMs1Spectrum.class)
@Provides(Ms1IsotopePattern.class)
public class TargetedIsotopePatternDetection implements IsotopePatternDetection {

    protected SimpleSpectrum extractSpectrum(ProcessedInput processedInput) {
        final Ms2Experiment experiment = processedInput.getExperimentInformation();
        final SimpleSpectrum ms1 = processedInput.getAnnotationOrThrow(MergedMs1Spectrum.class).mergedSpectrum;
        final ChemicalAlphabet stdalphabet;
        if (experiment.getMolecularFormula()!=null) {
            stdalphabet = ChemicalAlphabet.alphabetFor(processedInput.getExperimentInformation().getMolecularFormula());
        } else if (processedInput.hasAnnotation(FormulaConstraints.class)) {
            stdalphabet = processedInput.getAnnotation(FormulaConstraints.class).getChemicalAlphabet();
        } else {
            FormulaSettings fs = processedInput.getAnnotationOrDefault(FormulaSettings.class);
            stdalphabet = fs.getEnforcedAlphabet().getExtendedConstraints(fs.getFallbackAlphabet()).getExtendedConstraints(fs.getAutoDetectionElements().toArray(new Element[0])).getChemicalAlphabet();
        }

        final Spectrum<Peak> massOrderedSpectrum = Spectrums.getMassOrderedSpectrum(ms1);
        final ArrayList<SimpleSpectrum> patterns = new ArrayList<SimpleSpectrum>();
        MS1MassDeviation dev = processedInput.getAnnotationOrDefault(MS1MassDeviation.class);
        final int index = Spectrums.mostIntensivePeakWithin(massOrderedSpectrum, experiment.getIonMass(), dev.allowedMassDeviation);
        if (index < 0) return null;
        final SimpleMutableSpectrum spec = new SimpleMutableSpectrum();
        spec.addPeak(massOrderedSpectrum.getPeakAt(index));
        // add additional peaks
        final PeriodicTable T = PeriodicTable.getInstance();
        for (int k=1; k <= 5; ++k) {
            final Range<Double> nextMz = T.getIsotopicMassWindow(stdalphabet, dev.allowedMassDeviation, spec.getMzAt(0), k);
            final double a = nextMz.lowerEndpoint();
            final double b = nextMz.upperEndpoint();
            final double startPoint = a - dev.massDifferenceDeviation.absoluteFor(a);
            final double endPoint = b + dev.massDifferenceDeviation.absoluteFor(b);
            final int nextIndex = Spectrums.indexOfFirstPeakWithin(massOrderedSpectrum, startPoint, endPoint);
            if (nextIndex < 0) break;
            double mzBuffer = 0d;
            double intensityBuffer = 0d;
            for (int i=nextIndex; i < massOrderedSpectrum.size(); ++i) {
                final double mz = massOrderedSpectrum.getMzAt(i);
                if (mz > endPoint) break;
                final double intensity = massOrderedSpectrum.getIntensityAt(i);
                mzBuffer += mz*intensity;
                intensityBuffer += intensity;
            }
            mzBuffer /= intensityBuffer;
            spec.addPeak(mzBuffer, intensityBuffer);
        }
        return new SimpleSpectrum(spec);
    }

    @Override
    public void detectIsotopePattern(ProcessedInput processedInput) {
        processedInput.setAnnotation(Ms1IsotopePattern.class, new Ms1IsotopePattern(extractSpectrum(processedInput), 0d));
    }
}
