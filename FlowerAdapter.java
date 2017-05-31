package com.example.anju.retrofit_flowers.Adapter;

import android.content.Context;
import android.support.test.espresso.core.deps.guava.base.Splitter;
import android.support.test.espresso.core.deps.guava.collect.Lists;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anju.retrofit_flowers.Model.Flower;
import com.example.anju.retrofit_flowers.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anju on 04-05-2017.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.MyVH> {
    private List<Flower> flowers;
    private Context context;
    public FlowerAdapter(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public FlowerAdapter() {

    }

    @Override
    public FlowerAdapter.MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem,parent,false);
        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(FlowerAdapter.MyVH holder, int position) {
        final String PHOTO_URL="http://services.hanselandpetal.com/photos/";
        holder.cateogory.setText("Category :"+flowers.get(position).getCategory());
        holder.price.setText("Price :"+flowers.get(position).getPrice()+"");
        holder.name.setText("Name :"+flowers.get(position).getName());
       holder.pdtid.setText("id :"+flowers.get(position).getProductId()+"");
      //  String img=flowers.get(position).getPhoto();
     //  Glide.with(context).load(PHOTO_URL).into(holder.iv);
        String URL="";

        if (flowers.get(position).getPhoto()!=null){
            String images=flowers.get(position).getPhoto();
            List<String> list = Lists.newArrayList(Splitter.on(",").splitToList(images));

            String img=list.get(0);
            URL=PHOTO_URL+img;
            // loading album cover using Glide library
            Glide.with(context).load(URL).into(holder.iv);

        }


    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView cateogory,price,name,pdtid;
        public MyVH(View itemView) {
            super(itemView);
            cateogory=(TextView)itemView.findViewById(R.id.category);
            name=(TextView)itemView.findViewById(R.id.name);
            pdtid=(TextView)itemView.findViewById(R.id.pdtid);
            price=(TextView)itemView.findViewById(R.id.price);
            iv=(ImageView)itemView.findViewById(R.id.photo);
        }
    }
}
