package com.jeannius.interviewprep.DataStructure.Graph;


import com.jeannius.interviewprep.DataStructure.Graph.model.GraphNode;


/**
 * Created by Jeannius on 4/9/2019
 */
public interface Graph {

    void BFS(GraphNode g);
    void DFS(GraphNode g);

    static void addToEachOtherAdjacencyList(GraphNode g1, GraphNode g2){
        g1.addToAdjacencyList(g2);
        g2.addToAdjacencyList(g1);
    }
}
