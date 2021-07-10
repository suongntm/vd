/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author SuongNTM
 */
public class MyLinkedList<T> implements Serializable, Iterable<T> {

    private Node head;
    private Node tail;
    public static final long serialVersionUID = 1L;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public MyLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public void addFirst(T item) {
        Node p = new Node(item);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void addLast(T item) {
        Node p = new Node(item);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public int getSize() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void addAfterPosition(int k, T item) {
        Node p = new Node(item);
        if (k == -1) {
            addFirst(item);
        } else {
            int count = 0;
            Node p1 = head;
            while (p1 != null && count < k) {
                p1 = p1.next;
                count++;
            }
            if (p1.next == null && count == k) {
                addLast(item);
            }
            p.next = p1.next;
            p1.next = p;
        }
    }

    public void deleteNode(T item) {
        Node temp = head, prev = null;
        
        if (temp != null && temp.data.equals(item)) {
            //remove head
            head = temp.next;
            return;
        }
        
        while (temp != null) {
            if (temp.data.equals(item)) {
                break;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    public void deleteBeforeNode(T item) {
        Node temp = head, prev1Node = null, prev2Node = null;
        
        if (temp != null && temp.data.equals(item)) {
            //remove head
            head = temp.next;
            return;
        }
       
        while (temp != null) {
            if (temp.data.equals(item)) {
                break;
            } else {
                prev2Node = prev1Node;
                prev1Node = temp;
                temp = temp.next;
            }
        }
        
        if (temp == null) {
            return;
        }
        prev2Node.next = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T item = (T) node.data;
                    node = node.next;
                    return item;
                }
                return null;
            }
        };
    }

    public void swap(T a, T b) {
        Node preX = null, currenX = head;
        
        if (currenX != null && !currenX.data.equals(a)) {
            preX = currenX;
            currenX = currenX.next;
        }
        Node preY = null, currenY = head;
        
        if (currenY != null && !currenY.data.equals(b)) {
            preY = currenY;
            currenY = currenY.next;
        }
        if (currenX == null || currenY == null) {
            return;
        }

       
        if (preX != null) {
            preX.next = currenY;
        } else {
            head = currenY;
        }

        
        if (preY != null) {
            preY.next = currenY;
        } else {
            head = currenX;
        }

        Node temp = currenX.next;
        currenX.next = currenY.next;
        currenY.next = temp;
    }

    public T getDataOfNextNode(T item) {
        Node p = head;
        while (p.next != null) {
            if (p.data.equals(item)) {
                return (T) p.next.data;
            }
            p = p.next;
        }
        return null;
    }

    public void sort() {
        if (getSize() > 1) {
            for (int i = 0; i < getSize(); i++) {
                Node currentNode = head;
                Node next = head.next;
                for (int j = 0; j < getSize() - 1; j++) {
                    if (currentNode.data.toString().compareTo(next.data.toString()) > 0) {
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;
                    }
                    currentNode = next;
                    next = next.next;
                }
            }
        }
    }

}
