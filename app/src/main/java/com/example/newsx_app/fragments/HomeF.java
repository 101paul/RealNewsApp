package com.example.newsx_app.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.newsx_app.R;
import com.example.newsx_app.customAdapter.customAdapter;
import com.example.newsx_app.model.mainNews;
import com.example.newsx_app.retrofit.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeF extends Fragment {
    Button sportsB , scienceB , businessB , technologyB, entertainmentB , healthB  ;
    LinearLayout buttonContainer ;
    private RecyclerView recyclerView ;
    private customAdapter adapter  ;
    private ArrayList<com.example.newsx_app.model.model> model ;
    private String api_key = "107f5929b77e45408c1b4ed2888f6b2d" ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null) ;
        sportsB = view.findViewById(R.id.sports) ;
        scienceB = view.findViewById(R.id.science) ;
        businessB = view.findViewById(R.id.business) ;
        technologyB = view.findViewById(R.id.technology) ;
        entertainmentB = view.findViewById(R.id.entertainment) ;
        healthB = view.findViewById(R.id.health) ;
        buttonContainer = view.findViewById(R.id.horizontal_layout);
//        recyclerView = view.findViewById(R.id.recyclerMain) ;
//        model = new ArrayList<>() ;
//        recyclerView.setHasFixedSize(true);
//        adapter = new customAdapter(getContext(),model) ;
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())) ;
//        getNews();
        getParentFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,new general_f())
                .addToBackStack(null)
                .commit() ;
        for(int i = 0; i < buttonContainer.getChildCount(); i++) {
            View viewx = buttonContainer.getChildAt(i);
            if (viewx instanceof Button) {
                Button button = (Button) viewx;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        highlightButton(buttonContainer, button);
                        if(button == view.findViewById(R.id.general)){
                                getParentFragmentManager().beginTransaction()
                                        .replace(R.id.frameLayout,new general_f())
                                        .addToBackStack(null)
                                        .commit() ;
                        }
                        else if(button == view.findViewById(R.id.sports)){
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.frameLayout,new sports_f())
                                    .addToBackStack(null)
                                    .commit() ;
                        }else if(button == view.findViewById(R.id.science)){
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.frameLayout,new science_f())
                                    .addToBackStack(null)
                                    .commit() ;
                        }else if(button == view.findViewById(R.id.technology)){
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.frameLayout,new technology_f())
                                    .addToBackStack(null)
                                    .commit() ;
                        }else if(button == view.findViewById(R.id.business)){
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.frameLayout,new business_f())
                                    .addToBackStack(null)
                                    .commit() ;
                        }else if(button == view.findViewById(R.id.entertainment)){
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.frameLayout,new entertainment_f())
                                    .addToBackStack(null)
                                    .commit() ;
                        }else if(button == view.findViewById(R.id.health)){
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.frameLayout,new health_f())
                                    .addToBackStack(null)
                                    .commit() ;
                        }
                    }
                });
            }
        }
        return view ;
    }

    private void highlightButton(LinearLayout container, Button selectedButton) {
        for (int i = 0; i < container.getChildCount(); i++) {
           View viewx = container.getChildAt(i);
           if (viewx instanceof Button) {
               Button button = (Button) viewx;
               if (button == selectedButton) {
                   button.setBackgroundColor(Color.parseColor("#800080")); // Highlight color
               } else {
                   button.setBackgroundColor(Color.parseColor("#607D8B")); // Default color
               }
           }
       }
    }
    private void getNews(){
        ApiUtilities.getapiInterface().getNews("us","general",api_key)
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