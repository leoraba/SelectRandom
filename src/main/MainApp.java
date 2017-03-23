/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ControllerWindowMain;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Leonardo
 */
public class MainApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try 
            {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/view/WindowMain.fxml"));
                //Parent mainWindowGUI = FXMLLoader.load(getClass().getResource("/view/WindowMain.fxml"));
                Parent mainWindowGUI = (Parent) loader.load();
                Scene scene = new Scene(mainWindowGUI);
                scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setTitle("Random selection");
                primaryStage.show();
                primaryStage.setResizable(false);

                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
                {
                public void handle(WindowEvent ev) 
                {
                    Platform.exit();
                }
            });
	        		
            ControllerWindowMain controller = loader.getController();
            controller.setMainApp(this);
            } catch(Exception e) {
                    e.printStackTrace();
            }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
