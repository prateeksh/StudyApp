package com.example.prateek.studyapp.Service;

import com.example.prateek.studyapp.Model.Registration;

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
    Call<List<Registration>> all();

    @GET("/{name}")
    Call<Registration> get(@Path("name") String name);

    @POST("/addnew")
    Call<Registration> update(@Body Registration userDetail);
}
