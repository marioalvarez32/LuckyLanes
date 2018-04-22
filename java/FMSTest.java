/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

/**
* FMS Test Object Model
* 
* This is the representation of all the physical tests for the FMS Score Sheet.
* 
* Note: Some tests only require one raw score.
* 
*/
public class FMSTest {
    private String testName;
    private int rawScoreL;
    private int rawScoreR;
    private int finalScore;
    private String comments;
    
    /**
     *
     * @param testName
     */
    public FMSTest(String testName){
        this.testName = testName;
        this.rawScoreL=0;
        this.rawScoreR=0;
        this.comments="";
    }
     
    /**Constructor
     * 
     * Creates a test using both left and right raw score.
     * 
     * @param testName
     * @param rawScoreL
     * @param rawScoreR
     * @param comments
     */
    public FMSTest(String testName,int rawScoreL, int rawScoreR, String comments){
        this.testName = testName;
        this.rawScoreL=rawScoreL;
        this.rawScoreR=rawScoreR;
        this.comments="";
    }
    
    /**Constructor
     * 
     * Creates a test using only one raw score.
     *
     * @param testName
     * @param rawScore
     * @param comments
     */
    public FMSTest(String testName,int rawScore,String comments){
        this.testName = testName;
        this.rawScoreL=rawScore;
        this.rawScoreR=rawScore;
        this.comments="";
    }

    /**
     * @return the testName
     */
    public String getTestName() {
        return testName;
    }

    /**
     * @param testName the testName to set
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * @return the rawScoreL
     */
    public int getRawScoreL() {
        return rawScoreL;
    }

    /**
     * @param rawScoreL the rawScoreL to set
     */
    public void setRawScoreL(int rawScoreL) {
        this.rawScoreL = rawScoreL;
    }

    /**
     * @return the rawScoreR
     */
    public int getRawScoreR() {
        return rawScoreR;
    }

    /**
     * @param rawScoreR the rawScoreR to set
     */
    public void setRawScoreR(int rawScoreR) {
        this.rawScoreR = rawScoreR;
    }

    /**
     * @return the finalScore
     */
    public int getFinalScore() {
        return finalScore;
    }

    /**
     * @param finalScore the finalScore to set
     */
    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
    
    
    
}
