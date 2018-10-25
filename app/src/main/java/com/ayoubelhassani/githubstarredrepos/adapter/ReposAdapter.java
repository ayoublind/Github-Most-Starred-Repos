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

import java.util.List;

/**
 * Created by Ayoub on 10/25/2018.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {

    //this context will use to inflate the layout
    private Context mCtx;

    //i'm gonna store all the repos in a list
    private List<Repository> repositoryList;

    //getting the context and repository list with constructor
    public ReposAdapter(Context mCtx, List<Repository> repositoryList) {
        this.mCtx = mCtx;
        this.repositoryList = repositoryList;
    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.repos_item, null);

        //retourning the view holder for this item repos
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {
        //getting the repository of the specified position
        Repository r = repositoryList.get(position);

        //binding the data with the viewholder views
        holder.txtname.setText(r.getName());
        holder.txtdesc.setText(r.getDesc());
        holder.txtowner.setText(r.getOwner());
        holder.numberstarts.setText(String.valueOf(r.getRaiting()));

        //holder.ownerimage.setImageDrawable(mCtx.getResources().getDrawable(r.getImageOwner()));

    }


    @Override
    public int getItemCount() {
        return repositoryList.size();
    }


    class ReposViewHolder extends RecyclerView.ViewHolder {

        TextView txtname, txtdesc, txtowner, numberstarts;
        ImageView ownerimage, startsimage;

        public ReposViewHolder(View itemView) {
            super(itemView);
            //getting the item var from the view
            txtname = itemView.findViewById(R.id.txtname);
            txtdesc = itemView.findViewById(R.id.txtdesc);
            txtowner = itemView.findViewById(R.id.txtowner);
            numberstarts = itemView.findViewById(R.id.numberstarts);
            ownerimage = itemView.findViewById(R.id.ownerimage);

            //will not used but ..
            startsimage = itemView.findViewById(R.id.startsimage);
        }
    }
}
