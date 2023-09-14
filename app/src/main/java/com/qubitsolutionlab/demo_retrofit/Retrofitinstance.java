package com.qubitsolutionlab.demo_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitinstance {

    static String baseurl = "https://jsonplaceholder.typicode.com/";
    API api;
    static Retrofitinstance retrofitinstance;

    Retrofitinstance() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(API.class);
    }

    public static Retrofitinstance getinstance() {
        if (retrofitinstance == null) {

            retrofitinstance = new Retrofitinstance();
        }
        return retrofitinstance;
    }


}
