package com.stepanenko;

import java.io.Serializable;

public class Changable extends Device implements Serializable {
    private int maxpower = super.getPower();
    private int level = 0;
    private float current_power = 0f;


    @Override
    public void setPower(int power) {
        super.setPower(power);
        maxpower = super.power;
    }

    public Changable(){}

    public Changable(String name, int level)
    {
        super(name);
        this.level = level;
    }

    public Changable(String name, int power, int level)
    {
        super(name, power);
        this.level = level;
    }

    public Changable(String name, int power, boolean state, int level)
    {
        super(name, power, state);
        this.level = level;
    }


    public float getCurrent_power() {
        return current_power;
    }

    public void setCurrent_power(float current_power) {
        this.current_power = current_power;
    }

    public int getLevel() {
        return level;
    }


    void setLevel(int level){
        this.level = level;
        this.current_power = ((float)level/10)*maxpower;
    }

    @Override
    int getType(){
        return 2;
    }

    @Override
    public void toString1(){
        System.out.println("Name: " + name + "\nMax power: " + power + "\nLevel: " + level);
        System.out.println("Current power: " + current_power  + "\nState: " + (state ?"Turned on":"Turned off")+"\n");
    }
}
