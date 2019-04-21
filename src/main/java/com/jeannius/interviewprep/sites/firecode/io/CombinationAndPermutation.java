package com.jeannius.interviewprep.sites.firecode.io;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Jeannius on 4/9/2019
 */
public class CombinationAndPermutation {


    public static ArrayList<String> getCombPerms(String s) {
        if(s==null){
            return null;
        }

        Set<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        if(s.length()==0){
            return result;
        }



        for(int i=0; i<s.length(); i++){
            result.add(String.valueOf(s.charAt(i)));

        }

        permute(s, 0, s.length()-1, set);

        result.addAll(set);
        return result;
    }


    private static void permute(String s, int l, int r, Set<String> result){
        result.add(s);
        System.out.printf("recursing with s: %s, l:%d, r:%d\t result:",s,l, r);
        System.out.print(result);
        System.out.println();

        while(l<r){
            s = swap(s, l, r);
            l++;
            permute(s, l, r, result);
            s = swap(s, r, l);
        }

    }

    private static String swap (String s, int i, int j){
        char[] arr = s.toCharArray();

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return String.valueOf(arr);

    }


    public static void main(String[] args) {
        System.out.println( CombinationAndPermutation.getCombPerms("ab"));
    }


    public static ArrayList<String> getCombPerms2(String s) {
        ArrayList<String> permutations = new ArrayList<String>();
        if (s == null)  return null;    // error case
        else if (s.length() == 1) {     // base case
            permutations.add(s);
            return permutations;
        }
        String first = s.substring(0,1);    // get and add the first character
        permutations.add(first);
        String remainder = s.substring(1);  // remove the first character
        ArrayList<String> words = getCombPerms2(remainder);
        // Insert the first character into each possible position in permutation
        for (String word : words)
            for (int j = 0; j <= word.length(); j++)
                permutations.add(insertCharAt(word, first, j));
        permutations.addAll(words);     // add permutations without the first character
        return permutations;
    }
    public static String insertCharAt(String word, String c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
}
