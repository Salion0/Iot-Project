package it.unipi.iot.MQTT;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.sql.Timestamp;
import it.unipi.iot.DBDriver.SensorsDataDBDriver;
import it.unipi.iot.Model.SensorsData;

public class MqttSubscriber implements MqttCallback{

    private String broker ="tcp://127.0.0.1:1883";
    private String clientId="JavaSubscriber";
    private String topic="sensorsData";

    public MqttSubscriber() throws MqttException{
        MqttClient mqttCient = new MqttClient(this.broker,this.clientId);
        mqttCient.setCallback(this);
        mqttCient.connect();
        mqttCient.subscribe(this.topic);
    }

    public void connectionLost(Throwable cause) {
        throw new UnsupportedOperationException("Unimplemented method 'connectionLost'");
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
        /*Parse the message and insert it into the MySQL DB */
        //Parsing the message
        String stringMsg = message.toString();
        String[] tokenizedMsg = stringMsg.split(";");
        Timestamp  timestamp = Timestamp.valueOf(tokenizedMsg[0]);
        Double value = Double.valueOf(tokenizedMsg[1]);

        System.out.println("Timestamp: "+timestamp.toString()+"\nValue: "+value);

        SensorsData data = new SensorsData(timestamp,value);
        SensorsDataDBDriver dataDBDriver = new SensorsDataDBDriver();
        dataDBDriver.createSensorsData(data);
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deliveryComplete'");
    }
}
