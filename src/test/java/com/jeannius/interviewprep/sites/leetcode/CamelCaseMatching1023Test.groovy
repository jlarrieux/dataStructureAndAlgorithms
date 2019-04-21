package com.jeannius.interviewprep.sites.leetcode

import com.jeannius.interviewprep.sites.leetcode.com.CamelCaseMatchin1023
import spock.lang.Specification

class CamelCaseMatching1023Test  extends Specification{

    def"single test"(){
        given: "an array of string and a pattern"
        String[] q = ["CompetitiveProgramming","CounterPick","ControlPanel"]
        String p ="CooP"

        when: "Trying to match"
        List<Boolean> result = new CamelCaseMatchin1023().camelMatch(q, p)

        then:
        assert [false, false, true]==result
    }

    def" Bonanza"(){
        expect:
        new CamelCaseMatchin1023().camelMatch(x, y)== z

        where:
        x| y|z
        ["FooBar", "FooBarTest","FootBall", "FrameBuffer", "ForceFeedBack"] as String[]|"FB"|[true, false, true, true, false]
        ["CompetitiveProgramming","CounterPick","ControlPanel"] as String[]|"CooP"|[false, false, true]

    }
}
