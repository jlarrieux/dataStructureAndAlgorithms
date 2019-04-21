package com.jeannius.interviewprep.Algorithm.dp;



/**
 * Created by Jeannius on 2/18/2019
 */
public class Knapsack01 {



    public int bottomUpFindMaxProfit(int[] weight, int[] profit, int max){
        if(weight.length != profit.length){
            throw new IllegalStateException("Weight array and profit array should be of same size!");
        }

        if(max==0 || max <0){
            return 0;
        }
        int[][] dp = new int[weight.length+1][max+1];

        for(int w=0; w<weight.length+1; w++ ){
            for(int c=1; c<max+1;  c++){
                if(c==0 || w==0){ //if this is first row or first column
                    dp[w][c] =0;
                    continue;
                }
                if(weight[w-1]<=c){//weight less than capacity
                    dp[w][c] = Math.max(profit[w-1]+ dp[w-1][c-weight[w-1]], dp[w-1][c]);
                }
                else{ //weight greater than capacity
                   dp[w][c] = Math.max(dp[w-1][c], dp[w][c-1]);
                }
            }
        }


        return dp[weight.length][max];

    }


}
