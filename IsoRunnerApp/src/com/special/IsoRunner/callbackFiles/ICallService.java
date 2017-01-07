package com.special.IsoRunner.callbackFiles;

import com.special.IsoRunner.models.LoginResponse;
import com.special.IsoRunner.models.TrainingItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Paweł on 2016-10-14.
 */
public interface ICallService {

//    @GET("/isorunnerservice.azurewebsites.net/api/news")
//    public Call<List<String>> GetNews(Callback<List<String>> callback);

    @GET("/api/news")
    Call<List<TrainingItem>> GetNews();

    @FormUrlEncoded
    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @POST("/api/Register")
    Call<LoginResponse> Register(@Field("name") String name, @Field("password") String password);

    @FormUrlEncoded
    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @POST("/api/Login")
    Call<LoginResponse> Login(@Field("name") String name, @Field("password") String password);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://isorunnerservice.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
