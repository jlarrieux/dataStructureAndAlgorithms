package com.jeannius.interviewprep.DataStructure.Tree

import spock.lang.Specification

class BinarySearchTreeTest extends Specification{

    def "Looking up a value from an empty tree should return empty"(){
        given: "a binary find tree"
        BinarySearchTreeNode node = new BinarySearchTreeNode();

        when:"Looking up a value"
        Optional<BinarySearchTreeNode> result = node.find(5)

        then: " result should be null"
        assert result == Optional.empty()

    }


    def "Looking up a value from a tree should return the value"(){
        given: "a binary find tree"
        BinarySearchTreeNode node = new BinarySearchTreeNode(7);
        node.insert(3)
        node.insert(9)

        when:"Looking up a value"
        Optional<BinarySearchTreeNode> result = node.find(9)

        then: " result should be null"
        assert result.get().getData() == 9

    }




}
