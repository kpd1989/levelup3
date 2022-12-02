package ru.levelup.homework2.version2.console;

import ru.levelup.homework2.version2.object.Word;
import java.util.Collections;
import static ru.levelup.homework2.version2.object.BaseWords.listWords;

public class Printer {
    public static void printOnConsole() {
        Collections.sort(listWords);

        for (Word word : listWords) {
            System.out.println(word);
        }
    }
}
