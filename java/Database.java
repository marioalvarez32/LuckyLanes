/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolenelson
 */
public class Database {
    
    // driver name and database
    static final String DRIVER = "org.h2.Driver";
    static String URL = "jdbc:h2:~/LuckyLanes";
    
    // database credentials
    static String USERNAME = "luckylanes";
    static String PASSWORD = "lucky";
    
    public static Connection conn = null;
    public static Statement state = null;

    
    /**Function:    Connect
     * Return:      Void
     * Parameters:  None
     * Description: Will set up a connection to the
     *              database.
     */
    public static void connect(String url){
        URL = "jdbc:h2:file:" +url;
        
        try {
            System.out.println("Grabbing driver...");
            Class.forName(DRIVER);
            
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection("jdbc:h2:file:"+url, USERNAME, PASSWORD);
            System.out.println("Connected...");
        } catch (SQLException ex) {
           System.out.println("Connection was unsuccessful.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver detection was unsuccessful.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**Function:    Close
     * Return:      Void
     * Parameters:  None
     * Description: Will close the connection to the databse.
     */
    public static void close() {
        // close database
        try {
            System.out.println("Closing the database...");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**Function:    createDatabase
     * Return:      Void, none.
     * Parameters:  None
     * Description: Will create the database and tables of the database
     */
    public static void createDatabase(String url) {
        // declare variables
        String sql;
        URL = "jdbc:h2:file:" +url;
        
        try {
            // grab driver
            Class.forName(DRIVER);
            
            // create a database of the following credentials
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // add in athlete table
            state = conn.createStatement();
            sql = "CREATE TABLE ATHLETE (ID INT PRIMARY KEY, name VARCHAR(255), "
                    + "date VARCHAR(255), dateOfBirth VARCHAR(255), address VARCHAR(255), city VARCHAR(255), "
                    + "state VARCHAR(255), zip int, phone VARCHAR(255), school VARCHAR(255), "
                    + "height doublt, weight double, age int, gender VARCHAR(255), handDominance "
                    + "VARCHAR(255), legDominance VARCHAR(255), primarySport VARCHAR(255), primaryPosition VARCHAR(255);";
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
    
    /**Function:    executeUpdate
     * Return:      Void, none.
     * Parameters:  String sql - the sql statement
     *              that will be executed.
     * Description: insert, update, delete functions
     *              of SQL statements will be executed
     */
    public static void executeUpdate(String sql) {
        try {
            // connect
            connect(URL);
            
            // execute the SQL statement
            state = conn.createStatement();
            state.executeUpdate(sql);
            
            // close the database
            close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
