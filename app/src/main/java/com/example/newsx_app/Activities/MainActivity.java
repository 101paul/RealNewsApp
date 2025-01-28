package com.example.newsx_app.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.newsx_app.R;
import com.example.newsx_app.fragments.HomeF;
import com.example.newsx_app.favaoriteF.favorite_f;
import com.example.newsx_app.fragments.search_f;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {


    private Button selectedButton; // Track the currently highlighted button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = findViewById(R.id.bottom_view) ;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout2,new HomeF()) ;
        ft.addToBackStack(null) ;
        ft.commit() ;

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               if(item.getItemId()==R.id.search){
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.framelayout2,new search_f()) ;
                   ft.commit() ;
                   return true ;
               }
               if(item.getItemId()==R.id.home){
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.framelayout2,new HomeF()) ;
                   ft.commit() ;
                   return true ;
               }
               if(item.getItemId()==R.id.favorite){
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.framelayout2,new favorite_f()) ;
                   ft.commit() ;
                   return true ;
               }
               return false;
           }
       });

    }
}
