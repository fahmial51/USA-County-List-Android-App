package com.example.newsapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.newsapp.Models.Country;
import com.example.newsapp.Models.CountryApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://datausa.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getCountryList(OnFetchDataListener listener, String category, String query)
    {
        CallCountryApi callCountryApi = retrofit.create(CallCountryApi.class);
        Call<CountryApiResponse> call = callCountryApi.callCountries("State","Population","latest");

        try{
            call.enqueue(new Callback<CountryApiResponse>() {
                @Override
                public void onResponse(Call<CountryApiResponse> call, Response<CountryApiResponse> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context,"Error!!",Toast.LENGTH_LONG);
                    }

//                    for ( Country singleRecord : response.body().getData())
//                    {
//                        Log.d("Records:Button--", singleRecord.toString().toString());
//                    }
                    System.out.println("response body: " + response.body().toString());
                    System.out.println("response body get data: " + response.body().getData().toArray()[0].toString());

                    listener.onFetchData(response.body().getData(), response.message());

                }

                @Override
                public void onFailure(Call<CountryApiResponse> call, Throwable t) {
                    listener.onError("Request Failed");

                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public RequestManager(Context context) { this.context = context;}

    public interface CallCountryApi {
        @GET("data")
        Call<CountryApiResponse> callCountries(
                @Query("drilldowns") String drilldowns,
                @Query("measures") String measures,
                @Query("year") String year
        );
    }
}
