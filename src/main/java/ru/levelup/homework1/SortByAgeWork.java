package ru.levelup.homework1;

import java.util.Comparator;

public class SortByAgeWork implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o2.getWorkAge() != o1.getWorkAge()){
            return Integer.compare(o2.getWorkAge(), o1.getWorkAge());
        }
        return o2.getFullName().compareTo(o1.getFullName());
    }
}