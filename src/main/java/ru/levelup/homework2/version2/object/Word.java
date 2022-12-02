package ru.levelup.homework2.version2.object;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Word implements Comparable<Word> {
    private String word;
    private Integer countWords;

    @Override
    public String toString() {
        return word + " -" + countWords + " раз(а)";
    }

    @Override
    public int compareTo(Word o) {
        return -getCountWords().compareTo(o.getCountWords());
    }
}
