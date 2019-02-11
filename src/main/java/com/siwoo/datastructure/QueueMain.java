package com.siwoo.datastructure;

import com.siwoo.datastructure.queue.ArrayQueue;
import com.siwoo.datastructure.queue.Queue;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class QueueMain {

    public static void main(String[] args) {
        Employee janeJones = new Employee(1, "Jane", "Jones");
        Employee johnDoe = new Employee(2, "John", "Doe");
        Employee marrySmith = new Employee(3, "Mary", "Smith");
        Employee mikeWilson = new Employee(4, "Mike", "Wilson");
        Employee billEnd = new Employee(5, "Bill", "End");

        Queue<Employee> queue = new ArrayQueue<>(3);
        assertTrue(queue.isEmpty());
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marrySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);
        assertEquals(queue.size(), 5);
        queue.print();
        System.out.println("=============================");

        Employee removed = queue.remove();
        assertEquals(queue.size(), 4);
        assertEquals(removed, janeJones);
        removed = queue.remove();
        assertEquals(queue.size(), 3);
        assertEquals(removed, johnDoe);
        removed = queue.peek();
        assertEquals(queue.size(), 3);
        assertEquals(removed, marrySmith);
        queue.print();

        removed = queue.remove();
        assertEquals(queue.size(), 2);
        assertEquals(removed, marrySmith);
        removed = queue.remove();
        assertEquals(queue.size(), 1);
        assertEquals(removed, mikeWilson);
        removed = queue.remove();
        assertTrue(queue.isEmpty());
        assertEquals(removed, billEnd);
        //reset queue momonet
        queue.add(removed);
        assertEquals(queue.size(), 1);


        queue = new ArrayQueue<>(5);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.remove();
        queue.add(marrySmith);
        queue.remove();
        queue.add(mikeWilson);
        queue.remove();
        queue.add(billEnd);
        queue.remove();
        queue.add(janeJones);
        queue.print();
        assertEquals(queue.capacity(), 5);

        queue = new ArrayQueue<>(5);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marrySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);

        queue.remove();
        queue.remove();
        assertEquals(queue.capacity(), 10);
        assertEquals(queue.size(), 3);
    }
}
