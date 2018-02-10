/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author dawitabera
 */
public class Driver {
    public static void main(String[] args) {
        int V = 5;
        UndirectedGraph graphObj = new UndirectedGraph(V);
        graphObj.addEdge(graphObj, 0, 1);
        graphObj.addEdge(graphObj, 0, 4);
        graphObj.addEdge(graphObj, 1, 2);
        graphObj.addEdge(graphObj, 1, 3);
        graphObj.addEdge(graphObj, 1, 4);
        graphObj.addEdge(graphObj, 2, 3);
        graphObj.addEdge(graphObj, 3, 4);
        
        graphObj.printGraph(graphObj);
    }
    
}
