package com.jeannius.interviewprep.Algorithm.dp;



import java.util.Collections;
import java.util.List;



/**
 * Created by Jeannius on 3/25/2019
 */
public class MinimumNumberOfCoinChange {


    public static int  bottomUp(List<Integer> coins, int value){
        int[][] dp = new int[coins.size()][value+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(j==0){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=-1;
                }
            }
        }


        Collections.sort(coins);

        for(int i=0; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int coin = coins.get(i);
                if(coin > j){
                    dp[i][j] = dp[i-1][j];
                }
                if(coin==j){
                    dp[i][j] =1;
                }
                if(coin<j){
                    if(i==0 && j%coin==0){
                        dp[i][j] = j/coin;
                    }
                    else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
                    }
                }

            }
        }
        return dp[coins.size()-1][value];

    }


}
