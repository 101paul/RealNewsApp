package com.example.newsx_app.favaoriteF;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsx_app.R;

import java.util.List;


public class favorite_f extends Fragment {

    private RecyclerView recyclerView ;
    private fAdapter adapter ;
    private roomDB db ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = roomDB.getInstance(getContext());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite_f,null);
        recyclerView = view.findViewById(R.id.favorite_recycle) ;
        recyclerView = view.findViewById(R.id.favorite_recycle);
        recyclerView.setHasFixedSize(true) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DAO D = db.favoriteArticleDao() ;
        // Fetch favorites from the database
        new Thread(() -> {
            List<ARTICLE> favoriteArticles = db.favoriteArticleDao().getAllArticles();
            getActivity().runOnUiThread(() -> {
                adapter = new fAdapter(getContext(),favoriteArticles,D);
                recyclerView.setAdapter(adapter);
            });
        }).start();

        return view ;
    }
}