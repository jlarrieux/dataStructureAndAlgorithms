package com.jeannius.interviewprep.sites.firecode.io;



import com.jeannius.interviewprep.sites.firecode.io.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;



/**
 * Created by Jeannius on 2/17/2019
 */
public class BinaryTreeSerialization {

    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.



    public static void main(String[] args) {
        TreeNode head = build();
        BinaryTreeSerialization binaryTreeSerialization = new BinaryTreeSerialization();
        String s= binaryTreeSerialization.serializeTree(head);
        binaryTreeSerialization.restoreTree(s);

    }

    private static TreeNode build(){
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(3, six, seven);
        return new TreeNode(1, two, three);
    }

    public String serializeTree(TreeNode root){
        System.out.println("Serializing!");
        if(root==null){
            return "*";
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        StringBuilder builder = new StringBuilder();
        writeToBuilder(builder, root);
        while(q.size()>0){
            System.out.printf("S-- with builder: %s and q.size: %d\t", builder.toString(), q.size());
            TreeNode curr = q.removeFirst();
            System.out.printf("after removal q.size: %d\n", q.size());
            writeToBuilder(builder, curr.left);
            writeToBuilder(builder, curr.right);
            if(curr.left!=null){
                q.offer(curr.left);
            }

            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        System.out.println(builder.toString());
        return builder.toString();

    }

    private void writeToBuilder(StringBuilder builder, TreeNode node){
        if(builder.length()>0){
            builder.append(",");
        }

        if(node==null){
            builder.append("*");
        }
        else{
            builder.append(node.data);
        }
    }

    public TreeNode restoreTree(String str){
        System.out.printf("\nRestoring! with s: %s\n", str);
        if(str==null || str.length()==0 || (str.length()==1 && str.charAt(0)=='*')){
            return null;
        }

        String[] arr = str.split(",");
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode head = createNode(arr[0]);
        q.offer(head);

        for(int i=1; i<arr.length;i+=2){
            TreeNode curr = q.removeFirst();
            if(curr!=null){
                System.out.printf("Not null: %d\n", curr.data);
                curr.left = createNode(arr[i]);
                curr.right = createNode(arr[i+1]);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }

        }

        return head;
    }

    private TreeNode createNode(String s){
        if(s==null || s.length()==0 || (s.length()==1 && s.charAt(0)=='*')){
            return null;
        }
        return new TreeNode(Integer.valueOf(s));
    }










}
