package com.siwoo.datastructure.hashtable;

import java.util.LinkedList;
import java.util.Objects;

public class ChainedHashTable<K, V> implements HashTable<K, V> {

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

    private transient LinkedList<Entry>[] table;
    private transient int size = 0;
    public static final int DEFAULT_CAPACITY = 10;

    public ChainedHashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < table.length; i++)
            table[i] = new LinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        int hash = hash(key);
        Entry<?, ?> newEntry = new Node<>(key, value);
        if (!table[hash].contains(newEntry)) {
            table[hash].add(new Node(key, value));
            size++;
        }
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        Entry e = null;
        for (Entry el: table[hash]) {
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
        Entry e = null;
        int index = 0;
        for (Entry el: table[hash]) {
            if (el.getKey().equals(key)) {
                e = el;
                table[hash].remove(index);
                size--;
                break;
            }
            index++;
        }
        return e == null ? null : (V) e.getValue();
    }

    @Override
    public void print() {
        for (int i = 0; i < table.length; i++) {
            table[i].stream().map(Entry::getValue).forEach(System.out::println);
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
