package com.jeannius.interviewprep.util;


import java.util.Arrays;
import java.util.Map;
import java.util.Queue;


/**
 * Created by Jeannius on 4/13/2019
 */
public class Util {

    public  static <T> void printArray(T[] t){


        if(t[0]!= null && t[0].getClass().isArray()){
            print2DArray((T[][])t);
        }
        StringBuilder b = new StringBuilder();

        for(T r: t){
            if(b.length()>1){
                b.append(", ");
            }
            b.append(t.toString());
        }
        System.out.println(b.toString());
    }





    public static <T> void print2DArray(T[][] t){
        StringBuilder b = new StringBuilder();
        for(T[] r: t){
            if(b.length()>1){
                b.append(", ");
            }
            b.append("[");
            StringBuilder b1 = new StringBuilder();
            for(int i=0; i<r.length;i++){
                if(b1.length()>0){
                    b1.append(",");
                }
                b1.append(r[i]);
            }
            b.append(b1);
            b.append("]");
        }
        System.out.println(b);
    }

    public static void print2DintArray(int[][] arr){
        Integer[][] result = new Integer[arr.length][arr[0].length];
        for(int i=0; i< arr.length; i++){
            result[i] = Arrays.stream(arr[i]).boxed().toArray(Integer[]::new);
        }

        print2DArray(result);
    }


    public static <E> void printQueue(Queue<E> q){
        for(E e: q){
            if(e instanceof Map.Entry){
                printMapEntry((Map.Entry<? extends Object, ? extends Object>) e);
            }
        }
    }


    public static <k,v> void printMapEntry(Map.Entry<k,v> mapEntry){
        System.out.printf("Key: %s, Value: %s\n", String.valueOf(mapEntry.getKey()), String.valueOf(mapEntry.getValue()));
    }

}
