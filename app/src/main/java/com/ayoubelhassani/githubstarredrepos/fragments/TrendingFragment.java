package com.ayoubelhassani.githubstarredrepos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ayoubelhassani.githubstarredrepos.R;
import com.ayoubelhassani.githubstarredrepos.adapter.ReposAdapter;
import com.ayoubelhassani.githubstarredrepos.model.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayoub on 10/25/2018.
 */

public class TrendingFragment extends Fragment {

    //a list to store all the repositories
    List<Repository> repositoryList;
    //the recyclerview
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*
        * Here i'm gonna use this fragenment to load the most starred repos
        */
        return inflater.inflate(R.layout.fragment_trending, null);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // /getting the recyclerview from xml
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //initializing the productlist
        repositoryList = new ArrayList<>();



        //LOCAL TEST
        localTest();
    }

    private void localTest() {
        //adding some items to the list

        repositoryList.add(new Repository("Repo1","ayoub","description 1", 4.3));
        repositoryList.add(new Repository("Repo2","toto","description 2", 2.3));
        repositoryList.add(new Repository("Repo3","titi","description 3", 3.5));
        repositoryList.add(new Repository("Repo4","elhassani","description 4", 1.9));
        repositoryList.add(new Repository("Repo5","mimi","description 5", 5.0));

        //creating recyclerview adapter
        ReposAdapter adapter = new ReposAdapter(this.getContext(), repositoryList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
