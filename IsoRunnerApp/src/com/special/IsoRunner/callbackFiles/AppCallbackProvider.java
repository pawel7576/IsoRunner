package com.special.IsoRunner.callbackFiles;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Paweł on 2016-10-14.
 */
public class AppCallbackProvider {

    ICallService callService;

//    public AppCallbackProvider() {
//    }

    public void GetNews(final Callback<List<String>> callback) {
        callService.GetNews(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                callback.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                int i = 0;
            }
        });
    }
}
