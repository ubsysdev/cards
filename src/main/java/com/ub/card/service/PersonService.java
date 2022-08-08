package com.ub.card.service;

import com.ub.card.model.Person;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Matshedisoo on 6/15/2016.
 */
public interface PersonService {

    @POST("insertrecords")
    Call<List<Person>> insertRecords(@Body ArrayList<Person> people);

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).build();

    public static final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8090")
            .addConverterFactory(JacksonConverterFactory.create())
            .client(okHttpClient).build();
}
