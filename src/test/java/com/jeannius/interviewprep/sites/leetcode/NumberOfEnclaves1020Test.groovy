package com.jeannius.interviewprep.sites.leetcode

import com.jeannius.interviewprep.sites.leetcode.com.NumberOfEnclaves1020
import spock.lang.Specification

class NumberOfEnclaves1020Test extends Specification {

    def"single Test"(){
        given:"an input array"
        int[][] A = [[0,0,0,1,1,1,0,1,0,0],[1,1,0,0,0,1,0,1,1,1],[0,0,0,1,1,1,0,1,0,0],[0,1,1,0,0,0,1,0,1,0],[0,1,1,1,1,1,0,0,1,0],[0,0,1,0,1,1,1,1,0,1],[0,1,1,0,0,0,1,1,1,1],[0,0,1,0,0,1,0,1,0,1],[1,0,1,0,1,1,0,0,0,0],[0,0,0,0,1,1,0,0,0,1]]

        when:" we compute it"
        int result = new NumberOfEnclaves1020().numEnclavesSolOnline(A)

        then:
        assert 3==result
    }
}
