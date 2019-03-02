package com.siwoo.datastructure;

import com.siwoo.datastructure.hashtable.HashTable;
import com.siwoo.datastructure.practice.ChainedHashTable;
import com.siwoo.datastructure.practice.LinearProbingHashTable;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HashTableMain {

    public static void main(String[] args) {
        Employee janeJones = new Employee(1, "Jane", "Jones");
        Employee johnDoe = new Employee(2, "John", "Doe");
        Employee mikeWilson = new Employee(4, "Mike", "Wilson");
        Employee marrySmith = new Employee(3, "Mary", "Smith");
        Employee billEnd = new Employee(5, "Bill", "End");
        Employee longName = new Employee(5, "Long", "ninthnine");

        HashTable<String, Employee> table = new ChainedHashTable<>();
        table.put(janeJones.getLastName(), janeJones);
        table.put(johnDoe.getLastName(), johnDoe);
        table.put(mikeWilson.getLastName(), mikeWilson);
        //collision
        table.put(marrySmith.getLastName(), marrySmith);
        //collision
        table.put(billEnd.getLastName(), billEnd);
        table.put(longName.getLastName(), longName);
        table.put(longName.getLastName(), longName);
        table.print();
        assertThat(table.size(), is(6));

        table.print();
        //System.out.println(((LinearProbingHashTable<String, Employee>) table).getLoadFactor());

        assertThat(table.get(mikeWilson.getLastName()), is(mikeWilson));
        assertThat(table.get(marrySmith.getLastName()), is(marrySmith));
        assertThat(table.get(longName.getLastName()), is(longName));
        System.out.println("=============================");
        assertThat(table.remove(mikeWilson.getLastName()), is(mikeWilson));
        assertThat(table.remove(janeJones.getLastName()), is(janeJones));
        assertThat(table.size(), is(4));
        table.print();
        assertThat(table.get(marrySmith.getLastName()), is(marrySmith));

    }
}
