package com.special.IsoRunner.callbackFiles;

import com.special.IsoRunner.models.TrainingItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Paweł on 2016-10-14.
 */
public interface ICallService {

//    @GET("/isorunnerservice.azurewebsites.net/api/news")
//    public Call<List<String>> GetNews(Callback<List<String>> callback);

    @GET("/api/news")
    Call<List<TrainingItem>> GetNews();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://isorunnerservice.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
