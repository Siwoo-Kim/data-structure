package com.siwoo.datastructure.list;

import com.siwoo.datastructure.practice.SinglyLinkedList;



public class DoublyLinkMain {
    private static class Element {
        private int id;
        private String name;

        public Element(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        Element el1 = new Element(123, "Jones");
        Element el2 = new Element(456, "Doe");
        Element el3 = new Element(222, "Smith");
        Element el4 = new Element(324, "Wilson");

        LinkedList<Element> list = new DoublyLinkedList<>();
        list.linkLast(el1);
        list.linkLast(el2);
        list.print();
        list.linkFirst(el3);
        list.linkFirst(el4);
        list.print();

    }


}
