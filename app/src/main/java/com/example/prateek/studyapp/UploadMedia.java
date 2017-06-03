package com.example.prateek.studyapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Prateek on 6/3/2017.
 */

public class UploadMedia {

    @SerializedName("images")
    String images;

    @SerializedName("videos")
    String videos;

    @SerializedName("presentations")
    String presentations;

    public String getImages() {
        return images;
    }

    public String getPresentations() {
        return presentations;
    }

    public String getVideos() {
        return videos;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setPresentations(String presentations) {
        this.presentations = presentations;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }
}
