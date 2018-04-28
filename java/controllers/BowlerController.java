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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.LuckyLanes;
import main.java.scene.control.TextFieldRequired;

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
    //FMS SCORE SHEET TAB
    @FXML
    TextField txfDeepSquat;
    @FXML
    ScrollPane spDataSheet;
    //THis is used to change the Tabs in the gui.
    SingleSelectionModel<Tab> selectionModel;
    
    @FXML
    TabPane tabPane;
    private int NUM_TAB = 5;
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
        //Create validation regex for all TextFieldRequired
        /*
        txfName.setValidationRegex("^([a-zA-Z&.()\\-,']+[ ]*)+$");//Name contains at least two letters.
        txfAddress.setValidationRegex("^[a-zA-Z0-9 #.,;:'°]{3,}$");
        txfWeight.setValidationRegex("^[0-9]+$");
        txfHeight.setValidationRegex("^[0-9]+$");
        */

    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void createListeners() {
        this.stage.titleProperty().bind(txfName.textProperty());

        selectionModel.selectedIndexProperty().addListener((observable, oldVal, newVal) -> {
            validateTabs(oldVal.intValue());
        });

    }

    /**
     * *************************************************************************
     *                                                                         *
     * GUI Handlers * *
     *************************************************************************
     */
    @FXML
    private void nextTab(ActionEvent event) {
        //validateTabs();
        
        if (!validateTabs(selectionModel.getSelectedIndex()) && !errors[selectionModel.getSelectedIndex()]) {
            //Message has been shown, set error flag to true;
            errors[selectionModel.getSelectedIndex()] = true;
            if (showMissingInformationAlert()) {
                return;
            }

        }
        
        //Set a variable for the number of tabs in scene.
        if (selectionModel.getSelectedIndex() == NUM_TAB-1) {
            selectionModel.select(0);
        } else {
            selectionModel.select(selectionModel.getSelectedIndex() + 1);
        }
    }

    @FXML
    private void prevTab(ActionEvent event) {
        //validateTabs();

        if (!validateTabs(selectionModel.getSelectedIndex()) && !errors[selectionModel.getSelectedIndex()]) {
            //Message has been shown, set error flag to true;
            errors[selectionModel.getSelectedIndex()] = true;
            if (showMissingInformationAlert()) {
                return;//Consume event
            }

        }

        //Set a variable for the number of tabs in scene.
        if (selectionModel.getSelectedIndex() == 0) {
            selectionModel.select(NUM_TAB-1);
        } else {
            selectionModel.select(selectionModel.getSelectedIndex() - 1);
        }
    }

    private boolean showMissingInformationAlert() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Missing Information");
        alert.setHeaderText("There are required fields missing.");
        alert.setContentText("Press OK to move to the next tab.");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.CANCEL) {

            }
        });
        return alert.getResult() == ButtonType.CANCEL;
    }

    /**
     * *************************************************************************
     *                                                                         *
     * Auxiliary methods
     *************************************************************************
     */
    private boolean validateTab1() {
        //IsValid activates the color effect. They all have to be called.
        /*
        txfName.isValid();
        txfAddress.isValid();
        txfWeight.isValid();
        txfHeight.isValid();
        
       return txfName.isValid() && txfAddress.isValid() && txfWeight.isValid() && txfHeight.isValid();
        */
        return true;
    }

    private boolean validateTab2() {
        //Validate fields in tab 1 and set errors flag 0 to true if any errors are found.
        if (txfDeepSquat.getText().equals("")) {
            
            //Red shadow effect
            txfDeepSquat.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
            //txfAddress.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");

            return false;
        }
        return true;
    }
    private boolean validateTabs(int index) {
        if(index == -1){
            index = selectionModel.getSelectedIndex();
        }
        boolean flag = false;
        switch (index) {
            case 0:
                flag = validateTab1();
                break;
            case 1:
                flag = validateTab2();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        if(flag){
            //No errors
            selectionModel.getSelectedItem().getStyleClass().clear();
            selectionModel.getSelectedItem().getStyleClass().addAll("tab-valid","tab");
        }else{
            //Errors
            selectionModel.getSelectedItem().getStyleClass().clear();
            selectionModel.getSelectedItem().getStyleClass().addAll("tab-invalid","tab");
        }
        return flag;
    }
}
