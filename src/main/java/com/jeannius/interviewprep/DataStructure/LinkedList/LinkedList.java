package com.jeannius.interviewprep.DataStructure.LinkedList;



/**
 * Created by Jeannius on 2/11/2019
 */
public abstract class LinkedList {

    protected Node headSentinel, tailSentinel;
    protected int size =0;

    public abstract void addLast(Node node);
    public abstract void addFirst(Node node);
    public abstract Node removeFirst();
    public abstract Node removeLast();
    public abstract boolean remove(Node node);

    public LinkedList(){
        headSentinel = new Node();
        tailSentinel = new Node();
        headSentinel.setNext(tailSentinel);
    }

    public Node getHead(){
        if(size>0){

            return headSentinel.getNext();
        }
        else{
            return null;
        }
    }

    public Node getTail(){
        return tailSentinel.getPrevious();
    }

    public int getSize(){
        return size;
    }

    public Node peek(){
        if(size>0){
            return new Node(headSentinel.getData());
        }
        return null;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node current = getHead();
        while(current != tailSentinel){
            builder.append(current.getData());
            current = current.getNext();
        }
        return builder.toString();
    }

}
