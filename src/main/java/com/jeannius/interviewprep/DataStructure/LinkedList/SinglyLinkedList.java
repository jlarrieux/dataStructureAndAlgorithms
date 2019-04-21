package com.jeannius.interviewprep.DataStructure.LinkedList;



/**
 * Created by Jeannius on 2/11/2019
 */
public class SinglyLinkedList<T> extends LinkedList{


    @Override
    public void addLast(Node node) {

    }



    public void addFirst(Node node) {
        Node previousHead = getHead();
        headSentinel.setNext(node);
        node.setNext(previousHead);
        size++;
    }



    @Override
    public Node removeFirst() {
        Node first  =getHead();
        if(size>0){
            if(size>1){
                Node nextNext = first.getNext();
                headSentinel.setNext(nextNext);
            }
            size--;
        }

        return first;
    }



    @Override
    public Node removeLast() {
        Node last = null;
        if(getSize()>0){
            Node current = getHead();
            Node previous = headSentinel;
            while(current.getNext() != tailSentinel){
                previous = current;
                current = current.getNext();
            }
            if(previous!=headSentinel){
                previous.setNext(tailSentinel);
            }
            last = current;
            size--;
        }

        return last;
    }



    @Override
    public boolean remove(Node node) {
        Node current = getHead();
        Node previous = headSentinel;
        while(current !=tailSentinel){
            if(current == node){
                previous.setNext(current.getNext());
                size --;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }
}
