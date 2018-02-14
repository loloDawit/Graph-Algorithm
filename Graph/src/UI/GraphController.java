/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import FileChooser.OpenFileController;
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
import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author dawitabera
 */
public class GraphController implements Initializable{
    
    private Desktop desktop = Desktop.getDesktop();
    final FileChooser fileChooser = new FileChooser();
    UndirectedGraph graphObj; 

    @FXML
    private Label fielLable;
    @FXML
    private TextField fileTextInput;
    @FXML
    private TextArea textArea;
    private TextField checkLable;
    @FXML
    private TextField ScrLable;
    @FXML
    private TextField desLable;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ImportFile(ActionEvent event) throws FileNotFoundException {
        boolean flag;
        //String file = "/Users/dawitabera/Desktop/Graph/Graph-Algorithm/Graph/src/graph/";
        configureFileChooser(fileChooser);
        File file2 = fileChooser.showOpenDialog(new Stage());
        if(file2 != null){
            openGraphFile(file2);
        }
        fileTextInput.setText(file2.getPath());
        String fileinput = fileTextInput.getText();
       // String newString = file.concat(fileinput);
        flag = fileinput.isEmpty();
        if(flag){
            Alerts.dispalyTextFieldError();
            return;
        }
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

    @FXML
    private void checkEdge(ActionEvent event) {
        String getSrc = ScrLable.getText();
        String getDst = desLable.getText();
        
        int getSCR = Integer.parseInt(getSrc);
        int getDST = Integer.parseInt(getDst);
        if(getSCR < 0 || getDST < 0){
            Alerts.dispalyTextFieldError();
            return;
        }
        graphObj.addEdge(graphObj, getSCR, getDST);
        for(int i=0; i<5;i++){
            textArea.appendText("Adj List of the vertex: " + i + "\n");
            textArea.appendText("["+i+"]");
            for(Integer itreate:graphObj.adjacencyList[i]){
                textArea.appendText("-->" + itreate);
            }
             textArea.appendText("\n");
        }
        
    }

    @FXML
    private void openSecondWindow(ActionEvent event) {
        loadWindow("/UI/SecondWindow/secondWindow.fxml", "Graph");
        closeStage();
        
    }
       void loadWindow(String loc, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GraphController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       public void closeStage() {
        ((Stage)textArea.getScene().getWindow()).close();
    }
       
      private static void configureFileChooser(final FileChooser fileChooser){                           
        fileChooser.setTitle("View Graph Files");
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        ); 
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        
    }
      
      private void openGraphFile(File file){
          try {
              desktop.open(file);
          } catch (Exception e) {
              Logger.getLogger(OpenFileController.class.getName()).log(Level.SEVERE,null,e);
          }
      }
    
    
}
