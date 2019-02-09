package com.siwoo.datastructure;

import com.siwoo.datastructure.practice.DoublyLinkedList;

import java.util.Deque;

import static org.junit.Assert.*;



public class DoublyLinkedListMain {
    public static void main(String[] args) {
        Employee janeJones = new Employee(1, "Jane", "Jones");
        Employee johnDoe = new Employee(2, "John", "Doe");
        Employee marrySmith = new Employee(3, "Mary", "Smith");
        Employee mikeWilson = new Employee(4, "Mike", "Wilson");
        Employee billEnd = new Employee(5, "Bill", "End");

        DoublyLinkedList<Employee> list = new DoublyLinkedList<>();
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marrySmith);
        list.addFirst(mikeWilson);
        assertEquals(list.size(), 4);
        list.print();

        list.addLast(billEnd);
        assertEquals(list.size(), 5);
        list.print();
        Employee removed = list.removeFirst();
        assertEquals(removed.getId(), mikeWilson.getId());
        assertEquals(list.size(), 4);
        list.print();
        removed = list.removeLast();
        assertEquals(removed.getId(), billEnd.getId());
        assertEquals(list.size(), 3);
        list.print();

        removed = list.removeLast();
        assertEquals(removed.getId(), janeJones.getId());
        assertEquals(list.size(), 2);
        list.print();

        removed = list.removeLast();
        assertEquals(removed.getId(), johnDoe.getId());
        assertEquals(list.size(), 1);
        list.print();

        removed = list.removeLast();
        assertEquals(removed.getId(), marrySmith.getId());
        assertTrue(list.isEmpty());
        list.print();
        list.addFirst(janeJones);
        list.addLast(marrySmith);
        assertEquals(list.size(), 2);
    }
}
