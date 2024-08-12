package com.example.newsapp.Models;

import java.io.Serializable;
import java.util.List;

public class CountryApiResponse implements Serializable {
    List<Country> data;

    public List<Country> getData() {
        return data;
    }

    public void setData(List<Country> data) {
        this.data = data;
    }
}
