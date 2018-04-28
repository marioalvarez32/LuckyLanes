/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.scene.control;

import javafx.scene.control.TextField;

/**
 *
 * @author Mario
 */
public class TextFieldRequired extends TextField{
    private String validationRegex;
    public TextFieldRequired(){
        super("");
        validationRegex="";
        
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValid(newValue)) {
                this.setStyle("-fx-effect: dropshadow( gaussian , rgba(51, 174, 44,1) , 10,0,0,0 );");
            }else{
                this.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
            }
        });
    }
    public void setValidationRegex(String regex){
        this.validationRegex = regex;
    }
    
    public boolean isValid(){
        if(this.getText().matches(validationRegex)){
            this.setStyle("-fx-effect: dropshadow( gaussian , rgba(51, 174, 44,1) , 10,0,0,0 );");
            return true;
        }
        this.setStyle("-fx-effect: dropshadow( gaussian , rgba(212, 27, 27,1) , 10,0,0,0 );");
        return false;
    }
    
    public boolean isValid(String text){
        if(text.matches(validationRegex)){
            return true;
        }
        return false;
    }
}
