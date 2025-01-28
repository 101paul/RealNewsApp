package com.example.newsx_app.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsx_app.R;
import com.example.newsx_app.model.model;
import com.example.newsx_app.Activities.readNewsActivity;

import java.util.ArrayList;
import java.util.List;

public class customAdapter extends RecyclerView.Adapter<customViewHolder>{
    private Context context ;
    private ArrayList<model> model ;
    public customAdapter(Context context, ArrayList<model> model ) {
        this.context = context;
        this.model = model ;

    }

    @NonNull
    @Override
    public customViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new customViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull customViewHolder holder, int position) {

         holder.title.setText(model.get(position).getTitle()) ;
//         holder.text.setText(model.get(position).getDescription())  ;
         holder.source.setText(model.get(position).getSource().getName()) ;
         Glide.with(context).load(model.get(position).getUrlToImage()).into(holder.img) ;

        Intent i =  new Intent(context, readNewsActivity.class);
        i.putExtra("URL",model.get(position).getUrl());
        i.putExtra("title",model.get(position).getTitle()) ;
        i.putExtra("urltoImage",model.get(position).getUrlToImage()) ;
        i.putExtra("source",model.get(position).getSource().getName()) ;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(i) ;
            }
        });
    }
    @Override
    public int getItemCount() {
        return model.size() ;
    }
}
