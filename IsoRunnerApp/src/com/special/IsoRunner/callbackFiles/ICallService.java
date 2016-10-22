package com.special.IsoRunner.callbackFiles;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by Paweł on 2016-10-14.
 */
public interface ICallService {

    @GET("/isorunnerservice.azurewebsites.net/api/news")
    void GetNews(Callback<List<String>> callback);
}
