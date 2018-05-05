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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import main.java.Athlete;
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

    /**
     * *************************************************************************
     *                                                                         *
     * Root Injected Objects
     * **************************************************************************
     */
    @FXML
    WebView webView;
    @FXML
    TabPane tabPane;
    @FXML
    Button btnBack;
    @FXML
    Button btnNext;
    @FXML
    Tab tabDemographics;
    @FXML
    Tab tabYBalance;
    @FXML
    Tab tabFMS;

    /**
     * *************************************************************************
     *                                                                         *
     * Bowler Information Tab Injected Objects
     * **************************************************************************
     */
    @FXML
    TextFieldRequired txfName;
    @FXML
    Label lblDate;
    @FXML
    DatePicker dpDate;
    @FXML
    TextFieldRequired txfAddress;
    @FXML
    TextFieldRequired txfCity;
    @FXML
    ComboBox cbState;
    @FXML
    TextFieldRequired txfZip;
    @FXML
    TextFieldRequired txfPhone;
    @FXML
    TextFieldRequired txfSchool;
    @FXML
    TextFieldRequired txfAge;
    @FXML
    TextFieldRequired txfHeight;
    @FXML
    TextFieldRequired txfWeight;
    @FXML
    TextFieldRequired txfGender;
    @FXML
    TextFieldRequired txfPrimaryPosition;
    @FXML
    TextFieldRequired txfPrimarySport;
    @FXML
    ToggleGroup tgGender;
    @FXML
    ToggleGroup dominance;
    @FXML
    RadioButton radMale;
    @FXML
    RadioButton radFemale;
    /**
     * *************************************************************************
     *                                                                         *
     * Y-Balance Test Injected Objects
     * **************************************************************************
     */
    @FXML
    VBox vbYBalanceRoot;
    @FXML
    TextFieldRequired txfRightLimbLength;
    @FXML
    TextFieldRequired txfA1Right;
    @FXML
    TextFieldRequired txfA2Right;
    @FXML
    TextFieldRequired txfA3Right;
    @FXML
    TextFieldRequired txfA1Left;
    @FXML
    TextFieldRequired txfA2Left;
    @FXML
    TextFieldRequired txfA3Left;
    @FXML
    TextFieldRequired txfPM1Right;
    @FXML
    TextFieldRequired txfPM2Right;
    @FXML
    TextFieldRequired txfPM3Right;
    @FXML
    TextFieldRequired txfPL1Right;
    @FXML
    TextFieldRequired txfPL2Right;
    @FXML
    TextFieldRequired txfPL3Right;
    @FXML
    TextFieldRequired txfPM1Left;
    @FXML
    TextFieldRequired txfPM2Left;
    @FXML
    TextFieldRequired txfPM3Left;
    @FXML
    TextFieldRequired txfPL1Left;
    @FXML
    TextFieldRequired txfPL2Left;
    @FXML
    TextFieldRequired txfPL3Left;
    @FXML
    Label lblARight;
    @FXML
    Label lblALeft;
    @FXML
    Label lblPMRight;
    @FXML
    Label lblPLRight;
    @FXML
    Label lblPMLeft;
    @FXML
    Label lblPLLeft;
    @FXML
    Label lblADif;
    @FXML
    Label lblPMDif;
    @FXML
    Label lblPLDif;
    @FXML
    Label lblCompositeLeft;
    @FXML
    Label lblCompositeRight;

    /**
     * *************************************************************************
     *                                                                         *
     * FMS Score Sheet Injected Objects
     * **************************************************************************
     */
    @FXML
    VBox vbFMSRoot;
    @FXML
    ScrollPane spDataSheet;
    @FXML
    ToggleGroup tgHurdleStepR;
    @FXML
    ToggleGroup tgHurdleStepL;
    @FXML

    ToggleGroup tgDeepSquat;
    @FXML
    ToggleGroup tgInlineLoungeL;
    @FXML
    ToggleGroup tgInlineLoungeR;
    @FXML
    ToggleGroup tgShoulderMobilityL;
    @FXML
    ToggleGroup tgShoulderMobilityR;
    @FXML
    ToggleGroup tgActiveStraightL;
    @FXML
    ToggleGroup tgActiveStraightR;
    @FXML
    ToggleGroup tgTrunkStability;
    @FXML
    ToggleGroup tgRotaryStabilityL;
    @FXML
    ToggleGroup tgRotaryStabilityR;
    @FXML
    ToggleGroup tgShoulderClearingL;
    @FXML
    ToggleGroup tgShoulderClearingR;
    @FXML
    ToggleGroup tgExtensionClearing;
    @FXML
    ToggleGroup tgFlexionClearing;

    @FXML
    TextFieldRequired txfTrunkStability;
    @FXML
    TextFieldRequired txfInlineLounge;
    @FXML
    TextFieldRequired txfShoulderMobility;
    @FXML
    TextFieldRequired txfActiveStraight;
    @FXML
    TextFieldRequired txfRotaryStability;
    @FXML
    TextFieldRequired txfHurdleStep;
    @FXML
    TextFieldRequired txfDeepSquat;
    @FXML
    TextField txfFMSTotal;
    /**
     * *************************************************************************
     *                                                                         *
     * Fitness Testing Data Sheet Injected Objects
     * **************************************************************************
     */
    @FXML
    VBox vbFtinessTestingRoot;
    @FXML
    TextField txfAge2;
    @FXML
    TextField txfHeight2;
    @FXML
    TextField txfWeight2;
    @FXML
    ToggleGroup gender2;
    @FXML
    RadioButton radMale2;
    @FXML
    RadioButton radFemale2;
    @FXML
    RadioButton radDominanceRight;
    @FXML
    RadioButton radDominanceLeft;
    @FXML
    RadioButton radDominance2Right;
    @FXML
    RadioButton radDominance2Left;
    
    @FXML
    ScrollPane scrollPane;
    @FXML
    Button btnFinish;
    //THis is used to change the Tabs in the gui.
    SingleSelectionModel<Tab> selectionModel;
    private int NUM_TAB = 5;
    private Stage stage;
    private boolean[] errors;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
        /*
        WebEngine webEngine = webView.getEngine();
        URL xd =this.getClass().getResource("index.html"); 
        webEngine.load(xd.toExternalForm());
        */
        errors = new boolean[NUM_TAB];
        
        lblDate.setText(dateFormat.format(date));
        selectionModel = tabPane.getSelectionModel();
        initializeDemographics();
        initializeYBalance();
        initializeFMS();
        //Create validation regex for all TextFieldRequired
        /*
        //Name contains at least two letters.
        
        txfWeight.setValidationRegex("^[0-9]+$");
        txfHeight.setValidationRegex("^[0-9]+$");
         */

    }

    private void initializeDemographics() {
        ObservableList<String> options = FXCollections.observableArrayList("Wisconsin");
        cbState.getItems().setAll(options);
        //TextField Required 
        txfName.setValidation("^([a-zA-Z&.()\\-,']+[ ]*)+$", "Name must be at least two characters and can contain: & . ( ) - , '");
        txfAddress.setValidation("^[a-zA-Z0-9 #]{3,}$", "Address can contain only letters, numbers and #");

        txfCity.setValidation("^[a-zA-Z]+(?:[\\s-][a-zA-Z]*)*$", "City must contain only letters.");
        txfZip.setValidation("^\\d{5}$", "Zip Code must contain 5 digits.");
        txfPhone.setValidation("^(\\d{10})|(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", "Phone Number must be in any of the following formats: \n###-###-####\n(###) ###-####\n### ### ####\n###.###.####\n+## (###) ###-####");
        txfSchool.setValidation(TextFieldRequired.ALPHANUMERIC, "School can contain only letters, numbers");

        txfHeight.setValidation("^[0-9]+$", "Height must be in centimeters and can only contain digits.");
        txfWeight.setValidation("^[0-9]+$", "Weight must be in kilograms and can only contain digits.");
        txfAge.setValidation("^[0-9]+$", "Age must be in years and can only contain digits.");

        txfPrimarySport.setValidation(TextFieldRequired.ALPHANUMERIC, "Primary Sport can contain any letters or numbers");
        txfPrimaryPosition.setValidation(TextFieldRequired.ALPHANUMERIC, "Primary position can contain any letters or numbers");

        txfAddress.setRequired(true);
        txfName.setRequired(true);
        txfAge.setRequired(true);
        txfWeight.setRequired(true);
        txfHeight.setRequired(true);
    }

    private void initializeYBalance() {
        //Initialize all YBalanace textfield boxes to be required and to validate to only digits.

        for (TextFieldRequired txf : getAllTextFieldRequired(vbYBalanceRoot)) {
            txf.setValidation(TextFieldRequired.NUMERIC, "Measurement must be in centimeters and only contain digits.");
            txf.setRequired(true);
        }
    }

    private void initializeFMS() {
        //Initialize all YBalanace textfield boxes to be required and to validate to only digits.

        for (TextFieldRequired txf : getAllTextFieldRequired(vbFMSRoot)) {
            txf.setValidation("^[0-3]{1}$", "Select raw score to calculate final score.");
            txf.setRequired(true);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void createListeners() {

        //validateTabs();
        this.stage.titleProperty().bind(txfName.textProperty());
        txfAge.textProperty().bindBidirectional(txfAge2.textProperty());

        txfHeight.textProperty().bindBidirectional(txfHeight2.textProperty());
        txfWeight.textProperty().bindBidirectional(txfWeight2.textProperty());
        //Y-Balance Test Bindings.

        setYBalanceHandlers();
        setFMSScoreSheetHandlers();

        radMale.selectedProperty().bindBidirectional(radMale2.selectedProperty());
        radFemale.selectedProperty().bindBidirectional(radFemale2.selectedProperty());
        
        radDominanceRight.selectedProperty().bindBidirectional(radDominance2Right.selectedProperty());
        radDominanceLeft.selectedProperty().bindBidirectional(radDominance2Left.selectedProperty());
        
        selectionModel.selectedIndexProperty().addListener((observable, oldVal, newVal) -> {
            validateTabs(oldVal.intValue());
        });

    }

    /**
     * *************************************************************************
     *                                                                         *
     * GUI Handlers * *
     * ************************************************************************
     */
    @FXML
    private void nextTab(ActionEvent event) {

        //validateTabs();
        if (!validateTabs() && !errors[selectionModel.getSelectedIndex()]) {
            //Message has been shown, set error flag to true;
            errors[selectionModel.getSelectedIndex()] = true;
            if (showMissingInformationAlert()) {
                return;
            }

        }

        //Set a variable for the number of tabs in scene.
        if (selectionModel.getSelectedIndex() == NUM_TAB - 1) {
            selectionModel.select(0);
        } else {
            selectionModel.select(selectionModel.getSelectedIndex() + 1);
        }
    }

    @FXML
    private void prevTab(ActionEvent event) {
        //validateTabs();

        if (!validateTabs() && !errors[selectionModel.getSelectedIndex()]) {
            //Message has been shown, set error flag to true;
            errors[selectionModel.getSelectedIndex()] = true;
            if (showMissingInformationAlert()) {
                return;//Consume event
            }

        }

        //Set a variable for the number of tabs in scene.
        if (selectionModel.getSelectedIndex() == 0) {
            selectionModel.select(NUM_TAB - 1);
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
     * ************************************************************************
     */
    private String maxValue(String t1, String t2, String t3) {
        double a, b, c;
        try {
            a = Double.parseDouble(t1);
            b = Double.parseDouble(t2);
            c = Double.parseDouble(t3);
            if (a >= b && a >= c) {
                return "" + a;
            } else if (b >= a && b >= c) {
                return "" + b;
            } else {
                return "" + c;
            }
        } catch (Exception e) {
            return "";
        }
    }

    private String minValue(String t1, String t2) {
        double a, b;
        try {
            a = Double.parseDouble(t1);
            b = Double.parseDouble(t2);

            if (a <= b) {
                return "" + (int) a;
            } else {
                return "" + (int) b;
            }
        } catch (Exception e) {
            return "";
        }
    }

    private String difValue(String t1, String t2) {
        double a, b;
        try {
            a = Double.parseDouble(t1);
            b = Double.parseDouble(t2);
            return "" + Math.abs(a - b);
        } catch (Exception e) {
            return "";
        }
    }

    private String compositeValue(String rightLimbLength, String t1, String t2, String t3) {
        double a, b, c, dblRightLimbLength;
        try {
            a = Double.parseDouble(t1);
            b = Double.parseDouble(t2);
            c = Double.parseDouble(t3);
            dblRightLimbLength = Double.parseDouble(rightLimbLength);
            DecimalFormat decFor = new DecimalFormat("###.##");
            //Anterior +POsteromedial+Posterolateral / 3* RIght Limb Length *100
            return "" + decFor.format(((a + b + c) / (3 * dblRightLimbLength)) * 100);
        } catch (Exception e) {
            return "";
        }
    }

    private void setYBalanceHandlers() {
        //Composite Scores

        lblARight.textProperty().addListener((observer, oldVal, newVal) -> {
            lblCompositeRight.setText(compositeValue(txfRightLimbLength.getText(), newVal, lblPMRight.getText(), lblPLRight.getText()));
        });
        lblPMRight.textProperty().addListener((observer, oldVal, newVal) -> {
            lblCompositeRight.setText(compositeValue(txfRightLimbLength.getText(), newVal, lblARight.getText(), lblPLRight.getText()));
        });
        lblPLRight.textProperty().addListener((observer, oldVal, newVal) -> {
            lblCompositeRight.setText(compositeValue(txfRightLimbLength.getText(), newVal, lblPMRight.getText(), lblARight.getText()));
        });

        lblALeft.textProperty().addListener((observer, oldVal, newVal) -> {
            lblCompositeLeft.setText(compositeValue(txfRightLimbLength.getText(), newVal, lblPMLeft.getText(), lblPLLeft.getText()));
        });
        lblPMLeft.textProperty().addListener((observer, oldVal, newVal) -> {
            lblCompositeLeft.setText(compositeValue(txfRightLimbLength.getText(), newVal, lblALeft.getText(), lblPLLeft.getText()));
        });
        lblPLLeft.textProperty().addListener((observer, oldVal, newVal) -> {
            lblCompositeLeft.setText(compositeValue(txfRightLimbLength.getText(), newVal, lblPMLeft.getText(), lblALeft.getText()));
        });

        txfRightLimbLength.textProperty().addListener((observer, oldVal, newVal) -> {
            lblCompositeLeft.setText(compositeValue(newVal, lblPMLeft.getText(), lblPLLeft.getText(), lblALeft.getText()));
            lblCompositeRight.setText(compositeValue(newVal, lblPMRight.getText(), lblPLRight.getText(), lblARight.getText()));
        });
        /**
         * *********************************
         */
        lblARight.textProperty().addListener((observable, oldVal, newVal) -> {
            lblADif.setText(difValue(newVal, lblALeft.getText()));
        });
        lblALeft.textProperty().addListener((observable, oldVal, newVal) -> {
            lblADif.setText(difValue(newVal, lblARight.getText()));
        });

        lblPMRight.textProperty().addListener((observable, oldVal, newVal) -> {
            lblPMDif.setText(difValue(newVal, lblPMLeft.getText()));
        });
        lblPMLeft.textProperty().addListener((observable, oldVal, newVal) -> {
            lblPMDif.setText(difValue(newVal, lblPMRight.getText()));
        });

        lblPLRight.textProperty().addListener((observable, oldVal, newVal) -> {
            lblPLDif.setText(difValue(newVal, lblPLLeft.getText()));
        });
        lblPLLeft.textProperty().addListener((observable, oldVal, newVal) -> {
            lblPLDif.setText(difValue(newVal, lblPLRight.getText()));
        });

        txfA1Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblARight.setText(maxValue(newVal, txfA2Right.getText(), txfA3Right.getText()));
        });
        txfA2Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblARight.setText(maxValue(newVal, txfA1Right.getText(), txfA3Right.getText()));
        });
        txfA3Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblARight.setText(maxValue(newVal, txfA2Right.getText(), txfA1Right.getText()));
        });

        txfA1Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblALeft.setText(maxValue(newVal, txfA2Left.getText(), txfA3Left.getText()));
        });
        txfA2Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblALeft.setText(maxValue(newVal, txfA1Left.getText(), txfA3Left.getText()));
        });
        txfA3Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblALeft.setText(maxValue(newVal, txfA2Left.getText(), txfA1Left.getText()));
        });

        txfPM1Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblPMRight.setText(maxValue(newVal, txfPM2Right.getText(), txfPM3Right.getText()));

        });
        txfPM2Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblPMRight.setText(maxValue(newVal, txfPM1Right.getText(), txfPM3Right.getText()));

        });
        txfPM3Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblPMRight.setText(maxValue(newVal, txfPM1Right.getText(), txfPM2Right.getText()));
        });
        txfPL1Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblPLRight.setText(maxValue(newVal, txfPL2Right.getText(), txfPL3Right.getText()));

        });
        txfPL2Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblPLRight.setText(maxValue(newVal, txfPL1Right.getText(), txfPL3Right.getText()));

        });
        txfPL3Right.textProperty().addListener((observable, oldval, newVal) -> {
            lblPLRight.setText(maxValue(newVal, txfPL2Right.getText(), txfPL1Right.getText()));
        });
        txfPM1Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblPMLeft.setText(maxValue(newVal, txfPM2Left.getText(), txfPM3Left.getText()));
        });
        txfPM2Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblPMLeft.setText(maxValue(newVal, txfPM1Left.getText(), txfPM3Left.getText()));

        });
        txfPM3Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblPMLeft.setText(maxValue(newVal, txfPM1Left.getText(), txfPM2Left.getText()));
        });
        txfPL1Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblPLLeft.setText(maxValue(newVal, txfPL2Left.getText(), txfPL3Left.getText()));
        });
        txfPL2Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblPLLeft.setText(maxValue(newVal, txfPL1Left.getText(), txfPL3Left.getText()));
        });
        txfPL3Left.textProperty().addListener((observable, oldval, newVal) -> {
            lblPLLeft.setText(maxValue(newVal, txfPL2Left.getText(), txfPL1Left.getText()));
        });
    }

    private void setFMSScoreSheetHandlers() {
        /**
         * **************************************************************
         */
        for (TextFieldRequired txf : getAllTextFieldRequired(vbFMSRoot)) {

            txf.textProperty().addListener((observable, oldValue, newValue) -> {
                boolean flag = true;
                int sum = 0;
                for (TextFieldRequired txf2 : getAllTextFieldRequired(vbFMSRoot)) {
                    if (txf2.isValidNoEffect()) {
                        //IT has a number in it
                        sum += Integer.parseInt(txf2.getText());
                    } else {
                        return;
                    }
                }
                txfFMSTotal.setText("" + sum);
            });
        }

        /**
         * **************************************************************
         */
        tgHurdleStepR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgHurdleStepR.getSelectedToggle() != null && tgHurdleStepL.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgHurdleStepL.getSelectedToggle());
                txfHurdleStep.setText(minValue(l.getText(), r.getText()));

            } else {
                txfHurdleStep.setText("");
            }
        });

        tgHurdleStepL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgHurdleStepR.getSelectedToggle() != null && tgHurdleStepL.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgHurdleStepR.getSelectedToggle());
                txfHurdleStep.setText(minValue(l.getText(), r.getText()));

            } else {
                txfHurdleStep.setText("");
            }
        });
        /**
         * **************************************************************
         */
        tgDeepSquat.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgDeepSquat.getSelectedToggle() != null) {
                ToggleButton currentToggle = ((ToggleButton) newToggle);
                txfDeepSquat.setText(currentToggle.getText());
            } else {
                txfDeepSquat.setText("");
            }
        });
        /**
         * **************************************************************
         */
        tgTrunkStability.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgTrunkStability.getSelectedToggle() != null && tgExtensionClearing.getSelectedToggle() != null) {
                ToggleButton currentToggle = ((ToggleButton) newToggle);
                ToggleButton clearingL = ((ToggleButton) tgExtensionClearing.getSelectedToggle());
                if (clearingL.getText().equals("+")) {
                    txfTrunkStability.setText("0");
                } else {
                    txfTrunkStability.setText(currentToggle.getText());
                }

            } else {
                txfTrunkStability.setText("");
            }
        });

        tgExtensionClearing.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {
            if (tgTrunkStability.getSelectedToggle() != null && tgExtensionClearing.getSelectedToggle() != null) {
                ToggleButton clearingL = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgTrunkStability.getSelectedToggle());

                if (clearingL.getText().equals("+")) {
                    txfTrunkStability.setText("0");
                } else {
                    txfTrunkStability.setText(r.getText());
                }
            } else {
                txfTrunkStability.setText("");
            }

        });

        /**
         * **************************************************************
         */
        tgInlineLoungeR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgInlineLoungeR.getSelectedToggle() != null && tgInlineLoungeL.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgInlineLoungeL.getSelectedToggle());
                txfInlineLounge.setText(minValue(l.getText(), r.getText()));

            } else {
                txfInlineLounge.setText("");
            }
        });

        tgInlineLoungeL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgInlineLoungeR.getSelectedToggle() != null && tgInlineLoungeL.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgInlineLoungeR.getSelectedToggle());
                txfInlineLounge.setText(minValue(l.getText(), r.getText()));

            } else {
                txfInlineLounge.setText("");
            }
        });

        /**
         * **************************************************************
         */
        tgShoulderMobilityR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgShoulderMobilityR.getSelectedToggle() != null && tgShoulderMobilityL.getSelectedToggle() != null && tgShoulderClearingL.getSelectedToggle() != null && tgShoulderClearingR.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgShoulderMobilityL.getSelectedToggle());
                ToggleButton clearingL = ((ToggleButton) tgShoulderClearingL.getSelectedToggle());
                ToggleButton clearingR = ((ToggleButton) tgShoulderClearingR.getSelectedToggle());

                if (clearingL.getText().equals("+") || clearingR.getText().equals("+")) {
                    txfShoulderMobility.setText("0");
                } else {
                    txfShoulderMobility.setText(minValue(l.getText(), r.getText()));
                }

            } else {
                txfShoulderMobility.setText("");
            }
        });
        tgShoulderClearingL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {
            if (tgShoulderMobilityR.getSelectedToggle() != null && tgShoulderMobilityL.getSelectedToggle() != null && tgShoulderClearingL.getSelectedToggle() != null && tgShoulderClearingR.getSelectedToggle() != null) {
                ToggleButton clearingL = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgShoulderMobilityR.getSelectedToggle());
                ToggleButton l = ((ToggleButton) tgShoulderMobilityL.getSelectedToggle());

                if (clearingL.getText().equals("+")) {
                    txfShoulderMobility.setText("0");
                } else {
                    txfShoulderMobility.setText(minValue(l.getText(), r.getText()));
                }
            } else {
                txfShoulderMobility.setText("");
            }

        });
        tgShoulderClearingR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {
            if (tgShoulderMobilityR.getSelectedToggle() != null && tgShoulderMobilityL.getSelectedToggle() != null && tgShoulderClearingL.getSelectedToggle() != null && tgShoulderClearingR.getSelectedToggle() != null) {

                ToggleButton clearingR = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgShoulderMobilityR.getSelectedToggle());
                ToggleButton l = ((ToggleButton) tgShoulderMobilityL.getSelectedToggle());

                if (clearingR.getText().equals("+")) {
                    txfShoulderMobility.setText("0");
                } else {
                    txfShoulderMobility.setText(minValue(l.getText(), r.getText()));
                }
            } else {
                txfShoulderMobility.setText("");
            }
        });
        tgShoulderMobilityL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgShoulderMobilityR.getSelectedToggle() != null && tgShoulderMobilityL.getSelectedToggle() != null && tgShoulderClearingL.getSelectedToggle() != null && tgShoulderClearingR.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgShoulderMobilityR.getSelectedToggle());
                ToggleButton clearingL = ((ToggleButton) tgShoulderClearingL.getSelectedToggle());
                ToggleButton clearingR = ((ToggleButton) tgShoulderClearingR.getSelectedToggle());

                if (clearingL.getText().equals("+") || clearingR.getText().equals("+")) {
                    txfShoulderMobility.setText("0");
                } else {
                    txfShoulderMobility.setText(minValue(l.getText(), r.getText()));
                }

            } else {
                txfShoulderMobility.setText("");
            }
        });
        /**
         * **************************************************************
         */
        tgActiveStraightR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgActiveStraightR.getSelectedToggle() != null && tgActiveStraightL.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgActiveStraightL.getSelectedToggle());
                txfActiveStraight.setText(minValue(l.getText(), r.getText()));

            } else {
                txfActiveStraight.setText("");
            }
        });

        tgActiveStraightL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgActiveStraightR.getSelectedToggle() != null && tgActiveStraightL.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgActiveStraightR.getSelectedToggle());
                txfActiveStraight.setText(minValue(l.getText(), r.getText()));

            } else {
                txfActiveStraight.setText("");
            }
        });
        /**
         * **************************************************************
         */
        tgRotaryStabilityR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgRotaryStabilityR.getSelectedToggle() != null && tgRotaryStabilityL.getSelectedToggle() != null && tgFlexionClearing.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgRotaryStabilityL.getSelectedToggle());
                ToggleButton clearing = ((ToggleButton) tgFlexionClearing.getSelectedToggle());

                if (clearing.getText().equals("+")) {
                    txfRotaryStability.setText("0");
                } else {
                    txfRotaryStability.setText(minValue(l.getText(), r.getText()));
                }

            } else {
                txfRotaryStability.setText("");
            }
        });

        tgRotaryStabilityL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgRotaryStabilityR.getSelectedToggle() != null && tgRotaryStabilityL.getSelectedToggle() != null && tgFlexionClearing.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgRotaryStabilityR.getSelectedToggle());
                ToggleButton clearing = ((ToggleButton) tgFlexionClearing.getSelectedToggle());

                if (clearing.getText().equals("+")) {
                    txfRotaryStability.setText("0");
                } else {
                    txfRotaryStability.setText(minValue(l.getText(), r.getText()));
                }

            } else {
                txfRotaryStability.setText("");
            }
        });

        tgFlexionClearing.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgRotaryStabilityR.getSelectedToggle() != null && tgRotaryStabilityL.getSelectedToggle() != null && tgFlexionClearing.getSelectedToggle() != null) {
                ToggleButton clearing = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgRotaryStabilityR.getSelectedToggle());
                ToggleButton l = ((ToggleButton) tgRotaryStabilityL.getSelectedToggle());

                if (clearing.getText().equals("+")) {
                    txfRotaryStability.setText("0");
                } else {
                    txfRotaryStability.setText(minValue(l.getText(), r.getText()));
                }

            } else {
                txfRotaryStability.setText("");
            }

        });

    }

    public static ArrayList<TextFieldRequired> getAllTextFieldRequired(Parent root) {
        ArrayList<TextFieldRequired> nodes = new ArrayList<>();
        addAllTextFIeldRequired(root, nodes);
        return nodes;
    }

    private static void addAllTextFIeldRequired(Parent parent, ArrayList<TextFieldRequired> nodes) {
        for (Node node : parent.getChildrenUnmodifiable()) {

            if (node instanceof TextFieldRequired) {
                nodes.add((TextFieldRequired) node);
            } else if (node instanceof Pane) {
                addAllTextFIeldRequired((Parent) node, nodes);
            }
        }
    }

    private boolean validateDemographics() {
        boolean flag = true;
        Parent root = (Parent) tabDemographics.getContent();
        for (TextFieldRequired txf : getAllTextFieldRequired(root)) {
            if (!txf.isValid()) {
                flag = false;
            }
        }

        if (flag) {
            //No errors
            tabDemographics.getStyleClass().clear();
            tabDemographics.getStyleClass().addAll("tab-valid", "tab");
        } else {
            //Errors
            tabDemographics.getStyleClass().clear();
            tabDemographics.getStyleClass().addAll("tab-invalid", "tab");
        }
        //IsValid activates the color effect. They all have to be called.
        /*
        txfName.isValid();
        txfAddress.isValid();
        txfWeight.isValid();
        txfHeight.isValid();
        
       return txfName.isValid() && txfAddress.isValid() && txfWeight.isValid() && txfHeight.isValid();
         */
        return flag;
    }

    private boolean validateTabYBalanceTest() {
        boolean flag = true;

        for (TextFieldRequired txf : getAllTextFieldRequired(vbYBalanceRoot)) {
            if (!txf.isValid()) {
                flag = false;
            }
        }

        if (flag) {
            //No errors
            tabYBalance.getStyleClass().clear();
            tabYBalance.getStyleClass().addAll("tab-valid", "tab");
        } else {
            //Errors
            tabYBalance.getStyleClass().clear();
            tabYBalance.getStyleClass().addAll("tab-invalid", "tab");
        }

        //Validate fields in tab 1 and set errors flag 0 to true if any errors are found.
        /* if (txfDeepSquat.getText().equals("")) {
            
            //Red shadow effect
            txfDeepSquat.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
            //txfAddress.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");

            return false;
        }*/
        return flag;
    }

    private boolean validateFMS() {
        boolean flag = true;

        for (TextFieldRequired txf : getAllTextFieldRequired(vbFMSRoot)) {
            if (!txf.isValid()) {
                flag = false;
            }
        }

        if (flag) {
            //No errors
            tabFMS.getStyleClass().clear();
            tabFMS.getStyleClass().addAll("tab-valid", "tab");
        } else {
            //Errors
            tabFMS.getStyleClass().clear();
            tabFMS.getStyleClass().addAll("tab-invalid", "tab");
        }
        return flag;
    }

    private boolean validateTabs(int index) {
        if (index == -1) {
            index = selectionModel.getSelectedIndex();
        }
        boolean flag = false;
        switch (index) {
            case 0:
                flag = validateDemographics();
                break;
            case 1:
                flag = validateTabYBalanceTest();
                break;
            case 2:
                flag = validateFMS();
                break;
            case 3:
                flag = true;
                break;
            case 4:
                break;
        }

        if (flag) {
            //No errors
            selectionModel.getSelectedItem().getStyleClass().clear();
            selectionModel.getSelectedItem().getStyleClass().addAll("tab-valid", "tab");
        } else {
            //Errors
            selectionModel.getSelectedItem().getStyleClass().clear();
            selectionModel.getSelectedItem().getStyleClass().addAll("tab-invalid", "tab");
        }

        return flag;
    }

    private boolean validateTabs() {

        if (validateDemographics() && validateTabYBalanceTest() && validateFMS()) {
            btnFinish.setDisable(false);
            return true;
        }
        btnFinish.setDisable(true);
        return false;
    }

    @FXML
    private void finishDataCollection(ActionEvent e) {
        
        //Try with a catch if you get exceptions.
        //Athlete temp = createAthlete();
        createAthlete();
        System.out.println("Did Stuff");
    }

    @FXML
    private void testingData(ActionEvent e) {
        //YBalance
        for (TextFieldRequired txf : getAllTextFieldRequired(vbYBalanceRoot)) {
            txf.setText("2");
        }
        txfName.setText("Potato");
        txfAddress.setText("Address potato");
        //txfCity.setText("Potatoland");
        //txfSchool.setText("Potato High");
       // txfZip.setText("66666");
        //txfPhone.setText("9999999999");
        txfHeight.setText("5");
        txfWeight.setText("1");
        txfAge.setText("525");
        radMale.setSelected(true);
        //cbState.getSelectionModel().select(0);
        //dpDate.setValue(LocalDate.now());
        dominance.getToggles().get(0).setSelected(true);
        //txfPrimarySport.setText("Potatoball");
        //txfPrimaryPosition.setText("Fried Potato");

        tgDeepSquat.getToggles().get(0).setSelected(true);
        tgHurdleStepL.getToggles().get(0).setSelected(true);
        tgHurdleStepR.getToggles().get(0).setSelected(true);

        tgInlineLoungeL.getToggles().get(0).setSelected(true);
        tgInlineLoungeR.getToggles().get(0).setSelected(true);

        tgShoulderMobilityL.getToggles().get(2).setSelected(true);
        tgShoulderMobilityR.getToggles().get(2).setSelected(true);
        tgActiveStraightL.getToggles().get(2).setSelected(true);
        tgActiveStraightR.getToggles().get(1).setSelected(true);
        tgTrunkStability.getToggles().get(1).setSelected(true);
        tgRotaryStabilityL.getToggles().get(2).setSelected(true);
        tgRotaryStabilityR.getToggles().get(1).setSelected(true);
    }

    //Create Athlete object.
    private void createAthlete() {

        /**
         * **************Athlete Creation********************
         */
        Calendar cal = Calendar.getInstance();
        
        
        
        
        
        
        String name = txfName.getText();
        String date = lblDate.getText();
       
        String address = txfAddress.getText();
        String city = txfCity.getText();
        String state = (cbState.getValue()!=null)?"No State Selected":cbState.getValue().toString();
        int zip = (txfZip.getText().equals("") ? 0 : Integer.parseInt(txfZip.getText()));
        String phone = txfPhone.getText();
        String school = txfSchool.getText();
        double height = (txfHeight.getText().equals("") ? 0 : Double.parseDouble(txfHeight.getText()));
        double weight = (txfWeight.getText().equals("") ? 0 : Double.parseDouble(txfWeight.getText()));
        int age = (txfAge.getText().equals("") ? 0 : Integer.parseInt(txfAge.getText()));
        cal.add(Calendar.YEAR, (age *-1));
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String dateOfBirth = dateFormat.format(cal.getTime());
        dateOfBirth = (dpDate.getValue() != null)?dpDate.getValue().toString():dateOfBirth;
        String gender = (tgGender.getSelectedToggle() != null) ? ((ToggleButton) tgGender.getSelectedToggle()).getText() : "-";
        String handDominance = (dominance.getSelectedToggle() != null) ? ((ToggleButton) dominance.getSelectedToggle()).getText() : "-";
        String legDominance = (dominance.getSelectedToggle() != null) ? ((ToggleButton) dominance.getSelectedToggle()).getText() : "-";
        String primarySport = txfPrimarySport.getText();
        String primaryPosition = txfPrimaryPosition.getText();

        Athlete temp = new Athlete(name, date, dateOfBirth, address, city, state, zip, phone, school, height, weight, age, gender, handDominance, legDominance, primarySport, primaryPosition);

        //Try with a catch if you get exceptions.
        temp.addRow();

        System.out.println("Created Athlete");

    }

    private void createFMS() {
        
    }

    private void createYBalance() {
        
    }
    /**
     * **********************Fitness Data injections********************************
     */
    @FXML
    TextField txfRestingHR;
    @FXML
    TextField txfRestingBPA;
    @FXML
    TextField txfRestingBPB;
    @FXML
    TextField txfBMI;
    @FXML
    TextField txfPeakFLow1;
    @FXML
    TextField txfPeakFLow2;
    @FXML
    TextField txfWCirc;
    @FXML
    TextField txfHipCirc;
    @FXML
    TextField txfMidTCirc;
    @FXML
    TextField txfFlexArmCirc;
    @FXML
    TextField txfAntThigh1;
    @FXML
    TextField txfAntThigh2;
    @FXML
    TextField txfAntThighAVG;
    @FXML
    TextField txfHamCSA;
    @FXML
    TextField txfQuadCSA;
    @FXML
    TextField txfTotalCSA;
    @FXML
    TextField txfStartDist;
    @FXML
    TextField txfEndDist1;
    @FXML
    TextField txfEndDist2;
    @FXML
    TextField txfEndDist3;
    @FXML
    TextField txfFinalDist;
    @FXML
    TextField txfHGR1;
    @FXML
    TextField txfHGR2;
    @FXML
    TextField txfHGR3;
    @FXML
    TextField txfHGL1;
    @FXML
    TextField txfHGL2;
    @FXML
    TextField txfHGL3;
    @FXML
    TextField txfProneTime;
    @FXML
    TextField txfKneeExtForceR1;
    @FXML
    TextField txfKneeExtForceR2;
    @FXML
    TextField txfKneeExtForceL1;
    @FXML
    TextField txfKneeExtForceL2;
    @FXML
    TextField txfJH1;
    @FXML
    TextField txfJH2;
    @FXML
    TextField txfMedPass1;
    @FXML
    TextField txfMedPass2;
    @FXML
    TextField txfPostHR;
    @FXML
    TextField txfVO2Max;
    @FXML
    TextField txfPostVO2Max;
    @FXML
    TextField txfRockportHR;
    @FXML
    TextField txfRockportTime;
    @FXML
    TextField txfRockportVO2Max;
    @FXML
    TextField txfWalkDistance;
    @FXML
    TextField txfWalkVO2;
    
    @FXML
    private void createFitnessData(ActionEvent e) {
        String regexNum = TextFieldRequired.NUMERIC;
        DecimalFormat df = new DecimalFormat("#.##");
        /**
         * ***************First Section********************
         */
        double restingHR = 0;
        double restingBPA=0;
        double restingBPB=0;
        double bmi=0;
        double peakFlow=0;
        double height=0;
        double weight=0;
        double age =0;
        try {
            if(txfAge2.getText().matches(regexNum)){
                age =Double.parseDouble(txfAge2.getText());
            }
            if (txfHeight2.getText().matches(regexNum) && txfWeight2.getText().matches(regexNum)) {
                height = Double.parseDouble(txfHeight2.getText());
                weight = Double.parseDouble(txfWeight2.getText());

                bmi = (weight / (Math.pow(height, 2))) * 10000;
                txfBMI.setText(df.format(bmi));
            }else{
                txfBMI.setText("");
            }

            if (txfRestingHR.getText().matches(regexNum)) {
                restingHR = Double.parseDouble(txfRestingHR.getText());
            }

            if (txfRestingBPA.getText().matches(regexNum) && txfRestingBPB.getText().matches(regexNum)) {
                restingBPA = Double.parseDouble(txfRestingHR.getText());
                restingBPB = Double.parseDouble(txfRestingHR.getText());
            }
            if (txfPeakFLow1.getText().matches(regexNum) && txfPeakFLow2.getText().matches(regexNum)) {
                double pf1 = Double.parseDouble(txfHeight2.getText());
                double pf2 = Double.parseDouble(txfWeight2.getText());

                peakFlow = Math.max(pf1, pf2);
            }
        } catch (Exception exception) {
            System.out.println("First section of fitness data has errors");
            exception.printStackTrace();
        }
        /**
         * ***************Anthropometrics Section********************
         */
        double ant1=0;
        double ant2=0;
        double wCirc=0;
        double hCirc=0;
        double midCirc=0;
        double fCirc=0;
        double hamCSA=0;
        double quadCSA=0;
        double totalCSA=0;
        
        try{
            if(txfAntThigh1.getText().matches(regexNum) && txfAntThigh2.getText().matches(regexNum)){
                ant1=Double.parseDouble(txfAntThigh1.getText());
                ant2=Double.parseDouble(txfAntThigh2.getText());
                
                double avg = (ant1+ant2)/2;
                txfAntThighAVG.setText(""+df.format(avg));
                
                //Calculate CSA variables
                if(txfMidTCirc.getText().matches(regexNum)){
                    midCirc = Double.parseDouble(txfMidTCirc.getText());
                    
                    quadCSA = (2.52 * midCirc) - (1.25*avg) - 45.13;
                    hamCSA = (1.08 * midCirc) - (0.64*avg) - 22.69;
                    totalCSA = (4.68 * midCirc) - (2.09*avg) - 80.99;
                    
                    txfHamCSA.setText(df.format(hamCSA));
                    txfQuadCSA.setText(df.format(quadCSA));
                    txfTotalCSA.setText(df.format(totalCSA));
                }else{
                    midCirc =0;
                    hamCSA=0;
                    quadCSA=0;
                    totalCSA=0;
                    txfHamCSA.setText("");
                    txfQuadCSA.setText("");
                    txfTotalCSA.setText("");
                }
                
                if(txfWCirc.getText().matches(regexNum)){
                    wCirc = Double.parseDouble(txfWCirc.getText());  
                }else{
                    wCirc=0;
                }
                
                if(txfHipCirc.getText().matches(regexNum)){
                    hCirc = Double.parseDouble(txfHipCirc.getText());  
                }else{
                    hCirc=0;
                }
                
                if(txfFlexArmCirc.getText().matches(regexNum)){
                    fCirc = Double.parseDouble(txfFlexArmCirc.getText());  
                }else{
                    fCirc=0;
                }
                                
            }else{
                
                hamCSA=0;
                quadCSA=0;
                totalCSA=0;
                txfHamCSA.setText("");
                txfQuadCSA.setText("");
                txfTotalCSA.setText("");
                txfAntThighAVG.setText("");
            }
        } catch (Exception exception) {
            System.out.println("Antrhopometrics section of fitness data has errors");
            exception.printStackTrace();
        }
        
        /**
         * ***************Anthropometrics Section********************
         */
        
        double startDist=0;
        double endDist1=0;
        double endDist2=0;
        double endDist3=0;
        double endDist=0;
        try{
            if(txfStartDist.getText().matches(regexNum)){
                startDist = Double.parseDouble(txfStartDist.getText());
                boolean flag=true;
                if(txfEndDist1.getText().matches(regexNum)&&txfEndDist1.getText().matches(regexNum)&&txfEndDist1.getText().matches(regexNum)){
                    endDist1 = Double.parseDouble(txfEndDist1.getText());
                    endDist2 = Double.parseDouble(txfEndDist2.getText());
                    endDist3 = Double.parseDouble(txfEndDist3.getText());
                    
                    endDist = (Math.max(endDist1, Math.max(endDist2, endDist3))) - startDist;
                }else{
                    txfFinalDist.setText("");
                }
            }else{
                txfStartDist.setText("");

                txfFinalDist.setText("");
            }
        } catch (Exception exception) {
            System.out.println("Sit & Reach section of fitness data has errors");
            exception.printStackTrace();
        }
        
        /**
         * ***************Anthropometrics Section********************
         */
        double hgR1=0;
        double hgR2=0;
        double hgR3=0;
        double hgR=0;
        
        double hgL1=0;
        double hgL2=0;
        double hgL3=0;
        double hgL=0;
        
        double proneTime=0;
        double kneeExtForceR1=0;
        double kneeExtForceR2=0;
        double kneeExtForceL1=0;
        double kneeExtForceL2=0;
        
        double jh1=0;
        double jh2=0;
        double medPass1=0;
        double medPass2=0;
        
        try{
           if(txfHGR1.getText().matches(regexNum)&&txfHGR2.getText().matches(regexNum)&&txfHGR2.getText().matches(regexNum)){
               hgR1=Double.parseDouble(txfHGR1.getText());
               hgR2=Double.parseDouble(txfHGR2.getText());
               hgR3=Double.parseDouble(txfHGR3.getText());
               
               hgR= Math.max(hgR1, Math.max(hgR2, hgR3));
           }else{
               hgR=0;
               hgR1=0;
               hgR2=0;
               hgR3=0;
           }
           
           if(txfHGL1.getText().matches(regexNum)&&txfHGL2.getText().matches(regexNum)&&txfHGL2.getText().matches(regexNum)){
               hgL1=Double.parseDouble(txfHGL1.getText());
               hgL2=Double.parseDouble(txfHGL2.getText());
               hgL3=Double.parseDouble(txfHGL3.getText());
               
               hgL= Math.max(hgL1, Math.max(hgL2, hgL3));
           }else{
               hgL=0;
               hgL1=0;
               hgL2=0;
               hgL3=0;
           }
           
           if(txfProneTime.getText().matches(regexNum)){
               proneTime = Double.parseDouble(txfProneTime.getText());
           }else{
               proneTime=0;
           }
           
           if(txfKneeExtForceR1.getText().matches(regexNum)&&txfKneeExtForceR2.getText().matches(regexNum)){
               kneeExtForceR1 = Double.parseDouble(txfKneeExtForceR1.getText());
               kneeExtForceR2 = Double.parseDouble(txfKneeExtForceR2.getText());        
           }else{
               kneeExtForceR1=0;
               kneeExtForceR2=0;
           }
           if(txfKneeExtForceL1.getText().matches(regexNum)&&txfKneeExtForceL2.getText().matches(regexNum)){
               kneeExtForceL1 = Double.parseDouble(txfKneeExtForceL1.getText());
               kneeExtForceL2 = Double.parseDouble(txfKneeExtForceL2.getText()); 
           }else{
               kneeExtForceL1=0;
               kneeExtForceL2=0;
           }
           if(txfJH1.getText().matches(regexNum)&&txfJH2.getText().matches(regexNum)){
               jh1 = Double.parseDouble(txfJH1.getText());
               jh2 = Double.parseDouble(txfJH2.getText());
           }else{
               jh1 =0;
               jh2=0;
           }
           if(txfMedPass1.getText().matches(regexNum)&&txfMedPass2.getText().matches(regexNum)){
               medPass1 = Double.parseDouble(txfMedPass1.getText());
               medPass2 = Double.parseDouble(txfMedPass2.getText());
           }else{
               medPass1 = 0;
               medPass2 = 0;
           }
           
        } catch (Exception exception) {
            System.out.println("Sit & Reach section of fitness data has errors");
            exception.printStackTrace();
        }
        
        /**
         * ***************Anthropometrics Section********************
         */
        
        double postHR=0;
        double postVO2Max=0;
        double vO2Max=0;
        double rockHR=0;
        double walkTime =0;
        double rockVO2Max=0;
        double walkDistance=0;
        double walkVO2Max=0;
        try{
            vO2Max = ((0.046*height) - (0.021*age)-4.93)*1000;//ml/min
            vO2Max = vO2Max / weight; //ml/kg/min
            txfVO2Max.setText(df.format(vO2Max));
            
            if(txfPostHR.getText().matches(regexNum)){
                postHR = Double.parseDouble(txfPostHR.getText());
                postVO2Max = (-0.9675 * postHR)+77.643;
                txfPostVO2Max.setText(df.format(postVO2Max));
            }else{
                txfPostVO2Max.setText("");
            }
            
            //Rockport Test
            if(txfRockportHR.getText().matches(regexNum)&&txfRockportTime.getText().matches("^[0-9]+(:\\d+)+$")){
                String time[] = txfRockportTime.getText().split(":");
                
                rockHR=Double.parseDouble(txfRockportHR.getText());
                walkTime=Double.parseDouble(time[0])+ (Double.parseDouble(time[1]) / 60);//convert seconds to minutes.
                //Just doing Male for now.
                if(age>=30 && age <=65){
                    rockVO2Max= (139.168 - (0.3877 * age) - (0.1692*(weight*2.20462)) - (3.2649*walkTime) - (0.1565 * rockHR));
                }else if(age>=18 && age <=29){
                    rockVO2Max= (97.660 - (0.0957 * age) - (0.1692*(weight*2.20462)) - (1.4537*walkTime) - (0.1194 * rockHR));
                }
                
                txfRockportVO2Max.setText(df.format(rockVO2Max));
            }else{
                txfRockportVO2Max.setText("");
            }
            
            //12-Minute Walk Test
            if(txfWalkDistance.getText().matches(regexNum)){
                walkDistance=Double.parseDouble(txfWalkDistance.getText());
                //VO2max(mL/kg/min)= (distance covered in meters - 504.9)/44.73
                walkVO2Max = (walkDistance - 504.9) / 44.73;
                txfWalkVO2.setText(df.format(walkVO2Max));   
            }else{
                txfWalkVO2.setText("");
            }
            
        } catch (Exception exception) {
            System.out.println("Estimated Aerobic thing of fitness data has errors");
            exception.printStackTrace();
        }
    }
}
