package de.unijena.bioinf.FragmentationTreeConstruction.computation.scoring;

import de.unijena.bioinf.ChemistryBase.chem.MolecularFormula;
import de.unijena.bioinf.ChemistryBase.chem.utils.MolecularFormulaScorer;
import de.unijena.bioinf.ChemistryBase.math.DensityFunction;
import de.unijena.bioinf.ChemistryBase.math.LogNormalDistribution;
import de.unijena.bioinf.FragmentationTreeConstruction.model.ProcessedInput;
import de.unijena.bioinf.FragmentationTreeConstruction.model.ProcessedPeak;

import java.util.List;

public class LossSizeScorer implements PeakPairScorer, MolecularFormulaScorer{

    public static final DensityFunction LEARNED_DISTRIBUTION = new LogNormalDistribution(4.057753844479435d, 0.6386804182255676d);
    public static final double LEARNED_NORMALIZATION = -5.860753214730718d;

    private DensityFunction distribution;
    private double normalization;

    public LossSizeScorer() {
        this(LEARNED_DISTRIBUTION, LEARNED_NORMALIZATION);
    }

    public LossSizeScorer(DensityFunction distribution, double normalization) {
        this.distribution = distribution;
        this.normalization = normalization;
    }

    public double getNormalization() {
        return normalization;
    }

    private final double scoring(double mass) {
        return Math.log(distribution.getDensity(mass)) - normalization;
    }

    @Override
    public double score(MolecularFormula formula) {
        return scoring(formula.getMass()) - normalization;
    }

    @Override
    public void score(List<ProcessedPeak> peaks, ProcessedInput input, double[][] scores) {
        for (int fragment=0; fragment < peaks.size(); ++fragment) {
            final double fragmentMass = peaks.get(fragment).getMass();
            for (int parent=fragment+1; parent < peaks.size(); ++parent) {
                final double parentMass = peaks.get(parent).getMass();
                scores[parent][fragment] += scoring(parentMass-fragmentMass);
            }
        }
    }
}
