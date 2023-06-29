package it.unipi.iot.Model;

import java.sql.Time;
    
public class Animal{
    
    private String name;
    private double food_qt;
    private double water_qt;
    private int num_eat;
    private Time eat_time;

    public Animal(String name, double food_qt, double water_qt, int num_eat, Time eat_time) {
        this.name = name;
        this.food_qt = food_qt;
        this.water_qt = water_qt;
        this.num_eat = num_eat;
        this.eat_time = eat_time;
    }
    
    public Animal() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getFood_qt() {
        return food_qt;
    }
    public void setFood_qt(double food_qt) {
        this.food_qt = food_qt;
    }
    public double getWater_qt() {
        return water_qt;
    }
    public void setWater_qt(double water_qt) {
        this.water_qt = water_qt;
    }
    public int getNum_eat() {
        return num_eat;
    }
    public void setNum_eat(int num_eat) {
        this.num_eat = num_eat;
    }
    public Time getEat_time() {
        return eat_time;
    }
    public void setEat_time(Time eat_time) {
        this.eat_time = eat_time;
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", food_qt=" + food_qt + ", water_qt=" + water_qt + ", num_eat=" + num_eat
                + ", eat_time=" + eat_time + "]";
    }
    
    
     


}