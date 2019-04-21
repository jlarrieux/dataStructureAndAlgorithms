package com.jeannius.interviewprep.DataStructure.Tree;



/**
 * Created by Jeannius on 3/1/2019
 */
public abstract class AbstractBinaryNode<T extends Comparable<T>> extends AbstractNode<T> {

    public AbstractBinaryNode(T value){
        super(value);
    }



    @Override
    final protected int height(AbstractNode node) {
        if(node==null){
            return 0;
        }
        BinaryTreeNode binaryTreeNode = (BinaryTreeNode) node;
        int ch = Math.max(height(binaryTreeNode.getLeft()), height(binaryTreeNode.getRight()) );
        return ch+1;
    }


    public int height(){
        return height(this);
    }

}
