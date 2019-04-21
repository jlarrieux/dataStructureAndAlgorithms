package com.jeannius.interviewprep.DataStructure.Graph;


import com.jeannius.interviewprep.DataStructure.Graph.model.GraphNode;

import java.util.*;

import static com.jeannius.interviewprep.DataStructure.Graph.Graph.addToEachOtherAdjacencyList;


/**
 * Created by Jeannius on 4/9/2019
 */
public class UndirectedGraph implements Graph {

    private Set<GraphNode> nodes = new HashSet<>();

    public  void addNode(GraphNode node) {
        nodes.add(node);
    }


    public Set<GraphNode> getNodes(){
        return Collections.unmodifiableSet(nodes);
    }

    public boolean contains(GraphNode g1){
        return nodes.contains(g1);
    }

    public void BFS(GraphNode g1) {
        Deque<GraphNode> q = new ArrayDeque<>();
        q.offer(g1);
        StringBuilder builder = new StringBuilder();
        Set<GraphNode> set = new HashSet<>();
        set.add(g1);
        while (q.size() > 0) {
            GraphNode curr = q.removeFirst();
            if (builder.length() > 0) {
                builder.append("->");
            }
            builder.append(curr.getLabel());
            List<GraphNode> list = curr.getAdjacencyList();
            for (GraphNode g : list) {
                if (!set.contains(g)) {
                    q.offer(g);
                    set.add(g);
                }
            }
        }
        System.out.printf("BFS: %s\n", builder.toString());

    }


    public void DFS(GraphNode g1) {
        Set<GraphNode> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        printDFSHelper(g1, set, builder);
        System.out.printf("DFS: %s\n",builder.toString());
    }


    private static void printDFSHelper(GraphNode g1, Set<GraphNode> visited, StringBuilder b) {
        if (!visited.contains(g1)) {
            visited.add(g1);
            if (b.length() > 0) {
                b.append("->");
            }
            b.append(g1.getLabel());
            List<GraphNode> nodes = g1.getAdjacencyList();

            for (GraphNode g : nodes) {
                printDFSHelper(g, visited, b);
            }


        }
    }

    public void printNodes(){
        StringBuilder b = new StringBuilder();

        for(GraphNode g: nodes){
            if(b.length()>0){
                b.append(",");
            }

            b.append(g.getLabel());
        }

        System.out.println(b);
    }



















    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph();

        GraphNode graphNode0 = new GraphNode("0");
        GraphNode graphNode1 = new GraphNode("1");
        GraphNode graphNode2 = new GraphNode("2");
        GraphNode graphNode3 = new GraphNode("3");
        GraphNode graphNode4 = new GraphNode("4");
        GraphNode graphNode5 = new GraphNode("5");

        addToEachOtherAdjacencyList(graphNode0, graphNode1);
        addToEachOtherAdjacencyList(graphNode0, graphNode4);
        addToEachOtherAdjacencyList(graphNode0, graphNode5);

        addToEachOtherAdjacencyList(graphNode1, graphNode2);
        addToEachOtherAdjacencyList(graphNode1, graphNode3);
        addToEachOtherAdjacencyList(graphNode1, graphNode4);

        addToEachOtherAdjacencyList(graphNode2, graphNode3);
        addToEachOtherAdjacencyList(graphNode3, graphNode4);

        undirectedGraph.addNode(graphNode0);
        undirectedGraph.addNode(graphNode1);
        undirectedGraph.addNode(graphNode2);
        undirectedGraph.addNode(graphNode3);
        undirectedGraph.addNode(graphNode4);
        undirectedGraph.addNode(graphNode5);

        undirectedGraph.printNodes();

        undirectedGraph.DFS(graphNode0);
        undirectedGraph.BFS(graphNode0);
    }


}
