package com.example.mvvmpractice.network;

import com.example.mvvmpractice.PojoClass.FAQEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BaseUrl= "https://bookmymealapi.herokuapp.com/api/";

    @GET("FAQ")
    Call<List<FAQEntity>> getAll();
}
