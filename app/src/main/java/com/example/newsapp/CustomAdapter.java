package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.Country;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{
    private Context context;
    private List<Country> country;
    private SelectListener listener;

    public CustomAdapter(Context context, List<Country> data, SelectListener listener) {
        this.context = context;
        this.country = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_state.setText(country.get(position).getState());
        holder.text_population.setText(country.get(position).getPopulation());
//        if (country.get(position).getUrlToImage()!=null){
//            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
//
//        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnNewsClicked(country.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {

        return country.size();
    }
}