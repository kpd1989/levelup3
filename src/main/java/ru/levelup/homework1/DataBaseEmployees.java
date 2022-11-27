package ru.levelup.homework1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.levelup.homework1.GeneratedEmployee.*;

public class DataBaseEmployees {
    private static final List<Employee> listEmployees = new ArrayList<>();

    public DataBaseEmployees(int sizeBase) {
        for (int i = 0; i < sizeBase - 1; i++) {
            listEmployees.add(new Employee(getFullName(), getWorkAge()));
        }
        listEmployees.add(new Employee("Тестов Тест Тестович", 0));
    }

    public List<Employee> getListEmployees() {
        return listEmployees;
    }

    // Создание множества для третьей задачи
    static Set<Employee> creatSetBase(int sizeBase) {
        Set<Employee> setEmployees = new HashSet<>();
        for (int i = 0; i < sizeBase - 1; i++) {
            setEmployees.add(new Employee(getFullName(), getWorkAge()));
        }
        setEmployees.add(new Employee("Тестов Тест Тестович", 0));
        return setEmployees;
    }

}
