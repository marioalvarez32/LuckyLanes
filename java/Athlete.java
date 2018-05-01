/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.util.Date;

/**
 *
 * @author Ian
 */
public class Athlete {
    private String name;
    private Date date;
    private Date dateOfBirth;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phone;
    private String school;
    private double height;
    private double weight;
    private int age;
    private String gender;
    private String handDominance;
    private String legDominance;
    private String primarySport;
    private String primaryPosition;

    
    public Athlete(){
        this.name = "";
        this.date = null;
        this.dateOfBirth = null;
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = 0;
        this.phone = "";
        this.school = "";
        this.height = 0;
        this.weight = 0;
        this.age = 0;
        this.gender = "";
        this.handDominance = "";
        this.legDominance = "";
        this.primarySport = "";
        this.primaryPosition = "";
 
    }
    
      
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
        /**
     * @return the state
     */
    public String getState() {
        return state;
    }
    
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * @return the zip
     */
    public int getZip() {
        return zip;
    }
    
    /**
     * @param zip the zip to set
     */
    public void setZip(int zip) {
        this.zip = zip;
    }
    
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
        
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the handDominance
     */
    public String getHandDominance() {
        return handDominance;
    }

    /**
     * @param handDominance the handDominance to set
     */
    public void setHandDominance(String handDominance) {
        this.handDominance = handDominance;
    }
    
    /**
     * @return the legDominance
     */
    public String getLegDominance() {
        return legDominance;
    }

    /**
     * @param legDominance the legDominace to set
     */
    public void setLegDominance(String legDominance) {
        this.legDominance = legDominance;
    }
    
     /**
     * @return the primarySport
     */
    public String getPrimarySport() {
        return primarySport;
    }

    /**
     * @param primarySport the primarySport to set
     */
    public void setPrimarySport(String primarySport) {
        this.primarySport = primarySport;
    }
    
    /**
     * @return the primaryPosition
     */
    public String getPrimaryPosition() {
        return primaryPosition;
    }

    /**
     * @param primaryPosition the primaryPosition to set
     */
    public void setPrimaryPosition(String primaryPosition) {
        this.primaryPosition = primaryPosition;
    }


}
