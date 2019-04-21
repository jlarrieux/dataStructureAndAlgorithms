package com.jeannius.interviewprep.Algorithm.sorting

import spock.lang.Specification

class MergeSortTest extends Specification{

    def"sorting test"(){
        given:"an array"
        Integer[] a =[2,6,9,1,3,4]

        when:"sorting"
        MergeSort.mergeSort(a)

        then: "should be sorted"
        assert a ==[1,2,3,4,6,9]

    }

    def"string"(){
        given: "an array of characters"
        Character[] c = ['v','b','a']

        when: "sorting"
        MergeSort.mergeSort(c)

        then: "should be sorted"
        assert c == ['a','b','v']
    }
}
