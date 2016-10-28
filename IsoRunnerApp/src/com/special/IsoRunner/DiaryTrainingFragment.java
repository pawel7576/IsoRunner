package com.special.IsoRunner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.special.IsoRunner.adapters.TrainingListRecyclerViewAdapter;
import com.special.IsoRunner.callbackFiles.AppCallbackProvider;
import com.special.IsoRunner.callbackFiles.ICallService;
import com.special.IsoRunner.models.TrainingItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Paweł on 2016-10-08.
 */
public class DiaryTrainingFragment extends Fragment {


    AppCallbackProvider callbackProvider;
    List<TrainingItem> trainingList;
//    RecyclerView recyclerTrainingListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackProvider = new AppCallbackProvider();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(
                R.layout.dairy_training_layout, container, false);
//        recyclerTrainingListView = (RecyclerView) view.findViewById(R.id.list_training);
//        recyclerTrainingListView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        getNews();
        return view;
    }

    private void getNews() {
        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<List<TrainingItem>> call = gitHubService.GetNews();
        call.enqueue(new Callback<List<TrainingItem>>() {

            @Override
            public void onResponse(Call<List<TrainingItem>> call, Response<List<TrainingItem>> response) {
                trainingList = response.body();
                attachAdapter();
            }


            @Override
            public void onFailure(Call<List<TrainingItem>> call, Throwable t) {
                //TODO add communication error
            }
        });
    }

    private void attachAdapter() {
//        recyclerTrainingListView.setAdapter(new TrainingListRecyclerViewAdapter(trainingList));
    }
}
