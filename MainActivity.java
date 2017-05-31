package com.example.anju.retrofit_flowers;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.anju.retrofit_flowers.Adapter.FlowerAdapter;
import com.example.anju.retrofit_flowers.Model.Flower;
import com.example.anju.retrofit_flowers.Model.JSONResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MainActivity";
    private RecyclerView recyclerView;
    private FlowerAdapter adapter;
    private ArrayList<Flower> flowers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
     //   recyclerView.setAdapter(adapter);
        loadJSON();
    }

    private void loadJSON() {
        Log.d(TAG,"inside loadJson() ");

        //my endpoint of url
        final APIinterface apIinterface=APIclient.getAPIclient().create(APIinterface.class);

        Log.d(TAG,"interface() ");
        //call back
        Call<List<Flower>> call=apIinterface.getFlower();

       call.enqueue(new Callback<List<Flower>>() {
           @Override
           public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
               flowers= (ArrayList<Flower>) response.body();
               adapter=new FlowerAdapter(flowers);
               recyclerView.setAdapter(adapter);
           }

           @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
                Log.d("JASONERROR",t.getMessage());

            }
        });


    }
}
