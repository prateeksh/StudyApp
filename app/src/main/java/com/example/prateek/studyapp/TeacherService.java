package com.example.prateek.studyapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Prateek on 6/3/2017.
 */

public interface TeacherService {

    @GET("/result")
    Call<List<Student>> all();

    @GET("/{name}")
    Call<Student> get(@Path("name") String name);

    @POST("/addnew")
    Call<Student> update(@Body Student userDetail);
}
