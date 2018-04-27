/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controllers;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.LuckyLanes;

/**
 * FXML Controller class
 *
 * This class handles the interaction from the user in the bowler.fxml file.
 *
 * It shows the forms needed to register a new bowler. Athlete information, FMS
 * Score Sheet, etc.
 *
 * @author Mario
 */
public class BowlerController implements Initializable {

    @FXML
    Button btnBack;
    @FXML
    Button btnNext;
    @FXML
    ComboBox cbState;
    @FXML
    DatePicker dpDate;
    @FXML
    Label lblDate;
    @FXML
    Tab tabFMSScore;
    @FXML
    Tab tabBowlerInformation;
    @FXML
    TextField txfAddress;
    @FXML
    TextField Age;
    @FXML
    TextField txfCity;
    @FXML
    TextField txfGender;
    @FXML
    TextField txfHeight;
    @FXML
    TextField txfLegDominance;
    @FXML
    TextField txfName;
    @FXML
    TextField txfPhone;
    @FXML
    TextField PrimaryPosition;
    @FXML
    TextField txfPrimarySport;
    @FXML
    TextField txfSchool;
    @FXML
    TextField txfWeight;
    @FXML
    TextField txfZip;

    //THis is used to change the Tabs in the gui.
    SingleSelectionModel<Tab> selectionModel;

    @FXML
    TabPane tabPane;
    private int NUM_TAB = 4;
    private Tab currentTab;
    private Stage stage;
    private boolean[] errors;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        errors = new boolean[NUM_TAB];

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        lblDate.setText(dateFormat.format(date));

        selectionModel = tabPane.getSelectionModel();

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void createListeners() {
        this.stage.titleProperty().bind(txfName.textProperty());

        selectionModel.selectedItemProperty().addListener((ObservableValue<? extends Tab> ov, Tab t, Tab t1) -> {
            validateTabs();
        });

        txfName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.equals("")) {
                txfName.setStyle("-fx-effect: dropshadow( gaussian , rgba(51, 174, 44,1) , 10,0,0,0 );");
            }
        });
    }

    private void validateTabs() {

        switch (selectionModel.getSelectedIndex()) {
            case 0:
                validateTab1();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
    private boolean showMissingInformationAlert(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Missing Information");
        alert.setHeaderText("There are required fields missing.");
        alert.setContentText("I have a great message for you!");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.CANCEL) {
                
            }
        });
        return alert.getResult() == ButtonType.CANCEL;
    }
    @FXML
    private void nextTab(ActionEvent event) {
        validateTabs();
        
        if(showMissingInformationAlert()){
            
            return;
        }
        
        //Set a variable for the number of tabs in scene.
        if (selectionModel.getSelectedIndex() == 4) {
            selectionModel.select(0);
        } else {
            selectionModel.select(selectionModel.getSelectedIndex() + 1);
        }
    }

    private boolean validateTab1() {
        if (txfName.getText().equals("") && txfAddress.getText().equals("")) {
            tabBowlerInformation.setStyle("-fx-background-color:red;");
            //Red shadow effect
            txfName.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
            txfAddress.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
            return false;
        }
        return true;
    }

}
