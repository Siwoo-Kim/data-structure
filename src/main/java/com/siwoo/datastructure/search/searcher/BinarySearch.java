package com.siwoo.datastructure.search.searcher;

//ref: only works for sorted array
public class BinarySearch<E extends Comparable> extends Searcher<E> {

    @Override
    public int search(E[] elements, E element) {
        int high = elements.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (high + low) / 2;
            int result = element.compareTo(elements[mid]);
            if (result == 0)
                return mid;
            else if (result > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    @Override
    public int search(E[] elements, String attribute, Object value) {
        return -1;
    }
}
