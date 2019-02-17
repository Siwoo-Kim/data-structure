package com.siwoo.datastructure.search.searcher;

public class LinearSearch<E> extends Searcher<E> {

    @Override
    public int search(E[] elements, E element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element))
                return i;
        }
        return -1;
    }

    @Override
    public int search(E[] elements, String attribute, Object value) {
//        int i = 0;
//        while (true) {
//            if (i == elements.length)
//                return -1;
//            if (invoke(elements[i], attribute).equals(value))
//                return i;
//            i++;
//        }
        for (int i = 0; i < elements.length; i++) {
            if (invoke(elements[i], attribute).equals(value))
                return i;
        }
        return -1;
    }

}
