package com.learning.TODO.helper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class Helper {
    public static Date parseDate(Object date){
        LocalDateTime localDateTime = (LocalDateTime) date;
        Date parsedDate = Date.from(localDateTime.toInstant(ZoneOffset.UTC));
        return parsedDate;
    }
}
