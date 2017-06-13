package com.example.prateek.studyapp.Service;

import com.example.prateek.studyapp.UploadMedia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Prateek on 6/3/2017.
 */

public interface MediaService {

    @GET("/result")
    Call<List<UploadMedia>> all();

    @GET("/{image}")
    Call<UploadMedia> get(@Path("image") String image);

    @POST("/addnew")
    Call<UploadMedia> update(@Body UploadMedia uploadMedia);
}
