package com.special.IsoRunner.models;

/**
 * Created by qdirq on 1/23/2017.
 */

public abstract class NewsBase {
    public String title;
    public String date;
    public String text;

    public NewsBase(String title, String date, String text) {
        this.title = title;
        this.date = date;
        this.text = text;
    }
}
