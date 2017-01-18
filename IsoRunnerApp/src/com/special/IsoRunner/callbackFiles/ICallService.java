package com.special.IsoRunner.callbackFiles;

import com.special.IsoRunner.models.ChatMessage;
import com.special.IsoRunner.models.LoginResponse;
import com.special.IsoRunner.models.Note;
import com.special.IsoRunner.models.TrainingItem;

import java.util.Date;
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
import retrofit2.http.Query;

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


    @FormUrlEncoded
    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @POST("/api/AddNote")
    Call<String> AddNote(@Query("token") String name, @Field("text") String password);

    @FormUrlEncoded
    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @POST("/api/AddMessage")
    Call<String> AddMessage(@Query("token") String token, @Field("text") String text);

    @FormUrlEncoded
    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @POST("/api/RemoveNote")
    Call<String> RemoveNote(@Query("token") String name, @Field("noteId") int password);

    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @GET("/api/GetNotes")
    Call<List<Note>> GetNotes(@Query("token") String name);

    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @GET("/api/GetTrainings")
    Call<List<TrainingItem>> GetTrainings(@Query("token") String name);

    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @GET("/api/GetMessages")
    Call<List<ChatMessage>> GetMessages(@Query("token") String name);

    @FormUrlEncoded
    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @POST("/api/AddTraining")
    Call<String> AddTraining(@Query("token") String name,
                             @Field("Date") Date pas1,
                             @Field("Duration") String pas2,
                             @Field("Distance") double pas3,
                             @Field("Description") String pas4,
                             @Field("Temperature") int pas5,
                             @Field("WeatherConditions") String pas6,
                             @Field("TrainingId") int pas7);

    @FormUrlEncoded
    @Headers({
            "X-ApiKey: MagiczniCzarodzieje",
    })
    @POST("/api/SaveFilter")
    Call<String> SaveFilter(@Query("token") String name,
                             @Field("FromDistance") double pas1,
                             @Field("ToDistance") double pas2,
                             @Field("FromTemperature") int pas3,
                             @Field("ToTemperature") int pas4,
                             @Field("WeatherConditions") String pas5);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://isorunnerservice.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
