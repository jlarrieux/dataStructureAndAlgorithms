package com.jeannius.interviewprep.sites.firecode.io.model;


import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Jeannius on 2/17/2019
 */
public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    private TreeNode(){

    }

    public TreeNode(int[] arr){
        Queue<com.jeannius.interviewprep.sites.firecode.io.model.TreeNode> q = new LinkedList<>();
        q.offer(this);

        for(int i: arr){
            com.jeannius.interviewprep.sites.firecode.io.model.TreeNode curr = q.remove();
            if(curr ==null){
                curr = new TreeNode();
            }
            curr.data =i;
            curr.left= null;
            q.offer(curr.left);
            curr.right = null;
            q.offer(curr.right);
        }

    }
}
