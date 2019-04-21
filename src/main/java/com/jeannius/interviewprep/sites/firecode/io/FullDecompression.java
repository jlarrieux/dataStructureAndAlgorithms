package com.jeannius.interviewprep.sites.firecode.io;



import com.jeannius.interviewprep.sites.firecode.io.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;



/**
 * Created by Jeannius on 2/17/2019
 */
public class FullDecompression {

    /**
     * Given a String that represents a Binary Tree, write a method - decompressTree that decompresses
     * that tree (reconstructs the tree) and returns the root AbstractNode. The compression algorithm
     * included traversing the tree level by level, from the left to the right. The AbstractNode's
     * data values were appended to the String, delimited by commas. Also, null TreeNodes were denoted
     * by appending an asterisk - *. The input String denotes the structure of a Full Binary
     * Tree - i.e. a tree that is structurally balanced. However, the reconstructed tree may not be
     * a full tree as the String included * characters, which represent null TreeNodes.
     */


    public TreeNode decompressTree(String str){
        if(str==null || str.length()==0 || (str.length()==1 && str.charAt(0)=='*') ){
            return null;
        }

        String[] arr = str.split(",");
        Deque<TreeNode> q = new ArrayDeque<>();
        // Deque<AbstractNode> nextLevel = new ArrayDeque<>();
        TreeNode head = createNode(arr[0]);
        q.offer(head);
        for(int i=1; i<arr.length-1; i +=2){
            TreeNode curr = q.removeFirst();
            System.out.printf("curr: %d\t", curr.data);
            if(curr!=null){
                curr.left = createNode(arr[i]);

                curr.right = createNode(arr[i+1]);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }

        }

        return head;
    }


    private TreeNode createNode(String s){
        if(s.equals('*') || s==null){
            return null;
        }
        return new TreeNode(Integer.valueOf(s));
    }


}
