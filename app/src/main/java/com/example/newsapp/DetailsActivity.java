package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.Models.Country;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    Country data;
    TextView txt_state,txt_year,txt_population;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txt_state = findViewById(R.id.text_detail_state);
        txt_year = findViewById(R.id.text_detail_year);
        txt_population = findViewById(R.id.text_detail_population);
        img_news = findViewById(R.id.img_detail_news);

        data = (Country) getIntent().getSerializableExtra("data");

        txt_state.setText(data.getState());
        txt_population.setText(data.getPopulation());
        txt_year.setText(data.getYear());

        String imageUri = "@drawable/"+data.getState().toLowerCase();

        int checkExistence = getResources().getIdentifier(imageUri, null, getPackageName());

        if ( checkExistence != 0 ) {  // the resource exists...
            Drawable logoDrawable = getResources().getDrawable(checkExistence);
            img_news.setImageDrawable(logoDrawable);
        }

    }
}