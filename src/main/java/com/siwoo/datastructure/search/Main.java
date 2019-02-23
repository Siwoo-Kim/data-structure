package com.siwoo.datastructure.search;

import com.siwoo.datastructure.search.searcher.BinarySearch;
import com.siwoo.datastructure.search.searcher.LinearSearch;
import com.siwoo.datastructure.search.searcher.Searcher;

public class Main {

    public static void main(String[] args) {
        Element[] elements = {
                new Element(1, "A"), new Element(2, "B"), new Element(3, "C"),
                new Element(4, "D"), new Element(5, "E"), new Element(6, "F"),
                new Element(7, "G"), new Element(8, "H"), new Element(9, "I"), new Element(10, "J"),
        };

        Searcher<Element> searcher = new LinearSearch<>();
        int index = searcher.search(elements, "name", "F");
        System.out.println(index);

        searcher = new BinarySearch<>();
        index = searcher.search(elements, new Element(5, "E"));
        System.out.println(index);
    }
}
