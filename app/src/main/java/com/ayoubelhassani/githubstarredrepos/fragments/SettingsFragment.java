package com.ayoubelhassani.githubstarredrepos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ayoubelhassani.githubstarredrepos.R;

/**
 * Created by Ayoub on 10/25/2018.
 */

public class SettingsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /* with this fragment settings i juste want to inflate the fragment layout
        * like if the class should have R.layout.settings_fragment
        */
        return inflater.inflate(R.layout.fragment_settings, null);
    }
}
