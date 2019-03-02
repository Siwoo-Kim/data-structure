package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.hashtable.HashTable;
import sun.dc.pr.PRError;

import java.util.Objects;


public class LinearProbingHashTable<K, V> implements HashTable<K, V> {

    static class Node<K, V> implements HashTable.Entry<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof HashTable.Entry) {
                HashTable.Entry<?, ?> that = (Entry<?, ?>) o;
                if (Objects.equals(key, that.getKey()) &&
                        Objects.equals(value, that.getValue()))
                    return true;
            }
            return false;
        }
    }

    public static final int DEFAULT_CAPACITY = 10;
    private transient Entry[] table;
    private transient int size = 0;

    public LinearProbingHashTable() {
        this.table = new Entry[DEFAULT_CAPACITY];
    }

    private void put(K key, V value, boolean rehasing) {
        int h = hash(key);
        if (table[h] != null) {
            if (table[h].getKey().equals(key)) {
                table[h] = new Node(key, value);
                return;
            }
            int stop = h;
            if (h == table.length - 1)
                h = 0;
            else
                h++;
            while (h != stop && table[h] != null)
                h = (h + 1) % table.length;
        }
        if (table[h] != null)
            System.out.println("Table is full.");
        else {
            table[h] = new Node(key, value);
            if (!rehasing)
                size++;
        }
    }

    @Override
    public void put(K key, V value) {
        put(key, value, false);
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1 ? null : (V) table[index].getValue();
    }

    private int getIndex(K key) {
        int h = hash(key);
        if (table[h] != null && table[h].getKey().equals(key))
            return h;
        int stop = h;
        if (h == table.length - 1)
            h = 0;
        else
            h++;
        while (stop != h && table[h] != null && !table[h].getKey().equals(key)) {
            h = (h + 1) % table.length;
        }
        if (table[h] != null && table[h].getKey().equals(key))
            return h;
        else
            return -1;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        if (index == -1)
            return null;
        Entry e = table[index];
        table[index] = null;
        size--;
        Entry[] old = table;
        table = new Entry[old.length];
        for (int i = 0; i < old.length; i++) {
            if (old[i] != null) {
                put((K) old[i].getKey(), (V) old[i].getValue(), true);
            }
        }
        return (V) e.getValue();
    }

    @Override
    public void print() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null)
                System.out.println(table[i].getValue());
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int hash(K key) {
        return key.toString().length() % table.length;
    }
}
