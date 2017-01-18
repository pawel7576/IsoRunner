package com.special.IsoRunner;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import com.special.IsoRunner.adapters.EventsListViewAdapter;
import com.special.IsoRunner.adapters.MapTrainingsAdapter;

/**
 * Created by Paweł on 2016-10-08.
 */
public class MapFragment extends Fragment {

    private Button buttonStartTraining;
    private Button buttonLoadTrainings;

    private ScrollView mapScrollView;
    private ListView mapListView;

    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map_layout, container, false);

        buttonStartTraining = (Button) rootView.findViewById(R.id.map_start_trainings);
        buttonLoadTrainings = (Button) rootView.findViewById(R.id.map_load_trainings);

        buttonStartTraining.setOnClickListener(new MapFragment.startButtonListener(this));
        buttonLoadTrainings.setOnClickListener(new MapFragment.loadButtonListener(this));

        mapScrollView = (ScrollView) rootView.findViewById(R.id.mapScrollView);
        mapListView = (ListView) rootView.findViewById(R.id.mapListView);

        mapListView.setVisibility(View.GONE);

        mContext = getActivity().getBaseContext();

        return rootView;
    }

    private class startButtonListener implements View.OnClickListener {

        MapFragment mMapFragment;
        public startButtonListener(MapFragment mapFragment) {
            this.mMapFragment = mapFragment;
        }
        @Override
        public void onClick(View v)
        {
            mMapFragment.showAlertDialog();
            mapScrollView.setVisibility(View.VISIBLE);
            mapListView.setVisibility(View.GONE);
        }
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
        builder1.setMessage("GPS signal finding.....");
        builder1.setCancelable(true);

        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


    private class loadButtonListener implements View.OnClickListener {
        MapFragment mMapFragment;
        public loadButtonListener(MapFragment mapFragment) {
            this.mMapFragment = mapFragment;
        }
        @Override
        public void onClick(View v)
        {
            mapScrollView.setVisibility(View.GONE);
            mapListView.setVisibility(View.VISIBLE);
            MapTrainingsAdapter eventsAdapter = new MapTrainingsAdapter(getActivity().getBaseContext());
            mapListView.setAdapter(eventsAdapter);
        }
    }
}
