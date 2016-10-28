package com.special.IsoRunner.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by pawel on 22/10/16.
 */

public class UtilsApp {
    public static String getFormattedDate(Date date) {
        if(date == null)
            return "";

        DateFormat df = new SimpleDateFormat("d MMM yyyy");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = df.format(date);

        return formattedDate;
    }
}
