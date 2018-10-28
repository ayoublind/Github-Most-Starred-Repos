package com.ayoubelhassani.githubstarredrepos.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayoubelhassani.githubstarredrepos.R;
import com.ayoubelhassani.githubstarredrepos.model.Repository;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Ayoub on 10/25/2018.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private ArrayList<Repository> itemsData;
    private Context context;

    public ReposAdapter(ArrayList<Repository> itemsData, Context ctx) {
        this.itemsData = itemsData;
        this.context = ctx;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ReposAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repos_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from the itemsData at this position
        // - replace the contents of the view with that itemsData
        Repository r = itemsData.get(position);
        viewHolder.txtname.setText(r.getName());
        viewHolder.txtowner.setText(r.getOwner());
        viewHolder.txtdesc.setText(r.getDesc());
        viewHolder.numberstart.setText(""+r.getRaiting());

        // -- local test --
        //viewHolder.imgOwner.setImageResource(itemsData[position].getImageOwner());
        //viewHolder.imgOwner.setImageResource(R.drawable.ic_dashboard_black_24dp);

        // -- test using glide --
        Glide.with(context)
                .load(r.getImageOwner())
                .into(viewHolder.imgOwner);

    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtname, txtowner, txtdesc, numberstart;
        public ImageView imgOwner;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtname = (TextView) itemLayoutView.findViewById(R.id.txtname);
            txtowner = (TextView) itemLayoutView.findViewById(R.id.txtowner);
            txtdesc = (TextView) itemLayoutView.findViewById(R.id.txtdesc);
            numberstart = (TextView) itemLayoutView.findViewById(R.id.numberstarts);
            imgOwner = (ImageView) itemLayoutView.findViewById(R.id.ownerimage);
        }
    }


    // Return the size of your itemsData
    @Override
    public int getItemCount() {
        return itemsData.size();
    }
}
