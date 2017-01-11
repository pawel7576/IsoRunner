package com.special.IsoRunner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.special.IsoRunner.ResideMenuItem.ResideMenuItemExtended;
import com.special.IsoRunner.ResideMenuItem.ResideMenuItemsProvider;

public class MenuActivity extends FragmentActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private MenuActivity mContext;

    public int settingsChoosenImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mContext = this;
        setUpMenu();
        if( savedInstanceState == null )
            changeFragment(new HomeFragment());
    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
//        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.drawable.background_main_menu);
        settingsChoosenImage = 0;
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        resideMenu.setScaleValue(0.6f);         //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.

        // create menu items;

        ResideMenuItemExtended[] leftItems = ResideMenuItemsProvider.getLeftItems(this);
        ResideMenuItemExtended[] rightItems = ResideMenuItemsProvider.getRightItems(this);

        addToMenu(leftItems,  ResideMenu.DIRECTION_LEFT);
        addToMenu(rightItems,  ResideMenu.DIRECTION_RIGHT);

        // TODO ? disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    public void setBackgroundImage(int imageResrouce) {
        resideMenu.setBackground(imageResrouce);
    }

    private void addToMenu(ResideMenuItemExtended[] leftItems, int directionLeft) {
        for (ResideMenuItem menuItem : leftItems) {
            menuItem.setOnClickListener(this);
            resideMenu.addMenuItem(menuItem,directionLeft);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {
        if(((ResideMenuItemExtended)view).id.equals(ResideMenuItemsProvider.mLogOut)) {
            finish();
        }
        else {
            changeFragment(ResideMenuItemsProvider.getFragmentInstance(((ResideMenuItemExtended)view).id));
            resideMenu.closeMenu();
        }

    }

    //testing
    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
//            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
//            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}
