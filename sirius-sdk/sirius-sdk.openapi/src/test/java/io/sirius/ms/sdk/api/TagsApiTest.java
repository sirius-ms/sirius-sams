/*
 *  This file is part of the SIRIUS libraries for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2024 Bright Giant GmbH
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
 *
 *  NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 *  https://openapi-generator.tech
 *  Do not edit the class manually.
 */


package io.sirius.ms.sdk.api;

import io.sirius.ms.sdk.model.TagDefinition;
import io.sirius.ms.sdk.model.TagDefinitionImport;
import io.sirius.ms.sdk.model.TagGroup;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * API tests for TagsApi
 */
@Ignore
public class TagsApiTest {

    private final TagsApi api = new TagsApi();

    
    /**
     * [EXPERIMENTAL] Group tags in the project
     *
     * [EXPERIMENTAL] Group tags in the project. The group name must not exist in the project.   &lt;p&gt;  See &lt;code&gt;/tagged&lt;/code&gt; for filter syntax.  &lt;/p&gt;   [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void addGroupTest()  {
        String projectId = null;
        String groupName = null;
        String filter = null;
        String type = null;
        TagGroup response = api.addGroup(projectId, groupName, filter, type);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Add a possible value to the tag definition in the project
     *
     * [EXPERIMENTAL] Add a possible value to the tag definition in the project.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void addPossibleValuesToTagDefinitionTest()  {
        String projectId = null;
        String tagName = null;
        List<Object> requestBody = null;
        TagDefinition response = api.addPossibleValuesToTagDefinition(projectId, tagName, requestBody);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Add tags to the project
     *
     * [EXPERIMENTAL] Add tags to the project. Tag names must not exist in the project.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void createTagsTest()  {
        String projectId = null;
        List<TagDefinitionImport> tagDefinitionImport = null;
        List<TagDefinition> response = api.createTags(projectId, tagDefinitionImport);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Delete tag groups with the given name from the specified project-space
     *
     * [EXPERIMENTAL] Delete tag groups with the given name from the specified project-space.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void deleteGroupTest()  {
        String projectId = null;
        String groupName = null;
        api.deleteGroup(projectId, groupName);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Delete tag definition with the given name from the specified project-space
     *
     * [EXPERIMENTAL] Delete tag definition with the given name from the specified project-space.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void deleteTagTest()  {
        String projectId = null;
        String tagName = null;
        api.deleteTag(projectId, tagName);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Get tag group by name in the given project-space
     *
     * [EXPERIMENTAL] Get tag group by name in the given project-space.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void getGroupByNameTest()  {
        String projectId = null;
        String groupName = null;
        TagGroup response = api.getGroupByName(projectId, groupName);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Get all tag based groups in the given project-space
     *
     * [EXPERIMENTAL] Get all tag based groups in the given project-space.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void getGroupsTest()  {
        String projectId = null;
        String groupType = null;
        List<TagGroup> response = api.getGroups(projectId, groupType);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Get tag groups by type in the given project-space
     *
     * [EXPERIMENTAL] Get tag groups by type in the given project-space.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void getGroupsByTypeTest()  {
        String projectId = null;
        String groupType = null;
        List<TagGroup> response = api.getGroupsByType(projectId, groupType);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Get tag definition by its name in the given project-space
     *
     * [EXPERIMENTAL] Get tag definition by its name in the given project-space.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void getTagTest()  {
        String projectId = null;
        String tagName = null;
        TagDefinition response = api.getTag(projectId, tagName);

        // TODO: test validations
    }
    
    /**
     * [EXPERIMENTAL] Get all tag definitions in the given project-space
     *
     * [EXPERIMENTAL] Get all tag definitions in the given project-space.  &lt;p&gt;  [EXPERIMENTAL] This endpoint is experimental and not part of the stable API specification. This endpoint can change at any time, even in minor updates.
     */
    @Test
    public void getTagsTest()  {
        String projectId = null;
        String tagScope = null;
        List<TagDefinition> response = api.getTags(projectId, tagScope);

        // TODO: test validations
    }
    
}
