package ru.levelup.homework1;

import static ru.levelup.homework1.BaseOperations.*;

public class Main {

    public static void main(String[] args) {
        DataBaseEmployees baseEmployees = new DataBaseEmployees();
        //    System.out.println(baseEmployees.getListEmployees());

        int workAgeWithScanner = keyboardInput();
        printEmployee(baseEmployees.getListEmployees(), workAgeWithScanner);

        removeOddWorkers(baseEmployees.getListEmployees());

        sortingSet(baseEmployees.getListEmployees());

    }
}
