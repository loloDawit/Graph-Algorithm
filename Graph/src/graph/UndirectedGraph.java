/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;

/**
 *
 * @author dawitabera
 */
public class UndirectedGraph{
    private int Vertex;
    LinkedList<Integer> adjacencyList[];
    
    // constructor
    public UndirectedGraph(int Vertex){
        if(Vertex < 0)
            throw new RuntimeException("The Vertex size can not be negative");
        this.Vertex = Vertex;
        //The size of the array will be the same as the size
        // of the vertices 
        adjacencyList = new LinkedList[Vertex];
        
        // intilaize a new a list to store the nodes
        for(int i=0; i < Vertex; i++){
            adjacencyList[i] = new LinkedList<>();
        }
        
    }

    public void addEdge(UndirectedGraph graph, int scr, int dest) {
        graph.adjacencyList[scr].addFirst(dest);
        graph.adjacencyList[dest].addFirst(scr);
        
    }

    public void printGraph(UndirectedGraph graph) {
        for(int i=0; i<graph.Vertex;i++){
            System.out.println("Adj List of the vertex: " + i);
            System.out.print("["+i+"]");
            for(Integer itreate:graph.adjacencyList[i]){
                System.out.print("-->" + itreate);
            }
            System.out.println("\n");
        }
        
    }
    
}
