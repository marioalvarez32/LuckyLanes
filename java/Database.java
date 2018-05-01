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
        URL = URL.split("\\.",2)[0];
        System.out.println("URL IS:" +URL);
        try {
            System.out.println("Grabbing driver...");
            Class.forName(DRIVER);
            
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
            sql = "CREATE TABLE ATHLETE (ID INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), "
                    + "date VARCHAR(255), dateOfBirth VARCHAR(255), address VARCHAR(255), city VARCHAR(255), "
                    + "state VARCHAR(255), zip int, phone VARCHAR(255), school VARCHAR(255), "
                    + "height double, weight double, age int, gender VARCHAR(255), handDominance "
                    + "VARCHAR(255), legDominance VARCHAR(255), primarySport VARCHAR(255), primaryPosition VARCHAR(255));";           
            state.execute(sql);
            System.out.println("Created a table...");
          
            for(int i = 0; i<50; i++) {
            sql = "INSERT INTO ATHLETE VALUES (null, 'Nicole', '2/3/19', '12/11/1994',"
                    + "'a box', 'whitewater', 'wi', 53045, '208-5039', 'UW-Whitewater',"
                    + "5.3, 10000000, 23, 'female', 'right', 'left', 'eating', 'front end');";
            state.executeUpdate(sql);
            }
            
            sql = "SELECT name, school, zip FROM ATHLETE;";
            ResultSet rs = state.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            while(rs.next()) {
                for(int j = 1; j <= columns; j++) {
                    if(j>1) {
                        System.out.println(", "); 
                    }
                    String colVal = rs.getString(j);
                    System.out.print(colVal + " " + rsmd.getColumnName(j));
                }
                System.out.println("");
            }
            System.out.println("Executed Query....");

            // close database 
            System.out.println("Closing the database...");
            state.close();
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
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
