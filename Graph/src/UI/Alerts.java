/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.scene.control.Alert;

/**
 *
 * @author dawitabera
 */
class Alerts {
    public static Alert alert;

    static void dispalyTextFieldError() {
         alert = new Alert(Alert.AlertType.ERROR);
         alert.setHeaderText(null);
         alert.setContentText("Please Enter All Fields.");
         alert.showAndWait();
    }
    
    static void displayConfirmation(int z){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        
        alert.setContentText("Yes the value" + z + " exists");
    }
    
    
}
