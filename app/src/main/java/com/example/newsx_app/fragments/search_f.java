package com.example.newsx_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.newsx_app.R;
import com.example.newsx_app.customAdapter.customAdapter;
import com.example.newsx_app.model.mainNews;
import com.example.newsx_app.retrofit.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search_f extends Fragment {
    private RecyclerView recyclerView;
    private customAdapter adapter;
    private ArrayList<com.example.newsx_app.model.model> model;
    private String lastQuery = "";
    private static String api_key = "107f5929b77e45408c1b4ed2888f6b2d";
    SearchView searchV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_f2, null);
        searchV = view.findViewById(R.id.searchView);
        searchV.setSubmitButtonEnabled(true);
        searchV.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!TextUtils.isEmpty(query)) {
                    getnews(query);
                    searchV.clearFocus();
                } else {
                    Toast.makeText(getContext(), "Please enter search item", Toast.LENGTH_LONG).show();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        recyclerView = view.findViewById(R.id.search_recycler);
        model = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        adapter = new customAdapter(getContext(), model);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getnews("general") ;
        return view;
    }

    private void getnews(String query) {
        ApiUtilities.getapiInterface().searchForNews(query, api_key)
                .enqueue(new Callback<mainNews>() {
                    @Override
                    public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            // clear the previous data
                            model.clear() ;
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