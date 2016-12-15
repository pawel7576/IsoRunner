package com.special.IsoRunner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.special.IsoRunner.R;
import com.special.IsoRunner.models.Event;

import java.util.List;

/**
 * Created by pawel on 10/12/16.
 */

public class EventsListViewAdapter extends BaseAdapter {

    List<Event> events;
    Context context;

    public EventsListViewAdapter(Context baseContext, List<Event> events) {
        this.events = events;
        this.context = baseContext;
    }

    @Override
    public int getCount() {
        return events.size();
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
        convertView = inflater.inflate(R.layout.event_item, parent, false);

        TextView date = (TextView) convertView.findViewById(R.id.event_date);
        TextView place = (TextView) convertView.findViewById(R.id.event_place);
        TextView information = (TextView) convertView.findViewById(R.id.information_event);

        date.setText(events.get(position).date);
        place.setText(events.get(position).place);
        information.setText(events.get(position).information);

        return convertView;
    }
}
