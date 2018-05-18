/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.formObjects;

import main.java.Database;

/**
 *
 * @author Nick Bentzen
 */
public class YBalance {

    private double rightLimbLength,
            antRightMean, antLeftMean,
            pmRightMean, pmLeftMean,
            plRightMean, plLeftMean, antR1, antR2, antR3, antL1, antL2, antL3, pmR1, pmR2, pmR3,
            pmL1, pmL2, pmL3, plR1, plR2, plR3, plL1, plL2, plL3;
    private double compositeLeft;
    private double compositeRight;

    //constructor that takes in all required fields.
    public YBalance(double rightLimbLength, double antR1, double antR2, double antR3, double antL1, double antL2, double antL3, double pmR1, double pmR2, double pmR3,
            double pmL1, double pmL2, double pmL3, double plR1, double plR2, double plR3, double plL1, double plL2, double plL3) {
        this.pmL1=pmL1;
        this.pmL2=pmL2;
        this.pmL3=pmL3;
        this.pmR1=pmR1;
        this.pmR2=pmR2;
        this.pmR3=pmR3;
        this.plL1=pmL1;
        this.plL2=pmL2;
        this.plL3=pmL3;
        this.plR1=pmR1;
        this.plR2=pmR2;
        this.plR3=pmR3;
        this.antL1=antL1;
        this.antL2=antL2;
        this.antL3=antL3;
        this.antR1=antR1;
        this.antR2=antR2;
        this.antR3=antR3;     
        this.rightLimbLength = rightLimbLength;
        this.antRightMean = Math.max(Math.max(antR1, antR2), antR3);
        this.antLeftMean = Math.max(Math.max(antL1, antL2), antL3);
        this.pmRightMean = Math.max(Math.max(pmR1, pmR2), pmR3);
        this.pmLeftMean = Math.max(Math.max(pmL1, pmL2), pmL3);
        this.plRightMean = Math.max(Math.max(plR1, plR2), plR3);
        this.plLeftMean = Math.max(Math.max(plL1, plL2), plL3);
        
        this.compositeLeft=((this.antLeftMean + this.pmLeftMean + this.plLeftMean) / (3 * this.rightLimbLength)) * 100;
        this.compositeRight=((this.antRightMean + this.pmRightMean + this.plRightMean) / (3 * this.rightLimbLength)) * 100;
    }

    public String toHTML(){
        String rowStart = "<tr><td>";
        String rowMid = "</td><td>";
        String rowEnd = "</td></tr>";
        String html = "</br></br></br><table><tr><th>Y-Balance</th><th></th></tr>";
        html += rowStart + "Left Posteromedial 1" + rowMid + this.pmL1 + rowEnd
                + rowStart + "Left Posteromedial 2" + rowMid + this.pmL2 + rowEnd
                + rowStart + "Left Posteromedial 3" + rowMid + this.pmL3 + rowEnd
                + rowStart + "Right Posteromedial 1" + rowMid + this.pmR1 + rowEnd
                + rowStart + "Right Posteromedial 2" + rowMid + this.pmR2 + rowEnd
                + rowStart + "Right Posteromedial 3" + rowMid + this.pmR3 + rowEnd
                + rowStart + "Left Posterolateral 1" + rowMid + this.plL1 + rowEnd
                + rowStart + "Left Posterolateral 2" + rowMid + this.plL2 + rowEnd
                + rowStart + "Left Posterolateral 3" + rowMid + this.plL3 + rowEnd
                + rowStart + "Right Posterolateral 1" + rowMid + this.plR1 + rowEnd
                + rowStart + "Right Posterolateral 2" + rowMid + this.plR2 + rowEnd
                + rowStart + "Right Posterolateral 3" + rowMid + this.plR3 + rowEnd
                + rowStart + "Left Anterior 1" + rowMid + this.antL1 + rowEnd
                + rowStart + "Left Anterior 2" + rowMid + this.antL2 + rowEnd
                + rowStart + "Left Anterior 3" + rowMid + this.antL3 + rowEnd
                + rowStart + "Right Anterior 1" + rowMid + this.antR1 + rowEnd
                + rowStart + "Right Anterior 2" + rowMid + this.antR2 + rowEnd
                + rowStart + "Right Anterior 3" + rowMid + this.antR3 + rowEnd
                + rowStart + "Right Limb Length" + rowMid + this.rightLimbLength + rowEnd
                + rowStart + "Right Anterior Mean " + rowMid + this.antRightMean + rowEnd
                + rowStart + "Left Anterior Mean " + rowMid + this.antLeftMean + rowEnd
                + rowStart + "Left Posteromedial Mean" + rowMid + this.pmLeftMean + rowEnd
                + rowStart + "Right Posteromedial Mean" + rowMid + this.pmRightMean + rowEnd
                + rowStart + "Left Posterolateral Mean" + rowMid + this.plLeftMean + rowEnd
                + rowStart + "Right Posterolateral Mean" + rowMid + this.plRightMean + rowEnd
                        +"</table>";
                /*
                this.antRightMean = Math.max(Math.max(antR1, antR2), antR3);
        this.antLeftMean = Math.max(Math.max(antL1, antL2), antL3);
        this.pmRightMean = Math.max(Math.max(pmR1, pmR2), pmR3);
        this.pmLeftMean = Math.max(Math.max(pmL1, pmL2), pmL3);
        this.plRightMean = Math.max(Math.max(plR1, plR2), plR3);
        this.plLeftMean = Math.max(Math.max(plL1, plL2), plL3);        
                */
        return html;
    }
    //empty constructor
    public YBalance() {

    }

    //sets the rightLimbLength in cm
    public void setRightLimbLength(double rightLimbLength) {
        this.rightLimbLength = rightLimbLength;
    }

    //takes in three measurements for right anterior and sets the mean
    public void setRightAntMean(double ant1, double ant2, double ant3) {
        this.antRightMean = (ant1 + ant2 + ant3) / 3.0;
    }

    //takes in three measurements for left anterior and sets the mean
    public void setLeftAntMean(double ant1, double ant2, double ant3) {
        this.antLeftMean = (ant1 + ant2 + ant3) / 3.0;
    }

    //takes in 3 measurements for posteromedial and sets the mean
    public void setPmRightMean(double num1, double num2, double num3) {
        this.pmRightMean = (num1 + num2 + num3) / 3.0;
    }

    //takes in 3 measurements for posteromedial and sets the mean
    public void setPmLeftMean(double num1, double num2, double num3) {
        this.pmLeftMean = (num1 + num2 + num3) / 3.0;
    }

    //takes in 3 measurements for posteromedial and sets the mean
    public void setPLRightMean(double num1, double num2, double num3) {
        this.plRightMean = (num1 + num2 + num3) / 3.0;
    }

    //takes in 3 measurements for posteromedial and sets the mean
    public void setPLLeftMean(double num1, double num2, double num3) {
        this.plLeftMean = (num1 + num2 + num3) / 3.0;
    }

    //returns anterior difference.
    public double getAntDiff() {
        return this.antRightMean - this.antLeftMean;
    }

    //returns posteromedial difference.
    public double getPmDiff() {
        return this.pmRightMean - this.pmLeftMean;
    }

    //returns posterolateral difference.
    public double getPlDiff() {
        return this.plRightMean - this.plLeftMean;
    }

    //returns composite right score
    public double getRightScore() {
        return this.pmRightMean + this.plRightMean + this.antRightMean;
    }

    //returns composite left score
    public double getLeftScore() {
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
   
    public void addRow() {
        String sql;
            sql = "INSERT INTO YBALANCE VALUES ("
                + "null,"
                + rightLimbLength +","
                    + antRightMean +","+antLeftMean +","
                    + pmRightMean +","+pmLeftMean +","
                    + plRightMean +","+plLeftMean +","
                    + antR1 +","+antR2 +","+antR3 +","
                    + antL1 +","+antL2 +","+antL3 +","
                    + pmR1 +","+pmR2 +","+pmR3 +","
                    + pmL1 +","+pmL2 +","+pmL3 +","
                    + plR1 +","+plR2 +","+plR3 +","
                    + plL1 +","+plL2 +","+plL3 +","
                    + compositeLeft +","+compositeRight +");";
        Database.executeUpdate(sql);
    }
}
