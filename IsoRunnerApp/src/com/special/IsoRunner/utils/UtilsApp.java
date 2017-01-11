package com.special.IsoRunner.utils;

import android.app.Activity;
import android.content.SharedPreferences;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static android.content.Context.MODE_PRIVATE;

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
    public static String getToken(Activity activity) {
        if(activity == null) return "";
        SharedPreferences myPrefs = activity.getSharedPreferences("myPrefs", MODE_PRIVATE);
        return myPrefs.getString("token","default_token_value");
    }
}
