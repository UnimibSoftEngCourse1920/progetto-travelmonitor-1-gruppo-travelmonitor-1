package com.sviluppotrilo.trilo.Domain;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CurrentDateTime {

    public final String DATEFORMAT = "E%20MMM%20dd%20yyyy%20HH:mm:ss";

    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT, new Locale("EN"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}