package com.jeannius.interviewprep.DataStructure.Graph;


import com.jeannius.interviewprep.DataStructure.Graph.model.GraphEdge;
import com.jeannius.interviewprep.DataStructure.Graph.model.GraphNode;
import lombok.Data;

import java.util.*;


/**
 * Created by Jeannius on 4/12/2019
 */
@Data
public class UndirectedWeightedGraph  extends UndirectedGraph{
    private Set<GraphEdge> edges = new HashSet<>();

    public void add(GraphNode g1, GraphNode g2, int val){
        Graph.addToEachOtherAdjacencyList(g1, g2);
        super.addNode(g1);
        super.addNode(g2);
        edges.add(new GraphEdge(val, g1, g2));
    }


    @Override
    public void addNode(GraphNode node) {
        throw new UnsupportedOperationException("Must use 'add' and provide 2 GraphNodes and an int");
    }

    public GraphEdge getEdge(GraphNode g1, GraphNode g2){
        GraphEdge e = new GraphEdge(0,g1, g2);
        GraphEdge f = new GraphEdge(0,g2, g1);
        for(GraphEdge edge: edges){
            if(e.equals(edge) || f.equals(edge)){
                return edge;
            }
        }
        throw new IllegalArgumentException(String.format("No edge linking nodes %s and %s!",g1.getLabel(), g2.getLabel()));
    }


    public void  printDijkstra(GraphNode source, GraphNode destination){
        if(!contains(source)){
            throw new IllegalArgumentException("Source is not present in this graph!");
        }

        if(!contains(destination)){
            throw new IllegalArgumentException("Destination is not present in this graph!");
        }

        Map<GraphNode, Integer> map = initializeDijkstraMap();
        map.put(source, 0);
        Queue<Map.Entry<GraphNode, Integer>> q = new PriorityQueue<>(Comparator.comparing(Map.Entry<GraphNode,Integer>::getValue));
        Set<GraphNode> visited = new HashSet<>();

        for(Map.Entry<GraphNode, Integer> entry : map.entrySet()){
            q.add(entry);
        }
        GraphNode curr ;
        while(q.size()>0){
            curr = q.remove().getKey();
            System.out.printf("curr: %s\n", curr.getLabel());

            for(GraphNode child: curr.getAdjacencyList()){
                if(!visited.contains(child)){
                    GraphEdge edge = getEdge(curr, child);
                    int update = map.get(curr)+ edge.getValue();
                    if (map.get(child) > update) {
                        map.put(child, map.get(curr)+ edge.getValue());
                    }
                    if (!q.isEmpty()) {
                        q.add(q.remove());

                    }
                }
            }
            printQ(q);
            printMap(map);
            visited.add(curr);
        }


        for(Map.Entry<GraphNode, Integer> entry: map.entrySet()){
            System.out.printf("node: %s, distance: %d\n", entry.getKey().getLabel(), entry.getValue());
        }
    }


    private void printAStar(){

    }

    private void printQ(Queue<Map.Entry<GraphNode, Integer>> q){
        for(Map.Entry<GraphNode, Integer> mapEntry: q){
            System.out.printf("qKey: %s, qValue: %s\n", mapEntry.getKey().getLabel(), String.valueOf(mapEntry.getValue()));
        }
        System.out.printf("\n");
    }

    private void printMap(Map<GraphNode, Integer> map){
        for(GraphNode graphNode : map.keySet()){
            System.out.printf("MapKey:%s, mapValue: %d\n", graphNode.getLabel(), map.get(graphNode));
        }
        System.out.printf("\n\n");
    }

    private Map<GraphNode, Integer> initializeDijkstraMap(){
        Map<GraphNode, Integer> map = new HashMap<>();
        for(GraphNode graphNode: getNodes()){
            map.put(graphNode, Integer.MAX_VALUE);
        }
        return map;
    }






    public static void main(String[] args) {
        UndirectedWeightedGraph undirectedWeightedGraph = new UndirectedWeightedGraph();

        GraphNode graphNodeA = new GraphNode("A");
        GraphNode graphNodeB = new GraphNode("B");
        GraphNode graphNodeC = new GraphNode("C");
        GraphNode graphNodeD = new GraphNode("D");
        GraphNode graphNodeE = new GraphNode("E");
        GraphNode graphNodeF = new GraphNode("F");

        undirectedWeightedGraph.add(graphNodeA, graphNodeB,10);
        undirectedWeightedGraph.add(graphNodeA, graphNodeC,15);
        undirectedWeightedGraph.add(graphNodeB, graphNodeD,12);
        undirectedWeightedGraph.add(graphNodeB, graphNodeF,15);
        undirectedWeightedGraph.add(graphNodeC, graphNodeE,10);
        undirectedWeightedGraph.add(graphNodeD, graphNodeE,2);
        undirectedWeightedGraph.add(graphNodeD, graphNodeF,1);


        undirectedWeightedGraph.add(graphNodeF,graphNodeE,5);

        undirectedWeightedGraph.printDijkstra(graphNodeA, graphNodeE);
//        System.out.println( undirectedWeightedGraph.getEdgeValue(graphNodeA, graphNodeB));

//        undirectedWeightedGraph.printNodes();

//        undirectedWeightedGraph.DFS(graphNodeA);
//        undirectedWeightedGraph.BFS(graphNodeA);
    }


}
