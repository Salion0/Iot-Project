package it.unipi.iot.DBDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import it.unipi.iot.Model.Animal;

public class AnimalDBDriver extends BaseDriver {

    private String tableName = "Animal";
    private String primaryKey = "name";
    //Constructor   
    public AnimalDBDriver(String user, String password, String urlString, String dbName){
       super(user,password,dbName,urlString);
    }
    public AnimalDBDriver(String user, String password, String dbName){
       super(user,password,dbName);
    }
    public AnimalDBDriver(){}
    
    public String getTableName() {
        return tableName;
    }

    //CRUD OPERATIONS
    public void createAnimal(Animal animal){
        try {
            Connection conn = getConnection();
            //Prepare the INSERT operation
            String sql = "INSERT INTO "+tableName+" (name, eat_time, num_eat,food_qt,water_qt) VALUES (?,?,?,?,?)";                
            
            //statement
            PreparedStatement statement = conn.prepareStatement(sql);
            
            //Set all the parameter in the query
            statement.setString(1, animal.getName());
            statement.setTime(2, animal.getEat_time());
            statement.setInt(3, animal.getNum_eat());
            statement.setDouble(4, animal.getFood_qt());
            statement.setDouble(5, animal.getWater_qt());

            //exec the operation
            statement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Animal readAnimal(String name){
    Animal animal =  new Animal();
    try {
        Connection conn = getConnection();
        //query
        String sql = "SELECT name, eat_time, num_eat, food_qt, water_qt FROM "+tableName+" WHERE "+primaryKey+"=?";
       
        //statement 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);

        //execute the query and get the result
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            animal.setName(result.getString("name"));
            animal.setEat_time(result.getTime("eat_time"));
            animal.setNum_eat(result.getInt("num_eat"));
            animal.setFood_qt(result.getDouble("food_qt"));
            animal.setWater_qt(result.getDouble("water_qt"));
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return animal;
    }
    
    public void updateAnimal(String name, Animal animal){
        try {
            Connection conn = getConnection();
            
            //Prepare the update string
            String sql = "UPDATE "+tableName+" SET eat_time = ?, num_eat = ?, food_qt = ?, water_qt = ? WHERE "+primaryKey+" = ?";
            
            //Prepare the statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setTime(1,animal.getEat_time());
            statement.setInt(2,animal.getNum_eat());
            statement.setDouble(3, animal.getFood_qt());
            statement.setDouble(4, animal.getWater_qt());
            statement.setString(5, name); //set primary key value
            
            //Execute the update
            statement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAnimalEat_time(String name,Time eat_time ){
        try {
        Connection conn = getConnection();
        
        //Prepare the update string
        String sql = "UPDATE "+tableName+" SET eat_time = ? WHERE "+primaryKey+" = ?";
        
        //Prepare the statement
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setTime(1,eat_time);
        statement.setString(2, name); //set primary key value
        
        //Execute the update
        statement.executeUpdate();
        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
    public void updateAnimalNum_eat(String name,int num_eat ){
        try {
        Connection conn = getConnection();
        
        //Prepare the update string
        String sql = "UPDATE "+tableName+" SET num_eat = ? WHERE "+primaryKey+" = ?";
        
        //Prepare the statement
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,num_eat);
        statement.setString(2, name); //set primary key value
        
        //Execute the update
        statement.executeUpdate();
        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }     
    }
    public void updateAnimalFood_qt(String name,Double food_qt ){
        try {
        Connection conn = getConnection();
        
        //Prepare the update string
        String sql = "UPDATE "+tableName+" SET food_qt = ? WHERE "+primaryKey+" = ?";
        
        //Prepare the statement
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1,food_qt);
        statement.setString(2, name); //set primary key value
        
        //Execute the update
        statement.executeUpdate();
        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void updateAnimalWater_qt(String name,Double water_qt ){
        try {
        Connection conn = getConnection();
        
        //Prepare the update string
        String sql = "UPDATE "+tableName+" SET water_qt = ? WHERE "+primaryKey+" = ?";
        
        //Prepare the statement
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1,water_qt);
        statement.setString(2, name); //set primary key value
        
        //Execute the update
        statement.executeUpdate();
        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void deleteAnimal(String name){
        try {
        Connection conn = getConnection();
        
        //Prepare the delete string
        String sql = "DELETE FROM "+tableName+" WHERE "+primaryKey+" = ?";
        
        //Prepare the statement
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,name);
        
        //Execute the delete
        statement.executeUpdate();
        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
}
