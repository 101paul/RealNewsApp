package com.example.newsx_app.favaoriteF;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsx_app.Activities.readNewsActivity;
import com.example.newsx_app.R;
import com.example.newsx_app.customAdapter.customViewHolder;
import com.example.newsx_app.model.model;

import java.util.ArrayList;
import java.util.List;

public class fAdapter extends RecyclerView.Adapter<fViewHolder> {
    private Context context ;
    private List<ARTICLE> model ;
    private DAO favoriteArticleDao;

    public fAdapter(Context context, List<ARTICLE> model,DAO favoriteArticleDao) {
        this.context = context;
        this.model = model;
        this.favoriteArticleDao = favoriteArticleDao ;
    }

    @NonNull
    @Override
    public fViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new fViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.design2,parent,false)) ;

    }

    @Override
    public void onBindViewHolder(@NonNull fViewHolder holder, int position) {
        ARTICLE article = model.get(position) ;
        holder.title.setText(model.get(position).getTitle()) ;
//         holder.text.setText(model.get(position).getDescription())  ;
        holder.source.setText(model.get(position).getSource()) ;
        Glide.with(context).load(model.get(position).getImageUrl()).into(holder.img) ;
        Intent i =  new Intent(context, readNewsActivity2.class);
        i.putExtra("URL",model.get(position).getUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(i) ;
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(() -> {
                    favoriteArticleDao.deleteByUrl(article.getUrl()); // Assuming URL is unique
                }).start();

                // Remove the article from the list
                model.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, model.size());

                Toast.makeText(context, "Article removed from favorites", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return model.size() ;
    }
}
