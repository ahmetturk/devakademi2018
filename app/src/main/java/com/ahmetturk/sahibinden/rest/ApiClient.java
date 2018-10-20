package com.ahmetturk.sahibinden.rest;

import com.ahmetturk.sahibinden.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("users/findAllByBirthYearGreaterThan")
    Call<ArrayList<User>> getUsersByBirthYearGreaterThan(@Query("birthYear") String year);

    @GET("users/findAllByBirthYearLessThan")
    Call<ArrayList<User>> getUsersByBirthYearLessThan(@Query("birthYear") String year);

    @GET("users/findAllByBirthYear")
    Call<ArrayList<User>> getUsersByBirthYear(@Query("birthYear") String year);

    @GET("users/findAllByCityName")
    Call<ArrayList<User>> getUsersByCityName(@Query("cityName") String city);

    @GET("users/findAllByEducation")
    Call<ArrayList<User>> getUsersByEducation(@Query("education") String education);

    @GET("users/findAllByMartialStatus")
    Call<ArrayList<User>> getUsersByMartialStatus(@Query("martialStatus") String martialStatus);

    @GET("users/findAllByGender")
    Call<ArrayList<User>> getUsersByGender(@Query("gender") String gender);
}
