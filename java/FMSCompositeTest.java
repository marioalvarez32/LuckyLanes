/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.util.LinkedList;

/**
* FMS Composite Test Object Model
* 
* This is a composite test used in the FMS Score Sheet. It gives a final score
* using a list of tests. 
* 
* 
*  
*/
public class FMSCompositeTest {
    private LinkedList<FMSTest> tests;
    private int finalScore;
    
    /**
     *Creates an FMS Composite Test object using two tests. Look at the pdf form.
     * @param a
     * @param b
     */
    public FMSCompositeTest(FMSTest a, FMSTest b){
        this.tests =  new LinkedList<>();
        this.tests.add(a);
        this.tests.add(b);
    }
}
