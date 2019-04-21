package com.jeannius.interviewprep.sites.leetcode.com;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Jeannius on 4/15/2019
 */
public class LongestArithmeticSequence1027 {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Integer> map = new HashMap<>(); //max, run

        List<int[]> list = new ArrayList<>();//max, run
        for(int i: A){
            boolean found =false;
            for(int[] j: list){
                int max =j[0];
                if(i>max){
                    j[0] =i;
                    j[1]=j[1]+1;
                    found =true;
                }
            }

            if(!found){
                int[] temp = {i,1};
                list.add(temp);
            }
        }

        int result =0;

        for(int j: map.keySet()){
            System.out.printf("max: %d, run: %d\n", j, map.get(j));
            if(map.get(j)> result){
                result =map.get(j);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {};
    }

}
