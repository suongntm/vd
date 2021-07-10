/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

import java.io.Serializable;

/**
 *
 * @author SuongNTM
 */
public class Customer implements Serializable {

    private String ccode;
    private String cusName;
    private String phone;
    public static final long serialVersionUID = 1L;

    public Customer() {
    }

    public Customer(String ccode, String cusName, String phone) {
        this.ccode = ccode;
        this.cusName = cusName;
        this.phone = phone;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return String.format("%-10s| %-10s| %-10s\n", ccode, cusName, phone);
    }
}
