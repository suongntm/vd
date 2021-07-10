/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author SuongNTM
 */
public class BusList {

    static MyLinkedList<Bus> busList;

    public BusList() {
        busList = new MyLinkedList<>();
    }

    public void addtest() {
        busList.addFirst(new Bus("B03", "Sug", 12, 3, 11, 15));
        busList.addFirst(new Bus("B01", "Mil", 10, 5, 5.7, 8));
        busList.addFirst(new Bus("B02", "App", 5, 2, 4, 7));
        busList.addFirst(new Bus("B05", "Roo", 7, 6, 15, 19));
        busList.addFirst(new Bus("B07", "Bee", 9, 5, 5, 13.6));
        busList.addFirst(new Bus("B04", "Boo", 9, 5, 5, 7.1));
    }

    public Bus input() {
        Bus bus = new Bus();
        String code;
        do {
            System.out.print("Enter Bus Code: ");
            code = Validation.checkInputString();
            if (!checktCodeExist(code)) {
                System.err.println("Bus code is exist in list");
            }
        } while (!checktCodeExist(code));
        bus.setBcode(code);
        System.out.print("Enter Bus Name: ");
        bus.setBusName(Validation.checkInputString());
        System.out.print("Enter number of seat: ");
        bus.setSeat(Validation.checkInputPositiveInt());
        System.out.print("Enter number of booked: ");
        bus.setBooked(Validation.checkInputIntLimit(0, bus.getSeat()));
        System.out.print("Enter depart time: ");
        bus.setDepartTime(Validation.checkInputDouble());
        System.out.print("Enter arrival time: ");
        bus.setArrivalTime(Validation.checkInputDouble());
        return bus;
    }

    public void addBus() {
        busList.addFirst(input());
    }

    public void sortByBCode() {
        busList.sort();
    }

    public void display() {
        System.out.println("");
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%5s|%10s|%4s|%6s|%11s|%12s|%14s\n", "bcode", "bus_name", "seat", "booked",
                "depart_time", "arrival_time", "travel_time");
        System.out.println("-------------------------------------------------------------------");
        for (Bus b : busList) {
            System.out.printf("%-5s|", b.getBcode());
            System.out.printf("%-10s|", b.getBusName());
            System.out.printf("%-4s|", b.getSeat());
            System.out.printf("%-6s|", b.getBooked());
            System.out.printf("%-11s|", b.getDepartTime());
            System.out.printf("%-12s|", b.getArrivalTime());
            System.out.printf("%-14s", b.getArrivalTime() - b.getDepartTime());
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");
    }

    public void deleteByBCode() {
        System.out.print("Enter bus code to delete: ");
        String bcode = Validation.checkInputString();
        for (Bus b : busList) {
            if (bcode.equalsIgnoreCase(b.getBcode())) {
                busList.deleteNode(b);
                System.out.println("Delete success");
                return;
            }
        }
        System.out.println("Dont have this bus in list");
    }

    public void searchByBCode() {
        System.out.print("Enter bus code to search: ");
        String bcode = Validation.checkInputString();
        for (Bus b : busList) {
            if (bcode.equalsIgnoreCase(b.getBcode())) {
                System.out.println(b.toString());
                return;
            }
        }
        System.out.println("Dont have this bus in list");
    }

    public static Bus searchByBCode(String bcode) {
        for (Bus b : busList) {
            if (bcode.equalsIgnoreCase(b.getBcode())) {
                return b;
            }
        }
        return null;
    }

    public void saveToFile() throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream("bus.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(busList);
            oos.close();
        } catch (Exception e) {
        }

        PrintWriter pw = new PrintWriter(new FileOutputStream("bus.txt"));
        for (Bus b : busList) {
            String tmp = b.toString();
            pw.write(tmp);
        }
        pw.close();
    }

    public void loadFromFile() {
        try {
            FileInputStream fis = new FileInputStream("bus.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            busList = (MyLinkedList) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Dont have this file");
        }
    }

    public void deleteBeforeBus() {
        String bcode;
        System.out.print("Enter bus code: ");
        bcode = Validation.checkInputString();
        for (Bus b : busList) {
            if (bcode.equalsIgnoreCase(b.getBcode())) {
                busList.deleteBeforeNode(b);
            }
        }
    }

    public void addAfterPosition() {
        int k;
        System.out.print("Enter position to add: ");
        k = Validation.checkInputPositiveInt();
        busList.addAfterPosition(k, input());
    }

    public static boolean checktCodeExist(String bcode) {
        for (Bus bus : busList) {
            if (bcode.equalsIgnoreCase(bus.getBcode())) {
                return false;
            }
        }
        return true;
    }
}
