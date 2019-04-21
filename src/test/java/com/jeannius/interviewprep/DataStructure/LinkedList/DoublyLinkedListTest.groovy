package com.jeannius.interviewprep.DataStructure.LinkedList

import spock.lang.Specification

class DoublyLinkedListTest extends Specification {

    def "at the beginning size should be zero"(){
        expect: "should be zero"
        new DoublyLinkedList().getSize()==0;
    }


    def "add one element to linked list should be size 1"(){
        given: "A new empty doubly linked list"
        LinkedList linkedList = new DoublyLinkedList();

        when:"we add an element"
        Node node = new Node("A")
        linkedList.addFirst(node)

        then: "size should be 1"
        assert  linkedList.size==1
        assert linkedList.getHead() == node
    }

    def "add one element to linked list and then remove it, should be size =0"(){
        given: "A new empty doubly linked list"
        LinkedList linkedList = new DoublyLinkedList();

        when:"we add an element and then remove it"
        Node node = new Node(7)
        linkedList.addFirst(node)
        Node removed =linkedList.removeFirst()

        then: "size should be 1"
        assert  linkedList.size==0
        assert  removed ==node
    }



    def"adding one element and then removing it"(){
        given: "A new empty singly linked list"
        LinkedList linkedList = new DoublyLinkedList();

        when:"we add an element and then remove it"
        Node node = new Node(5)
        linkedList.addFirst(node)

        then: "size should be 0"
        assert linkedList.remove(node) ==true;
        assert  linkedList.size==0

    }


    def" acting a 3 node and removing the middle should be fine"(){
        given: "A new empty singly linked list"
        LinkedList linkedList = new DoublyLinkedList();

        when:"we add an element and then remove it"
        Node node = new Node(5)
        linkedList.addFirst(node)
        linkedList.addLast(new Node(6));
        linkedList.addFirst(new Node(4));
//        linkedList.remove(node);


        then: " size should be 2"
        assert  linkedList.size ==2;
        assert linkedList.peek().getData() ==4;
        assert linkedList.removeFirst().getData() ==4;
        assert linkedList.removeFirst().getData()==6;
    }
}
