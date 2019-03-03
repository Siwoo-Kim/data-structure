package com.siwoo.datastructure.tree;

import com.siwoo.datastructure.queue.Queue;

import java.util.Arrays;

public class Heap<E extends Comparable> implements Tree<E>, Queue<E> {

    private transient E[] heap;
    private transient int size;

    public Heap(int capacity) {
        this.heap = (E[]) new Comparable[capacity];
    }


    @Override
    public void insert(E el) {
        if (size == heap.length)
            heap = Arrays.copyOf(heap, heap.length * 2);
        heap[size] = el;
        //ref: heapify
        heapifyAbove(size++);
    }

    @Override
    public void delete(E el) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty.");
        int index = -1;
        for (int i = 0; i < heap.length; i++) {
            if (el.equals(heap[i])) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return;
        int parent = getParent(index);
        heap[index] = heap[size - 1];
        if (index == 0 || heap[index].compareTo(heap[parent]) < 0)
            heapifyBelow(index, size - 1);
        else
            heapifyAbove(index);
        size--;
    }

    private void heapifyBelow(int index, int lastHeapIndex) {
        E el = heap[index];

        int swap;
        while (index <= lastHeapIndex) {
            int left = getChild(index, true);
            int right = getChild(index, false);
            if (left <= lastHeapIndex) {
                if (right > lastHeapIndex) {
                    swap = left;
                } else {
                    swap = heap[left].compareTo(heap[right]) > 0 ? left : right;
                }

                if (heap[index].compareTo(heap[swap]) < 0) {
                    E tmp = heap[index];
                    heap[index] = heap[swap];
                    heap[swap] = tmp;
                } else {
                    break;
                }
                index = swap;
            } else {
                break;
            }
        }

    }

    private void heapifyAbove(int index) {
        E el = heap[index];
        while (index > 0 && el.compareTo(heap[getParent(index)]) > 0) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = el;
    }

    @Override
    public int capacity() {
        return heap.length;
    }

    @Override
    public void add(E el) {
        insert(el);
    }

    @Override
    public E remove() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Heap is empty.");
        E el = heap[0];
        delete(el);
        return el;
    }

    @Override
    public E peek() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Heap is empty.");
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getChild(int index, boolean left) {
        return (2 * index) + (left ? 1 : 2);
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public E get(E el) {
        return null;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }
}
