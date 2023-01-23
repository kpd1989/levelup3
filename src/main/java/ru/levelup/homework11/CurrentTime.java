package ru.levelup.homework11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {

    Date timeNow = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss a");

    public String getTime() {
        return formatForDateNow.format(timeNow);
    }
}
