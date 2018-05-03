/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import main.java.Database;

/**
 * FXML Controller class
 *
 * @author nicolenelson
 */
public class SearchController implements Initializable {

    @FXML TableView table;
    private ObservableList<ObservableList> data;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void button() {
        
    }
    
    public void buildData() {
        data = FXCollections.observableArrayList();
        
    }
}
