package com.example.anju.retrofit_flowers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Anju on 31-05-2017.
 */

public class ShowFlower extends AppCompatActivity {
    private ImageView iv;
    String flwr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showflower);
        iv=(ImageView)findViewById(R.id.imgv);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        flwr=b.getString("url");
        Glide.with(getApplicationContext()).load(flwr).into(iv);
    }
}
