package com.special.IsoRunner;

import com.special.IsoRunner.models.Event;
import com.special.IsoRunner.models.News;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by pawel on 19/11/16.
 */

public class GlobalDataProvider {

    static List<News> getNews() {

        List<News> news = new ArrayList<>();

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        News news1 = new News(
                "Aguire wygrywa",
                formattedDate,
                "Aguire wygrywa maraton, osiągając czas 3:52:41. Drugi na mecie był Marokańczyk Mailar.");
        news.add(news1);

        News news2 = new News(
                "Bydgoszcz ugości najlepszych",
                formattedDate,
                "Światowa federacja lekkiej atletyki ogłosiła, że gospodarzem kolejnych MŚ zostaje Bydgoszcz.");
        news.add(news2);

        News news3 = new News(
                "Majewski kończy 35 lat",
                formattedDate,
                "Dwukrotny mistrz olimpijski w pchnięciu kulą - Tomasz Majewski - kończy dzisiaj 35 lat");
        news.add(news3);

        return news;
    }


    static List<Event> getEvents() {

        List<Event> events = new ArrayList<>();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

        c.add(Calendar.DATE, 3);
        String formattedDate = df.format(c.getTime());

        Event event1 = new Event(
                "Bydgoszcz",
                formattedDate,
                "Mistrzostwa Świata Juniorów");
        events.add(event1);

        c.add(Calendar.DATE, 4);
        formattedDate = df.format(c.getTime());

        Event event2 = new Event(
                "Paryż",
                formattedDate,
                "Bieg uliczny im. Fransa Savourisa");
        events.add(event2);

        c.add(Calendar.DATE, 2);
        formattedDate = df.format(c.getTime());

        Event event3 = new Event(
                "Wakebe",
                formattedDate,
                "Mistrzostwa Zimbawe");
        events.add(event3);

        return events;
    }

}
