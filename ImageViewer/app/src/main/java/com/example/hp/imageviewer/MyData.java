package com.example.hp.imageviewer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 5/25/2017.
 */

public class MyData {
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("flag")
    @Expose
    private String flag;

    public String getRank() {
        return rank;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }

    public String getFlag()
    {
        return flag;
    }
}
