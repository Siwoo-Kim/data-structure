package com.siwoo.datastructure;

import com.siwoo.datastructure.practice.ArrayStack;
import com.siwoo.datastructure.stack.Stack;

import static org.junit.Assert.assertEquals;

public class StackMain {

    public static void main(String[] args) {
        Stack<Employee> stack = new ArrayStack<>(10);
        Employee janeJones = new Employee(1, "Jane", "Jones");
        stack.push(janeJones);
        Employee johnDoe = new Employee(2, "John", "Doe");
        stack.push(johnDoe);
        Employee marrySmith = new Employee(3, "Mary", "Smith");
        stack.push(marrySmith);
        Employee mikeWilson = new Employee(4, "Mike", "Wilson");
        stack.push(mikeWilson);
        Employee billEnd = new Employee(5, "Bill", "End");
        stack.push(billEnd);
        assertEquals(stack.size(), 5);
        stack.print();
        System.out.println(stack.peek());
        assertEquals(stack.peek(), billEnd);
        assertEquals(stack.size(), 5);
        assertEquals(stack.pop(), billEnd);
        assertEquals(stack.size(), 4);
        assertEquals(stack.pop(), mikeWilson);
        assertEquals(stack.size(), 3);

    }
}
