package com.stepanenko;

import java.util.Scanner;

public class Main {
    static Control control_panel = new Control();

    public static void main(String[] args) {
        input();
        menu();
    }

    private static void input() {
        System.out.println("Hello! I'm a house's electricity control program");
        System.out.println("Choose how do you want to input the information");
        System.out.println("Write *File* to read from file, write *ProgramFile* to read from programfile, or *Keyboard* to read from keyboard");

        Scanner scan = new Scanner(System.in);
        boolean exit = true;
        String smt;
        while (exit) {
            smt = scan.nextLine();
            switch (smt) {
                case "File": {
                    IOFile reading = new IOFile();
                    reading.read();
                    exit = false;
                    break;
                }
                case "ProgramFile": {
                    IOFile reading = new IOFile();
                    reading.vvid();
                    exit = false;
                    break;
                }
                case "Keyboard": {
                    InputKeyboard inp = new InputKeyboard();
                    inp.input();
                    exit = false;
                    break;
                }
                default: {
                    System.out.println("Incorrect!");
                }
            }
        }
    }
    private static void menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write \"Details\" to show detailed information about your electricity");
        System.out.println("Write \"Power\" to show information about power");
        System.out.println("Write \"Filter\" to show all devices that matches your desire");
        System.out.println("Write \"InFile\" to save all list");
        System.out.println("Write \"Save\" to save all list in program file");
        System.out.println("Write \"Sort\" to sort all list by power");
        System.out.println("Write \"SortName\" to sort all list by name");
        System.out.println("Write \"Max\" to see the device that needs the least power");
        System.out.println("Write \"Min\" to see the device that needs the most power");
        System.out.println("Write \"Month\" to see the approximate power usage per month");
        System.out.println("Write \"Turn\" to turn on/turn off the device");
        System.out.println("Write \"Information\" to see detailed information about particular device");
        System.out.println("Write \"Add\" to add new elements to existing list");
        System.out.println("Write \"Edit\" to edit information about the particular device");
        System.out.println("Write \"Delete\" to delete the device (to sell this device)");

        String something2;
        while (!(something2 = scan.nextLine()).equals("end")) {
            if (something2.matches("\\s*Details\\s*")) {
                control_panel.details();
            } else if (something2.matches("\\s*Power\\s*")) {
                System.out.println("Power consumption = " + control_panel.getallpower());
            } else if (something2.matches("\\s*Filter\\s*")) {
                control_panel.filter();
            } else if (something2.matches("\\s*InFile\\s*")) {
                control_panel.infile();
            } else if (something2.matches("\\s*Save\\s*")) {
                control_panel.save();
            } else if (something2.matches("\\s*Sort\\s*")) {
                control_panel.sort();
            } else if (something2.matches("\\s*Sortname\\s*")) {
                control_panel.sortName();
            } else if (something2.matches("\\s*Max\\s*")) {
                System.out.println("Max power consumption is " + control_panel.max());
            } else if (something2.matches("\\s*Min\\s*")) {
                System.out.println("Min power consumption is " + control_panel.min());
            } else if (something2.matches("\\s*Month\\s*")) {
                System.out.println("You use about " + control_panel.per_month() + " per month");
            } else if (something2.matches("\\s*Turn\\s*")) {
                control_panel.turn();
            } else if (something2.matches("\\s*Information\\s*")) {
                control_panel.information();
            } else if (something2.matches("\\s*Add\\s*")) {
                control_panel.addNewElements();
            } else if (something2.matches("\\s*Edit\\s*")) {
                control_panel.edit();
            } else if (something2.matches("\\s*Delete\\s*")) {
                control_panel.delete();
            }
        }
    }
}
