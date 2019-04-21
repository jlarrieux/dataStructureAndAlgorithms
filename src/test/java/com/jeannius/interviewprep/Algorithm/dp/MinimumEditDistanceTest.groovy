package com.jeannius.interviewprep.Algorithm.dp

import spock.lang.Specification

class MinimumEditDistanceTest extends Specification {

    def"testing"(){
        given: "2 string s1 and s2"
        String s1 = "azced";
        String s2 = "abcdef";

        when: "we find minimum edit distance"
        int min = MinimumEditDistance.bottomUp(s1, s2);

        then: "should equal 3"
        assert min ==3

    }
}
