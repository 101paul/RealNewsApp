package com.example.newsx_app.favaoriteF;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsx_app.R;

public class fViewHolder extends RecyclerView.ViewHolder {
    public TextView title , source ;
    public ImageView img , delete;
    public fViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title) ;
//        date = itemView.findViewById(R.id.date) ;
//        text  = itemView.findViewById(R.id.text);
        source = itemView.findViewById(R.id.source) ;
        img = itemView.findViewById(R.id.img) ;
        delete = itemView.findViewById(R.id.delete) ;
    }
}
