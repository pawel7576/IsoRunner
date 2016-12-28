package com.special.IsoRunner;

import com.special.IsoRunner.models.BackgroundImageInfo;
import com.special.IsoRunner.models.Event;
import com.special.IsoRunner.models.News;
import com.special.IsoRunner.models.Note;

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

    static List<Note> getNotes() {

        List<Note> news = new ArrayList<>();

        Note news1 = new Note("1","note daslk djas alskdj ");
        news.add(news1);

        news1 = new Note("2","note daslk djas alskdj ");
        news.add(news1);

        news1 = new Note("3","Proponowane zmiany zakładają m.in., że powstanie grupa stałych korespondentów parlamentarnych. Stali korespondenci parlamentarni mieliby otrzymać specjalne przepustki ważne do końca kadencji, gwarantujące nieograniczony dostęp do Centrum Medialnego oraz głównego gmachu Sejmu i Senatu. Co ważne, wyboru dziennikarzy na stałe oddelegowanych do Sejmu dokonywałyby redakcje. Zgodnie z założeniem, każda z nich miałaby możliwość wyznaczenia dwóch takich osób, pracujących na zmiany. Niewykluczone także, że duże media, składające się z kilku redakcji będą liczone jako jedna. ");
        news.add(news1);

        news1 = new Note("4","note daslk djas alskdj ");
        news.add(news1);

        news1 = new Note("5","note daslk djas alskdj ");
        news.add(news1);

        news1 = new Note("6","- PiS nie boi się dziennikarzy w Sejmie. To nie PiS ustala zasady, czy będzie ustalało zasady pobytu dziennikarzy w Sejmie i z tego, co wiem, wszystkie redakcje mają być reprezentowane w parlamencie. Nie uważam, aby działo się coś złego, aby prawa dziennikarzy były ograniczane – mówiła rzeczniczka PiS Beata Mazurek na porannym briefingu w Sejmie. Jak stwierdziła, „nie ma mowy, abyście byli odcięci od informacji”. – To propozycja Kancelarii Sejmu, nie PiS – dodała.  ");
        news.add(news1);

        news1 = new Note("7","note daslk djas alskdj ");
        news.add(news1);

        news1 = new Note("8","note daslk djas alskdj ");
        news.add(news1);

        return news;
    }

    public static List<BackgroundImageInfo> getBackgroundImagesList() {
        List<BackgroundImageInfo> images = new ArrayList<>();

        BackgroundImageInfo news1 = new BackgroundImageInfo("Runner",R.drawable.background_main_menu);
        images.add(news1);

        news1 = new BackgroundImageInfo("Forest",R.drawable.menu_background);
        images.add(news1);

        news1 = new BackgroundImageInfo("Fire",R.drawable.menu_background); //TODO add new background image
        images.add(news1);

        return images;
    }
}
