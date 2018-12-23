package com.stepanenko;

import java.util.Scanner;

import static com.stepanenko.Main.control_panel;

class InputKeyboard {
    enum Choose {Changable, Unchangable};
    void input() {
        boolean exit = true;
        Scanner in = new Scanner(System.in);
        while (exit) {
            Choose arg;
            System.out.println("Select type of the device you want to add:");
            System.out.println("write Changable, if you can change level of usage of this device");
            System.out.println("write Unchangable, if you can't change level of usage of this device");
            String arg1 = in.next();
            try {
                arg = Choose.valueOf(arg1);
            } catch (IllegalArgumentException e) {
                return;
            }
            switch (arg) {
                case Changable:
                    Changable aa = new Changable();
                    control_panel.addelement(aa);
                    System.out.println("Successfully created new Changable object!");
                    informationChangable(aa);
                    break;
                case Unchangable: {
                    Device bb = new Device();
                    control_panel.addelement(bb);
                    System.out.println("Successfully created new Unchangable object!");
                    informationUnchangable(bb);
                    break;
                }
                default: {
                    System.out.println("Incorrect! write *Changable* or *Unchangable*");
                }
            }
        }
    }

    void informationChangable(Changable aa){
        System.out.println("write *Help* to show what you should to write");
        System.out.println("write which value do you want to add:\nwrite *end* to apply all information and exit editing");
        String smt;

        Scanner in = new Scanner(System.in);
        boolean out = false;
        while (!out) {
            smt = in.next();
            switch (smt) {
                case "Name": {
                    System.out.println("write name of the device:");
                    aa.setName(in.next());
                    System.out.println("Successfully added!");
                    break;
                }
                case "Power": {
                    System.out.println("write power of the device:");
                    aa.setPower(in.nextInt());
                    System.out.println("Successfully added!");
                    break;
                }
                case "State": {
                    System.out.println("write state of the device (On/Off):");
                    String temp = in.next();
                    boolean ready = false;
                    while (!ready) switch (temp) {
                        case "On": {
                            aa.turnOn();
                            ready = true;
                            break;
                        }
                        case "Off": {
                            aa.turnOff();
                            ready = true;
                            break;
                        }
                        default:
                            ready = false;
                    }
                    System.out.println("Successfully added!");
                    break;
                }
                case "Level": {
                    System.out.println("write level of usage of the device");
                    System.out.println("Choose from 1 to 10");
                    int temp2 = -1;
                    while ((temp2 < 0 || temp2 > 11)) {

                        temp2 = in.nextInt();
                    }
                    aa.setLevel(temp2);
                    System.out.println("Successfully added!");
                    break;
                }
                case "Help": {
                    System.out.println("write *Name* to fill in the name of the device ");
                    System.out.println("write *Power* to fill in the power of the device ");
                    System.out.println("write *State* to fill in the state of the device ");
                    System.out.println("write *Level* to fill in the level of the device ");
                    break;
                }
                case "end": {
                    out = true;
                    break;
                }
                default: {
                    System.out.println("I don't understand what do you want from me. write *help* to show some information");
                    break;
                }
            }

        }
    }

    void informationUnchangable(Device bb){
        System.out.println("write *Help* to show what you should to write");
        System.out.println("write which value do you want to add:\nwrite *end* to apply all information and exit editing");
        String smt;

        Scanner in = new Scanner(System.in);
        boolean out = false;
        out = false;
        while (!out) {
            smt = in.next();
            switch (smt) {
                case "Name": {
                    System.out.println("write name of the device:");
                    bb.setName(in.next());
                    System.out.println("Successfully added!");
                    break;
                }
                case "Power": {
                    System.out.println("write power of the device:");
                    bb.setPower(in.nextInt());
                    System.out.println("Successfully added!");
                    break;
                }
                case "State": {
                    System.out.println("write state of the device (On/Off):");
                    String temp = in.next();
                    boolean ready = false;
                    while (!ready) switch (temp) {
                        case "On": {
                            bb.turnOn();
                            ready = true;
                            break;
                        }
                        case "Off": {
                            bb.turnOff();
                            ready = true;
                            break;
                        }
                        default:
                            ready = false;
                    }
                    System.out.println("Successfully added!");
                    break;
                }
                case "Help": {
                    System.out.println("write *Name* to fill in the name of the device ");
                    System.out.println("write *Power* to fill in the power of the device ");
                    System.out.println("write *State* to fill in the state of the device ");
                    break;
                }
                case "end": {
                    out = true;
                    break;
                }
                default: {
                    System.out.println("I don't understand what do you want from me. write *help* to show some information");
                    break;
                }
            }
        }
    }
}

