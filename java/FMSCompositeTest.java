/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.util.LinkedList;

/**
 *
 * @author Mario
 */
public class FMSCompositeTest {
    private LinkedList<FMSTest> tests;
    private int finalScore;
    
    public FMSCompositeTest(FMSTest a, FMSTest b){
        this.tests =  new LinkedList<>();
        this.tests.add(a);
        this.tests.add(b);
    }
}
