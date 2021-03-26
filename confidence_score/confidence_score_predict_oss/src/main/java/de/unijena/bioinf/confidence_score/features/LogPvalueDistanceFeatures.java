/*
 *
 *  This file is part of the SIRIUS library for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2013-2020 Kai Dührkop, Markus Fleischauer, Marcus Ludwig, Martin A. Hoffman and Sebastian Böcker,
 *  Chair of Bioinformatics, Friedrich-Schilller University.
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 3 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with SIRIUS. If not, see <https://www.gnu.org/licenses/lgpl-3.0.txt>
 */

package de.unijena.bioinf.confidence_score.features;

import de.unijena.bioinf.ChemistryBase.algorithm.ParameterHelper;
import de.unijena.bioinf.ChemistryBase.algorithm.scoring.Scored;
import de.unijena.bioinf.ChemistryBase.chem.CompoundWithAbstractFP;
import de.unijena.bioinf.ChemistryBase.data.DataDocument;
import de.unijena.bioinf.ChemistryBase.fp.Fingerprint;
import de.unijena.bioinf.ChemistryBase.fp.ProbabilityFingerprint;
import de.unijena.bioinf.chemdb.FingerprintCandidate;
import de.unijena.bioinf.confidence_score.FeatureCreator;
import de.unijena.bioinf.fingerid.blast.parameters.ParameterStore;
import org.jetbrains.annotations.Nullable;

/**
 * Created by martin on 20.06.18.
 */


/**
 *
 *
 computes distance features, max distance is variable, so are scorers. Top scoring hit is FIXED at this point!


 */


public class LogPvalueDistanceFeatures implements FeatureCreator {
    private int[] distances;
    private int feature_size;
    Scored<FingerprintCandidate>[] rankedCandidates;
    Scored<FingerprintCandidate>[] rankedCandidates_filtered;
    public int weight_direction=1;


    public LogPvalueDistanceFeatures(Scored<FingerprintCandidate>[] rankedCandidates,Scored<FingerprintCandidate>[] rankedCandidates_filtered,int... distances){

        this.distances=distances;
        feature_size=distances.length;
        this.rankedCandidates=rankedCandidates;
        this.rankedCandidates_filtered=rankedCandidates_filtered;

    }

    @Override
    public int weight_direction() {
        return weight_direction;
    }

    @Override
    public double[] computeFeatures(@Nullable ParameterStore ignored) {

        assert  rankedCandidates[0].getScore()>=rankedCandidates[rankedCandidates.length-1].getScore();
        PvalueScoreUtils putils = new PvalueScoreUtils();

        double[] scores =  new double[feature_size];

        int pos = 0;

        for (int j = 0; j < distances.length; j++) {

            int additional_shift=0;
            while (rankedCandidates_filtered[distances[j]+additional_shift].getCandidate().getFingerprint().toOneZeroString().equals(rankedCandidates_filtered[0].getCandidate().getFingerprint().toOneZeroString())){
                additional_shift+=1;
            }


            double pvalue1=putils.computePvalueScore(rankedCandidates,rankedCandidates_filtered, rankedCandidates_filtered[0]);
            double pvalue2 = putils.computePvalueScore(rankedCandidates,rankedCandidates_filtered,rankedCandidates_filtered[distances[j]+additional_shift]);
            if(pvalue1-pvalue2==0){
                System.out.println("pvaluedist "+pvalue1+" "+pvalue2+" "+rankedCandidates.length+" "+additional_shift);
                scores[pos++]=-20;
            }else {

                scores[pos++] = Math.log(Math.abs(putils.computePvalueScore(rankedCandidates, rankedCandidates_filtered, rankedCandidates_filtered[0]) - putils.computePvalueScore(rankedCandidates, rankedCandidates_filtered, rankedCandidates_filtered[distances[j] + additional_shift])));

            }
        }

        assert pos == scores.length;
        return scores;



    }

    @Override
    public int getFeatureSize() {
        return distances.length;
    }

    @Override
    public boolean isCompatible(ProbabilityFingerprint query, CompoundWithAbstractFP<Fingerprint>[] rankedCandidates) {
        return false;
    }

    @Override
    public int getRequiredCandidateSize() {
        return distances.length;
    }

    @Override
    public String[] getFeatureNames()
    {
        String[] name=  new String[distances.length];
        for(int i=0;i<distances.length;i++){
            name[i]="LogdistancePvalue_"+distances[i];
        }
        return name;
    }

    @Override
    public <G, D, L> void importParameters(ParameterHelper helper, DataDocument<G, D, L> document, D dictionary) {

    }

    @Override
    public <G, D, L> void exportParameters(ParameterHelper helper, DataDocument<G, D, L> document, D dictionary) {

    }
}
