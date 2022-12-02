package ru.levelup.homework2.version2.action;

import ru.levelup.homework2.version2.object.Word;

import static ru.levelup.homework2.version2.check.CheckInputText.stupidStupidityTestInput;
import static ru.levelup.homework2.version2.console.Reader.readConsole;
import static ru.levelup.homework2.version2.object.BaseWords.listWords;

public class actionsWithList {
    public static void createWordsList() {
        String line = readConsole();
        String[] words = line.toLowerCase().split("(?U)[\\W]+");

        stupidStupidityTestInput(words);

        addWordsToList(words);
    }

    private static void addWordsToList(String[] words) {
        for (String word : words) {
            boolean equalsNewWord = false;
            int indexInList = 0;

            for (int ind = 0; ind < listWords.size(); ind++) {
                if (listWords.get(ind).getWord().equals(word)) {
                    equalsNewWord = true;
                    indexInList = ind;
                }
            }

            if (equalsNewWord) {
                listWords.get(indexInList).setCountWords(
                        listWords.get(indexInList).getCountWords() + 1);
            } else {
                listWords.add(new Word(word, 1));
            }

        }
    }
}
