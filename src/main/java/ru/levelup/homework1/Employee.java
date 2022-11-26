package ru.levelup.homework1;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Employee {
    private final String fullName;
    private int workAge;

    public Employee(String fullName, int workAge) {
        this.fullName = fullName;
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        return "Employee{ФИО: " + fullName+", стаж= " + workAge + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return workAge == employee.workAge && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, workAge);
    }

}