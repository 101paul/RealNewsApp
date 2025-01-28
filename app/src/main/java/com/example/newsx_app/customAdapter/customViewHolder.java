package com.example.newsx_app.customAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsx_app.R;

public class customViewHolder extends RecyclerView.ViewHolder{
    public TextView title , source ;
    public ImageView img ;
    public customViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title) ;
//        date = itemView.findViewById(R.id.date) ;
//        text  = itemView.findViewById(R.id.text);
        source = itemView.findViewById(R.id.source) ;
        img = itemView.findViewById(R.id.img) ;
    }
}
