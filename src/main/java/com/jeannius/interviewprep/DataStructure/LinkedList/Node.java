package com.jeannius.interviewprep.DataStructure.LinkedList;



/**
 * Created by Jeannius on 2/11/2019
 */
public class Node<T extends Comparable<T>> {

    protected T data;
    private Node previous, next;

    public Node(T data){
        this.data = data;
    }

    public Node(){

    }


    public T getData() {
        return data;
    }



    public void setData(T data) {
        this.data = data;
    }



    public Node getPrevious() {
        return previous;
    }



    public void setPrevious(Node previous) {
        this.previous = previous;
    }



    public Node getNext() {
        return next;
    }



    public void setNext(Node next) {
        this.next = next;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node<?> node = (Node<?>) o;

        return data.equals(node.data);
    }



    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
