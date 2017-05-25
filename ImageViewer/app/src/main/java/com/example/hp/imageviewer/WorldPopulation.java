package com.example.hp.imageviewer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by HP on 5/25/2017.
 */

public class WorldPopulation {
    @SerializedName("worldpopulation")
    @Expose
    private ArrayList<MyData> worldpopulation = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<MyData> getWorldPopulation() {
        return worldpopulation;
    }

    public void setWorldpopulation(ArrayList<MyData> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }
}
