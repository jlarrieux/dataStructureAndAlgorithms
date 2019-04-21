package com.jeannius.interviewprep.sites.leetcode.com;


import java.util.Arrays;


/**
 * Created by Jeannius on 4/14/2019
 */
public class NumberOfEnclaves1020 {

    public int numEnclaves(int[][] A) {

        int[] dp = new int[A[0].length];

        Arrays.fill(dp,0);
        int result=0;
        for(int i=0; i<A.length;i++){
            for(int j=0; j<A[0].length;j++){
                int currA = A[i][j];
                int currD =dp[j];
                if(A[i][j]==0){
                    dp[j]=0;
                }else{
                    if(i==0 || j==0){
                        dp[j]=-1;
                    }
                    else if(dp[j-1]==-1){
                        dp[j]=-1;
                    }else if(dp[j]!=-1){
                        dp[j]= dp[j-1]+ dp[j]+1;
                        result = dp[j];
                    }
                }
            }
        }


        return result;

    }


    public int numEnclavesSolOnline(int[][] A){
        if(A.length==0 || A[0].length==0) return 0;
        int result = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(i==0 || i==A.length-1 || j==0 || j==A[0].length-1){
                    if(A[i][j]==1){
                        DFS(A, i, j);
                    }
                }
            }
        }
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(A[i][j]==1){
                    result++;
                }
            }
        }
        return result;
    }

    private void DFS(int[][] A, int i, int j){
        if(i<0 || i>A.length-1 || j<0 || j>A[0].length-1 || A[i][j]==0){
            return;
        }
        A[i][j] = 0;
        DFS(A, i+1, j);
        DFS(A, i-1, j);
        DFS(A, i, j+1);
        DFS(A, i, j-1);
    }


    public static void main(String[] args) {
        int[][] a = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(new NumberOfEnclaves1020().numEnclaves(a));
    }
}
