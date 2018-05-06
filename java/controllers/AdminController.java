/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.java.Database;
import main.java.LuckyLanes;
import main.java.Trace;

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
    @FXML
    ImageView imgDatabase;
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Trace.createFile();
    }

    private void showDatabaseAlert() {
        imgDatabase.setImage(new Image("/main/resources/icons/dbDisconnected.png"));
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Database Not Found.");
        alert.setHeaderText("Please create or open a database file");
        alert.setContentText("Select an option");

        ButtonType buttonTypeCreate = new ButtonType("Create");
        ButtonType buttonTypeOpen = new ButtonType("Open");

        alert.getButtonTypes().addAll(buttonTypeCreate, buttonTypeOpen);

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeCreate) {
            this.createDatabase(null);
        } else if (result.get() == buttonTypeOpen) {
            this.openDatabase(null);
        } else {

        }
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

    public void test() {

    }

    public void loadDatabase() {
        imgDatabase.setVisible(true);
        String url = Database.loadProperties();
        if (url == null) {
            showDatabaseAlert();

        } else {
            System.out.println("Loading Database:" + url);
            
            if (Database.connect(url)) {
                imgDatabase.setImage(new Image("/main/resources/icons/dbConnected.png"));
            } else {
                //lblTest.setText("Couldn't connect with that url");
                showDatabaseAlert();
                imgDatabase.setImage(new Image("/main/resources/icons/dbDisconnected.png"));
            }
        }
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

            Database.createDatabase(databasePath.getPath());
            Database.saveProperties(databasePath.getPath());
            loadDatabase();
        }

    }

    @FXML
    public void openDatabase(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Database File");
        //   fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Database file(*.db)", "*.db"));
        File databasePath = fileChooser.showOpenDialog(stage);
        if (databasePath != null) {
            Database.saveProperties(databasePath.toString());
            loadDatabase();
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
