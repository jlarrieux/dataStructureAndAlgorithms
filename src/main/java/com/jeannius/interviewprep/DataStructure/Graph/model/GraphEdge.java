package com.jeannius.interviewprep.DataStructure.Graph.model;


import lombok.Data;


/**
 * Created by Jeannius on 4/9/2019
 */
@Data
public class GraphEdge {
    private int value;
    private GraphNode g1, g2;

    public GraphEdge(int val, GraphNode g1, GraphNode g2){
        this.value = val;
        this.g1 = g1;
        this.g2 = g2;
    }


//    public static void main(String[] args) {
//        GraphEdge edge = new GraphEdge(1,new GraphNode("a"), new GraphNode("b"));
//        System.out.println(edge);
//    }

    @Override
    public String toString(){
        return String.format("%s -- %s: %d\n",g1.getLabel(), g2.getLabel(), value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphEdge)) return false;

        GraphEdge edge = (GraphEdge) o;

        if (getG1() != null ? !getG1().equals(edge.getG1()) : edge.getG1() != null) return false;
        return getG2() != null ? getG2().equals(edge.getG2()) : edge.getG2() == null;

    }


    @Override
    public int hashCode() {
        int result = getG1() != null ? getG1().hashCode() : 0;
        result = 31 * result + (getG2() != null ? getG2().hashCode() : 0);
        return result;
    }

}
