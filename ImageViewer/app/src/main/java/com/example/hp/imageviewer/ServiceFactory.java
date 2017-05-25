package com.example.hp.imageviewer;

import retrofit.RestAdapter;

/**
 * Created by HP on 5/25/2017.
 */

    public class ServiceFactory {

        /**
         * Creates a retrofit service from an arbitrary class (clazz)
         * @param clazz Java interface of the retrofit service
         * @param endPoint REST endpoint url
         * @return retrofit service with defined endpoint
         */
        public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
            final RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(endPoint)
                    .build();
            T service = restAdapter.create(clazz);

            return service;
        }
    }

