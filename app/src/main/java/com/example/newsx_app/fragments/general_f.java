package com.example.newsx_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newsx_app.R;
import com.example.newsx_app.customAdapter.customAdapter;
import com.example.newsx_app.model.mainNews;
import com.example.newsx_app.retrofit.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class general_f extends Fragment {
    private RecyclerView recyclerView;
    private customAdapter adapter;
    private ArrayList<com.example.newsx_app.model.model> model;
    private static String api_key = "107f5929b77e45408c1b4ed2888f6b2d";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_general_f, container, false);
        recyclerView = view.findViewById(R.id.general_recycler);
        model = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        adapter = new customAdapter(getContext(), model);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getnews();
        return view ;
    }
    private void getnews() {
        ApiUtilities.getapiInterface().getNews("us", "general", api_key)
                .enqueue(new Callback<mainNews>() {
                    @Override
                    public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                        if (response.isSuccessful()) {
                            model.addAll(response.body().getArticles());
                            adapter.notifyDataSetChanged();

                        } else {
                            Toast.makeText(getContext(), "not getting the data", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<mainNews> call, Throwable t) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_LONG).show();

                    }
                });
    }
}