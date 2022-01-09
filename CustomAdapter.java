package com.example.profile_api_call;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private JSONObject localDataSet;
    private ViewGroup parent;
    private int viewType;
    private ViewGroup viewGroup;

    LayoutInflater inflater;
    List<Profiles> profilesList;

    public CustomAdapter (Context ctx, List<Profiles> profilesList){
        this.inflater = LayoutInflater.from(ctx);
        this.profilesList = profilesList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = inflater.inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(profilesList.get(position).getName());
        holder.txtv2.setText(profilesList.get(position).getId());
        Picasso.get().load(profilesList.get(position).getImges()).into(holder.imgV);
    }
    @Override
    public int getItemCount() {

        return profilesList.size();
    }
    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imgV;
        private TextView txtv2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);
            imgV = (ImageView) itemView.findViewById(R.id.imageView);
            txtv2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }


}
