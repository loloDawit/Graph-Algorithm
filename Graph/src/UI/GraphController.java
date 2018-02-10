/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import graph.UndirectedGraph;
import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javafx.application.Platform;

/**
 * FXML Controller class
 *
 * @author dawitabera
 */
public class GraphController implements Initializable{
    UndirectedGraph graphObj; 
    private PrintStream ps;

    @FXML
    private Label fielLable;
    @FXML
    private TextField fileTextInput;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ImportFile(ActionEvent event) throws FileNotFoundException {
        String fileinput = fileTextInput.getText();
        Scanner scan = new Scanner(new File(fileinput));
        int v = scan.nextInt();
        System.out.println("Vertex: " + v);
        graphObj = new UndirectedGraph(v);
        while(scan.hasNext()){
            
            int scr = scan.nextInt();
            int des = scan.nextInt();
            graphObj.addEdge(graphObj, scr, des);
            
        }
        //graphObj.printGraph(graphObj);
        textArea.appendText("Vertex: " + Integer.toString(v) + "\n");
        
        for(int i=0; i<v;i++){
            textArea.appendText("Adj List of the vertex: " + i + "\n");
            textArea.appendText("["+i+"]");
            for(Integer itreate:graphObj.adjacencyList[i]){
                textArea.appendText("-->" + itreate);
            }
             textArea.appendText("\n");
        }
        
    }

    @FXML
    private void clearField(ActionEvent event) {
        textArea.clear();
        fileTextInput.clear();
    }
    
}
