package com.special.IsoRunner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.special.IsoRunner.adapters.EventsListViewAdapter;
import com.special.IsoRunner.adapters.NewsListViewAdapter;
import com.special.ResideMenu.ResideMenu;

import retrofit2.Call;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private View parentView;
    private ResideMenu resideMenu;

    private ListView listNews ;
    private ListView listEvents ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.home, container, false);
        setUpViews();

        listNews = (ListView) parentView.findViewById(R.id.news_list);
        NewsListViewAdapter adapter = new NewsListViewAdapter(getActivity().getBaseContext(), GlobalDataProvider.getNews());
        listNews.setAdapter(adapter);

        listEvents = (ListView) parentView.findViewById(R.id.events_list);
        EventsListViewAdapter eventsAdapter = new EventsListViewAdapter(getActivity().getBaseContext(), GlobalDataProvider.getEvents());
        listEvents.setAdapter(eventsAdapter);

        return parentView;
    }

    private void setUpViews() {
        MenuActivity parentActivity = (MenuActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();
    }

}
