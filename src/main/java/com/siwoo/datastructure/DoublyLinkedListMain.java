package com.siwoo.datastructure;

import com.siwoo.datastructure.list.AdvancedLinkedList;
import com.siwoo.datastructure.list.LinkedList;
import com.siwoo.datastructure.practice.DoublyLinkedList;

import static org.junit.Assert.*;



public class DoublyLinkedListMain {
    public static void main(String[] args) {
        Employee janeJones = new Employee(1, "Jane", "Jones");
        Employee johnDoe = new Employee(2, "John", "Doe");
        Employee marrySmith = new Employee(3, "Mary", "Smith");
        Employee mikeWilson = new Employee(4, "Mike", "Wilson");
        Employee billEnd = new Employee(5, "Bill", "End");

        LinkedList<Employee> list = new AdvancedLinkedList<>();
        assertTrue(list.isEmpty());
        list.linkLast(janeJones);
        list.linkLast(johnDoe);
        list.linkLast(marrySmith);
        list.linkLast(mikeWilson);
        assertEquals(list.size(), 4);
        list.print();

        list.linkFirst(billEnd);
        assertEquals(list.size(), 5);
        list.print();
        Employee removed = list.unlinkLast();
        assertEquals(removed.getId(), mikeWilson.getId());
        assertEquals(list.size(), 4);
        assertEquals(marrySmith.getId(), list.getLast().getId());
        list.print();
        removed = list.unlinkFirst();
        assertEquals(removed.getId(), billEnd.getId());
        assertEquals(list.size(), 3);
        list.print();
        removed = list.unlinkFirst();
        assertEquals(removed.getId(), janeJones.getId());
        assertEquals(list.size(), 2);
        list.print();
        removed = list.unlinkFirst();
        assertEquals(removed.getId(), johnDoe.getId());
        assertEquals(list.size(), 1);
        list.print();
        removed = list.unlinkLast();
        assertEquals(removed.getId(), marrySmith.getId());
        assertTrue(list.isEmpty());
        list.print();
        list.linkFirst(janeJones);
        list.linkLast(marrySmith);
        assertEquals(list.size(), 2);
    }
}
