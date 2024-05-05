package com.example.collab.ApiCollab;

import com.google.gson.annotations.SerializedName;

public class GithubRepo {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }
}
