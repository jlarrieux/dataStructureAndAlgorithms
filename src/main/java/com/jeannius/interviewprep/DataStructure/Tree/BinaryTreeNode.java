package com.jeannius.interviewprep.DataStructure.Tree;



import java.util.*;



/**
 * Created by Jeannius on 2/26/2019
 */
public class BinaryTreeNode<T extends Comparable<T>> extends AbstractBinaryNode<T > {

    public BinaryTreeNode(T value){
        super(value);
    }



    @Override
    public void insert(T value) {
        if(getLeft()==null){
            setLeft(new BinaryTreeNode(value));
            return;
        }
        if(getRight()==null){
            setRight(new BinaryTreeNode(value));
            return;
        }

        Deque<BinaryTreeNode> q = new ArrayDeque<>();
        if(getLeft()!=null){
            q.offer(getLeft());
        }
        if(getRight()!=null){
            q.offer(getRight());
        }
        BinaryTreeNode val = new BinaryTreeNode(value);
        BinaryTreeNode current=null;
        while(q.size()>0){
            current = q.removeFirst();
            if(current.getLeft()==null){
                current.setLeft(val);
                break;
            }
            else{
                q.offer(current.getLeft());
            }

            if(current.getRight()==null){
                current.setRight(val);
                break;
            }
            else{
                q.offer(current.getRight());
            }
        }

    }



    @Override
    protected boolean delete(T value) {
        if(getData() == value){
            return  true;
        }
        return recursionDelete(getLeft(), value) || recursionDelete(getRight(), value);
    }


    private boolean recursionDelete(BinaryTreeNode node, T value){
        if(node==null){
            return false;
        }

        if(node.getData()==value){
            node = null;
            return true;
        }
        return recursionDelete(node.getLeft(), value) || recursionDelete(node.getRight(), value);

    }


    @Override
    protected Optional<AbstractNode> find(T value) {
        if(getData() ==value){
            return Optional.of(this);
        }
        AbstractNode left = recursionSearch(getLeft(), value);
        if(left !=null){
            return Optional.of(left);
        }
        AbstractNode right= recursionSearch(getRight(), value);
        if(right!=null){
            return Optional.of(right);
        }
        else{
            return Optional.empty();
        }
    }

    private AbstractNode recursionSearch(BinaryTreeNode node, T value){
        if(node==null || node.getData()==value){
            return node;
        }
        AbstractNode left = recursionSearch(node.getLeft(), value);
        if(left!=null){
            return left;
        }
        return recursionSearch(node.getRight(), value);

    }



    /**
     * this does not take into account width of value, it is optimized for single character width value
     */

    @Override
    public void printTree() {

        int height = height(this);

        int i=0, h=1;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(this);
        int frontSpace =0, interval =0;

        while(q.size()>0){
            int currentNumChildren = (int) Math.pow(2,i);

            if(h<height){
                frontSpace= (int) Math.pow(2, height-h)-1;
            }
            else{
                frontSpace=0;
            }
            for(int j=0; j<currentNumChildren; j++){
                BinaryTreeNode curr = q.remove();
                if(j==0){
                    tabber(frontSpace);
                }else{
                    tabber(interval);
                }
                if(curr!=null){
                    System.out.print(curr.getData().toString());
                    q.offer(curr.getLeft());
                    q.offer(curr.getRight());
                }else{
                    System.out.print(" ");
                }



                if(q.size()==0){
                    break;
                }
            }

            i++;
            System.out.println();
            h++;
            interval=frontSpace;
        }

    }




    public void setLeft(AbstractNode node){
        children.add(0, node);
    }

    public void setRight(AbstractNode node){
        if(children.size()==0){
            children.add(null);
        }
        children.add(1, node);
    }

    public BinaryTreeNode getLeft(){
        if(children.size()==0){
            return null;
        }
        return (BinaryTreeNode) children.get(0);
    }

    public BinaryTreeNode getRight(){
        if(children.size()<2){
            return null;
        }
        return (BinaryTreeNode) children.get(1);
    }







    public static void main(String[] args) {
        BinaryTreeNode head = new BinaryTreeNode(1);

        head.insert(2);
        head.insert(3);
        head.insert(4);
        head.insert(5);
        head.insert(6);
        head.insert(7);


        head.printTree();
    }

}
