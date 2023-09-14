package com.qubitsolutionlab.demo_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("/photos")
    Call<List<ResponseObject>> getuser();

}
