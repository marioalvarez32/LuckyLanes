/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.scene.control;

import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 *
 * @author Mario
 */
public class TextFieldRequired extends TextField {
    public static String ALPHA = "^[a-zA-Z]+$";
    public static String ALPHANUMERIC = "^[a-zA-Z0-9]+$";
    public static String NUMERIC = "^[1-9]+[0-9]*$";
    
    private String validationRegex;
    private String validationPrompt;
    private boolean isRequired;

    public TextFieldRequired() {
        super("");
        validationRegex = "";
        validationPrompt = "";
        isRequired = false;
    }

    public void setRequired(boolean r) {
        this.isRequired = r;
    }

    public boolean isRequired() {
        return this.isRequired;
    }
    
    public void setValidation(String regex, String validationPrompt) {
        this.validationRegex = regex;
        this.validationPrompt = validationPrompt;
        
        this.setTooltip(new Tooltip(validationPrompt));

        this.textProperty().addListener((observable, oldValue, newValue) -> {

            if (isRequired) {
                if (isValid(newValue)) {
                    this.setStyle("-fx-effect: dropshadow( gaussian , rgba(51, 174, 44,1) , 10,0,0,0 );");
                }else {
                    this.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
                }
            } else {
                if (isValid(newValue)) {
                    this.setStyle("-fx-effect: dropshadow( gaussian , rgba(51, 174, 44,1) , 10,0,0,0 );");
                }else if(newValue.matches("^[ ]*$")){
                     this.setStyle("-fx-effect: null;");
                }else {
                    this.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
                }
            }

        });
    }
    public boolean validate(){
        return isRequired && isValid();
    }
    public boolean isValid() {
        
        if (isRequired) {
            if (isValid(this.getText())) {
                this.setStyle("-fx-effect: dropshadow( gaussian , rgba(51, 174, 44,1) , 10,0,0,0 );");
                return true;
            }
            this.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
            return false;
        }
        //If the textfield is not empty, it must validate
        if(!this.getText().equals("")){
            if(isValid(this.getText())){
                return true;
            }
            
            return false;
        }
        return true;
    }

    public boolean isValid(String text) {
        return text.matches(validationRegex);
    }
}
