/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.formObjects;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 *
 * @author nicholas bentzen
 * This class is to implement the equations in "Aerobic Test Instructions and Norms"
 * pdf document.
 * 
 */

public class Aerobic {
    private int sexInt, age;
    private String sex, rating;
    private int[] maleRange = new int[5];
    private int[] femaleRange = new int[5];
   
    //constructor takes an integer age, and string sex.
    public Aerobic(int age, int heartRate, String sex) throws FileNotFoundException{
        if(sex == "male") this.sexInt = 1;
        else this.sexInt = 0;
        //this.age = age;
        this.sex = sex;
        int[] ageRange = {18, 26, 36, 46, 56, 65};
        int ageGroup = this.calcIndex(age, ageRange);
        HeartBeatFileReader reader = new HeartBeatFileReader("womenHB.txt");
        int[] heartArr = reader.getArr(ageGroup);
        
        
        
        
        
    }
    
    //helper method: calculates the age demographic of an athlete to determine
    //appropriate range of heart beats for a given score.
    private int calcIndex(int num, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1){
                if(arr[i] > num){
                    return i;
                }
            }else{
                if(compareNums(num, arr[i], arr[i+1])){
                    return i;
                }
            }
        }
        return -1;
    }
    
    // helper method: determines score of Excellent, Above Average, etc. by looking
    // at the age range,gender, and heart rate.
    private void calcRating(){
        if(this.sex == "male"){
            
        }else{
            
        }
        //if sex = male use mens rating table, else use female ratings table
        //need to calculate 3 scores: Bench, 12 min walk, and Rockport walk
        // need to calculte VO2 max for each score
    }
    
    //method takes in 3 numbers: mid, low  high; method returns
    // if mid is >= low and < high.
    private boolean compareNums(int mid, int low, int high){
        return low >= mid && mid < high;
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
