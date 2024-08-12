package com.example.newsapp.Models;

import java.io.Serializable;

public class Country implements Serializable {
    String State = "";
    String Year = "";
    String Population = "";

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }
}
