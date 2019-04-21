package com.jeannius.interviewprep.DataStructure.Tree;



import java.util.Optional;



/**
 * Created by Jeannius on 3/1/2019
 */
public class BinarySearchTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {

    public BinarySearchTreeNode(T value){
        super(value);
    }

    @Override
    public void insert(T value) {
        if(getLeft()==null && value.compareTo((T)this.getData())<=0){
            setLeft(new BinarySearchTreeNode(value));
            return;
        }

        if(getRight()==null && value.compareTo((T)getData())>0){
            setRight(new BinarySearchTreeNode(value));
            return;
        }

        if(getData().compareTo(value)>0){
            recursionInsertion(getLeft(), value);
        }
        else{
            recursionInsertion(getRight(), value);
        }
    }

    private void recursionInsertion(BinaryTreeNode node, T value){

        if(node.getData().compareTo(value)>0){
            if(node.getLeft()==null){
                node.setLeft(new BinarySearchTreeNode(value));
            }else{
                recursionInsertion( node.getLeft(), value);
            }
        }
        else{
            if(node.getRight()==null){
                node.setRight(new BinarySearchTreeNode(value));
            }else{
                recursionInsertion(node.getRight(), value);
            }
        }
    }


    @Override
    public Optional<AbstractNode> find(T value){
        if(this==null || getData()==null){
            return Optional.empty();
        }
        BinaryTreeNode bn = recursionBinarySearch(this, value);
        if(bn==null){
            return Optional.empty();
        }

        return Optional.of(bn);
    }

    private BinaryTreeNode recursionBinarySearch(BinaryTreeNode node, T value){
        if(node==null || node.getData()== value){
            return node;
        }
        if(node.getData().compareTo(value)>0){
            return recursionBinarySearch(node.getLeft(), value);

        }
        else{
            return recursionBinarySearch(node.getRight(), value);
        }
    }




    public static void main(String[] args) {
        BinarySearchTreeNode head = new BinarySearchTreeNode(7);
        head.insert(3);
        head.insert(9);
        head.insert(11);
        head.printTree();

        System.out.println( head.find(9));
    }







}
