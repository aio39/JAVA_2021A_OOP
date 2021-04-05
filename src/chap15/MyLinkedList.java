package chap15;

import java.util.*;
import java.util.stream.IntStream;

public class MyLinkedList {
    private Node head;
    private int size;

    public void add(Integer value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        size++;

    }

    public String toString() {
        String result = "[";
        Node tmp = head;
        while (tmp != null) {
            result += tmp.value + ",";
            tmp = tmp.next;
        }
        result += "]";
        return result;

    }

    public int size() {
        return size;
    }

    public Integer get(int index) {
        if (index >= size)
            return null;
        int idx = 0;
        Node tmp = head;
        while (idx < index && tmp.next != null) {
            tmp = tmp.next;
            idx++;
        }

        return tmp.value;

    }

    public void remove() {
        Node tmp = head;
        if (size < 2) {
            head = null;
            if (size != 0)
                size--;
            return;

        }
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
        size--;

    }

    private class Node {
        // Node prev;
        Integer value;
        Node next = null;

    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        IntStream.rangeClosed(1, 10).forEach(i -> list.add(i));
        System.out.println(list);
        System.out.println(list.get(9));
        list.remove();
        System.out.println(list);

        int length = list.size();
        for (int i = 0; i < length; i++) {
            list.remove();
            System.out.println(list);
        }
    }

}
