package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.hashtable.HashTable;

import static com.siwoo.datastructure.practice.LinearProbingHashTable.Node;
import static com.siwoo.datastructure.hashtable.HashTable.Entry;
import java.util.LinkedList;
import java.util.List;

public class ChainedHashTable<K, V> implements HashTable<K, V> {

    private transient List<Entry>[] table;
    private transient int size = 0;
    public static final int DEFAULT_CAPACITY = 10;

    public ChainedHashTable() {
        this.table = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        int h = hash(key);
        Entry newEntry = new Node(key, value);
        if (!table[h].contains(newEntry)) {
            table[h].add(newEntry);
            size++;
        }

    }

    private int hash(K key) {
        return key.toString().length() % table.length;
    }

    @Override
    public V get(K key) {
        int h = hash(key);
        Entry result = null;
        for (Entry e: table[h]) {
            if (e.getKey().equals(key)) {
                result = e;
                break;
            }
        }
        return result == null ? null : (V) result.getValue();
    }

    @Override
    public V remove(K key) {
        int h = hash(key);
        Entry result = null;
        int index = 0;
        for (Entry e: table[h]) {
            if (e.getKey().equals(key)) {
                result = e;
                table[h].remove(index);
                size--;
            }
            index++;
        }
        return result == null ? null : (V) result.getValue();
    }

    @Override
    public void print() {
        for (int i = 0; i < table.length; i++) {
            if (!table[i].isEmpty())
                table[i].stream().map(Entry::getValue).forEach(System.out::println);
        }
    }

    @Override
    public int size() {
        return size;
    }
}
