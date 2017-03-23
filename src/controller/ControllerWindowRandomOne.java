/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class ControllerWindowRandomOne {
    
    @FXML
    private Button btnOk;
    
    @FXML
    private Label lblName;
    
    public void btnOkPressed(ActionEvent actionEvent){
        Node  source = (Node)  actionEvent.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    public void setLbl(String lblText){
        lblName.setText(lblText);
    }
    
}
