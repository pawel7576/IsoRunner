package com.special.IsoRunner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.special.IsoRunner.DiaryTrainingFragment;
import com.special.IsoRunner.R;
import com.special.IsoRunner.models.TrainingItem;

import java.util.List;

/**
 * Created by pawel on 18/01/17.
 */

public class TrainingsListAdapter extends BaseAdapter {

    DiaryTrainingFragment mDiaryTrainingList;
    List<TrainingItem> trainingItems;
    Context context;

    public TrainingsListAdapter(DiaryTrainingFragment diaryTrainingFragment, Context context, List<TrainingItem> trainingElements) {
        this.trainingItems = trainingElements;
        this.context = context;
        this.mDiaryTrainingList = diaryTrainingFragment;
    }



    @Override
    public int getCount() {
        return trainingItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.training_item, parent, false);

        TextView textTemperature = (TextView) convertView.findViewById(R.id.training_temperature);
        textTemperature.setText(trainingItems.get(position).temperature + "°C");

        TextView textDistance = (TextView) convertView.findViewById(R.id.training_distance);
        textDistance.setText(trainingItems.get(position).distance + " km");

        TextView textTrainingDate = (TextView) convertView.findViewById(R.id.training_date);
        textTrainingDate.setText(trainingItems.get(position).date);

        TextView textTrainingTime = (TextView) convertView.findViewById(R.id.training_time);
        String trainingTime = trainingItems.get(position).duration;
        String[] separated = trainingTime.split(":");
        textTrainingTime.setText(separated[0] + "h " + separated[1] + "m " + separated[2] + "s");

        TextView textDescription = (TextView) convertView.findViewById(R.id.training_description);
        textDescription.setText(trainingItems.get(position).description);

        ImageView weatherImage = (ImageView) convertView.findViewById(R.id.training_weather_image);
        String weatherConditions = trainingItems.get(position).weatherConditions;
        if(weatherConditions.equals("1"))weatherImage.setImageResource(R.drawable.weather1);
        if(weatherConditions.equals("2"))weatherImage.setImageResource(R.drawable.weather2);
        if(weatherConditions.equals("3"))weatherImage.setImageResource(R.drawable.weather3);
        if(weatherConditions.equals("4"))weatherImage.setImageResource(R.drawable.weather4);

        return convertView;
    }
}
