package com.jeannius.interviewprep.DataStructure.LinkedList;



/**
 * Created by Jeannius on 2/11/2019
 */
public class DoublyLinkedList extends LinkedList {


    @Override
    public void addLast(Node node) {

    }



    @Override
    public void addFirst(Node node) {
        Node next = tailSentinel;
        if(getHead()!=null){
            next = getHead().getNext();
        }

        headSentinel.setNext(node);
        node.setNext(next);
        node.setPrevious(headSentinel);
        next.setPrevious(node);

        size++;
    }



    @Override
    public Node removeFirst() {
//        Node next =
        return null;
    }



    @Override
    public Node removeLast() {
        return null;
    }



    @Override
    public boolean remove(Node node) {
        return false;
    }
}
