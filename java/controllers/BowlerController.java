/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
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
    Tab tab1;
    @FXML
    Tab tab2;
    @FXML
    Tab tab3;
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

    
    SingleSelectionModel<Tab> selectionModel;
    
    @FXML
    TabPane tabPane;
    int tabIndex =0;
    private Tab currentTab;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Add all the tabs
        
        selectionModel= tabPane.getSelectionModel();
    }
    
    @FXML
    private void nextTab(ActionEvent event){
        //Set a variable for the number of tabs in scene.
        if(tabIndex == 4){
            tabIndex=0;
            selectionModel.select(tabIndex);
        }else{
            selectionModel.select(++tabIndex);   
        }
             
    }
    

}
