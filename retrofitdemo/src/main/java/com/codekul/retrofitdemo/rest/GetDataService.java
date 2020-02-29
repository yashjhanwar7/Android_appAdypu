package com.codekul.retrofitdemo.rest;

import com.codekul.retrofitdemo.domain.EmployeeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/api/v1/employees")
    Call<EmployeeResponse> getAllEmployees();
}
