/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.formObjects;

/**
 *
 * @author bentz
 */
public class FitnessTest {
    ////////Global Variables
    //vitals
    private int age, restingHR, restingHR1, restingHR2;
    private double height, bodyWeight, bmi;
    private String gender;
    
    //anthropomeetrics
    private double waistCirc, hipCirc, midThighCirc, flexArmCirc, hamCSA,
            quadCSA, totalThighCSA;
    
    //sit&reach
    private double startDist, endDist1, endDist2, endDist3, finalDist;
    
    //Muscle strength & Endurance Power
    private double rHgrip1, rHgrip2, rHgrip3, lHgrip1, lHgrip2, lHgrip3,
            plankTime, rKneeForce1, rKneeForce2, lKneeForce1, lKneeForce2,
            vJumpHeight1, vJumpHeight2, medBallChest1, medBallChest2;
    private String dominantHandLeg;
    
    //Estimated Aerobic Capacity
    ////Ymca step test
    private double nonExVO2, stepVO2MaxEst, ageRating;
    private int stepHeartRate;
    
    ////rockport walk test
    private int rockHeartRate;
    private double walkTime, rockVO2MaxEst;
    
    ////12-min walk test
    private double distance12min, twelveMinVO2Max, ACSMpercentile;
    
    
    /*********************     MASS SETTERS      ***********************/
    //sets all variables under "Vitals"
    public void setVitals(int age, int restingHR, int restingHR1, int restingHR2, double height, double bodyWeight, double bmi, String gender){
        this.age = age;
        this.restingHR = restingHR;
        this.restingHR1 = restingHR1;
        this.restingHR2 = restingHR2;
        this.height = height;
        this.bodyWeight = bodyWeight;
        this.bmi = bmi;
        this.gender = gender;
    }
    
    //sets all vars under anthropomeetrics
    public void setAnthro(double waistCirc, double hipCirc, double midThighCirc, double flexArmCirc, double hamCSA,
            double quadCSA, double totalThighCSA){
        this.waistCirc = waistCirc; 
        this.hipCirc = hipCirc;
        this.midThighCirc = midThighCirc;
        this.flexArmCirc = flexArmCirc;
        this.hamCSA = hamCSA;
        this.quadCSA = quadCSA;
        this.totalThighCSA = totalThighCSA;
    }
    
    //sets all vars under sit and reach
    public void setSitAndReach(double startDist, double endDist1, double endDist2, double endDist3, double finalDist){
        this.startDist = startDist;
        this.endDist1 = endDist1;
        this.endDist2 = endDist2;
        this.endDist3 = endDist3;
        this.finalDist = finalDist;
    }
}
