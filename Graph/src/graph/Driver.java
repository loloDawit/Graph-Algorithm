/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author dawitabera
 */
public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        UndirectedGraph graphObj;
        Scanner scan = new Scanner(new File("/Users/dawitabera/Desktop/Graph/Graph-Algorithm/Graph/src/graph/miniGraph.txt"));
        int v = scan.nextInt();
        System.out.println("Vertex: " + v);
        graphObj = new UndirectedGraph(v);
        while(scan.hasNext()){
            
            int scr = scan.nextInt();
            int des = scan.nextInt();
            graphObj.addEdge(graphObj, scr, des);
            
        }
        graphObj.printGraph(graphObj);
//        
//        int V = 5;
//        graphObj = new UndirectedGraph(V);
//        graphObj.addEdge(graphObj, 0, 1);
//        graphObj.addEdge(graphObj, 0, 4);
//        graphObj.addEdge(graphObj, 1, 2);
//        graphObj.addEdge(graphObj, 1, 3);
//        graphObj.addEdge(graphObj, 1, 4);
//        graphObj.addEdge(graphObj, 2, 3);
//        graphObj.addEdge(graphObj, 3, 4);
//        
//        graphObj.printGraph(graphObj);
    }
    
}
