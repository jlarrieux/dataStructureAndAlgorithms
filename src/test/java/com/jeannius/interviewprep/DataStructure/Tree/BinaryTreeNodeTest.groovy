package com.jeannius.interviewprep.DataStructure.Tree

import spock.lang.Specification



class BinaryTreeNodeTest extends  Specification{

    def"A blank tree should return null for search"(){
        given: " a blanck tree"
        BinaryTreeNode node = new BinarySearchTreeNode()

        when: " looking for a value"
        Optional<BinaryTreeNode> result = node.find(5)

        then: " we should get false"
        assert result==Optional.empty()
    }

    def"A tree wtih one element should return that element for search"(){
        given: " a blanck tree"
        BinaryTreeNode node = new BinarySearchTreeNode(5)

        when: " looking for a value"
        Optional<BinaryTreeNode> result = node.find(5)

        then: " we should get false"
        assert result.get().getData()==5
    }

    def"A tree with several element return one of the element for search"(){
        given: " a blanck tree"
        BinaryTreeNode node = new BinarySearchTreeNode(5)
        node.insert(7)
        node.insert(9)
        node.insert(3)

        when: " looking for a value"
        Optional<BinaryTreeNode> result = node.find(3)

        then: " we should get false"
        assert result.get().getData()==3
    }

    def"A tree with several element return null if search not found"(){
        given: " a blanck tree"
        BinaryTreeNode node = new BinarySearchTreeNode(5)
        node.insert(7)
        node.insert(9)
        node.insert(3)

        when: " looking for a value"
        Optional<BinaryTreeNode> result = node.find(10)

        then: " we should get false"
        assert result==Optional.empty()
    }
}
