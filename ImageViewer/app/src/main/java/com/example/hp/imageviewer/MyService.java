package com.example.hp.imageviewer;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit2.Call;
import rx.Observable;

/**
 * Created by HP on 5/25/2017.
 */

public interface MyService {
   // String SERVICE_ENDPOINT = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    @retrofit2.http.GET("jsonparsetutorial.txt")
//    @GET("/jsonparsetutorial.txt")
    Call<WorldPopulation> getMyJSON();
}