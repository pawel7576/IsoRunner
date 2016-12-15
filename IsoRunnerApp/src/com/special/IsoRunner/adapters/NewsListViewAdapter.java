package com.special.IsoRunner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.special.IsoRunner.R;
import com.special.IsoRunner.models.News;

import java.util.List;

/**
 * Created by pawel on 19/11/16.
 */

public class NewsListViewAdapter extends BaseAdapter {

    List<News> news;
    Context context;
    public NewsListViewAdapter(Context context, List<News> news) {
        this.news = news;
        this.context = context;
    }



    @Override
    public int getCount() {
        return news.size();
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
        convertView = inflater.inflate(R.layout.news_item, parent, false);

        TextView date = (TextView) convertView.findViewById(R.id.event_date);
        TextView title = (TextView) convertView.findViewById(R.id.event_place);
        TextView text = (TextView) convertView.findViewById(R.id.information_event);

        date.setText(news.get(position).date);
        title.setText(news.get(position).title);
        text.setText(news.get(position).text);

        return convertView;
    }
}
