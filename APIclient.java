package com.example.anju.retrofit_flowers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anju on 22-05-2017.
 */

public class APIclient {
    public static final String BASE_URL="http://services.hanselandpetal.com/";

    public static Retrofit retrofit=null;
    public static Retrofit getAPIclient(){
        if (retrofit==null){
            // retrofit reference
             retrofit=new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
