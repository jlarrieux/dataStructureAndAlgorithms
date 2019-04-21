package com.jeannius.interviewprep.sites.leetcode.com;


import java.util.PriorityQueue;
import java.util.TreeSet;


/**
 * Created by Jeannius on 4/15/2019
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null && nums.length<3){
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for(int i: nums){
            set.add(i);
        }

        int close =nums[0];

        for(int i=0; i<nums.length-1; i++){
            int curr = nums[i];
            for(int j=i+1; j<nums.length; j++){
                int next = nums[j];
                int val = target - (curr+next);
                int floor = set.floor(val);
                int ceiling = set.ceiling(val);

                int temp = target- floor> target - ceiling? ceiling: floor;
                close = Math.min(close, temp);

            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        return close;

    }


    public static void main(String[] args) {
        System.out.println(-2147483648 / 2);
    }
}
