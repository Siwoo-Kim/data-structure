package com.siwoo.datastructure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * Created by sm123tt@gmail.com on 2019-02-09
 * Project : data-structure
 * Github : http://github.com/Siwoo-Kim
 */

@Getter @Setter
public class Employee {

    private String firstName;
    private String lastName;
    private int id;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id + ", " +
                "firstName=" + firstName +
                '}';
    }
}
