package com.special.IsoRunner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.special.IsoRunner.R;
import com.special.IsoRunner.models.Event;

import java.util.List;

/**
 * Created by pawel on 18/01/17.
 */

public class MapTrainingsAdapter extends BaseAdapter {

    Context context;

    public MapTrainingsAdapter(Context baseContext) {
        this.context = baseContext;
    }

    @Override
    public int getCount() {
        return 2;
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
        if(position == 1) convertView = inflater.inflate(R.layout.map_training_item2, parent, false);
        else convertView = inflater.inflate(R.layout.map_training_item, parent, false);

//        TextView date = (TextView) convertView.findViewById(R.id.map_item_date);
//        TextView distance = (TextView) convertView.findViewById(R.id.map_item_distance);
//        ImageView imageItem = (ImageView) convertView.findViewById(R.id.map_item_image);
//
//        if(position == 1) {
//            date.setText("10.01.2017");
//            distance.setText("Distance: 3 km");
//            imageItem.setImageResource(R.drawable.trasa2);
//        }

        return convertView;
    }
}
