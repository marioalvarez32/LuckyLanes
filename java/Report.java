/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import main.formObjects.Athlete;
import main.formObjects.FMS;
import main.formObjects.FitnessTest;
import main.formObjects.YBalance;

/**
 *
 * @author Mario
 */
public class Report {
    ArrayList<Integer> ids;
    ArrayList<FMS> fms;
    ArrayList<Athlete> athlete;
    ArrayList<YBalance> yBalance;
    ArrayList<FitnessTest> fitnessData;
    private Executor exec ;
    public Report(){
        ids = new ArrayList<>();
        exec = Executors.newCachedThreadPool(runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t ;
        });
    }
    
    public void addID(int id){
        ids.add(id);
    }
    
    public void toDocs(){
        System.out.println("Printing Documents");
        int i=0;
        HTML.mkdir();
        
        for(FMS test:fms){
            HTML.createFile("FMS-"+i++);
            HTML.print(test.toHTML());
        }
    }
    
    public void createObjects(){
        
        ResultSet rsFMS = Database.searchQuery("SELECT * FROM FMS;");
        ResultSet rsAth = Database.searchQuery("SELECT * FROM Athlete;");
        ResultSet rsYBal = Database.searchQuery("SELECT * FROM YBalance;");
        ResultSet rsFitData = Database.searchQuery("SELECT * FROM FitnessData;");
        
        
        fms=fetchFMS(rsFMS);
        System.out.println("Fetched Data Succesfully");
        //fetchAthlete(rsAth);
        //fetchFitnessTest(rsFitData);
        //fetchYBalance(rsYBal);
    }
    
    
    private ArrayList<FMS> fetchFMS(ResultSet rs) {
        ArrayList<FMS> temp = new ArrayList<>();

        try {
            while (rs.next()) {

                int deepSquatRaw = Integer.parseInt(rs.getString("deepSquatRaw"));
                //int deepSquatFinal = Integer.parseInt(rs.getString("deepSquatFinal"));
                int hurdleStepRawL = Integer.parseInt(rs.getString("hurdleStepRawL"));
                int hurdleStepRawR = Integer.parseInt(rs.getString("hurdleStepRawR"));
                //int hurdleStepFinal=Integer.parseInt(rs.getString("hurdleStepFinal"));
                int inlineLoungeRawL = Integer.parseInt(rs.getString("inlineLoungeRawL"));
                int inlineLoungeRawR = Integer.parseInt(rs.getString("inlineLoungeRawR"));
                //int inlineLoungeFinal =Integer.parseInt(rs.getString("inlineLoungeFinal"));
                int shoulderMobilityRawL = Integer.parseInt(rs.getString("shoulderMobilityRawL"));
                int shoulderMobilityRawR = Integer.parseInt(rs.getString("shoulderMobilityRawR"));
                //If clearing test are true 
                boolean shoulderClearingL = (rs.getString("shoulderClearingL").equals("True"));
                boolean shoulderClearingR = (rs.getString("shoulderClearingR").equals("True"));
                //int shoulderMobilityFinal =Integer.parseInt(rs.getString("shoulderMobilityFinal"));
                int legRaiseRawL = Integer.parseInt(rs.getString("legRaiseRawL"));
                int legRaiseRawR = Integer.parseInt(rs.getString("legRaiseRawR"));
                //int legRaiseFinal =Integer.parseInt(rs.getString("legRaiseFinal"));
                int trunkStabilityRaw = Integer.parseInt(rs.getString("trunkStabilityRaw"));
                boolean extensionClearing = (rs.getString("extensionClearing").equals("True"));
                // int trunkStabilityFinal =Integer.parseInt(rs.getString("trunkStabilityFinal"));
                int rotaryRawL = Integer.parseInt(rs.getString("rotaryRawL"));
                int rotaryRawR = Integer.parseInt(rs.getString("rotaryRawR"));
                boolean flexionClearing = (rs.getString("flexionClearing").equals("True"));
                //int rotaryFinal= Integer.parseInt(rs.getString("rotaryFinal"));
                int total = Integer.parseInt(rs.getString("total"));;

                temp.add(new FMS(deepSquatRaw, hurdleStepRawL, hurdleStepRawR, inlineLoungeRawL, inlineLoungeRawR,
                        shoulderMobilityRawL, shoulderMobilityRawR, shoulderClearingL, shoulderClearingR,
                        legRaiseRawL, legRaiseRawR, trunkStabilityRaw, extensionClearing, rotaryRawL, rotaryRawR,
                        flexionClearing, total));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    private ArrayList<Athlete> fetchAthlete(ResultSet rs){
        ArrayList<Athlete> temp = new ArrayList<>();


        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String date = rs.getString("date");

                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                int zip = Integer.parseInt(rs.getString("zip"));
                String phone = rs.getString("phone");
                String school = rs.getString("school");
                double height = Double.parseDouble(rs.getString("height"));
                double weight = Double.parseDouble(rs.getString("weight"));
                int age = Integer.parseInt(rs.getString("age"));
                String dateOfBirth = rs.getString("dateOfBirth");
                String gender = rs.getString("gender");
                String handDominance = rs.getString("handDominance");
                String legDominance = rs.getString("legDominance");
                String primarySport = rs.getString("primarySport");
                String primaryPosition = rs.getString("primaryPosition");

                temp.add(new Athlete(name, date, dateOfBirth, address, city, state, zip, phone, school, height, weight, age, gender, handDominance, legDominance, primarySport, primaryPosition));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    private ArrayList<YBalance> fetchYBalance(ResultSet rs){
        ArrayList<YBalance> temp = new ArrayList<>();

        try {
            while (rs.next()) {
                double rightLimbLength, antR1, antR2, antR3, antL1, antL2, antL3, pmR1, pmR2, pmR3,
                        pmL1, pmL2, pmL3, plR1, plR2, plR3, plL1, plL2, plL3;

                rightLimbLength = Double.parseDouble(rs.getString("rightLimbLength"));
                antR1 = Double.parseDouble(rs.getString("antR1"));
                antR2 = Double.parseDouble(rs.getString("antR2"));
                antR3 = Double.parseDouble(rs.getString("antR3"));
                antL1 = Double.parseDouble(rs.getString("antL1"));
                antL2 = Double.parseDouble(rs.getString("antL2"));
                antL3 = Double.parseDouble(rs.getString("antL3"));
                pmR1 = Double.parseDouble(rs.getString("pmR1"));
                pmR2 = Double.parseDouble(rs.getString("pmR2"));
                pmR3 = Double.parseDouble(rs.getString("pmR3"));
                pmL1 = Double.parseDouble(rs.getString("pmL1"));
                pmL2 = Double.parseDouble(rs.getString("pmL2"));
                pmL3 = Double.parseDouble(rs.getString("pmL3"));
                plL1 = Double.parseDouble(rs.getString("plL1"));
                plL2 = Double.parseDouble(rs.getString("plL2"));
                plL3 = Double.parseDouble(rs.getString("plL3"));
                plR1 = Double.parseDouble(rs.getString("plR1"));
                plR2 = Double.parseDouble(rs.getString("plR2"));
                plR3 = Double.parseDouble(rs.getString("plR3"));
                
                temp.add(new YBalance(rightLimbLength, antR1, antR2, antR3, antL1, antL2, antL3, pmR1, pmR2, pmR3,
                pmL1, pmL2, pmL3, plR1, plR2, plR3, plL1, plL2, plL3));
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    private ArrayList<FitnessTest> fetchFitnessTest(ResultSet rs){
        ArrayList<FitnessTest> temp = new ArrayList<>();

        try {
            while (rs.next()) {
                String gender = rs.getString("gender");
                int restingHR = Integer.parseInt("restingHR");
                int restingBPA = Integer.parseInt("restingBPA");
                int restingBPB = Integer.parseInt("restingBPB");
                double bmi = Double.parseDouble("bmi");
                double peakFlow = Double.parseDouble("peakFlow");
                double height =Double.parseDouble("height");
                double weight = Double.parseDouble("weight");
                int age = Integer.parseInt("restingHR");
                double ant1 = Double.parseDouble("ant1");
                double ant2 = Double.parseDouble("ant2");
                double wCirc = Double.parseDouble("wCirc");
                double hCirc = Double.parseDouble("hCirc");
                double midCirc = Double.parseDouble("midCirc");
                double fCirc = Double.parseDouble("fCirc");
                double hamCSA = Double.parseDouble("hamCSA");
                double quadCSA = Double.parseDouble("quadCSA");
                double totalCSA = Double.parseDouble("totalCSA");
                double startDist = Double.parseDouble("startDist");
                double endDist1 = Double.parseDouble("endDist1");
                double endDist2 = Double.parseDouble("endDist2");
                double endDist3 = Double.parseDouble("endDist3");
                double endDist = Double.parseDouble("endDist");
                double hgR1 = Double.parseDouble("hgR1");
                double hgR2 = Double.parseDouble("hgR2");
                double hgR3 = Double.parseDouble("hgR3");
                double hgR = Double.parseDouble("hgR");

                double hgL1 = Double.parseDouble("hgL1");
                double hgL2 = Double.parseDouble("hgL2");
                double hgL3 = Double.parseDouble("hgL3");
                double hgL = Double.parseDouble("hgL");

                double proneTime = Double.parseDouble("proneTime");
                double kneeExtForceR1 = Double.parseDouble("kneeExtForceR1");
                double kneeExtForceR2 = Double.parseDouble("kneeExtForceR2");
                double kneeExtForceL1 = Double.parseDouble("kneeExtForceL1");
                double kneeExtForceL2 = Double.parseDouble("kneeExtForceL2");

                double jh1 = Double.parseDouble("jh1");
                double jh2 = Double.parseDouble("jh2");
                double medPass1 = Double.parseDouble("medPass1");
                double medPass2 = Double.parseDouble("medPass2");
                int postHR =Integer.parseInt("postHR");
                double postVO2Max = Double.parseDouble("postVO2Max");
                double vO2Max = Double.parseDouble("vO2Max");
                int rockHR =Integer.parseInt("rockHR");
                double walkTime = Double.parseDouble("walkTime");
                double rockVO2Max = Double.parseDouble("rockVO2Max");
                double walkDistance = Double.parseDouble("walkDistance");
                double walkVO2Max = Double.parseDouble("walkVO2Max");
                double ageRating=Double.parseDouble("ageRating");
                double ACSMpercentile=Double.parseDouble("ACSMpercentiles");
                
                FitnessTest tmp = new FitnessTest();
                tmp.setVitals(age, restingHR , restingBPA , restingBPB, height, weight,bmi,gender,peakFlow);
                tmp.setAnthro(ant1,ant2,wCirc, hCirc, midCirc, fCirc, hamCSA, quadCSA, totalCSA);
                tmp.setSitAndReach(startDist, endDist1, endDist2, endDist3,endDist);
                tmp.setMuscleAndStrength(hgR1, hgR2, hgR3, hgL1, hgL2, hgL3, proneTime, kneeExtForceR1, kneeExtForceR2, kneeExtForceL1, kneeExtForceL2, jh1, jh2, medPass1, medPass2);
                tmp.setAerobicCapacity(vO2Max, postHR, postVO2Max, ageRating, rockHR, walkTime, rockVO2Max, walkDistance, walkVO2Max, ACSMpercentile);
                
                
                temp.add(tmp);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    
    
    
    
    
}
