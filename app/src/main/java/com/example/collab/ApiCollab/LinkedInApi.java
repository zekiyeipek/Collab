package com.example.collab.ApiCollab;
import android.annotation.SuppressLint;

import com.google.firebase.firestore.auth.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface LinkedInApi {
    @SuppressLint("RestrictedApi")
    @GET("/v2/me")
    Call<User> getUserDetails(@Header("Authorization") String authHeader);
}
