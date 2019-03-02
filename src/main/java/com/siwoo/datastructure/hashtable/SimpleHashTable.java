package com.siwoo.datastructure.hashtable;

import java.util.Map;
import java.util.Objects;

public class SimpleHashTable<K, V> implements HashTable<K, V> {

    public static final int DEFAULT_CAPACITY = 10;
    private Entry[] table;
    private int size;

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

    public SimpleHashTable() {
        this.table = new Node[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int h = hash(key);
        if (table[h] != null) {
            if (table[h].getKey().equals(key)) {
                //duplicated element
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
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return index == -1 ? null : (V) table[index].getValue();
    }

    private int findIndex(K key) {
        int h = hash(key);
        if (table[h] != null && table[h].getKey().equals(key))
            return h;
        int stop = h;
        if (h == table.length - 1)
            h = 0;
        else
            h++;
        while (table[h] != null && !table[h].getKey().equals(key) && stop != h)
            h = (h + 1) % table.length;
        if (table[h] != null && table[h].getKey().equals(key))
            return h;
        else
            return -1;
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);
        if (index == -1)
            return null;
        Entry<K, V> e = table[index];
        table[index] = null;

        Entry[] old = table;
        table = new Entry[table.length];
        for (int i = 0; i < table.length; i++) {
            if (old[i] != null)
                put((K) old[i].getKey(), (V) old[i].getValue());
        }
        return e.getValue();
    }

    @Override
    public void print() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null)
                System.out.println(table[i].getValue());
        }
    }

    private int hash(K key) {
        return key.toString().length() % table.length;
    }

    @Override
    public int size() {
        return size;
    }

    public float getLoadFactor() {
        return size / (float) table.length;
    }
}
