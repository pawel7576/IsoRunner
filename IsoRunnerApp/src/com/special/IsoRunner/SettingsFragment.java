package com.special.IsoRunner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.special.IsoRunner.adapters.BackgroundImagesAdapter;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午3:28
 * Mail: specialcyci@gmail.com
 */
public class SettingsFragment extends Fragment {

    private View parentView;

    private ListView listBackgroundImages ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        parentView = inflater.inflate(R.layout.settings, container, false);

        listBackgroundImages = (ListView) parentView.findViewById(R.id.listBackgroundImages);
        int selectedIndex = ((MenuActivity)getActivity()).settingsChoosenImage;
        BackgroundImagesAdapter backgroundImagesAdapter = new BackgroundImagesAdapter(this, getActivity().getBaseContext(), GlobalDataProvider.getBackgroundImagesList(), selectedIndex);
        listBackgroundImages.setAdapter(backgroundImagesAdapter);

        return parentView;
    }

    public void clickedBackgroudImage(String clickedBackgroundImagePosition) {
        int index = Integer.parseInt(clickedBackgroundImagePosition);
        ((MenuActivity)getActivity()).settingsChoosenImage = index;
        ((MenuActivity)getActivity()).setBackgroundImage(GlobalDataProvider.getBackgroundImagesList().get(index).mResource);
        BackgroundImagesAdapter backgroundImagesAdapter = new BackgroundImagesAdapter(this, getActivity().getBaseContext(), GlobalDataProvider.getBackgroundImagesList(), index);
        listBackgroundImages.setAdapter(backgroundImagesAdapter);
    }
}
