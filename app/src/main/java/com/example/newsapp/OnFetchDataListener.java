package com.example.newsapp;

import com.example.newsapp.Models.Country;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse>{
    void onFetchData(List<Country> list, String message);
    void onError(String message);
}
