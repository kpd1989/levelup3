package ru.levelup.homework1;

import java.util.List;
import java.util.Random;

abstract class GeneratedEmployee {
    private static final List<String> listName = List.of("Иван", "Пётр", "Макар", "Дмитрий", "Павел", "Серафим", "Евкакий", "Матвей", "Геральт", "Гендальф", "Кузя");
    private static final List<String> listSurname = List.of("Иванов", "Петров", "Ньютон", "Аршавин", "Головин", "Миранчук", "Черчесов", "Тургенев", "Пушкин", "Чехов", "Акинфеев", "Заболотный", "Чалов", "Малком");
    private static final List<String> listPatronymic = List.of("Иванович", "Петрович", "Андреевич", "Дмитриевич", "Валентинович", "Феодосиевич", "Анатольевич", "Евкакиевич","Матвеевич");

    public static String getFullName() {
        String name = listName.get(new Random().nextInt(listName.size()));
        String surname = listSurname.get(new Random().nextInt(listSurname.size()));
        String patronymic = listPatronymic.get(new Random().nextInt(listPatronymic.size()));

        return surname + " " + name + " " + patronymic;
    }

    public static int getWorkAge() {
        return new Random().nextInt(10);
    }

}