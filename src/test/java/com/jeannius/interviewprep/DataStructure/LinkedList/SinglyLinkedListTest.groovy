package com.jeannius.interviewprep.DataStructure.LinkedList

import spock.lang.Specification

class SinglyLinkedListTest  extends Specification{

    def "at the beginning size should be zero"(){
        expect: " should be zero"
        new SinglyLinkedList().getSize()==0;
    }


    def "add one element to linked list should be size 1"(){
        given: "A new empty singly linked list"
        LinkedList linkedList = new SinglyLinkedList();

        when:"we add an element"
        linkedList.addFirst(new Node(5))

        then: "size should be 1"
        assert  linkedList.size==1
    }

    def "add one element to linked list and then remove it, should be size =0 and removed element == original element"(){
        given: "A new empty singly linked list"
        LinkedList linkedList = new SinglyLinkedList();

        when:"we add an element and then remove it"
        Node node = new Node(5)
        linkedList.addFirst(node)
        Node removed = linkedList.removeFirst()

        then: "size should be 1"
        assert  linkedList.size==0
        assert  removed == node
    }


    def"adding one element and then removing it"(){
        given: "A new empty singly linked list"
        LinkedList linkedList = new SinglyLinkedList();

        when:"we add an element and then remove it"
        Node node = new Node("A")
        linkedList.addFirst(node)

        then: "size should be 0"
        assert linkedList.remove(node) ==true;
        assert  linkedList.size==0
    }

    def "removing last element when size is one should have correct behaviour"(){
        given: "A new empty singly linked list"
        LinkedList linkedList = new SinglyLinkedList();

        when:"we add an element and then remove it"
        Node node = new Node(5)
        linkedList.addFirst(node)
        linkedList.removeFirst()

        then: "head should be null"
        assert linkedList.getHead() == null;
    }

    def "Adding last and removing last should be size zero"(){
        given: "An new empty linked list"
        LinkedList linkedList = new SinglyLinkedList();

        when: "WE add an element last and then remove it"
        Node node = new Node("ABC")
        linkedList.addLast(node)
        linkedList.removeLast()

        then: "We should have size zero and head ==null"
        assert linkedList.getSize() ==0
        assert linkedList.getHead() == null
    }

}
