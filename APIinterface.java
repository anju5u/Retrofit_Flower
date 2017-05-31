package com.example.anju.retrofit_flowers;

import com.example.anju.retrofit_flowers.Model.Flower;
import com.example.anju.retrofit_flowers.Model.JSONResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Anju on 04-05-2017.
 */

public interface APIinterface {
    @GET("/feeds/flowers.json")
    Call<List<Flower>>getFlower();
    @GET("/photos")
    Call<List<Flower>>getImage();
}
