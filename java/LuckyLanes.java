/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import main.java.controllers.LoginController;
import main.java.controllers.AdminController;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Mario
 */
public class LuckyLanes extends Application {

    private Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            stage = primaryStage;
            stage.setTitle("FXML Login");
            //Listener to set the minimum size once the stage is shown
            primaryStage.showingProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean showing) -> {
                if(showing) {
                    primaryStage.setMinHeight(primaryStage.getHeight());
                    primaryStage.setMinWidth(primaryStage.getWidth());
                }
            });
            gotoLogin();
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
            
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoLogin() {

        try {
            LoginController root = (LoginController) replaceSceneContent("/main/resources/view/Login.fxml");
            //LoginController root =(LoginController) replaceSceneContent("Login.fxml");
            root.createListeners();
            root.setApp(this);
            stage.setResizable(true);
            stage.sizeToScene();
            
            //stage.setMinHeight(stage.heightProperty().doubleValue());
           // stage.setMinWidth(stage.widthProperty().doubleValue());
        } catch (IOException ex) {
            Logger.getLogger(LuckyLanes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void gotoAdmin() {
        try {
            AdminController root = (AdminController) replaceSceneContent("/main/resources/view/admin.fxml");
            //LoginController root =(LoginController) replaceSceneContent("Login.fxml");
            //root.createListeners();
            root.setApp(this);
            stage.setResizable(true);
            stage.sizeToScene();
        } catch (IOException ex) {
            Logger.getLogger(LuckyLanes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Initializable replaceSceneContent(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = LuckyLanes.class.getResourceAsStream(fxml);

        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(LuckyLanes.class.getResource(fxml));
        //loader.setController(new MainController("/main/java/controllers/adminController.java"));
        AnchorPane root;
        try {
            root = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(root);    
        stage.setScene(scene);
        return (Initializable) loader.getController();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        System.out.println("Stage is closing");
        // Save file
    }
}
