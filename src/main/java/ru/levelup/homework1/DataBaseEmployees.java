package ru.levelup.homework1;

import java.util.ArrayList;
import java.util.List;

import static ru.levelup.homework1.GeneratedEmployee.*;

public class DataBaseEmployees {
    private static final List<Employee> listEmployees = new ArrayList<>();

    public DataBaseEmployees() {
        for (int i = 0; i<100; i++){
            listEmployees.add(new Employee(getFullName(), getWorkAge()));
        }
    }

    public List<Employee> getListEmployees() {
        return listEmployees;
    }
}
