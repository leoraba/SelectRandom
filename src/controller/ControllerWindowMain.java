/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.MainApp;

/**
 *
 * @author Leonardo
 */
public class ControllerWindowMain {
    
    @FXML
    private TextArea listTextArea;
    
    @FXML
    private Button selectOneBtn;
    
    @FXML
    private Button selectTwoBtn;
    
    // Reference to the main application
    private MainApp mainApp;
    private ControllerWindowRandomOne controllerWindowRandomOne;
    private ControllerWindowRandomTwo controllerWindowRandomTwo;
    private FXMLLoader loader;
    
    @FXML
    public void findOneRandom(){
        String[] arrayString = listTextArea.getText().split("\n");
        int rnd = random(arrayString.length);
        openWindow("/view/WindowRandomOne.fxml");
        controllerWindowRandomOne = loader.getController();
        controllerWindowRandomOne.setLbl(arrayString[rnd]);
            
    }
    
    @FXML
    public void findTwoRandom(){
        String[] arrayString = listTextArea.getText().split("\n");
        if( arrayString.length > 1 ){
            int rnd1 = random(arrayString.length);
            int rnd2 = -1;
            while(rnd2 < 0 || rnd2 == rnd1){
                rnd2 = random(arrayString.length);;
            }
            openWindow("/view/WindowRandomTwo.fxml");
            controllerWindowRandomTwo = loader.getController();
            controllerWindowRandomTwo.setLbl(arrayString[rnd1], arrayString[rnd2]);
        }else{
            
        }
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp main){
        this.mainApp = main;

        // Add observable list data to the table
//        tablePerson.setItems(MainRPG.getPersonData());
    }
    
    private int random(int size){
        Random rand = new Random();
        int  n = rand.nextInt(size);
        return n;
    }
    
    public void openWindow(String path){
        try{
            //path="/view/[name].fxml"

            loader = new FXMLLoader(MainApp.class.getResource(path));
            Parent newWindow = (Parent) loader.load();
            Scene scene1 = new Scene(newWindow);
            //scene1.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());

            Stage stageNew = new Stage();
            stageNew.setScene(scene1);
            stageNew.setTitle("Random");
            stageNew.show();
            stageNew.setResizable(false);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
