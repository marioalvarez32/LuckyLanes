/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.java.Database;
import main.java.LuckyLanes;

/**
 * FXML Controller class
 *
 * This class handles the interaction from the user in the Administration scene.
 *
 * @author Mario
 */
public class AdminController implements Initializable {

    private Database db;
    private LuckyLanes app;
    private Stage stage;

    @FXML
    Button btnNewBowler;

    @FXML
    Button btnTesting;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    /**
     *
     * @param app
     */
    public void setApp(LuckyLanes app) {
        this.app = app;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void testThis(ActionEvent e) {
    }
    
    @FXML
    public void createDatabase(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Database File");
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Database file(*.db)", "*.db"));
        File databasePath = fileChooser.showSaveDialog(stage);
        if (databasePath != null) {
            Database.createDatabase(databasePath.toString());
        }

    }

    @FXML
    public void openDatabase(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Database File");
        //   fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Database file(*.db)", "*.db"));
        File databasePath = fileChooser.showOpenDialog(stage);
        if (databasePath != null) {
            Database.connect(databasePath.toString());
        }
    }

    @FXML
    private void showNewAthlete(ActionEvent event) {
        String fxml = "/main/resources/view/newAthlete.fxml";

        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader();
            InputStream in = LuckyLanes.class.getResourceAsStream(fxml);

            loader.setBuilderFactory(new JavaFXBuilderFactory());
            loader.setLocation(LuckyLanes.class.getResource(fxml));

            try {
                root = (AnchorPane) loader.load(in);
            } finally {
                in.close();
            }

            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();

            NewAthleteController newAthlete = (NewAthleteController) ((Initializable) loader.getController());
            newAthlete.setStage(stage);

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
    private void showSearch(ActionEvent event) {
        String fxml = "/main/resources/view/Search.fxml";

        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader();
            InputStream in = LuckyLanes.class.getResourceAsStream(fxml);

            loader.setBuilderFactory(new JavaFXBuilderFactory());
            loader.setLocation(LuckyLanes.class.getResource(fxml));

            try {
                root = (AnchorPane) loader.load(in);
            } finally {
                in.close();
            }

            Stage stage = new Stage();
            stage.setTitle("Search Athlete");
            stage.setScene(new Scene(root));
            stage.show();

            SearchController newAthlete = (SearchController) ((Initializable) loader.getController());
            //newAthlete.setStage(stage);

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
    private void testing(ActionEvent event) {
        ((Button) event.getSource()).setStyle("-fx-background-color:red;");
    }
}
