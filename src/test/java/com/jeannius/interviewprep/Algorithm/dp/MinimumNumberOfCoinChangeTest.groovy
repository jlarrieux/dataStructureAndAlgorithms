package com.jeannius.interviewprep.Algorithm.dp

import spock.lang.Specification

class MinimumNumberOfCoinChangeTest extends Specification{

    def "testing"(){
        given: "a list of coins and a value"
        List<Integer> arr = new ArrayList<>();
        arr.add(1)
        arr.add(5)
        arr.add(6)
        arr.add(8)

        when:"we call the algo"
        int min = MinimumNumberOfCoinChange.bottomUp(arr, 11)

        then:" should return expected"
        assert min ==2
    }
}
