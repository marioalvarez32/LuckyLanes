/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Mario
 */
public class HTML {
    static File file;
    static String text;
    static String directory;
    public static void mkdir(){
        directory ="FMS Files";
        file = new File(directory);
        
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }
    public static void createFile(String name){
        
        try {
	     file = new File(directory+"\\"+name+".doc");
	     
             boolean flag = file.createNewFile();
	     if (flag){
	          System.out.println("File has been created successfully");
	     }
	     else{
	          System.out.println("File already present at the specified location");
	     }
    	} catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
	  }
    }
    public static void open(){
        text ="<!DOCTYPE html><html><head><style>table {font-family: arial, sans-serif;border-collapse: collapse;width: 100%;}td, th {border: 1px solid #dddddd;text-align: left;padding: 8px;}tr:nth-child(even) {background-color: #dddddd;}</style></head><body><H1>Lucky Lanes</H1>";
    }
    public static void close(){
        text+="</body></html>";
    }
    public static void print(String html) {
        PrintWriter out = null;
        try {
            open();
            text+=html;
            close();
            out = new PrintWriter(file);
            out.println(text);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    
    
}
