package com.jeannius.interviewprep.Algorithm.dp;


/**
 * Created by Jeannius on 4/7/2019
 */
public class MinimumEditDistance {


    public static int bottomUp(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i= 0; i<dp.length; i++){
            dp[i][0]=i;
        }

        for(int j= 0; j<dp[0].length; j++){
            dp[0][j]= j;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                if(c1==c2){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j])+1;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
