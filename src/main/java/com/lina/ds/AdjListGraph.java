package com.lina.ds;

import java.util.LinkedList;

public class AdjListGraph {
    int vertices;
    LinkedList<Integer> adjList[];

    public AdjListGraph(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i =0;i<vertices;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public void display(){
        for(int i =0; i<vertices; i++){
            if(adjList[i].size()>0){
                System.out.println("Vertex "+ i+ " is connected to:-");
                for(int j=0;j<adjList[i].size();j++){
                    System.out.print(adjList[i].get(j)+ " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        AdjListGraph adjListGraph = new AdjListGraph(3);
        adjListGraph.addEdge(0,1);
        adjListGraph.addEdge(1,2);
        adjListGraph.addEdge(2,0);
        adjListGraph.display();

    }
}
