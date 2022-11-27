package ru.levelup.homework1;

import java.util.*;

public class BaseOperations {
    // Cтатический метод печати в консоль имен тех рабочих,
    // которые имеют указанный стаж работы
    static void printEmployee(Collection<Employee> employees, int workAge) {
        boolean printed = true;
        for (Employee employee : employees) {
            if (employee.getWorkAge() == workAge) {
                System.out.println(employee);
                printed = false;
            }
        }
        if (printed) {
            System.out.println("Сотрудники со стажем " + workAge + " отсутствуют");
        }
        System.out.println("-----------Конец выборки-----------\n");
    }

    // метод, удаляющий элементы отсортированной коллекции,
    // стоящие на нечетных позициях с конца списка
    static void removeOddWorkers(Collection<Employee> employees) {
        System.out.println("Отсортированный список сотрудников (без нечетных позиций)");
        ArrayList<Employee> listEmployees = new ArrayList<>(List.copyOf(employees));
        listEmployees.sort(new SortByAgeWork());
        for (int i = employees.size() - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                listEmployees.remove(i);
            }
        }
        int count = 0;
        for (Employee worker : listEmployees) {
            System.out.println((++count) + " - " + worker);
        }
        System.out.println("-----------------Конец списка------------------------\n");
    }

    static void sortingSet(Collection<Employee> employees) {
        System.out.println("Отсортированное множество (Стаж по убыванию)");

        Set<Employee> setEmployees = new TreeSet<>(new SortByAgeWork());

        setEmployees.addAll(Set.copyOf(employees));
        setEmployees.add(new Employee("Тот кого нельзя называть", 999));
        System.out.println(setEmployees);

        System.out.println("-----------------Конец множества------------------------\n");
    }

    static int keyboardInput() {
        Scanner scanner = new Scanner(System.in);
        int workAgeWithScanner=0;
        System.out.println("Введите требуемый стаж работы сотрудника (0 - 10):");

       try{
           workAgeWithScanner= scanner.nextInt();
       } catch (Exception e) {
           System.out.println("Введите число!");
           keyboardInput();
       }
        return workAgeWithScanner;
    }

    static Set<Employee> union(Set<Employee> set1, Set<Employee> set2){
        System.out.println("Вывод объединенного множества");
        set1.addAll(Set.copyOf(set2));
        return set1;
    }

    static Set<Employee> intersect(Set<Employee> set1, Set<Employee> set2){
        System.out.println("Вывод пересечения двух множеств");
        set1.retainAll(set2);
    return set1;
    }
}