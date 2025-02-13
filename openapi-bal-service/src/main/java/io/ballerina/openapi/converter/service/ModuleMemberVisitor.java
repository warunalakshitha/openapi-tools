/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com). All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.openapi.converter.service;

import io.ballerina.compiler.syntax.tree.ListenerDeclarationNode;
import io.ballerina.compiler.syntax.tree.NodeVisitor;
import io.ballerina.compiler.syntax.tree.TypeDefinitionNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Visitor to get the TypeDefinitionNode and ListenerDeclarationNodes.
 *
 * @since 1.6.0
 */
public class ModuleMemberVisitor extends NodeVisitor {

    LinkedList<TypeDefinitionNode> typeDefinitionNodes = new LinkedList<>();
    LinkedList<ListenerDeclarationNode> listenerDeclarationNodes = new LinkedList<>();

    @Override
    public void visit(TypeDefinitionNode typeDefinitionNode) {
        typeDefinitionNodes.add(typeDefinitionNode);
    }

    @Override
    public void visit(ListenerDeclarationNode listenerDeclarationNode) {
        listenerDeclarationNodes.add(listenerDeclarationNode);
    }

    public List<TypeDefinitionNode> getTypeDefinitionNodes() {
        return typeDefinitionNodes;
    }

    public List<ListenerDeclarationNode> getListenerDeclarationNodes() {
        return listenerDeclarationNodes;
    }
}
