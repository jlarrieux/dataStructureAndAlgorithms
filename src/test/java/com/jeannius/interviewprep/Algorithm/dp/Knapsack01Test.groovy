package com.jeannius.interviewprep.Algorithm.dp


import spock.lang.Specification

class Knapsack01Test extends Specification {

    def "max of 0 should return 0"(){
        given: "a weight and profit array"
        int[] weight = [1,2,3]
        int[] profit = [1,2,3]

        when: "we call the profit calculator with a max of zero"
        int maxProfit = new Knapsack01().bottomUpFindMaxProfit(weight, profit, 0)

        then: "should return zero"
        assert maxProfit==0
    }

    def "max less than 0 should return 0"(){
        given: "a weight and profit array"
        int[] weight = [1,2,3]
        int[] profit = [1,2,3]

        when: "we call the profit calculator with a max of less than zero"
        int maxProfit = new Knapsack01().bottomUpFindMaxProfit(weight, profit, -9)

        then: "should return zero"
        assert maxProfit==0
    }

    def "should behave as expected"(){
        given: "a weigh and profit array"
        int[] weight = [1,3,4,5]
        int[] profit = [1,4,5,7]

        when: "we calculate max profit with constraint of weight 7"
        int maxProfit = new Knapsack01().bottomUpFindMaxProfit(weight,profit, 7);

        then: "should be"
        assert maxProfit ==9
    }


    def "should behave"(){
        expect:
        z == new Knapsack01().bottomUpFindMaxProfit(weight, profit, max)

        where:
        weight<<[[1,3,4,5],[10,20,30]]
        profit<<[[1,4,5,7],[60,100,120]]
        max<<[7,50]
        z << [9,220]
    }
}
