package com.special.IsoRunner.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.special.IsoRunner.R;
import com.special.IsoRunner.SettingsFragment;
import com.special.IsoRunner.models.BackgroundImageInfo;

import java.util.List;

/**
 * Created by pawel on 28/12/16.
 */

public class BackgroundImagesAdapter extends BaseAdapter {


    List<BackgroundImageInfo> bacgroundImages;
    Context context;
    SettingsFragment mSettingsFragment;
    int mSelectedIndex;

    public BackgroundImagesAdapter(SettingsFragment settingsFragment, Context context, List<BackgroundImageInfo> backImages, int selectedIndex) {
        this.bacgroundImages = backImages;
        this.context = context;
        this.mSettingsFragment = settingsFragment;
        this.mSelectedIndex = selectedIndex;
    }



    @Override
    public int getCount() {
        return bacgroundImages.size();
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
        convertView = inflater.inflate(R.layout.background_image_item, parent, false);
        if(position == mSelectedIndex) convertView.setBackgroundColor(Color.rgb(191,253,253));
        else convertView.setBackgroundColor(Color.WHITE);

        TextView text = (TextView) convertView.findViewById(R.id.backgroundImageName);
        text.setText(bacgroundImages.get(position).mName);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageBackgroundItem);
        imageView.setBackgroundResource(bacgroundImages.get(position).mResource);

        convertView.setTag(Integer.toString(position));
        convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String clickedBackgroundImagePosition = (String) v.getTag();
                mSettingsFragment.clickedBackgroudImage(clickedBackgroundImagePosition);
            }
        });

        return convertView;
    }

}
