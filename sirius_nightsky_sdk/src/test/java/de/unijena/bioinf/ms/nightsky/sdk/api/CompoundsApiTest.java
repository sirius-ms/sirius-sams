/*
 * SIRIUS Nightsky API
 * REST API that provides the full functionality of SIRIUS and its web services as background service. It is intended as entry-point for scripting languages and software integration SDKs.This API is exposed by SIRIUS 6.0.0-SNAPSHOT
 *
 * The version of the OpenAPI document: 2.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.unijena.bioinf.ms.nightsky.sdk.api;

import de.unijena.bioinf.ms.nightsky.sdk.client.ApiException;
import de.unijena.bioinf.ms.nightsky.sdk.model.AlignedFeatureOptField;
import de.unijena.bioinf.ms.nightsky.sdk.model.Compound;
import de.unijena.bioinf.ms.nightsky.sdk.model.CompoundOptField;
import de.unijena.bioinf.ms.nightsky.sdk.model.PageCompound;
import de.unijena.bioinf.ms.nightsky.sdk.model.SearchQueryType;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * API tests for CompoundsApi
 */
@Ignore
public class CompoundsApiTest {

    private final CompoundsApi api = new CompoundsApi();

    
    /**
     * Delete compound (group of ion identities) with the given identifier (and the included features) from the  specified project-space.
     *
     * Delete compound (group of ion identities) with the given identifier (and the included features) from the  specified project-space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteCompoundTest() throws ApiException {
        String projectId = null;
        String compoundId = null;
        
        api.deleteCompound(projectId, compoundId);
        
        // TODO: test validations
    }
    
    /**
     * Get compound (group of ion identities) with the given identifier from the specified project-space.
     *
     * Get compound (group of ion identities) with the given identifier from the specified project-space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCompoundTest() throws ApiException {
        String projectId = null;
        String compoundId = null;
        List<CompoundOptField> optFields = null;
        List<AlignedFeatureOptField> optFieldsFeatures = null;
        Compound response = 
        api.getCompound(projectId, compoundId, optFields, optFieldsFeatures);
        
        // TODO: test validations
    }
    
    /**
     * Get all available compounds (group of ion identities) in the given project-space.
     *
     * Get all available compounds (group of ion identities) in the given project-space.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCompoundsTest() throws ApiException {
        String projectId = null;
        Integer page = null;
        Integer size = null;
        List<String> sort = null;
        String searchQuery = null;
        SearchQueryType querySyntax = null;
        List<CompoundOptField> optFields = null;
        List<AlignedFeatureOptField> optFieldsFeatures = null;
        PageCompound response = 
        api.getCompounds(projectId, page, size, sort, searchQuery, querySyntax, optFields, optFieldsFeatures);
        
        // TODO: test validations
    }
    
}
