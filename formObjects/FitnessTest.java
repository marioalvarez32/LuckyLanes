/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.formObjects;

import main.java.Database;

/**
 *
 * @author bentz
 */
public class FitnessTest {

    ////////Global Variables
    //vitals
    private int age, restingHR, restingHR1, restingHR2;
    private double height, bodyWeight, bmi, peakFlow;
    private String gender;

    //anthropomeetrics
    private double ant1, ant2, antAvg, waistCirc, hipCirc, midThighCirc, flexArmCirc, hamCSA,
            quadCSA, totalThighCSA;

    //sit&reach
    private double startDist, endDist1, endDist2, endDist3, finalDist;
    
    //Muscle strength & Endurance Power
    private double hgR1, hgR2, hgR3, hgL1, hgL2, hgL3,
            proneTime, kneeExtForceR1, kneeExtForceR2, kneeExtForceL1, kneeExtForceL2,
            jh1, jh2, medPass1, medPass2;

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
    public void setVitals(int age, int restingHR, int restingHR1, int restingHR2, double height, double bodyWeight, double bmi, String gender, double peakFlow) {
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

    
    public void addRow() {
        String sql;
            sql = "INSERT INTO FITNESSDATA VALUES ("
                + "null,"
                + age +","+ restingHR +","+ restingHR1 +","+ restingHR2 +","+ height +","+ bodyWeight +","+ bmi +","+ peakFlow +",'"+ gender +"',"
                + ant1 +","+ ant2 +","+ antAvg +","+ waistCirc +","+ hipCirc +","+ midThighCirc +","+ flexArmCirc +","+ hamCSA +","+quadCSA +","+ totalThighCSA +","
                + startDist +","+ endDist1 +","+ endDist2 +","+ endDist3 +","+ finalDist +","
                + hgR1 +","+ hgR2 +","+ hgR3 +","+ hgL1 +","+ hgL2 +","+ hgL3 +","+proneTime +","+ kneeExtForceR1 +","+ kneeExtForceR2 +","+ kneeExtForceL1 +","+ kneeExtForceL2 +","+jh1 +","+ jh2 +","+ medPass1 +","+ medPass2 +","
                + vO2Max +","+ postVO2Max +","+ ageRating +","+postHR +","
                + walkTime +","+ rockVO2Max +","+ rockHR +","
                + walkDistance +","+ walkVO2Max +","+ ACSMpercentile+ ");";
        Database.executeUpdate(sql);
    }
    
    public String toHTML(){
        String html = "<br><br><br><h2>Functional Movement Screen</h2>"
                + "<table><tr><th>";
        return html;
    }

    /***
     * gets/sets each individual variable. 
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRestingHR() {
        return restingHR;
    }

    public void setRestingHR(int restingHR) {
        this.restingHR = restingHR;
    }

    public int getRestingHR1() {
        return restingHR1;
    }

    public void setRestingHR1(int restingHR1) {
        this.restingHR1 = restingHR1;
    }

    public int getRestingHR2() {
        return restingHR2;
    }

    public void setRestingHR2(int restingHR2) {
        this.restingHR2 = restingHR2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(double bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getPeakFlow() {
        return peakFlow;
    }

    public void setPeakFlow(double peakFlow) {
        this.peakFlow = peakFlow;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAnt1() {
        return ant1;
    }

    public void setAnt1(double ant1) {
        this.ant1 = ant1;
    }

    public double getAnt2() {
        return ant2;
    }

    public void setAnt2(double ant2) {
        this.ant2 = ant2;
    }

    public double getAntAvg() {
        return antAvg;
    }

    public void setAntAvg(double antAvg) {
        this.antAvg = antAvg;
    }

    public double getWaistCirc() {
        return waistCirc;
    }

    public void setWaistCirc(double waistCirc) {
        this.waistCirc = waistCirc;
    }

    public double getHipCirc() {
        return hipCirc;
    }

    public void setHipCirc(double hipCirc) {
        this.hipCirc = hipCirc;
    }

    public double getMidThighCirc() {
        return midThighCirc;
    }

    public void setMidThighCirc(double midThighCirc) {
        this.midThighCirc = midThighCirc;
    }

    public double getFlexArmCirc() {
        return flexArmCirc;
    }

    public void setFlexArmCirc(double flexArmCirc) {
        this.flexArmCirc = flexArmCirc;
    }

    public double getHamCSA() {
        return hamCSA;
    }

    public void setHamCSA(double hamCSA) {
        this.hamCSA = hamCSA;
    }

    public double getQuadCSA() {
        return quadCSA;
    }

    public void setQuadCSA(double quadCSA) {
        this.quadCSA = quadCSA;
    }

    public double getTotalThighCSA() {
        return totalThighCSA;
    }

    public void setTotalThighCSA(double totalThighCSA) {
        this.totalThighCSA = totalThighCSA;
    }

    public double getStartDist() {
        return startDist;
    }

    public void setStartDist(double startDist) {
        this.startDist = startDist;
    }

    public double getEndDist1() {
        return endDist1;
    }

    public void setEndDist1(double endDist1) {
        this.endDist1 = endDist1;
    }

    public double getEndDist2() {
        return endDist2;
    }

    public void setEndDist2(double endDist2) {
        this.endDist2 = endDist2;
    }

    public double getEndDist3() {
        return endDist3;
    }

    public void setEndDist3(double endDist3) {
        this.endDist3 = endDist3;
    }

    public double getFinalDist() {
        return finalDist;
    }

    public void setFinalDist(double finalDist) {
        this.finalDist = finalDist;
    }

    public double getHgR1() {
        return hgR1;
    }

    public void setHgR1(double hgR1) {
        this.hgR1 = hgR1;
    }

    public double getHgR2() {
        return hgR2;
    }

    public void setHgR2(double hgR2) {
        this.hgR2 = hgR2;
    }

    public double getHgR3() {
        return hgR3;
    }

    public void setHgR3(double hgR3) {
        this.hgR3 = hgR3;
    }

    public double getHgL1() {
        return hgL1;
    }

    public void setHgL1(double hgL1) {
        this.hgL1 = hgL1;
    }

    public double getHgL2() {
        return hgL2;
    }

    public void setHgL2(double hgL2) {
        this.hgL2 = hgL2;
    }

    public double getHgL3() {
        return hgL3;
    }

    public void setHgL3(double hgL3) {
        this.hgL3 = hgL3;
    }

    public double getProneTime() {
        return proneTime;
    }

    public void setProneTime(double proneTime) {
        this.proneTime = proneTime;
    }

    public double getKneeExtForceR1() {
        return kneeExtForceR1;
    }

    public void setKneeExtForceR1(double kneeExtForceR1) {
        this.kneeExtForceR1 = kneeExtForceR1;
    }

    public double getKneeExtForceR2() {
        return kneeExtForceR2;
    }

    public void setKneeExtForceR2(double kneeExtForceR2) {
        this.kneeExtForceR2 = kneeExtForceR2;
    }

    public double getKneeExtForceL1() {
        return kneeExtForceL1;
    }

    public void setKneeExtForceL1(double kneeExtForceL1) {
        this.kneeExtForceL1 = kneeExtForceL1;
    }

    public double getKneeExtForceL2() {
        return kneeExtForceL2;
    }

    public void setKneeExtForceL2(double kneeExtForceL2) {
        this.kneeExtForceL2 = kneeExtForceL2;
    }

    public double getJh1() {
        return jh1;
    }

    public void setJh1(double jh1) {
        this.jh1 = jh1;
    }

    public double getJh2() {
        return jh2;
    }

    public void setJh2(double jh2) {
        this.jh2 = jh2;
    }

    public double getMedPass1() {
        return medPass1;
    }

    public void setMedPass1(double medPass1) {
        this.medPass1 = medPass1;
    }

    public double getMedPass2() {
        return medPass2;
    }

    public void setMedPass2(double medPass2) {
        this.medPass2 = medPass2;
    }

    public double getvO2Max() {
        return vO2Max;
    }

    public void setvO2Max(double vO2Max) {
        this.vO2Max = vO2Max;
    }

    public double getPostVO2Max() {
        return postVO2Max;
    }

    public void setPostVO2Max(double postVO2Max) {
        this.postVO2Max = postVO2Max;
    }

    public double getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(double ageRating) {
        this.ageRating = ageRating;
    }

    public int getPostHR() {
        return postHR;
    }

    public void setPostHR(int postHR) {
        this.postHR = postHR;
    }

    public int getRockHR() {
        return rockHR;
    }

    public void setRockHR(int rockHR) {
        this.rockHR = rockHR;
    }

    public double getWalkTime() {
        return walkTime;
    }

    public void setWalkTime(double walkTime) {
        this.walkTime = walkTime;
    }

    public double getRockVO2Max() {
        return rockVO2Max;
    }

    public void setRockVO2Max(double rockVO2Max) {
        this.rockVO2Max = rockVO2Max;
    }

    public double getWalkDistance() {
        return walkDistance;
    }

    public void setWalkDistance(double walkDistance) {
        this.walkDistance = walkDistance;
    }

    public double getWalkVO2Max() {
        return walkVO2Max;
    }

    public void setWalkVO2Max(double walkVO2Max) {
        this.walkVO2Max = walkVO2Max;
    }

    public double getACSMpercentile() {
        return ACSMpercentile;
    }

    public void setACSMpercentile(double ACSMpercentile) {
        this.ACSMpercentile = ACSMpercentile;
    }
}
