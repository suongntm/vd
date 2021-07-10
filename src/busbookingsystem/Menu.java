/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

/**
 *
 * @author SuongNTM
 */
public class Menu {

    public static int Main() {
        System.out.println("--------Menu--------");
        System.out.println("1. Bus");
        System.out.println("2. Customer");
        System.out.println("3. Booking");
        System.out.println("4. Exit");
        System.out.println("---------------------");
        System.out.print("Your selection (1 -> 4): ");
        return Validation.checkInputInt();
    }

    public static int BusList() {
        System.out.println("--------------Bus----------------");
        System.out.println(" 1. Load data from file");
        System.out.println(" 2. Input & add to the head");
        System.out.println(" 3. Display data");
        System.out.println(" 4. Save bus list to file");
        System.out.println(" 5. Search by bcode");
        System.out.println(" 6. Delete by bcode");
        System.out.println(" 7. Sort by bcode");
        System.out.println(" 8. Add before position  k");
        System.out.println(" 9. Delete the node before the node having bcode = xCode");
        System.out.println(" 10. Exit\n");
        System.out.print(" Your selection (1 -> 10): ");
        return Validation.checkInputInt();
    }

    public static int CustomerList() {
        System.out.println("-----------Customer------------");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save customer list to file");
        System.out.println("5. Search by ccode");
        System.out.println("6. Delete by ccode");
        System.out.println("7. Exit");
        System.out.print("Your selection (1 -> 7): ");
        return Validation.checkInputInt();
    }

    public static int BookingList() {
        System.out.println("-------------Booking--------------");
        System.out.println("1. Input data");
        System.out.println("2. Display data width travel time");
        System.out.println("3. Sort  by bcode + ccode");
        System.out.println("4. Exit");
        System.out.print("Your selection (1 -> 4): ");
        return Validation.checkInputInt();
    }
}
