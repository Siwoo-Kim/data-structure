package com.siwoo.datastructure;

import com.siwoo.datastructure.queue.Queue;
import com.siwoo.datastructure.tree.Heap;
import com.siwoo.datastructure.tree.Tree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.PriorityQueue;

/**
 * Created by sm123tt@gmail.com on 2019-03-03
 * Project : data-structure
 * Github : http://github.com/Siwoo-Kim
 */

public class HeapMain {

    public static void main(String[] args) {
        Tree<Integer> heap = new Heap<>(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.print();
        //heap.delete(75);
        //heap.print();
        heap.delete(80);
        heap.print();
        Queue<Integer> q =  (Heap) heap;
        System.out.println(q.peek());
        heap.print();
        q.remove();
        heap.print();
        q.remove();
        heap.print();


        //MIN HEAP
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);
//        System.out.println(pq.peek());
//        System.out.println(pq.remove());
//        System.out.println(pq.peek());
//        System.out.println(pq.poll()); // = remove
//        System.out.println(pq.remove(54));
//        System.out.println(pq.peek());

        pq.add(-1);
        System.out.println(pq.peek());
        System.out.println("========================");
        Object[] ints = pq.toArray();
        for (Object num: ints) {
            System.out.println(num);
        }
    }
}

































