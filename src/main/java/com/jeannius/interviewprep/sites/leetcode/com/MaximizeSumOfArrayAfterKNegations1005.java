package com.jeannius.interviewprep.sites.leetcode.com;



/**
 * Created by Jeannius on 3/9/2019
 */
public class MaximizeSumOfArrayAfterKNegations1005 {

    public static int largestSumAfterKNegations(int[] A, int k) {
//        PriorityQueue<Integer> set = new PriorityQueue<>();
//
//        int negCount =0;
//        for(int i: A){
//            if(i<0){
//                negCount++;
//            }
//            set.add(i);
//        }
//
//        int sum =0;
//        int flip = k;
//        Iterator<Integer> it = set.iterator();
//        if(negCount>0) {
//            while (it.hasNext()) {
//                if (flip > 0 && negCount > 0) {
//                    set2.add(it.next() * -1);
//                    negCount--;
//                    flip--;
//                } else {
//                    set2.add(it.next());
//                }
//            }
//        }
//        else{
//            set2 = set;
//        }
//        if(flip!=0){
//            //finish flipping
//            int lowest = ((TreeSet<Integer>) set2).first();
//            set2.remove(lowest);
//            for(int i=0; i<flip; i++){
//                lowest *=-1;
//            }
//            set2.add(lowest);
//        }
//
//        Iterator<Integer> it2 = set2.iterator();
//        while(it2.hasNext()){
//            sum += it2.next();
//        }

//        return sum;
        return 0;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{5,6,9,-3,3};
        System.out.println( largestSumAfterKNegations(arr, 2));
    }
}
