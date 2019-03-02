package com.siwoo.datastructure.hashtable;

/**
 * Created by sm123tt@gmail.com on 2019-03-02
 * Project : data-structure
 * Github : http://github.com/Siwoo-Kim
 */

public interface HashTable<K, V> {
    void put(K key, V value);

    V get(K key);

    V remove(K key);

    void print();

    int size();

    interface Entry<K, V> {
        K getKey();
        V getValue();
    }

}
