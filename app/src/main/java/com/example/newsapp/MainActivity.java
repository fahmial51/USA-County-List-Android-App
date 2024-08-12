package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.newsapp.Models.Country;
import com.example.newsapp.Models.CountryApiResponse;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    Button b1,b2,b3,b4,b5,b6,b7;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RequestManager manager = new RequestManager(this);
        manager.getCountryList(listener, "general",null);
    }

    private final OnFetchDataListener<CountryApiResponse> listener = new OnFetchDataListener<CountryApiResponse>() {
        @Override
        public void onFetchData(List<Country> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivity.this, "No data found!!!", Toast.LENGTH_SHORT).show();
            }
            else{
                Log.d("this is my array", "msg: "+message+" arr: " + list.get(1) + ",,, " + list.get(1).getState());
                System.out.println("arr: " + list);
//                System.out.println("deep arr: " + Arrays.deepToString(list));
                showCountry(list);
//                dialog.dismiss();
            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "An Error Occured!!!", Toast.LENGTH_SHORT).show();

        }
    };

    private void showCountry(List<Country> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this,list,this  );
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(Country country) {
        startActivity(new Intent(MainActivity.this,DetailsActivity.class)
                .putExtra("data", country));

    }

}