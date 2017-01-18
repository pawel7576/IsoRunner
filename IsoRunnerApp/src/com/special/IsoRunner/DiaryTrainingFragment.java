package com.special.IsoRunner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.special.IsoRunner.adapters.LoadingAdapter;
import com.special.IsoRunner.adapters.TrainingsListAdapter;
import com.special.IsoRunner.callbackFiles.ICallService;
import com.special.IsoRunner.models.TrainingItem;
import com.special.IsoRunner.utils.UtilsApp;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Paweł on 2016-10-08.
 */
public class DiaryTrainingFragment extends Fragment {


//    AppCallbackProvider callbackProvider;
    List<TrainingItem> currentList;


    private Button buttonAddTraining;
    private Button buttonChangeFilters;
    private Button buttonList;

    Boolean isLoading;

    Context mContext;
    DiaryTrainingFragment diaryTrainingFragment;

    private ListView listTrainings;
    private LinearLayout addTrainingLayout ;
    private LinearLayout changeFiltersLayout;

    private Button buttonFinalAdd;
    private EditText option2;
    private EditText option3;
    private EditText option4;
    private EditText option5;
    private EditText option6;
    private EditText option7;

    private Button buttonSaveFilter;
    private EditText filter1;
    private EditText filter2;
    private EditText filter3;
    private EditText filter4;
    private EditText filter5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(
                R.layout.dairy_training_layout, container, false);

        buttonAddTraining = (Button) view.findViewById(R.id.add_training);
        buttonChangeFilters = (Button) view.findViewById(R.id.change_filters);
        buttonList = (Button) view.findViewById(R.id.show_list);
        buttonAddTraining.setOnClickListener(new ShowAddTrainingListener(this));
        buttonChangeFilters.setOnClickListener(new ShowChangeFiltersListener(this));
        buttonList.setOnClickListener(new ShowListListener(this));

        mContext = getActivity().getBaseContext();
        diaryTrainingFragment = this;


        //1 option
        addTrainingLayout = (LinearLayout) view.findViewById(R.id.add_training_layout);
        buttonFinalAdd = (Button) view.findViewById(R.id.add_training_final_button);
        buttonFinalAdd.setOnClickListener(new buttonFinalAddListener(this));
        option2 = (EditText) view.findViewById(R.id.par2);
        option3 = (EditText) view.findViewById(R.id.par3);
        option4 = (EditText) view.findViewById(R.id.par4);
        option5 = (EditText) view.findViewById(R.id.par5);
        option6 = (EditText) view.findViewById(R.id.par6);
        option7 = (EditText) view.findViewById(R.id.par7);
        //2 option
        changeFiltersLayout = (LinearLayout) view.findViewById(R.id.change_filters_layout);
        buttonSaveFilter = (Button) view.findViewById(R.id.save_filter_button);
        buttonSaveFilter.setOnClickListener(new buttonSaveFilterListener(this));
        filter1 = (EditText) view.findViewById(R.id.change_par1);
        filter2 = (EditText) view.findViewById(R.id.change_par2);
        filter3 = (EditText) view.findViewById(R.id.change_par3);
        filter4 = (EditText) view.findViewById(R.id.change_par4);
        filter5 = (EditText) view.findViewById(R.id.change_par5);
        //3 option
        listTrainings = (ListView) view.findViewById(R.id.listTrainings);

        listTrainings.setVisibility(View.VISIBLE);
        addTrainingLayout.setVisibility(View.GONE);
        changeFiltersLayout.setVisibility(View.GONE);
        loadList();
        return view;
    }

    private void loadList() {
        isLoading = true;
        LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"Loading ...");
        listTrainings.setAdapter(eventsAdapter);

        ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
        Call<List<TrainingItem>> call = gitHubService.GetTrainings(UtilsApp.getToken(getActivity()));
        call.enqueue(new Callback<List<TrainingItem>>() {
            @Override
            public void onResponse(Call<List<TrainingItem>> call, Response<List<TrainingItem>> response) {
                isLoading = false;
                if(response.body().size() == 0) {
                    LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"No content available");
                    listTrainings.setAdapter(eventsAdapter);
                }
                else {
                    TrainingsListAdapter eventsAdapter = new TrainingsListAdapter(diaryTrainingFragment, mContext, response.body());
                    listTrainings.setAdapter(eventsAdapter);
                    currentList = response.body();
                }
            }
            @Override
            public void onFailure(Call<List<TrainingItem>> call, Throwable t) {
                isLoading = false;
            }
        });
    }

    private class ShowAddTrainingListener implements View.OnClickListener {
        DiaryTrainingFragment mDiaryTrainingFragment;
        public ShowAddTrainingListener(DiaryTrainingFragment diaryTrainingFragment) {
            this.mDiaryTrainingFragment = diaryTrainingFragment;
        }

        @Override
        public void onClick(View v)
        {
            listTrainings.setVisibility(View.GONE);
            addTrainingLayout.setVisibility(View.VISIBLE);
            changeFiltersLayout.setVisibility(View.GONE);
        }
    }

    private class ShowChangeFiltersListener implements View.OnClickListener {
        DiaryTrainingFragment mDiaryTrainingFragment;
        public ShowChangeFiltersListener(DiaryTrainingFragment diaryTrainingFragment) {
            this.mDiaryTrainingFragment = diaryTrainingFragment;
        }

        @Override
        public void onClick(View v)
        {
            listTrainings.setVisibility(View.GONE);
            addTrainingLayout.setVisibility(View.GONE);
            changeFiltersLayout.setVisibility(View.VISIBLE);
        }
    }

    private class ShowListListener implements View.OnClickListener {
        DiaryTrainingFragment mDiaryTrainingFragment;
        public ShowListListener(DiaryTrainingFragment diaryTrainingFragment) {
            this.mDiaryTrainingFragment = diaryTrainingFragment;
        }

        @Override
        public void onClick(View v)
        {
            loadList();
            listTrainings.setVisibility(View.VISIBLE);
            addTrainingLayout.setVisibility(View.GONE);
            changeFiltersLayout.setVisibility(View.GONE);
        }
    }

    private class buttonFinalAddListener implements View.OnClickListener {
        DiaryTrainingFragment mDiaryTrainingFragment;
        public buttonFinalAddListener(DiaryTrainingFragment diaryTrainingFragment) {
            this.mDiaryTrainingFragment = diaryTrainingFragment;
        }

        @Override
        public void onClick(View v)
        {
            listTrainings.setVisibility(View.VISIBLE);
            addTrainingLayout.setVisibility(View.VISIBLE);


            isLoading = true;
            LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"Loading ..."); //TODO useless?
            listTrainings.setAdapter(eventsAdapter);

            ICallService gitHubService = ICallService.retrofit.create(ICallService.class);
            double distance = Double.parseDouble(option4.getText().toString().replaceAll(" ","."));
            Date date = new Date(2012,11,11);

            Call<String> call = gitHubService.AddTraining(UtilsApp.getToken(getActivity()),
                    date,
                    option3.getText().toString(),
                    distance,
                    option7.getText().toString(),
                    Integer.parseInt(option5.getText().toString()),
                    option6.getText().toString(),7);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    isLoading = false;

                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    isLoading = false;

                }
            });
        }
    }

    private class buttonSaveFilterListener implements View.OnClickListener {
        DiaryTrainingFragment mDiaryTrainingFragment;
        public buttonSaveFilterListener(DiaryTrainingFragment diaryTrainingFragment) {
            this.mDiaryTrainingFragment = diaryTrainingFragment;
        }

        @Override
        public void onClick(View v)
        {
            isLoading = true;
            LoadingAdapter eventsAdapter = new LoadingAdapter(getActivity().getBaseContext(),"Loading ...");
            listTrainings.setAdapter(eventsAdapter);

            ICallService gitHubService = ICallService.retrofit.create(ICallService.class);

            double fromDistance;
            double toDistance;
            int fromTemperature;
            int toTemperature ;
            String weatherConditions = null;

            try{
                fromDistance = Double.parseDouble(filter1.getText().toString());
            } catch (final NumberFormatException e) {
                fromDistance = 0;
            }

            try{
                toDistance = Double.parseDouble(filter2.getText().toString());
            } catch (final NumberFormatException e) {
                toDistance = 9999999;
            }

            try{
                fromTemperature = Integer.parseInt(filter3.getText().toString());
            } catch (final NumberFormatException e) {
                fromTemperature = -100;
            }

            try{
                toTemperature = Integer.parseInt(filter4.getText().toString());
            } catch (final NumberFormatException e) {
                toTemperature = 100;
            }

            if(!filter5.getText().toString().isEmpty())
                weatherConditions = filter5.getText().toString();

            Call<String> call = gitHubService.SaveFilter(UtilsApp.getToken(getActivity()),fromDistance,toDistance,fromTemperature,toTemperature,weatherConditions);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    isLoading = false;
                    loadList();
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    isLoading = false;
                    loadList();
                }
            });
        }
    }
}
