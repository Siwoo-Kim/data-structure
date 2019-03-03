package com.siwoo.datastructure.hashtable;

import java.util.Arrays;
import java.util.Objects;

public class LinearProbingHashTable<K, V> implements HashTable<K, V> {

    static class Node<K, V> implements Entry<K, V> {
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

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Entry) {
                Node that = (Node) o;
                return Objects.equals(this.key, that.key) &&
                        Objects.equals(this.value, that.value);
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

    @Override
    public void put(K key, V value) {
        put(key, value, false);
    }

    @Override
    public V get(K key) {
        int hash = getIndex(key);
        return hash == -1 ? null : (V) table[hash].getValue();
    }

    private int getIndex(K key) {
        int hash = hash(key);
        if (table[hash] != null && table[hash].getKey().equals(key))
            return hash;
        int stop = hash;
        if (hash == table.length - 1)
            hash = 0;
        else
            hash++;
        while (hash != stop && table[hash] != null && !table[hash].getKey().equals(key)) {
            hash = (hash + 1) % table.length;
        }
        if (table[hash] != null && table[hash].getKey().equals(key))
            return hash;
        else
            return -1;
    }

    @Override
    public V remove(K key) {
        int hash = getIndex(key);
        if (hash == -1)
            return null;
        Entry e = table[hash];
        table[hash] = null;
        rehashing();
        size--;
        return (V) e.getValue();
    }

    private void rehashing() {
        Entry[] old = table;
        table = new Entry[old.length];
        for (int i = 0; i < old.length; i++) {
            if (old[i] != null)
                put((K) old[i].getKey(), (V) old[i].getValue(), true);
        }
    }

    private void put(K key, V value, boolean rehash) {
        int hash = hash(key);
        if (table[hash] != null) {
            if (table[hash].getKey().equals(key)) {
                table[hash] = new Node(key, value);
                return;
            }
            //ref: collision occurs, do linear probing.
            int stop = hash;
            if (hash == table.length - 1)
                hash = 0;
            else
                hash++;
            while (hash != stop && table[hash] != null) {
                hash = (hash + 1) % table.length;
            }
        }
        //ref: After linear probing if hash is occupied, it indicates that table is full.
        if (table[hash] != null) {
            System.out.println("Table is full.");
            //ref: slow
            this.table = Arrays.copyOf(table, table.length * 2);
            put(key, value);
            rehashing();
        } else {
            this.table[hash] = new Node(key, value);
            if (!rehash) {
                size++;
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < table.length; i++)
            if (table[i] != null)
                System.out.println(table[i].getValue());
    }

    @Override
    public int size() {
        return size;
    }

    public int hash(K key) {
        //do not use in the practice
        return key.toString().length() % table.length;
    }
}















