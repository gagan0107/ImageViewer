package com.example.hp.imageviewer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 5/25/2017.
 */

public class RetroClient {
    private static final String ROOT_URL = "http://www.androidbegin.com/tutorial/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static MyService getMyService() {
        return getRetrofitInstance().create(MyService.class);
    }
}
