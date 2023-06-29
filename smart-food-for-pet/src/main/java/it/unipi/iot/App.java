package it.unipi.iot;
import java.sql.Date;
import java.sql.Time;

import java.sql.Timestamp;

import org.eclipse.paho.client.mqttv3.MqttException;

import it.unipi.iot.Model.*;
import it.unipi.iot.DBDriver.*;
import it.unipi.iot.MQTT.MqttSubscriber;
public class App 
{
    /*TEST */

    public static void main( String[] args ){




        
        
    }
    /*Test mqtt subscriber-----------------------*
    try{
        MqttSubscriber mqttSubscriber = new MqttSubscriber();
    }catch(Exception e){
        e.printStackTrace();
    }
    /*-----------------------------------------*/


     /*------------ test create animal in db ---------------------------
        Time time = new Time(2, 32, 2);
        Animal animal = new Animal("Animale2",54.3,24.4,4,time);                
        System.out.println("Obj Created");

        AnimalDBDriver animalDB = new AnimalDBDriver();
        
        try{
            animalDB.createAnimal(animal);
            System.out.println("Animal Created!");
        }catch(Exception e){
            e.printStackTrace();
        } 
        ------------------------------------------------------------*/

        /*------------test read animal from database ------------
        
        AnimalDBDriver animalDB = new AnimalDBDriver();
        Animal animal = animalDB.readAnimal("Animale1");
        System.out.println("Reading animal from db: "+animal.toString());
        /*------------------------------------------------*/

        /*------------test update animal from database ------------
        Time time = new Time(2, 32, 2);
        Animal animal = new Animal("Animale2",60.3,34.4,5,time);  
        AnimalDBDriver animalDBDriver = new AnimalDBDriver();
        animalDBDriver.updateAnimal(animal.getName(),animal);
        System.out.println("Animal Updateted !");
        /*--------------------------------------------------------- */ 
        
        /*------------test update single attribute animal from database ------------
        Time time = new Time(23, 30, 22);
        Animal animal = new Animal("Animale1",60.3,34.4,5,time);  
        AnimalDBDriver animalDBDriver = new AnimalDBDriver();

        animalDBDriver.updateAnimalWater_qt(animal.getName(),2.3);
        System.out.println("Animal Updateted !");
        /*--------------------------------------------------------- */ 

        /*------------test delete animal from database ------------
        Time time = new Time(2, 32, 2);
        Animal animal = new Animal("Animale2",60.3,34.4,5,time);  
        AnimalDBDriver animalDBDriver = new AnimalDBDriver();
        animalDBDriver.deleteAnimal(animal.getName());
        System.out.println("Animal Deleted !");
        /*---------------------------------------------------------*/ 


}
