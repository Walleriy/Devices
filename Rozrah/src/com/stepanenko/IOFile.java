package com.stepanenko;

import static com.stepanenko.Main.control_panel;
import static java.lang.Integer.parseInt;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IOFile {
    void write() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("write path to the file, you want to write in");
        File file = new File(scan2.nextLine());
        try {
            if (!file.exists())
                file.createNewFile();
            else
                System.out.println("Your file has been rewritten");

            PrintWriter pw = new PrintWriter(file);

            if (control_panel.kilkist != 0) {
                pw.println("You've got " + control_panel.kilkist + " devices");
                for (Device ae : control_panel.all)
                    pw.println("Name: " + ae.getName() + "\nPower: " + ae.getPower() + "\nState: " + (!ae.getState() ?"Turned on":"Turned off")+"\n");
            } else
                pw.println("You haven't got any devices. You should buy something new)");

            pw.close();

        }catch (IOException e) {
            System.out.println("Error: " + e);
        }
        finally {
            System.out.println("End of the work with file");
        }
    }
    void read() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("write path to the file, you want to read from");
        try {
            BufferedReader br = new BufferedReader(new FileReader(scan2.nextLine()));
            String line;
            int a = 0;
            while (a == 0)
                if ((line = br.readLine()) != null) {
                    if (line.matches("\\s*Changable\\s*")) {
                        Changable aa = new Changable();
                        control_panel.addelement(aa);
                        while ((line = br.readLine()) != null && !line.isEmpty()) {
                            Pattern pattern = Pattern.compile("\\s");
                            String[] strings = pattern.split(line, 2);
                            switch (strings[0]) {
                                case "Name:": {
                                    aa.setName(strings[1]);
                                    break;
                                }
                                case "Power:": {
                                    aa.setPower(parseInt(strings[1]));
                                    break;
                                }
                                case "State:": {
                                    if (strings[1].matches("\\s*On\\s*"))
                                        aa.turnOn();
                                    else
                                        aa.turnOff();
                                    break;
                                }
                                case "Level:": {
                                    if (parseInt(strings[1]) < 11 && parseInt(strings[1]) > 0)
                                        aa.setLevel(parseInt(strings[1]));
                                    break;
                                }
                            }
                        }
                    } else if (line.matches("\\s*Unchangable\\s*")) {
                        Device aa = new Device();
                        control_panel.addelement(aa);
                        while ((line = br.readLine()) != null && !line.isEmpty()) {
                            Pattern pattern = Pattern.compile("\\s");
                            String[] strings = pattern.split(line, 2);
                            switch (strings[0]) {
                                case "Name:": {
                                    aa.setName(strings[1]);
                                    break;
                                }
                                case "Power:": {
                                    aa.setPower(parseInt(strings[1]));
                                    break;
                                }
                                case "State:": {
                                    if (strings[1].matches("\\s*On\\s*"))
                                        aa.turnOn();
                                    else
                                        aa.turnOff();
                                    break;
                                }
                            }
                        }
                    }
                }
                    else
                        a = 1;
            br.close();
        }catch (IOException e) {
            System.out.println("Error: " + e);
        }
        finally {
            System.out.println("End of the work with file");
        }
    }

    void vvid(){
        System.out.println("write path to the file, you want to read from");
        Scanner scan2 = new Scanner(System.in);
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(scan2.nextLine()))){
            control_panel.all = (ArrayList<Device>)oos.readObject();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
