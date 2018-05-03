/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.formObjects;

/**
 *
 * @author Nick Bentzen
 */
public class YBalance {
    private double rightLimbLength, 
            antRightMean, antLeftMean,
            pmRightMean, pmLeftMean,
            plRightMean, plLeftMean;
    
    //constructor that takes in all required fields.
    public YBalance(double rightLimbLength, double antR1, double antR2, double antR3, double antL1, double antL2, double antL3, double pmR1, double pmR2, double pmR3,
            double pmL1, double pmL2, double pmL3, double plR1, double plR2, double plR3, double plL1, double plL2, double plL3){
            this.rightLimbLength = rightLimbLength;
            this.antRightMean = (antR1 + antR2 + antR3) / 3.0;
            this.antLeftMean = (antL1 + antL2 + antL3) / 3.0;
            this.pmRightMean = (pmR1 + pmR2 + pmR3) / 3.0;
            this.pmLeftMean = (pmL1 + pmL2 + pmL3) / 3.0;
            this.plRightMean = (plR1 + plR2 + plR3) / 3.0;
            this.plLeftMean = (plL1 + plL2 + plL3) / 3.0;
    }
    
    //empty constructor
    public YBalance(){
        
    }
    
    //sets the rightLimbLength in cm
    public void setRightLimbLength(double rightLimbLength){
        this.rightLimbLength = rightLimbLength;
    }
    //takes in three measurements for right anterior and sets the mean
    public void setRightAntMean(double ant1, double ant2, double ant3){
        this.antRightMean = (ant1 + ant2 + ant3)/3.0;
    }
    
    //takes in three measurements for left anterior and sets the mean
    public void setLeftAntMean(double ant1, double ant2, double ant3){
        this.antLeftMean = (ant1 + ant2 + ant3)/3.0;
    }
    
    //takes in 3 measurements for posteromedial and sets the mean
    public void setPmRightMean(double num1, double num2, double num3){
        this.pmRightMean = (num1 + num2 + num3)/3.0;
    }
    
     //takes in 3 measurements for posteromedial and sets the mean
    public void setPmLeftMean(double num1, double num2, double num3){
        this.pmLeftMean = (num1 + num2 + num3)/3.0;
    }
    
     //takes in 3 measurements for posteromedial and sets the mean
    public void setPLRightMean(double num1, double num2, double num3){
        this.plRightMean = (num1 + num2 + num3)/3.0;
    }
    
     //takes in 3 measurements for posteromedial and sets the mean
    public void setPLLeftMean(double num1, double num2, double num3){
        this.plLeftMean = (num1 + num2 + num3)/3.0;
    }
    
    //returns anterior difference.
    public double getAntDiff(){
        return this.antRightMean - this.antLeftMean;
    }
    
    //returns posteromedial difference.
    public double getPmDiff(){
        return this.pmRightMean - this.pmLeftMean;
    }
    
    //returns posterolateral difference.
    public double getPlDiff(){
        return this.plRightMean - this.plLeftMean;
    }
    
    //returns composite right score
    public double getRightScore(){
        return this.pmRightMean + this.plRightMean + this.antRightMean;
    }
    
    //returns composite left score
    public double getLeftScore(){
        return this.pmLeftMean + this.plLeftMean + this.antLeftMean;
    }
    
    public double getRightLimbLength() {
        return rightLimbLength;
    }

    public double getAntRightMean() {
        return antRightMean;
    }

    public double getAntLeftMean() {
        return antLeftMean;
    }

    public double getPmRightMean() {
        return pmRightMean;
    }

    public double getPmLeftMean() {
        return pmLeftMean;
    }

    public double getPlRightMean() {
        return plRightMean;
    }

    public double getPlLeftMean() {
        return plLeftMean;
    }
    
    
}
