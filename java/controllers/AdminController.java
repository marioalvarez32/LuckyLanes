/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.java.LuckyLanes;

/**
 * FXML Controller class
 *
 * @author Mario
 */
public class AdminController implements Initializable {

    private LuckyLanes app;

    @FXML
    Button btnNewBowler;

    @FXML
    Button btnTesting;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setApp(LuckyLanes app) {
        this.app = app;
    }
    @FXML
    private void showNewAthlete(ActionEvent event){
        AnchorPane root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("main/resources/view/newAthlete.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnCloseRequest((WindowEvent we) -> {
                ((Stage) (((Node) (event.getSource())).getScene().getWindow())).show();
            });
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void testing(ActionEvent event){
        ((Button)event.getSource()).setStyle("-fx-background-color:red;");
    }
}
