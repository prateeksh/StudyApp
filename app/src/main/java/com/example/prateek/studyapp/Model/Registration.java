package com.example.prateek.studyapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Prateek on 6/3/2017.
 */

public class Registration {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("email")
    String email;

    @SerializedName("password")
    String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
