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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
        trimTextArea();
        String onlyString = listTextArea.getText();
        String[] arrayString = onlyString.split("\n");
        if( onlyString.length() > 0 && arrayString.length > 0 ){
            String element1 = arrayString[random(arrayString.length)];
            openWindow("/view/WindowRandomOne.fxml");
            controllerWindowRandomOne = loader.getController();
            controllerWindowRandomOne.setLbl(element1);
            removeElementFromTextArea(element1);
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Warning");
            alert.setContentText("There is no element to choose!");
            alert.showAndWait();
        }
    }
    
    @FXML
    public void findTwoRandom(){
        trimTextArea();
        String onlyString = listTextArea.getText();
        String[] arrayString = onlyString.split("\n");
        if( onlyString.length() > 0 && arrayString.length > 1 ){
            int rnd1 = random(arrayString.length);
            int rnd2 = -1;
            while(rnd2 < 0 || rnd2 == rnd1){
                rnd2 = random(arrayString.length);;
            }
            openWindow("/view/WindowRandomTwo.fxml");
            removeElementFromTextArea(arrayString[rnd1]);
            removeElementFromTextArea(arrayString[rnd2]);
            controllerWindowRandomTwo = loader.getController();
            controllerWindowRandomTwo.setLbl(arrayString[rnd1], arrayString[rnd2]);
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Warning");
            alert.setContentText("There is no element to choose pairs!");
            alert.showAndWait();
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
    
    private void openWindow(String path){
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
    
    private void trimTextArea(){
        String onlyString = listTextArea.getText();
        String newString = "";
        String[] arrayString = onlyString.split("\n");
        for(String str: arrayString){
            if(str.trim().length() > 0){
                newString += str.trim().concat("\n");
            }
        }
        listTextArea.setText(newString.trim());
    }
    
    private void removeElementFromTextArea(String element){
        String onlyString = listTextArea.getText();
        if(onlyString.contains(element.concat("\n"))){
            listTextArea.setText(onlyString.replaceFirst(element.concat("\n"), ""));
        }else{
            listTextArea.setText(onlyString.replaceFirst(element, ""));
        }
    }
}
