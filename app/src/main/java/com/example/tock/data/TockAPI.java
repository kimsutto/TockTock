package com.example.tock.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TockAPI {

    @GET("/tock/{id}/")
    Call<List<Tock>> getTock(@Path("id") int id);

    @POST("/tock/")
    Call<Tock> postTock(@Body Tock tock);

}
