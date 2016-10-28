package com.special.IsoRunner.ResideMenuItem;

import android.content.Context;

import com.special.ResideMenu.ResideMenuItem;

/**
 * Created by Paweł on 2016-10-01.
 */
public class ResideMenuItemExtended extends ResideMenuItem{

    public String id;

    public ResideMenuItemExtended(Context context) {
        super(context);
    }

    public ResideMenuItemExtended(Context context, int icon, String title) {
        super(context,icon,title);
        id = title;
    }
}
