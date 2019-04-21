package com.jeannius.interviewprep.sites.leetcode.com;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jeannius on 4/14/2019
 */
public class CamelCaseMatchin1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {

        if(queries==null || queries.length==0 || pattern ==null){
            return null;
        }

        List<Boolean> result = new ArrayList<>();
        for(String s: queries){
            result.add(matches(s, pattern));
        }

        return result;


    }


    public boolean matches(String query, String pattern){
        int i= 0, j=0;
        StringBuilder b = new StringBuilder (pattern.length());

        while(i< query.length() && j<pattern.length()){
            char q =query.charAt(i);
            char p = pattern.charAt(j);
            if(p==q){
                i++;
                j++;
                b.append(p);
            }
            else if((Character.isUpperCase(p) && Character.isLowerCase(q)) || (Character.isLowerCase(p) && Character.isLowerCase(q))){
                i++;
            }else{
                return false;
            }

        }

        if(j<pattern.length()-1){
            return false; //reach end of query with more pattern left
        }
        if(i<query.length()-1){
            while(i<query.length()) {
                //we have more query to go but pattern is done
                char q = query.charAt(i);
                if (Character.isUpperCase(q)) {
                    return false;
                }
                i++;
            }
        }


        return b.toString().equals(pattern);
    }


    public static void main(String[] args) {
        String[] q = {"FooBar", "FooBarTest", "FrameBuffer", "ForceFeedBack"};
        System.out.println(new CamelCaseMatchin1023().camelMatch(q,"FB"));
    }
}
