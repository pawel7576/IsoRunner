package com.special.IsoRunner.ResideMenuItem;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.special.IsoRunner.NotesFragment;
import com.special.IsoRunner.DiaryTrainingFragment;
import com.special.IsoRunner.HomeFragment;
import com.special.IsoRunner.ChatFragment;
import com.special.IsoRunner.MapFragment;
import com.special.IsoRunner.R;
import com.special.IsoRunner.SettingsFragment;
import com.special.IsoRunner.TrainingAnalyzerFragment;

/**
 * Created by Paweł on 2016-10-01.
 */
public class ResideMenuItemsProvider {

    public static String mHome = "Home";
    public static String mDiaryTraining = "Diary training";
    public static String mTrainingAnalyzer = "Analyzer";
    public static String mMap = "Map";
    public static String mChat = "Chat";
    public static String mNotes = "Notes";
    public static String mSettings = "Settings";
    public static String mLogOut = "Log out";

    public static ResideMenuItemExtended[] getLeftItems(Context context) {
        return new ResideMenuItemExtended[] {
            new ResideMenuItemExtended(context, R.drawable.icon_home,    mHome),
                new ResideMenuItemExtended(context, R.drawable.icon_diary_training,  mDiaryTraining),
                new ResideMenuItemExtended(context, R.drawable.icon_training_analyzer, mTrainingAnalyzer),
                new ResideMenuItemExtended(context, R.drawable.icon_map,  mMap),
            new ResideMenuItemExtended(context, R.drawable.icon_profile, mChat)
        };
    }
    public static ResideMenuItemExtended[] getRightItems(Context context) {
        return new ResideMenuItemExtended[] {
            new ResideMenuItemExtended(context, R.drawable.icon_calendar, mNotes),
            new ResideMenuItemExtended(context, R.drawable.icon_settings, mSettings),
                new ResideMenuItemExtended(context, R.drawable.filter, mLogOut)
        };
    }


    public static Fragment getFragmentInstance(String identifier) {
        if (identifier.equals(mHome)){
            return(new HomeFragment());
        }else if (identifier.equals(mDiaryTraining)){
            return(new DiaryTrainingFragment());
        }else if (identifier.equals(mTrainingAnalyzer)){
            return(new TrainingAnalyzerFragment());
        }else if (identifier.equals(mMap)){
            return(new MapFragment());
        }else if (identifier.equals(mChat)){
            return(new ChatFragment());
        }else if (identifier.equals(mNotes)){
            return(new NotesFragment());
        }else if (identifier.equals(mSettings)){
            return(new SettingsFragment());
        }
        return null;
    }
}
