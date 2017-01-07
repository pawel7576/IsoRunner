package com.special.IsoRunner.callbackFiles;

import com.special.IsoRunner.models.TrainingItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

    public void GetNews(final Callback<List<TrainingItem>> callback) {
        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
//        Call<List<Contributor>> call = gitHubService.GetNews()


//        Call<List<TrainingItem>> call = callService.GetNews();
//        call.enqueue(new Callback<List<TrainingItem>>() {
//            @Override
//            public void onResponse(Call<List<TrainingItem>> call, Response<List<TrainingItem>> response) {
//                callback.onResponse(call,response);
//                int i = 0;
//            }
//
//            @Override
//            public void onFailure(Call<List<TrainingItem>> call, Throwable t) {
//                callback.onFailure(call,t);
//                int j = 0;
//            }
//        });


//        callService.GetNews(new Callback<List<TrainingItem>>() {
//            @Override
//            public void onResponse(Call<List<TrainingItem>> call, Response<List<TrainingItem>> response) {
//                callback.onResponse(call,response);
//            }
//
//            @Override
//            public void onFailure(Call<List<TrainingItem>> call, Throwable t) {
//                int i = 0;
//            }
//        });
    }
}
