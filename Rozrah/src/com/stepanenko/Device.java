package com.stepanenko;

import java.io.Serializable;

public class Device implements Serializable {

    protected String name = "Unknown";
    protected int power;
    protected boolean state = false;


    Device(){}

    Device(String name)
    {
        this.name = name;
    }

    Device(String name, int power)
    {
        this.name = name;
        this.power = power;
    }

    Device(String name, int power, boolean state)
    {
        this.name = name;
        this.power = power;
        this.state = state;
    }

    public float getCurrent_power() { return power;  }

    int getType(){
        return 1;
    }

    void turnOn(){
        this.state = true;
    }

    void turnOff(){
        this.state = false;
    }

    int getPower() {
        return power;
    }

    String getName() {
        return name;
    }

    boolean getState() {
        return state;
    }

    void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void toString1(){
        System.out.println("Name: " + name + "\nPower: " + power + "\nState: " + (state ?"Turned on":"Turned off")+"\n");
    }
}
