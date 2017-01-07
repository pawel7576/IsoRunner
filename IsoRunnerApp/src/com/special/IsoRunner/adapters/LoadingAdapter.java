package com.special.IsoRunner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.special.IsoRunner.NotesFragment;
import com.special.IsoRunner.R;
import com.special.IsoRunner.models.Note;

import java.util.List;

/**
 * Created by pawel on 07/01/17.
 */

public class LoadingAdapter extends BaseAdapter {


    Context context;
    String mText;

    public LoadingAdapter( Context context, String text) {
        this.context = context;
        this.mText = text;
    }



    @Override
    public int getCount() {
        return 1;
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
        convertView = inflater.inflate(R.layout.loading_item_text_view, parent, false);

        TextView text = (TextView) convertView.findViewById(R.id.loading_text_view);
        text.setText(mText);

        return convertView;
    }

}
