package com.jeannius.interviewprep.Algorithm.dp

import spock.lang.Specification

class SubsetSumTest extends Specification{


    def"should return correct value"(){
        given:"a list with a sum"
        int[] i = [2,3,7,8,10]

        when:"calculating subset"
        boolean result = SubsetSum.subsetSum(Arrays.asList(i), 11)

        then:"should be true"
        assert result ==true

    }

    def"should return correct value of false"(){
        given:"a list with a sum"
        int[] i = [2,3,7,8,10]

        when:"calculating subset"
        boolean result = SubsetSum.subsetSum(Arrays.asList(i), 14)

        then:"should be true"
        assert result ==false

    }
}
