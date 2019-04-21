package com.jeannius.interviewprep.DataStructure.Tree;



import com.jeannius.interviewprep.DataStructure.LinkedList.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



/**
 * Created by Jeannius on 2/26/2019
 */
public abstract class AbstractNode<T extends Comparable<T>> extends Node {



    protected List<AbstractNode> children = new ArrayList<>();

    public AbstractNode(){

    }

    public AbstractNode(T data){
        super(data);
    }


    protected abstract void insert(T value);
    protected abstract boolean delete(T value);
    protected abstract Optional<AbstractNode> find(T value);
    protected abstract void printTree();
    protected abstract int height(AbstractNode node);

    protected List<? extends AbstractNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    protected void tabber(int n){
        for(int i=0; i<n; i++){
            System.out.print(" ");
        }
    }

}
