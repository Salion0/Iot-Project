package it.unipi.iot.DBDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import it.unipi.iot.Model.Animal;
import it.unipi.iot.Model.SensorsData;

public class SensorsDataDBDriver extends BaseDriver{
   
    private String tableName = "SensorsData";
    private String primaryKey ="id";

    public String getTableName() {
        return tableName;
    }

    
    public SensorsDataDBDriver(String user, String password, String urlString, String dbName){
       super(user,password,dbName,urlString);
    }
    public SensorsDataDBDriver(String user, String password, String dbName){
       super(user,password,dbName);
    }
    public SensorsDataDBDriver(){}
    
    public void createSensorsData(SensorsData data){
        try {
            Connection conn = getConnection();
            //Prepare the INSERT operation
            String sql = "INSERT INTO "+tableName+" (timestamp,value) VALUES (?,?)";                
    
            //statement
            PreparedStatement statement = conn.prepareStatement(sql);
            
            //Set all the parameter in the query
            statement.setTimestamp(1, data.getTimestamp());
            statement.setDouble(2, data.getValue());

            //exec the operation
            statement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SensorsData readData(int id){
    SensorsData data =  new SensorsData();
    try {
        Connection conn = getConnection();
        //query
        String sql = "SELECT * FROM "+tableName+" WHERE "+primaryKey+"=?";
        
        //statement
        PreparedStatement statement = conn.prepareStatement(sql);
            
        //Set all the parameter in the query
        statement.setInt(1,id);
        ResultSet resultSet=statement.executeQuery();
        if(resultSet.next()){
            data.setId(id);
            data.setTimestamp(resultSet.getTimestamp("timestamp"));
            data.setValue(resultSet.getDouble("value"));
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return data;
    }
    

   


}
