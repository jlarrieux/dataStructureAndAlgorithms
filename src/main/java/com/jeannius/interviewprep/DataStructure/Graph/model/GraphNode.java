package com.jeannius.interviewprep.DataStructure.Graph.model;



import com.jeannius.interviewprep.DataStructure.LinkedList.Node;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Jeannius on 3/25/2019
 */
@Data
public  class GraphNode extends Node {

    protected List<GraphNode> adjacencyList = new ArrayList<>();
    protected String label;

    public GraphNode(String label){
        this.label = label;
        data =1;
    }

    public void addToAdjacencyList(GraphNode node){
        adjacencyList.add(node);
    }

    public List< GraphNode> getAdjacencyList() {
        return adjacencyList;
    }


    public void setAdjacencyList(List<GraphNode> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }


    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphNode)) return false;
        if (!super.equals(o)) return false;

        GraphNode graphNode = (GraphNode) o;

        return getLabel() != null ? getLabel().equals(graphNode.getLabel()) : graphNode.getLabel() == null;

    }


    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result ;
        result = 31 * result + (getLabel() != null ? getLabel().hashCode() : 0);
        return result;
    }

}
