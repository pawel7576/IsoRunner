package com.special.IsoRunner.models;

import java.util.Date;

/**
 * Created by pawel on 19/11/16.
 */

public class News {
    public String title;
    public String date;
    public String text;

    public News(String title, String date, String text){
        this.title = title;
        this.date = date;
        this.text = text;
    }
}
