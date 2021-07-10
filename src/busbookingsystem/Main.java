/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author SuongNTM
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int choice, choice1;
        BusList busl = new BusList();
        CustomerList customer = new CustomerList();
        BookingList booking = new BookingList();
        do {
            choice = Menu.Main();
            switch (choice) {
                case 1:
                    do {
                        choice1 = Menu.BusList();
                        switch (choice1) {
                            case 1:
                                busl.loadFromFile();
                                break;
                            case 2:
                                busl.addBus();
                                break;
                            case 3:
                                busl.display();
                                break;
                            case 4:
                                busl.saveToFile();
                                break;
                            case 5:
                                busl.searchByBCode();
                                break;
                            case 6:
                                busl.deleteByBCode();
                                break;
                            case 7:
                                busl.sortByBCode();
                                break;
                            case 8:
                                busl.addAfterPosition();
                                break;
                            case 9:
                                busl.deleteBeforeBus();
                                break;
                        }
                    } while (choice1 != 10);
                    break;
                case 2:
                    do {
                        choice1 = Menu.CustomerList();
                        switch (choice1) {
                            case 1:
                                customer.loadFromFile();
                                break;
                            case 2:
                                customer.addCustomer();
                                break;
                            case 3:
                                customer.display();
                                break;
                            case 4:
                                customer.saveToFile();
                                break;
                            case 5:
                                customer.searchByCCode();
                                break;
                            case 6:
                                customer.deleteByCCode();
                                break;
                        }
                    } while (choice1 != 7);
                    break;
                case 3:
                    do {
                        choice1 = Menu.BookingList();
                        switch (choice1) {
                            case 1:
                                booking.addBooking();
                                break;
                            case 2:
                                booking.display();
                                break;
                            case 3:
                                
                                break;
                        }
                    } while (choice1 != 4);
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }
}

