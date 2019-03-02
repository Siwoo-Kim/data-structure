package com.siwoo.datastructure;


import com.siwoo.datastructure.list.LinkedList;
import com.siwoo.datastructure.list.SimpleLinkedList;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class SinglyListMain {

    public static void main(String[] args) {
        Employee janeJones = new Employee(1, "Jane", "Jones");
        Employee johnDoe = new Employee(2, "John", "Doe");
        Employee marrySmith = new Employee(3, "Mary", "Smith");
        Employee mikeWilson = new Employee(4, "Mike", "Wilson");

        LinkedList<Employee> list = new SimpleLinkedList<>();
        assertTrue(list.isEmpty());
        list.linkLast(janeJones);
        list.linkLast(johnDoe);
        list.linkLast(marrySmith);
        list.linkLast(mikeWilson);
        assertFalse(list.isEmpty());
        assertThat(list.size(), is(4));

        list.print();
        list.unlinkLast();
        assertThat(list.size(), is(3));
        list.print();
        list.unlinkLast();
        assertThat(list.size(), is(2));
        list.unlinkLast();
        assertThat(list.size(), is(1));
        list.unlinkLast();
        assertTrue(list.isEmpty());
        list.print();
    }
}
