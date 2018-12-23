package com.stepanenko;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class Control implements Serializable {
    ArrayList<Device> all = new ArrayList<Device>();
    int kilkist = 0;

    void addelement(Device a) {
        all.add(a);
        kilkist++;
    }

    void details() {
        if (kilkist != 0) {
            System.out.println("You've got " + kilkist + " devices");
            for (Device ae : all)
                ae.toString1();
        } else if (all.size() == 0)
            System.out.println("You haven't got any devices. You should buy something new)");
        else {
            System.out.println("You've got " + all.size() + " devices");
            for (Device ae : all)
                ae.toString1();
        }
    }

    double getallpower() {
        double allPower = 0.0;
        for (Device ae : all)
            if (ae.getState())
                if (ae.getType() == 1)
                    allPower += ae.getPower();
                else
                    allPower += ae.getCurrent_power();
        return allPower;
    }

    void filter() {
        Scanner scan = new Scanner(System.in);
        System.out.println("write minimal level of consumption");
        int left = scan.nextInt();
        System.out.println("write maximal level of consumption");
        int right = scan.nextInt();

        ArrayList<Device> filt = new ArrayList<Device>();
        for (Device ae : all) {
            if (ae.getPower() >= left && ae.getPower() <= right)
                filt.add(ae);
        }

        for (Device ae : filt) {
            ae.toString1();
        }
    }

    void infile() {
        IOFile er = new IOFile();
        er.write();
    }

    void save() {
        System.out.println("write path to the file, you want to work with");
        Scanner scan2 = new Scanner(System.in);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(scan2.nextLine()))) {
            oos.writeObject(all);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Ended work with the file");
        }
    }

    void sort() {
        all.sort(Comparator.comparingInt(o -> o.power));
    }

    void sortName() {
        all.sort(Comparator.comparing(Device::getName));
    }

    double max() {
        double max = 0.0;
        for (Device ae : all) {
            if (ae.getPower() > max)
                max = ae.getPower();
        }
        return max;
    }

    double min() {
        double min = max();
        for (Device ae : all) {
            if (ae.getPower() < min)
                if (ae.getType() == 1)
                    min = ae.getPower();
                else
                    min = ae.getCurrent_power();
        }
        return min;
    }

    double per_month() {
        double allPower = 0.0;
        Scanner scan2 = new Scanner(System.in);
        for (Device ae : all) {
            ae.toString1();
            System.out.println("How many hours per day do you use this device?");
            int hours = scan2.nextInt();
            System.out.println("How many days per month do you use this device?");
            int days = scan2.nextInt();
            if (ae.getState())
                if (ae.getType() == 1)
                    allPower += ae.getPower() * hours * days;
                else
                    allPower += ae.getCurrent_power() * hours * days;
            System.out.println();
        }
        return allPower;
    }

    void turn() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Write name of the object, which do you want to turn on/off: ");
        String obj = scan2.nextLine();
        boolean exit = false;
        boolean exit2 = false;
        for (Device ae : all) {
            if(!exit2)
            if (ae.getName().matches(obj)) {
                System.out.println("Write \"On\"/\"Off\" to set state of the" + obj);
                while (!exit2) {
                    String temp = scan2.nextLine();
                    if (temp.matches("\\s*On\\s*")) {
                        ae.turnOn();
                        exit2 = true;
                    } else if (temp.matches("\\s*Off\\s*")) {
                        ae.turnOff();
                        exit2 = true;
                    } else {
                        System.out.println("Incorrect!");
                    }
                }
                exit = true;
            }
            else
                return;
        }
        if(!exit) {
            System.out.println("I can't find this device!");
        }
        System.out.println("Done!");
    }

    void information() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Write name of the object, about which do tou want to know details: ");
        String obj = scan2.nextLine();
        boolean exit = false;
        for (Device ae : all)
            if (ae.getName().matches(obj)) {
                ae.toString1();
                exit = true;
            }
        if(!exit) {
            System.out.println("I can't find this device!");
        }
        else
            System.out.println("Done!");
    }

    void addNewElements()
    {
        InputKeyboard inp = new InputKeyboard();
        inp.input();
        System.out.println("Done!");
    }

    void edit()
    {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Write name of the object, about which do tou want to know details: ");
        String obj = scan2.nextLine();
        boolean exit = false;
        for (Device ae : all)
            if (ae.getName().matches(obj)) {
                InputKeyboard edi = new InputKeyboard();
                if(ae.getType()==1)
                    edi.informationUnchangable(ae);
                else
                    edi.informationChangable((Changable) ae);
                exit = true;
            }
        if(!exit) {
            System.out.println("I can't find this device!");
        }
        else
            System.out.println("Done!");
    }

    void delete(){
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Write name of the object, about which do tou want to know details: ");
        String obj = scan2.nextLine();
        Iterator it = all.iterator();
        while(it.hasNext()) {
            Device temp = (Device)it.next();
            if (temp.getName().matches(obj)) {
                it.remove();
                kilkist--;
                System.out.println("Done!");
                return;
            }
        }
        System.out.println("I can't find this device!");
    }
}
