package com.jeannius.interviewprep.sites.firecode.io;


import java.util.Deque;
import java.util.LinkedList;


/**
 * Created by Jeannius on 4/17/2019
 */
public class MatrixMaxSumPathWithDFS {

    public static int matrixMaxSumDfs(int[][] grid) {
        class TravelNode{
            int row;
            int col;
            int nodeSum;

            public TravelNode (int r, int c, int sum, int[][] grid){
                row =r;
                col = c;
                sum += grid[r][c];
                nodeSum = sum;
            }


        }
        int max = Integer.MIN_VALUE;
        int bottom = grid.length-1;
        int right = grid[0].length-1;
        Deque<TravelNode> stack = new LinkedList<>();
        stack.addFirst(new TravelNode(0,0,0,grid));

        while(!stack.isEmpty()){
            TravelNode curr = stack.pop();
            if(curr.row==bottom && curr.col ==right){
                max = Math.max(max, curr.nodeSum);
            }else {
                if (curr.row < bottom ) {
                    stack.push(new TravelNode(curr.row + 1, curr.col, curr.nodeSum, grid));
                }

                if(curr.col<right){
                    stack.push(new TravelNode(curr.row, curr.col + 1, curr.nodeSum, grid));
                }
            }
        }

        return max;

    }




    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println( MatrixMaxSumPathWithDFS.matrixMaxSumDfs(m));
    }

}
