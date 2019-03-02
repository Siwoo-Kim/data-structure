package com.siwoo.datastructure;

import com.siwoo.datastructure.hashtable.HashTable;
import com.siwoo.datastructure.hashtable.SimpleHashTable;

public class HashTableMain {

    public static void main(String[] args) {
        Employee janeJones = new Employee(1, "Jane", "Jones");
        Employee johnDoe = new Employee(2, "John", "Doe");
        Employee mikeWilson = new Employee(4, "Mike", "Wilson");
        Employee marrySmith = new Employee(3, "Mary", "Smith");
        Employee billEnd = new Employee(5, "Bill", "End");
        Employee longName = new Employee(5, "Long", "ninthnine");

        HashTable<String, Employee> table = new SimpleHashTable<>();
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
        System.out.println(((SimpleHashTable<String, Employee>) table).getLoadFactor());

        System.out.println(table.get(mikeWilson.getLastName()));
        System.out.println(table.get(marrySmith.getLastName()));
        System.out.println(table.get(billEnd.getLastName()));

        System.out.println("=============================");
        table.remove(mikeWilson.getLastName());
        table.remove(janeJones.getLastName());
        table.print();

        System.out.println(table.get(marrySmith.getLastName()));

    }
}
