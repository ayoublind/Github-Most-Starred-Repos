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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ayoubelhassani.githubstarredrepos.R;
import com.ayoubelhassani.githubstarredrepos.adapter.ReposAdapter;
import com.ayoubelhassani.githubstarredrepos.model.Repository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ayoub on 10/25/2018.
 */

public class TrendingFragment extends Fragment {

    //a list to store all the repositories
    ArrayList<Repository> repositoryList;
    //the recyclerview
    RecyclerView recyclerView;
    ReposAdapter adapter;

    //the URL having the json data for repositories static but we can specified some args into the settings part
    private static final String JSON_URL = "https://api.github.com/search/repositories?q=tetris+language:assembly&sort=stars&order=desc+json";


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

        /*/ this is data fro recycler view -- local test(static)
        repositoryList.add(new Repository("name 1","owner 1","desc ",2.4));
        repositoryList.add(new Repository("name 2","owner 2","desc ",4.4));
        repositoryList.add(new Repository("name 3","owner 3","desc ",5.0));
        repositoryList.add(new Repository("name 4","owner 4","desc ",3.4));
        repositoryList.add(new Repository("name 5","owner 5","desc ",1.3));
        repositoryList.add(new Repository("name 6","owner 6","desc ",2.9));*/

        adapter = new ReposAdapter(repositoryList, getContext());
        //set adapter to the recyclerview
        recyclerView.setAdapter(adapter);
        // item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //data from github
        //getting the progressbar
        final ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);


        //creating a string request to send request to the url
        JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray items = (JSONArray) response.get("items");
                            //now looping through all the elements of the json array
                            for (int i = 0; i < items.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject repoObject = items.getJSONObject(i);

                                //creating a repo object and giving them the values from json object
                                Repository repos = new Repository();

                                repos.setName(repoObject.getString("name"));
                                repos.setDesc(repoObject.getString("description"));
                                repos.setRaiting(repoObject.getDouble("score"));

                                //owner information - json object
                                JSONObject owner = repoObject.getJSONObject("owner");

                                repos.setImageOwner(owner.getString("avatar_url"));
                                repos.setOwner(owner.getString("login"));

                                //adding the repos to list of repositories
                                repositoryList.add(repos);
                            }

                            //creating custom adapter object
                            adapter = new ReposAdapter(repositoryList, getContext());

                            //adding the adapter to listview
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                        //hiding the progressbar after completion
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        System.out.print(error);
                        //hiding the progressbar if there is an error
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        //adding the jsonArray request to request queue
        requestQueue.add(jsonObjectRequest);


        //return the view used
        return rootView;
    }




}
