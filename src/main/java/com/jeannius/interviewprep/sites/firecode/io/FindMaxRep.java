package com.jeannius.interviewprep.sites.firecode.io;



import java.util.HashMap;
import java.util.Map;



/**
 * Created by Jeannius on 3/6/2019
 */
public class FindMaxRep {

    public static int getMaxRepetition(int[] a) {
        if(a.length==0 || a.length==1){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i: a){
            map.computeIfPresent(i,(k,v)-> v+1);
            map.putIfAbsent(i, 1);
        }

        int max =0;
        for(int i: map.keySet()){
            int c = map.get(i);
            if(c>max){
                System.out.printf("Updating max of %d to %d\n", max, c);
                max =c;
            }
        }

        return max;

    }



    public static void main(String[] args) {
        int[] a = new int[]{3, 6,1,2,5,7,4,6,2,6};
        System.out.println( getMaxRepetition(a));
    }

}
