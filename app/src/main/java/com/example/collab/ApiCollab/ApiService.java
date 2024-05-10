package com.example.collab.ApiCollab;

import android.annotation.SuppressLint;

import com.google.firebase.database.core.Repo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("users/{user}/repos")
    Call<List<GithubRepo>> listRepos(@Path("user") String user);

 }


