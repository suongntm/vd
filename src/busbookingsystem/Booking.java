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
public class Booking {

    private String bcode;
    private String ccode;
    private Integer seat;
    public static final long serialVersionUID = 1L;

    public Booking() {
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking{" + "bcode=" + bcode + ", ccode=" + ccode + ", seat=" + seat + '}';
    }
    
    

}
