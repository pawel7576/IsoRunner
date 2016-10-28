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

    public AppCallbackProvider() {
        callService = ICallService.retrofit.create(ICallService.class);
//        callService = retrofit2.create(ICallService.class);
//        callService = retrofit.create(ICallService.class);

    }

//    public void GetNews(final Callback<List<String>> callback) {
//        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
//        Call<List<Contributor>> call = gitHubService.GetNews()
//
//        callService.GetNews(new Callback<List<String>>() {
//            @Override
//            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                callback.onResponse(call,response);
//            }
//
//            @Override
//            public void onFailure(Call<List<String>> call, Throwable t) {
//                int i = 0;
//            }
//        });
//    }
}
