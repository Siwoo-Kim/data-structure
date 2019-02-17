package com.siwoo.datastructure.search;

import java.util.Objects;

public class Element implements Comparable<Element> {
    private final long id;
    private final String name;

    public Element(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != getClass())
            return false;
        Element that = (Element) o;
        return Objects.equals(that.id, this.id) && Objects.equals(that.name, this.name);
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Element o) {
        return Long.compare(this.id, o.id);
    }
}
