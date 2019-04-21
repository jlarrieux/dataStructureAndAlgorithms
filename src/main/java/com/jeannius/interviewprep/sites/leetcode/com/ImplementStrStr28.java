package com.jeannius.interviewprep.sites.leetcode.com;


/**
 * Created by Jeannius on 4/16/2019
 */
public class ImplementStrStr28 {
    public int strStr(String haystack, String needle) {
        if( needle.length()==0) return 0;
        if(haystack == null || needle ==null || haystack.length()==0 ) return -1;

        int i=0, j=0, index =-1, pot =-1, k=0;
        char f = needle.charAt(0);
        boolean set = false;
        while(i<haystack.length() ){
            char h = haystack.charAt(i);
            char n = needle.charAt(j);
            if(k>15) break;
            if(!set && h==f && j!=0){
                set = true;
                pot =i;
            }
            if(h==n){
                if(j==0) index =i;
                j++;

            }
            else{
                j=0;
                if(set) i = pot;
                set = false;
            }
            System.out.printf("i: %d, j: %d, h: %c,  n: %c, index: %d, pot: %d, h==n? %b\n", i, j, h, n, index, pot, h==n);
            if(j==needle.length()){
                break;
            }
            i++;
            k++;
        }

        return j==needle.length()? index: -1;


    }


    public static void main(String[] args) {
        new ImplementStrStr28().strStr("mississippi", "issip");
    }
}
