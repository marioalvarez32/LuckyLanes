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
    private double height, bodyWeight, bmi, peakFlow;
    private boolean gender;

    //anthropomeetrics
    private double ant1, ant2, antAvg, waistCirc, hipCirc, midThighCirc, flexArmCirc, hamCSA,
            quadCSA, totalThighCSA;

    //sit&reach
    private double startDist, endDist1, endDist2, endDist3, finalDist;

    //Muscle strength & Endurance Power
    private double hgR1, hgR2, hgR3, hgL1, hgL2, hgL3,
            proneTime, kneeExtForceR1, kneeExtForceR2, kneeExtForceL1, kneeExtForceL2,
            jh1, jh2, medPass1, medPass2;

    private boolean dominantHandLeg;

    //Estimated Aerobic Capacity
    ////Ymca step test
    private double vO2Max, postVO2Max, ageRating;
    private int postHR;

    ////rockport walk test
    private int rockHR;
    private double walkTime, rockVO2Max;

    ////12-min walk test
    private double walkDistance, walkVO2Max, ACSMpercentile;

    public FitnessTest() {

    }

    /**
     * ******************* MASS SETTERS **********************
     */
    //sets all variables under "Vitals"
    public void setVitals(int age, int restingHR, int restingHR1, int restingHR2, double height, double bodyWeight, double bmi, boolean gender, double peakFlow) {
        this.age = age;
        this.restingHR = restingHR;
        this.restingHR1 = restingHR1;
        this.restingHR2 = restingHR2;
        this.height = height;
        this.bodyWeight = bodyWeight;
        this.bmi = bmi;
        this.gender = gender;
        this.peakFlow = peakFlow;
    }

    //sets all vars under anthropomeetrics
    public void setAnthro(double ant1, double ant2, double waistCirc, double hipCirc, double midThighCirc, double flexArmCirc, double hamCSA,
            double quadCSA, double totalThighCSA) {
        this.ant1 = ant1;
        this.ant2 = ant2;
        this.antAvg = (ant1 + ant2) / 2;
        this.waistCirc = waistCirc;
        this.hipCirc = hipCirc;
        this.midThighCirc = midThighCirc;
        this.flexArmCirc = flexArmCirc;
        this.hamCSA = hamCSA;
        this.quadCSA = quadCSA;
        this.totalThighCSA = totalThighCSA;
    }

    //sets all vars under sit and reach
    public void setSitAndReach(double startDist, double endDist1, double endDist2, double endDist3, double finalDist) {
        this.startDist = startDist;
        this.endDist1 = endDist1;
        this.endDist2 = endDist2;
        this.endDist3 = endDist3;
        this.finalDist = finalDist;
    }

    public void setMuscleAndStrength(double hgR1, double hgR2, double hgR3, double hgL1, double hgL2, double hgL3, double proneTime,
            double kneeExtForceR1, double kneeExtForceR2, double kneeExtForceL1, double kneeExtForceL2, double jh1, double jh2, double medPass1, double medPass2) {

        this.hgR1 = hgR1;
        this.hgR2 = hgR2;
        this.hgR3 = hgR3;
        this.hgL1 = hgL1;
        this.hgL2 = hgL2;
        this.hgL3 = hgL3;
        this.proneTime = proneTime;
        this.kneeExtForceR1 = kneeExtForceR1;
        this.kneeExtForceR2 = kneeExtForceR2;
        this.kneeExtForceL1 = kneeExtForceL1;
        this.kneeExtForceL2 = kneeExtForceL2;
        this.jh1 = jh1;
        this.jh2 = jh2;
        this.medPass1 = medPass1;
        this.medPass2 = medPass2;
    }

    public void setAerobicCapacity(double vO2Max, int postHR, double postVO2Max,
            double ageRating, int rockHR, double walkTime, double rockVO2Max,
            double walkDistance, double walkVO2Max, double ACSMpercentile) {

        this.vO2Max = vO2Max;
        this.postHR = postHR;
        this.postVO2Max = postVO2Max;
        this.ageRating = ageRating;
        this.rockHR = rockHR;
        this.walkTime = walkTime;
        this.rockVO2Max = rockVO2Max;

        this.walkDistance = walkDistance;
        this.walkVO2Max = walkVO2Max;
        this.ACSMpercentile = ACSMpercentile;

    }

}
