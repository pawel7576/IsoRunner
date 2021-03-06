package com.special.IsoRunner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.special.IsoRunner.adapters.NewsListViewAdapter;
import com.special.IsoRunner.callbackFiles.ICallService;
import com.special.IsoRunner.models.Weather;
import com.special.ResideMenu.ResideMenu;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private View parentView;
    private ResideMenu resideMenu;

    private ListView listNews ;
    private ListView listEvents ;

    private TextView temperatureTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.home, container, false);
        setUpViews();

        listNews = (ListView) parentView.findViewById(R.id.news_list);
        NewsListViewAdapter adapter = new NewsListViewAdapter(getActivity().getBaseContext(), GlobalDataProvider.getNewsAndEvents());
        listNews.setAdapter(adapter);

        temperatureTextView = (TextView) parentView.findViewById(R.id.temperature_textView);
        loadWeather();

        return parentView;
    }

    private void setUpViews() {
        MenuActivity parentActivity = (MenuActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();
    }

    private void loadWeather() {
        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<Weather> call = gitHubService.GetWeather(54.3520f, 18.6466f);

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                temperatureTextView.setText(String.format("%d°C", Math.round(response.body().temperature)));
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });

    }

}
