package com.siwoo.datastructure;



import com.siwoo.datastructure.practice.SinglyLinkedList;

import static org.junit.Assert.*;

public class SinglyListMain {

    public static void main(String[] args) {
        Employee janeJones = new Employee(1, "Jane", "Jones");
        Employee johnDoe = new Employee(2, "John", "Doe");
        Employee marrySmith = new Employee(3, "Mary", "Smith");
        Employee mikeWilson = new Employee(4, "Mike", "Wilson");

        SinglyLinkedList<Employee> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());
        list.add(janeJones);
        list.add(johnDoe);
        list.add(marrySmith);
        list.add(mikeWilson);
        list.print();

        assertEquals(list.size(), 4);
        assertFalse(list.isEmpty());
        list.remove();
        assertEquals(list.size(), 3);
        list.remove();
        assertEquals(list.size(), 2);
        list.remove();
        assertEquals(list.size(), 1);
        list.remove();
        assertTrue(list.isEmpty());
        assertNull(list.remove());
        list.print();
    }
}
