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
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    TextField txfTrunkStability;
    @FXML
    TextField txfInlineLounge;
    @FXML
    TextField txfShoulderMobility;
    @FXML
    TextField txfActiveStraight;
    @FXML
    TextField txfRotaryStability;
    @FXML
    TextField txfHurdleStep;
    @FXML
    TextField txfDeepSquat;

    /**
     * *************************************************************************
     *                                                                         *
     * Fitness Testing Data Sheet Injected Objects
     * **************************************************************************
     */
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

        errors = new boolean[NUM_TAB];

        lblDate.setText(dateFormat.format(date));
        selectionModel = tabPane.getSelectionModel();
        initializeDemographics();
        initializeYBalance();
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
    }
    private void initializeYBalance(){
        //Initialize all YBalanace textfield boxes to be required and to validate to only digits.
        
        for(TextFieldRequired txf:getAllTextFieldRequired(vbYBalanceRoot)){
            txf.setValidation(TextFieldRequired.NUMERIC, "Measurement must be in centimeters and only contain digits.");
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
        tgHurdleStepR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgHurdleStepR.getSelectedToggle() != null && tgHurdleStepL.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgHurdleStepL.getSelectedToggle());
                txfHurdleStep.setText(minValue(l.getText(), r.getText()));

            }
        });

        tgHurdleStepL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgHurdleStepR.getSelectedToggle() != null && tgHurdleStepL.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgHurdleStepR.getSelectedToggle());
                txfHurdleStep.setText(minValue(l.getText(), r.getText()));

            }
        });
        tgDeepSquat.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgDeepSquat.getSelectedToggle() != null) {
                ToggleButton currentToggle = ((ToggleButton) newToggle);
                txfDeepSquat.setText(currentToggle.getText());
            }
        });
        //
        tgTrunkStability.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgTrunkStability.getSelectedToggle() != null) {
                ToggleButton currentToggle = ((ToggleButton) newToggle);
                txfTrunkStability.setText(currentToggle.getText());
            }
        });

        //
        tgInlineLoungeR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgInlineLoungeR.getSelectedToggle() != null && tgInlineLoungeL.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgInlineLoungeL.getSelectedToggle());
                txfInlineLounge.setText(minValue(l.getText(), r.getText()));

            }
        });

        tgInlineLoungeL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgInlineLoungeR.getSelectedToggle() != null && tgInlineLoungeL.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgInlineLoungeR.getSelectedToggle());
                txfInlineLounge.setText(minValue(l.getText(), r.getText()));

            }
        });

        //
        tgShoulderMobilityR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgShoulderMobilityR.getSelectedToggle() != null && tgShoulderMobilityL.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgShoulderMobilityL.getSelectedToggle());
                txfShoulderMobility.setText(minValue(l.getText(), r.getText()));

            }
        });

        tgShoulderMobilityL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgShoulderMobilityR.getSelectedToggle() != null && tgShoulderMobilityL.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgShoulderMobilityR.getSelectedToggle());
                txfShoulderMobility.setText(minValue(l.getText(), r.getText()));

            }
        });
        //

        tgActiveStraightR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgActiveStraightR.getSelectedToggle() != null && tgActiveStraightL.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgActiveStraightL.getSelectedToggle());
                txfActiveStraight.setText(minValue(l.getText(), r.getText()));

            }
        });

        tgActiveStraightL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgActiveStraightR.getSelectedToggle() != null && tgActiveStraightL.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgActiveStraightR.getSelectedToggle());
                txfActiveStraight.setText(minValue(l.getText(), r.getText()));

            }
        });

        tgRotaryStabilityR.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgRotaryStabilityR.getSelectedToggle() != null && tgRotaryStabilityL.getSelectedToggle() != null) {
                ToggleButton r = ((ToggleButton) newToggle);
                ToggleButton l = ((ToggleButton) tgRotaryStabilityL.getSelectedToggle());
                txfRotaryStability.setText(minValue(l.getText(), r.getText()));

            }
        });

        tgRotaryStabilityL.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {

            if (tgRotaryStabilityR.getSelectedToggle() != null && tgRotaryStabilityL.getSelectedToggle() != null) {
                ToggleButton l = ((ToggleButton) newToggle);
                ToggleButton r = ((ToggleButton) tgRotaryStabilityR.getSelectedToggle());
                txfRotaryStability.setText(minValue(l.getText(), r.getText()));

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
                nodes.add((TextFieldRequired)node);
            }else if(node instanceof Pane){
                addAllTextFIeldRequired((Parent) node, nodes);
            }
        }
    }

    private boolean validateDemographics() {
        boolean flag = true;
        Parent root = (Parent)tabDemographics.getContent();
        for(TextFieldRequired txf:getAllTextFieldRequired(root)){
            if(!txf.isValid())
                flag=false;
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
        
        for(TextFieldRequired txf:getAllTextFieldRequired(vbYBalanceRoot)){
            if(!txf.isValid())
                flag=false;
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
        boolean flag;
        flag = !"".equals(txfTrunkStability.getText())
                && !"".equals(txfInlineLounge.getText())
                && !"".equals(txfShoulderMobility.getText())
                && !"".equals(txfActiveStraight.getText())
                && !"".equals(txfRotaryStability.getText())
                && !"".equals(txfHurdleStep.getText())
                && !"".equals(txfDeepSquat.getText());

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
        Athlete temp = createAthlete();

        System.out.println("Did Stuff");
    }

    //Create Athlete object.
    private Athlete createAthlete() {

        /**
         * **************Athlete Creation********************
         */
        String name = txfName.getText();
        String date = lblDate.getText();
        String dateOfBirth = dpDate.getValue().toString();
        String address = txfAddress.getText();
        String city = txfCity.getText();
        String state = cbState.getValue().toString();
        int zip = (txfZip.getText().equals("") ? 0 : Integer.parseInt(txfZip.getText()));
        String phone = txfPhone.getText();
        String school = txfSchool.getText();
        double height = (txfHeight.getText().equals("") ? 0 : Double.parseDouble(txfHeight.getText()));
        double weight = (txfWeight.getText().equals("") ? 0 : Double.parseDouble(txfWeight.getText()));
        int age = (txfAge.getText().equals("") ? 0 : Integer.parseInt(txfAge.getText()));

        String gender = (tgGender.getSelectedToggle() != null) ? ((ToggleButton) tgGender.getSelectedToggle()).getText() : "-";
        String handDominance = (dominance.getSelectedToggle() != null) ? ((ToggleButton) dominance.getSelectedToggle()).getText() : "-";
        String legDominance = (dominance.getSelectedToggle() != null) ? ((ToggleButton) dominance.getSelectedToggle()).getText() : "-";
        String primarySport = txfPrimarySport.getText();
        String primaryPosition = txfPrimaryPosition.getText();
<<<<<<< HEAD

        return new Athlete(name, date, dateOfBirth, address, city, state, zip, phone, school, height, weight, age, gender, handDominance, legDominance, primarySport, primaryPosition);

    }

    //Create Athlete object.
    private Athlete createAthlete2() {

        /**
         * **************Athlete Creation********************
         */
        String name = txfName.getText();
        String date = lblDate.getText();
        String dateOfBirth = dpDate.getValue().toString();
        String address = txfAddress.getText();
        String city = txfCity.getText();
        String state = cbState.getValue().toString();
        int zip = (txfZip.getText().equals("") ? 0 : Integer.parseInt(txfZip.getText()));
        String phone = txfPhone.getText();
        String school = txfSchool.getText();
        double height = (txfHeight.getText().equals("") ? 0 : Double.parseDouble(txfHeight.getText()));
        double weight = (txfWeight.getText().equals("") ? 0 : Double.parseDouble(txfWeight.getText()));
        int age = (txfAge.getText().equals("") ? 0 : Integer.parseInt(txfAge.getText()));

        String gender = (tgGender.getSelectedToggle() != null) ? ((ToggleButton) tgGender.getSelectedToggle()).getText() : "-";
        String handDominance = (dominance.getSelectedToggle() != null) ? ((ToggleButton) dominance.getSelectedToggle()).getText() : "-";
        String legDominance = (dominance.getSelectedToggle() != null) ? ((ToggleButton) dominance.getSelectedToggle()).getText() : "-";
        String primarySport = txfPrimarySport.getText();
        String primaryPosition = txfPrimaryPosition.getText();

        return new Athlete(name, date, dateOfBirth, address, city, state, zip, phone, school, height, weight, age, gender, handDominance, legDominance, primarySport, primaryPosition);

=======
        
        Athlete temp = new Athlete(name, date, dateOfBirth, address, city, state,zip, phone, school, height,weight,age, gender, handDominance, legDominance, primarySport, primaryPosition);
        
        //Try with a catch if you get exceptions.
         temp.addRow();
        
        System.out.println("Did Stuff");
>>>>>>> 7966b238964f5dbd966495371d7d3e11dae08dd1
    }
}
