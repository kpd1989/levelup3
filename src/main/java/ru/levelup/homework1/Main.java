package ru.levelup.homework1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static ru.levelup.homework1.BaseOperations.*;
import static ru.levelup.homework1.DataBaseEmployees.creatSetBase;

public class Main {

    public static void main(String[] args) {
        DataBaseEmployees baseEmployees = new DataBaseEmployees(100);
        //    System.out.println(baseEmployees.getListEmployees());

        int workAgeWithScanner = keyboardInput();
        printEmployee(baseEmployees.getListEmployees(), workAgeWithScanner);

        removeOddWorkers(baseEmployees.getListEmployees());

        //Задание 2 - множество
        sortingSet(baseEmployees.getListEmployees());


        // Задание 3 - Обьединение и пересечение множеств
        Set<Employee> set1 = creatSetBase(10);
        Set<Employee> set2 = creatSetBase(10);

        System.out.println(intersect(set1,set2));
        System.out.println();
        System.out.println(union(set1,set2));
    }
}
