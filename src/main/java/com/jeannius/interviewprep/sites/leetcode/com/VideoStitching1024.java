package com.jeannius.interviewprep.sites.leetcode.com;


import com.jeannius.interviewprep.util.Util;

import java.util.Arrays;


/**
 * Created by Jeannius on 4/13/2019
 */
public class VideoStitching1024 {


    public int videoStitching(int[][] clips, int T) {
        int n = clips.length;
        if(T<1 || n==0){
            return -1;
        }

        if(findMin(clips)>0){
            return -1;
        }
        Arrays.sort(clips, (int[] i1, int[] i2)-> i1[1]-i2[1]);
        Util.print2DintArray(clips);
        if(clips[n-1][1]< T){
            return -1;
        }
        int[][] memo = new int[clips.length+1][T+1];
        fillMemo(memo);

        for(int i=1; i<memo.length; i++){
            for(int j=1; j<memo[0].length; j++){
                if(j-1>=clips[i-1][1]){
                    memo[i][j] = 0;
                }
                else if(j-1<clips[i-1][0]){
                    memo[i][j] = memo[i-1][j];

                }
                else{
                    int top = memo[i-1][j];
                    int csJ= j- (j-1-clips[i-1][0])-1;
                    int cs= memo[i] [csJ];
                    if(top==0 && cs==0 && csJ>0){
                        memo[i][j]=0;
                    }
                    else{
                        if(cs==0){
                            memo[i][j] = 1;
                        }
                        else{
                            memo[i][j] = Math.min(top==0? cs+1:top, cs+1);
                        }


                    }


                }
            }
        }
        return memo[clips.length][T];
    }



    private void fillMemo(int[][] memo){
        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[0].length; j++){
                if(j==0 || i==0){
                    memo[i][j] =0;
                }
                else{
                    memo[i][j] = -1;
                }
            }
        }
    }

    private int findMin(int[][] clips){
        int min =clips[0][0];
        for(int[] c: clips){
            if(c[0]<min){
                min = c[0];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,4},{2,8}};
        int result = new VideoStitching1024().videoStitching(arr, 5);

        System.out.printf("\n%d\n",result);

    }

}
