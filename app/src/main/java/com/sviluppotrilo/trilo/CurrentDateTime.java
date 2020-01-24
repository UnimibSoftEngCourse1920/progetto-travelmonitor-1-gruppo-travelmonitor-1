package com.sviluppotrilo.trilo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CurrentDateTime {

    public String toString() {

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E%20MMM%20dd%20yyyy%20HH:mm:ss", new Locale("en"));
        return (LocalDateTime.now().format(myFormatObj));

    }
}