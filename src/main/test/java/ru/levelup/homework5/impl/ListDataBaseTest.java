package ru.levelup.homework5.impl;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListDataBaseTest {
    ArrayList<Integer> list = new ArrayList<>();
    ListDataBase listDataBase = new ListDataBase(list);

    @Test
    public void addElement() {
        listDataBase.addElement(3);
        assertEquals(3, list.size());

        listDataBase.addElement(6);
        assertEquals(6, list.size());

        listDataBase.addElement(25);
        assertEquals(25, list.size());
    }

    @Test
    public void getElement() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        listDataBase.getElement(4);

        String allWrittenLines = outputStreamCaptor.toString();
        assertTrue(allWrittenLines.contains("4-й элемент последовательности =2"));

//        assertEquals("""
//                        Эллемент добавлен в базу\r
//                        4-й элемент последовательности =2\r
//                        -----------------------\r
//                        """,
//                outputStreamCaptor.toString());

        int actualResult = list.get(3);
        assertEquals(2, actualResult);
    }
}