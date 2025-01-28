package com.example.newsx_app.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    public static Retrofit retrofit = null ;
    public static ApiInterface getapiInterface(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build() ;
        }
        return retrofit.create(ApiInterface.class) ;
    }
}
