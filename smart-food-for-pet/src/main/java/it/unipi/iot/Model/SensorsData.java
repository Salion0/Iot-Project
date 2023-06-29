package it.unipi.iot.Model;

import java.sql.Timestamp;

public class SensorsData{

    private int id;
    private Timestamp timestamp;
    private double value;
    
    public SensorsData(int id, Timestamp timestamp, double value) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
    }
        
    public SensorsData(Timestamp timestamp, double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public SensorsData() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorsData [id=" + id + ", timestamp=" + timestamp + ", value=" + value + "]";
    }

}
