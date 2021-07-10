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
public class BookingList {
    
    static MyLinkedList<Booking> bookingsList = new MyLinkedList<>();

    public Booking input() {
        Booking booking = new Booking();
        Bus bus;
        String ccode = "", bcode;
        int seat = 0;
        do {
            do {
                System.out.print("Enter bus's code: ");
                bcode = Validation.checkInputString();
                if (BusList.checktCodeExist(bcode)) {
                    System.err.println("Bus code is not found in bus list");
                }
            } while (BusList.checktCodeExist(bcode));
            bus = BusList.searchByBCode(bcode);
            if (bus.getSeat() == bus.getBooked()) {
                System.out.println("Bus is exhausted");
                continue;
            }
            do {
                System.out.print("Enter customer's code: ");
                ccode = Validation.checkInputString();
                if (CustomerList.checkcCodeExist(ccode)) {
                    System.err.println("Customer code is not found in bus list");
                }
            } while (CustomerList.checkcCodeExist(ccode));
            if (!checkExistBooking(bcode, ccode)) {
                System.out.println("This booking is exist in the list");
                continue;
            }
            do {
                System.out.print("Enter number of seat: ");
                seat = Validation.checkInputInt();
                if (seat > bus.getSeat() - bus.getBooked()) {
                    System.out.println("Number of seat avalible is " + (bus.getSeat() - bus.getBooked()));
                }
            } while (seat > bus.getSeat() - bus.getBooked());

        } while (!checkExistBooking(bcode, ccode) || bus.getSeat() == bus.getBooked() || seat > bus.getSeat() - bus.getBooked());
        booking.setBcode(bcode);
        booking.setCcode(ccode);
        booking.setSeat(seat);
        return booking;
    }

    public void addBooking() {
        bookingsList.addFirst(input());
    }

    public void display() {
        System.out.println("");
        System.out.println("--------------------------");
        System.out.printf("%9s|%12s|%4s\n", "Buscode", "Customercode", "Seat");
        for (Booking b : bookingsList) {
            System.out.printf("%-9s|%-12s|%-4s\n", b.getBcode(), b.getCcode(), b.getSeat());
        }
        System.out.println("--------------------------");
        System.out.println("");
    }

    public static boolean checkExistBooking(String bcode, String ccode) {
        for (Booking book : bookingsList) {
            if (bcode.equalsIgnoreCase(book.getBcode()) && ccode.equalsIgnoreCase(book.getCcode())) {
                return false;
            }
        }
        return true;
    }
}
