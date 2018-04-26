/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.formObjects;

/**
 *
 * @author nicholas bentzen
 * This class is to implement the equations in "Aerobic Test Instructions and Norms"
 * pdf document.
 * 
 */
public class Aerobic {
    private int sexInt, age, ageGroup;
    private String sex, rating;
    private int[] ageRange = {18, 26, 36, 46, 56, 65};
    public Aerobic(int age, String sex){
        if(sex == "male") this.sexInt = 1;
        else this.sexInt = 0;
        this.age = age;
        this.sex = sex;
        this.calcAgeDemographic();
    }
    
    //helper method: calculates the age demographic of an athlete to determine
    //appropriate range of heart beats for a given score.
    private void calcAgeDemographic(){
        for(int i = 0; i < this.ageRange.length; i++){
            if(i == this.ageRange.length - 1){
                if(this.ageRange[i] > this.age){
                    this.ageGroup = this.ageRange[i];
                }
            }else{
                if(this.age >= this.ageRange[i] && this.age < this.ageRange[i + 1] ){
                    this.ageGroup = this.ageRange[i];
                }
            }
        }
    }
    
    // helper method: determines score of Excellent, Above Average, etc. by looking
    // at the age range,gender, and heart rate.
    private void calcRating(){
        //if gender = male use mens rating table, else use female ratings table
        //need to calculate 3 scores: Bench, 12 min walk, and Rockport walk
        // need to calculte VO2 max for each score
    }
    
    
    //returns the rating, Ex: Excellent, Good, etc.
    public String getRating(){
        return this.rating;
    }
    
    //returns the number that determines the rating
    public int getScore(){
        return 0;
    }
}
