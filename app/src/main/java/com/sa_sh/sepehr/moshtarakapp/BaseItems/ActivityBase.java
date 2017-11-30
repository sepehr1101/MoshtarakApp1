package com.sa_sh.sepehr.moshtarakapp.BaseItems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sa_sh.sepehr.moshtarakapp.Models.ViewModels.UiElementInActivity;
import com.sa_sh.sepehr.moshtarakapp.R;


/**
 * Created by _1101 on 11/29/2017.
 */

public abstract class ActivityBase extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    //
  /*  int userCode;
    String token,deviceId;*/
    private UiElementInActivity uiElementInActivity;

    protected abstract UiElementInActivity getUiElementsInActivity();
    protected abstract void initialize();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);//right to left
        super.onCreate(savedInstanceState);
        uiElementInActivity=getUiElementsInActivity();
        //setTheme();
        setContentView(uiElementInActivity.getContentViewId());
        initializeBase();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.RIGHT);
            }
        });
        initialize();
    }
    //
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    //
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        /*if (id == R.id.nav_load) {
            Intent intentLoad=new Intent(this,LoadActivity.class);
            startActivity(intentLoad);
        }
        else if (id == R.id.nav_my_works) {
            Intent intentDisplayViewpager=new Intent(this,DisplayViewPager.class);
            startActivity(intentDisplayViewpager);
        }
        else if (id == R.id.nav_off_load) {
            Intent offLoad = new Intent(this,OffLoadActivity.class);
            startActivity(offLoad);
        }
        else if (id == R.id.nav_reports) {
            Intent intentMyWorksReport = new Intent(this,MyWorksReportActivity.class);
            startActivity(intentMyWorksReport);
        }
        else if (id == R.id.nav_reading_config) {
            Intent intentUrgent = new Intent(this,ReadingConfigActivity.class);
            startActivity(intentUrgent);
        }
        else if (id == R.id.nav_location) {
            Intent intentGis = new Intent(this,GISActivity.class);
            startActivity(intentGis);
        }
        else if (id == R.id.preferred_setting) {
            Intent intentSetting=new Intent(this,AppSettingActivity.class);
            startActivity(intentSetting);
        }
        else if(id==R.id.close_app){
            this.finishAffinity();
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //
    private void initializeBase(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }
    //
   /* private void setTheme(){
        int themeIndex= sharedPreferenceManager.getInt("theme");
        switch (themeIndex) {
            case 0:
                getTheme().applyStyle(R.style.AppTheme_GreenBlue_NoActionBar, true);
                break;
            case 1:
                getTheme().applyStyle(R.style.AppTheme_DarkGrey_NoActionBar, true);
                break;
            case 2:
                getTheme().applyStyle(R.style.AppTheme_Indigo_NoActionBar, true);
                break;
            case 3:
                getTheme().applyStyle(R.style.AppTheme_Monochrome1_NoActionBar, true);
                break;
            default:
                getTheme().applyStyle(R.style.AppTheme_GreenBlue_NoActionBar, true);
                break;
        }
    }*/
    //
    /*public int getUserCode(){
        userCode = sharedPreferenceManager.getInt("userCode");
        return userCode;
    }
    //
    public String getToken(){
        token = sharedPreferenceManager.getString("token");
        return token;
    }*/

}
