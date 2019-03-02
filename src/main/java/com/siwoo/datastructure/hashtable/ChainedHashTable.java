package com.siwoo.datastructure.hashtable;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable<K, V> implements HashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private LinkedList<Entry>[] table;

    private class Node<K, V> implements Entry{
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }
    }

    public ChainedHashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList();
        }
    }

    @Override
    public void put(K key, V value) {
        int hash = hash(key);
        size++;
        table[hash].add(new Node(key, value));
    }

    private int hash(K key) {
        return key.toString().length() % table.length;
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        ListIterator<Entry> itr = table[hash].listIterator();
        Entry e = null;
        while (itr.hasNext()) {
            Entry el = itr.next();
            if (el.getKey().equals(key)) {
                e = el;
                break;
            }
        }
        return e == null ? null : (V) e.getValue();
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);
        ListIterator<Entry> itr = table[hash].listIterator();
        Entry e = null;
        int index = 0;
        while (itr.hasNext()) {
            Entry el = itr.next();
            if (el.getKey().equals(key)) {
                e = el;
                break;
            }
            index++;
        }
        if (e == null || !e.getKey().equals(key))
            return null;
        else {
            table[hash].remove(index);
            size--;
            return (V) e.getValue();
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < table.length; i++) {
            if (!table[i].isEmpty())
                for (Entry e: table[i])
                    System.out.println(e.getValue());
        }
    }

    @Override
    public int size() {
        return size;
    }
}
