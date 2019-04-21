package com.jeannius.interviewprep.Algorithm.sorting;



/**
 * Created by Jeannius on 3/13/2019
 */
public class MergeSort {

    public static <T extends Comparable<T>> void mergeSort(T[] arr){
        int n = arr.length;
        if(n<2){
            return;
        }

        int mid = n/2;
        int right = n-mid ;
        T[] l = (T[]) new Comparable[mid];
        T[] r = (T[]) new Comparable[right];

        for(int i=0; i<mid; i++){
            l[i] = arr[i];
        }
        for(int i=mid; i<n; i++){
            r[i-mid] = arr[i];
        }

        mergeSort(l);
        mergeSort(r);
        merge(arr, l, r);
    }


    private static <T extends Comparable<T>> void merge(T[] arr, T[] l, T[] r){
        int i=0, j=0, k=0;
        int left = l.length;
        int right = r.length;
        while(i<left && j< right){
            if(l[i].compareTo(r[j]) <0 || l[i].compareTo(r[j])==0){
                arr[k++] = l[i++];
            }
            else{
                arr[k++] = r[j++];
            }
        }

        while(i<left) arr[k++] = l[i++];

        while(j<right) arr[k++] = r[j++];


    }



}
