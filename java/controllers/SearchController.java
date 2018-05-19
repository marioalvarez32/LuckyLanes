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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import main.java.Database;
import main.java.Report;

/**
 * FXML Controller class
 *
 * @author nicolenelson
 */
public class SearchController implements Initializable {

    // variables from the fxml file
    @FXML
    TableView table;
    @FXML
    TextField txtName;
    @FXML
    TextField txtAddress;
    @FXML
    TextField txtState;
    @FXML
    TextField txtCity;
    @FXML
    TextField txtSchool;
    @FXML
    TextField txtSport;
    @FXML
    TextField txtZip;
    @FXML
    TextField txtID;
    @FXML
    Button buttonSubmit;
    @FXML
    ProgressIndicator progressIndicator;
    // variables for sql/database
    private ObservableList<ObservableList> data;
    private Executor exec;
    private ResultSet rs;
    private Report report;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        exec = Executors.newCachedThreadPool(runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    /**
     *
     * @param e
     */
    @FXML
    public void printAllReport(ActionEvent e) {
        if (table.getItems().size() == 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error Saving reports");
            alert.setHeaderText("There are no reports to save");
            alert.setContentText("Search for reports and try again.");
            
            alert.showAndWait();
        } else {
            Report p = new Report();

            for (Object item : table.getItems()) {
                ObservableList<String> row = (ObservableList<String>) item;
                p.addID(Integer.parseInt(row.get(0)));
            }

            Task<Void> print = new Task<Void>() {
                @Override
                public Void call() throws Exception {
                    progressIndicator.setVisible(true);//FUCK YES!!!!
                    System.out.println("Creating Objets to save");
                    p.createObjects();
                    p.toDocs();
                    return null;
                }
            };
            progressIndicator.progressProperty().bind(print.progressProperty());
            progressIndicator.setStyle(" -fx-progress-color: green;");

            progressIndicator.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent arg0) {
                    if (progressIndicator.getProgress() == 1) {
                        progressIndicator.setVisible(false);
                    }
                }
            });
            print.setOnSucceeded(error -> {
                //this.rs=databaseQuery.getValue();
                System.out.println("It's Alive!!!");
                progressIndicator.progressProperty().unbind();
                progressIndicator.setProgress(1);
            });

            exec.execute(print);
        }

    }

    /**
     *
     * @param e
     */
    @FXML
    public void printSelectedReport(ActionEvent e) {
        if (table.getSelectionModel().getSelectedItems().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error Saving reports");
            alert.setHeaderText("There are no selected reports.");
            alert.setContentText("Select at least one report and try again");

            alert.showAndWait();
        } else {
            Report p = new Report();

            for (Object item : table.getSelectionModel().getSelectedItems()) {
                ObservableList<String> row = (ObservableList<String>) item;
                p.addID(Integer.parseInt(row.get(0)));
            }

            Task<Void> print = new Task<Void>() {
                @Override
                public Void call() throws Exception {
                    progressIndicator.setVisible(true);//FUCK YES!!!!
                    System.out.println("Creating Objets to save");
                    p.createObjects();
                    p.toDocs();
                    return null;
                }
            };
            progressIndicator.progressProperty().bind(print.progressProperty());
            progressIndicator.setStyle(" -fx-progress-color: green;");

            progressIndicator.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent arg0) {
                    if (progressIndicator.getProgress() == 1) {
                        progressIndicator.setVisible(false);
                    }
                }
            });
            print.setOnSucceeded(error -> {
                //this.rs=databaseQuery.getValue();
                System.out.println("It's Alive!!!");
                progressIndicator.progressProperty().unbind();
                progressIndicator.setProgress(1);
            });

            exec.execute(print);
        }
    }

    /**
     *
     * @param e
     */
    @FXML
    public void buildData(ActionEvent e) {

        //table.getItems().clear();
        table.getColumns().clear();

        System.out.println("Running");
        // prepare SQL statement
        String SQL = "SELECT ID,name, address, school,age, gender FROM athlete WHERE "
                + "(UPPER(name) LIKE UPPER('%" + txtName.getText() + "%') or name is null) "
                + "and (UPPER(address) LIKE UPPER('%" + txtAddress.getText() + "%') or address is null) "
                + "and (UPPER(state) LIKE UPPER('%" + txtState.getText() + "%') or state is null) "
                + "and (UPPER(city) LIKE UPPER('%" + txtCity.getText() + "%') or city is null) "
                + "and (zip LIKE ('%" + txtZip.getText() + "%') or zip is null) "
                + "and (UPPER(school) LIKE UPPER('%" + txtSchool.getText() + "%') or school is null) "
                + "and (UPPER(primarysport) LIKE UPPER('%" + txtSport.getText() + "%') or primarysport is null) "
                + "and (ID LIKE ('%" + txtID.getText() + "') or ID is null) "; // data to grab

        // grab the result set of the equation
        //ResultSet rs = Database.searchQuery(SQL);
        Task<Void> databaseQuery = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                System.out.print("fasldfkj;asldfkj");
                //BEHOLD
                progressIndicator.setVisible(true);//FUCK YES!!!!
                
                //Platform.runlater is used to update an UI control inside a different thread.
                Database.connect();
                ResultSet rs = Database.searchQuery(SQL);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        data = FXCollections.observableArrayList();
                        try {
                            
                            // go through the columns and add them
                            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                                final int j = i;
                                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                                        return new SimpleStringProperty(param.getValue().get(j).toString());
                                    }
                                });

                                table.getColumns().addAll(col);
                                //System.out.println("Column ["+i+"] ");
                            }

                            // add data to the observable list
                            while (rs.next()) {
                                //Iterate Row
                                ObservableList<String> row = FXCollections.observableArrayList();
                                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                                    //Iterate Column
                                    row.add(rs.getString(i));
                                }
                                //System.out.println("Row [1] added "+row );
                                data.add(row);
                            }

                            // add to the tableview
                            table.setItems(data);
                            Database.close();
                        } catch (SQLException ex) {

                            //Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });
                
                return null;
            }
        };

        progressIndicator.progressProperty().bind(databaseQuery.progressProperty());
        databaseQuery.setOnFailed(error -> {
            //databaseQuery.getException().printStackTrace();
            //Abandon the ship.
            System.out.println("Women and kids first");
        });

        databaseQuery.setOnSucceeded(error -> {
            //this.rs=databaseQuery.getValue();
            System.out.println("It's Alive!!!");
            progressIndicator.progressProperty().unbind();
            progressIndicator.setProgress(1);
            progressIndicator.setVisible(false);

        });

        // Task.getValue() gives the value returned from call()...
        //rs = widgetSearchTask.getValue())
        // start converting the result set into tableview
        exec.execute(databaseQuery);
    }

}
