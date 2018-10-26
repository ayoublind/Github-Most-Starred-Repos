package com.ayoubelhassani.githubstarredrepos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ayoubelhassani.githubstarredrepos.R;
import com.ayoubelhassani.githubstarredrepos.adapter.ReposAdapter;
import com.ayoubelhassani.githubstarredrepos.model.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ayoub on 10/25/2018.
 */

public class TrendingFragment extends Fragment {

    //a list to store all the repositories
    ArrayList<Repository> repositoryList;
    //the recyclerview
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*
        * Here i'm gonna use this fragenment to load the most starred repos
        */
        View rootView =  inflater.inflate(R.layout.fragment_trending, container, false);

        //init args
        recyclerView = rootView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        repositoryList = new ArrayList<>();

        // this is data fro recycler view -- local test(static)
        repositoryList.add(new Repository("name 1","owner 1","desc ",2.4));
        repositoryList.add(new Repository("name 2","owner 2","desc ",4.4));
        repositoryList.add(new Repository("name 3","owner 3","desc ",5.0));
        repositoryList.add(new Repository("name 4","owner 4","desc ",3.4));
        repositoryList.add(new Repository("name 5","owner 5","desc ",1.3));
        repositoryList.add(new Repository("name 6","owner 6","desc ",2.9));



        //create an adapter
        ReposAdapter mAdapter = new ReposAdapter(repositoryList, getContext());
        //set adapter to the recyclerview
        recyclerView.setAdapter(mAdapter);
        // item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

}
