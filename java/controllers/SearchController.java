/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.Database;

/**
 * FXML Controller class
 *
 * @author nicolenelson
 */
public class SearchController implements Initializable {
    
    // variables from the fxml file
    @FXML TableView table;
    @FXML TextField txtName;
    @FXML TextField txtAddress;
    @FXML TextField txtState;
    @FXML TextField txtCity;
    @FXML TextField txtSchool;
    @FXML TextField txtSport;
    @FXML TextField txtZip;
    @FXML TextField txtID;
    @FXML Button buttonSubmit;
    
    // variables for sql/database
    private ObservableList<ObservableList> data;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML 
    public void buildData(ActionEvent e) {
        for(int i = 0; i < table.getItems().size(); i++) {
            table.getItems().clear();
        }
        System.out.println("Running");
        // prepare SQL statement
        String SQL= "SELECT name, address, school FROM ATHLETE WHERE "
                + "(UPPER(name) LIKE UPPER('%" +txtName.getText() +"%') or name is null) "
                + "and (UPPER(address) LIKE UPPER('%" +txtAddress.getText() +"%') or address is null) "
                + "and (UPPER(state) LIKE UPPER('%" +txtState.getText() +"%') or state is null) "
                + "and (UPPER(city) LIKE UPPER('%" +txtCity.getText() +"%') or city is null) "
                + "and (zip LIKE ('%" +txtZip.getText() +"%') or zip is null) "
                + "and (UPPER(school) LIKE UPPER('%" +txtSchool.getText() +"%') or school is null) "
                + "and (UPPER(primarysport) LIKE UPPER('%" +txtSport.getText() +"%') or primarysport is null) "
                + "and (ID LIKE ('%" +txtID.getText() +"') or ID is null) "; // data to grab
        
        
        // grab the result set of the equation
        ResultSet rs = Database.searchQuery(SQL);
        
       // start converting the result set into tableview
       data = FXCollections.observableArrayList();
        try {
            // go through the columns and add them
            for(int i = 0; i<rs.getMetaData().getColumnCount(); i++) {
               final int j = i;
               TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
               col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }
            
            // add data to the observable list
            while(rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);
            }
            
            // add to the tableview
            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
