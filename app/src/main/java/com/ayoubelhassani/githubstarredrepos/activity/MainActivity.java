package com.ayoubelhassani.githubstarredrepos.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.ayoubelhassani.githubstarredrepos.R;
import com.ayoubelhassani.githubstarredrepos.fragments.SettingsFragment;
import com.ayoubelhassani.githubstarredrepos.fragments.TrendingFragment;
import com.ayoubelhassani.githubstarredrepos.model.Repository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment wich will be the TrendingFragment
        loadFragment(new TrendingFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    //this method is created to load fragment and that's gonna called anytime to make it easy
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    //when one of the bottom item selected action
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        //In this method we will switch the fragments.
        switch (menuItem.getItemId()) {
            case R.id.navigation_trending:
                fragment = new TrendingFragment();
                break;
            case R.id.navigation_settings:
                fragment = new SettingsFragment();
                break;
        }
        //and load it on the main fragment
        return loadFragment(fragment);
    }
}
