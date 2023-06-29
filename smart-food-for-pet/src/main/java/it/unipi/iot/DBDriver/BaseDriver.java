package it.unipi.iot.DBDriver;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public abstract class BaseDriver {

    private String user = "root"; 
    private String password = "PASSWORD";
    private String database= "IoT_Project"; 
    private String hostUsername = "localhost";
    private String port = "3306";
    private String urlString = "jdbc:mysql://"+hostUsername+":"+port+"/"+database;  
    
    public BaseDriver(String user, String password, String database, String urlString) {
        this.user = user;
        this.password = password;
        this.database = database;
        this.urlString = urlString;
    }

    public BaseDriver(String user, String password, String database) {
        this.user = user;
        this.password = password;
        this.database = database;
       }

    public BaseDriver(){}

    public Connection getConnection() throws SQLException{
        Connection connection = null;
        try{
        connection = DriverManager.getConnection(this.urlString, this.user, this.password);
        
        }catch(SQLException e){
            System.out.println("Connection Failed!");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return connection;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }
    



}
