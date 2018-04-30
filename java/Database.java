/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;
import java.sql.*;

/**
 *
 * @author nicolenelson
 */
public class Database {
    
    // driver name and database
    static final String DRIVER = "org.h2.Driver";
    static final String URL = "jdbc:h2:~/Lucky";
    
    // database credentials
    static final String USERNAME = "LuckyLanes";
    static final String PASSWORD = "lucky";
    
    /* Function:    Connect
     * Return:      Void
     * Parameters:  None
     * Description: Will set up a connection to the
     *              database.
     */
    public static void connect() {
        try {
            System.out.println("Grabbing driver...");
            Class.forName(DRIVER);
            
            System.out.println("Connecting to the database...");
            Connection conn;
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // close database 
         //   System.out.println("Closing the database...");
           // conn.close();
        } catch (SQLException ex) {
           System.out.println("Connection was unsuccessful.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver detection was unsuccessful.");
        }
    }
   
    /* Function:    createDatabase
     * Return:      Void
     * Parameters:  None
     * Description: Will create the database and tables of the database
     */
    public static void createDatabase() {
        // declare variables
        Connection conn = null;
        Statement state = null;
        String sql;
        
        try {
            // grab driver
            Class.forName(DRIVER);
            
            // create a database of the following credentials
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // add in athlete table
            state = conn.createStatement();
            sql = "CREATE TABLE ATHLETE (ID INT PRIMARY KEY, name VARCHAR(255), address VARCHAR(255), date int, dateOfBirth int, phone VARCHAR(255), school VARCHAR(255), gender VARCHAR(255), age int, weight double);";
            state.execute(sql);
            System.out.println("Created a table...");
            
            // close database 
            System.out.println("Closing the database...");
            state.close();
            conn.close();
        } catch (SQLException ex) {
           System.out.println("Connection was unsuccessful.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver detection was unsuccessful.");
        }
    }
}
