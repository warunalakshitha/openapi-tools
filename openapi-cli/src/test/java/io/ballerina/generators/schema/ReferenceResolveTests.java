/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.generators.schema;

import io.ballerina.compiler.syntax.tree.SyntaxTree;
import io.ballerina.generators.BallerinaSchemaGenerator;
import io.ballerina.generators.common.TestUtils;
import io.ballerina.openapi.exception.BallerinaOpenApiException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Tests for Schema Reference resolve.
 */
public class ReferenceResolveTests {
    private static final Path RES_DIR = Paths.get("src/test/resources/generators/schema").toAbsolutePath();
    BallerinaSchemaGenerator ballerinaSchemaGenerator = new BallerinaSchemaGenerator();

    @Test(description = "Tests with object type include reference")
    public void testReferenceIncludeWithObjectType() throws IOException, BallerinaOpenApiException {
        SyntaxTree syntaxTree = ballerinaSchemaGenerator.generateSyntaxTree(RES_DIR.resolve("swagger/world_bank.yaml"));
        TestUtils.compareGeneratedSyntaxTreewithExpectedSyntaxTree("schema/ballerina/world_bank.bal", syntaxTree);
    }

    @Test(description = "Test for object data type when absent reference and properties fields")
    public void testWorldBank() throws IOException, BallerinaOpenApiException {
        SyntaxTree syntaxTree = ballerinaSchemaGenerator.generateSyntaxTree(RES_DIR.resolve("swagger" +
                "/object_without_fields_reference.yaml"));
        TestUtils.compareGeneratedSyntaxTreewithExpectedSyntaxTree(
                "schema/ballerina/object_without_fields_reference.bal", syntaxTree);
    }
}