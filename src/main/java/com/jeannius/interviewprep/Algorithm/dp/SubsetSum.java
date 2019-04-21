package com.jeannius.interviewprep.Algorithm.dp;



import java.util.List;



/**
 * Created by Jeannius on 3/3/2019
 * Given a set and a value, is there a subset that adds to the value
 */
public class SubsetSum {


    public static boolean subsetSum(List<Integer> set, int value){
        Boolean[][] dp = new Boolean [set.size()+1 ][ value+1];
        for(int i=0; i<set.size()+1; i++){
            for(int j=0; j<value+1; j++){
                dp[i][j] =null;
            }
        }

        for(int i=0; i<set.size()+1 ; i++){
            for(int j=0; j< value+1; j++){
                if(j==0){
                    dp[i][j]= true;
                    continue;
                }
                else if(i==0){
                    dp[i][j]= false;
                    continue;
                }
                int current = set.get(i-1);

                if(current==j){
                    dp[i][j]= true;
                }
                 else if(current>j){
                     dp[i][j] = dp[i-1][j];
                }
                 else if(current<j){
                     dp[i][j] = dp[i-1][j-current] || dp[i-1][j];
                }


            }
        }

        return dp[set.size()][value];

    }


}
