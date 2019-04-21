package com.jeannius.interviewprep.sites.leetcode

import com.jeannius.interviewprep.sites.leetcode.com.VideoStitching1024
import spock.lang.Specification

class VideoStitching1024Test  extends Specification{

    def" simple test"(){
        given: "a clip array and a time"
        int[][] clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]
        int t=10
        when: "we try to stitch"
        int result = new VideoStitching1024().videoStitching(clips, t);

        then: "we get correct result"
        assert 3==result
    }

    def"single test"(){
        given: "a clip array and a time"
        int[][] clips = [[0,5],[1,6],[2,7],[3,8],[4,9],[5,10],[6,11],[7,12],[8,13],[9,14],[10,15],[11,16],[12,17],[13,18],[14,19],[15,20],[16,21],[17,22],[18,23],[19,24],[20,25],[21,26],[22,27],[23,28],[24,29],[25,30],[26,31],[27,32],[28,33],[29,34],[30,35],[31,36],[32,37],[33,38],[34,39],[35,40],[36,41],[37,42],[38,43],[39,44],[40,45],[41,46],[42,47],[43,48],[44,49],[45,50],[46,51],[47,52],[48,53],[49,54]]

        int t = 50

        when: " we try to stitch them"
        int result = new VideoStitching1024().videoStitching(clips,t)

        then: "we get correct result"
        assert 10 == result
    }


    def"bonanza"(){
        expect:
        new VideoStitching1024().videoStitching(x,y)== z

        where:
        x |y | z
        [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]] as int[][]| 10 | 3
        [[0,1],[1,2]] as int[][]|5|-1
        [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]] as int[][]| 9 | 3
        [[0,4],[2,8]] as int[][]| 5|2
        [[5,7],[1,8],[0,0],[2,3],[4,5],[0,6],[5,10],[7,10]] as int[][]|5|1
        [[5,6],[0,7],[7,10],[2,3],[4,4],[1,2],[3,4],[5,5],[0,0],[4,4]] as int[][] |2 |1
    }


}
