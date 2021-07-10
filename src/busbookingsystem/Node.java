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
public class Node<T> implements Serializable {

    T data;
    Node next;
    public static final long serialVersionUID = 1L;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
