package com.jeannius.interviewprep.sites.firecode.io;


import com.jeannius.interviewprep.sites.firecode.io.model.TreeNode;


/**
 * Created by Jeannius on 4/9/2019
 */
public class MirrorMirrorOnTheWall {
    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2==null){
            return true;
        }
        return recurse(root1, root2);

    }


    private boolean recurse(TreeNode n1, TreeNode n2){
        System.out.printf("n1: %s, n2: %s\n", printNode(n1), printNode(n2));
        if(n1==null && n2==null){
            return true;
        }
        if((n1==null&& n2!=null)  ||(n1!=null && n2==null)){
            return false;
        }
        if(n1.data!=n2.data){
            return false;
        }
        if((n1.left==null && n2.right!=null)|| (n1.left!=null && n2.right==null)){
            return false;
        }
        if(n1.left.data!= n2.right.data){
            return false;
        }
        else if(n1.right.data!=n2.left.data){
            return false;
        }

        return recurse(n1.left, n2.right) && recurse(n1.right, n2.left);
    }



    private String printNode(TreeNode node){
        if(node==null){
            return "null";
        }

        return String.valueOf(node.data);
    }


    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {1,3,2,7,6,5,4};
        TreeNode n1 = new TreeNode(arr1);
        TreeNode n2 = new TreeNode(arr2);
        System.out.println(new MirrorMirrorOnTheWall().isMirror(n1, n2));
    }
}
