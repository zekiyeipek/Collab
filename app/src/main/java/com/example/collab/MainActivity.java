package com.example.collab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collab.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



import com.example.collab.ApiCollab.ApiService;
import com.example.collab.ApiCollab.GithubRepo;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrofit nesnesi oluşturma
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // ApiService nesnesini oluşturma
        ApiService apiService = retrofit.create(ApiService.class);


        // API isteğini gönderme
        Call<List<GithubRepo>> call = apiService.listRepos("kullanıcıAdı");
        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                if (response.isSuccessful()) {
                    List<GithubRepo> repos = response.body();
                    if (repos != null) {
                        for (GithubRepo repo : repos) {
                            Log.d("Repo", repo.getName());
                        }
                    }
                } else {
                    Log.e("Error", "Response not successful");
                }
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });



        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        drawer = findViewById(R.id.drawer_layout);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });

    }



    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.menu_main, menu);
    //return true;
    //}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true; // No need to inflate menu here
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.settings);
            return true;
        }
        if (id == R.id.menu_edit_profile) {

            String accountType = getAccountType(); // You need to implement this method to get the account type

            // Navigate to the appropriate edit profile page based on the account type
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            if (accountType.equals("student")) {
                navController.navigate(R.id.editProfileStudent);
            } else if (accountType.equals("company")) {

                navController.navigate(R.id.editProfileCompanyFragment);
            } else if (accountType.equals("advisor")) {
                navController.navigate(R.id.editProfileAdvisorFragment);
            }else {

                // Handle other account types or show an error message
                Snackbar.make(binding.getRoot(), "Invalid account type", Snackbar.LENGTH_SHORT).show();
            }
            return true;
        }

        if (id == R.id.menu_create_team) {
            // Navigate to the create team page
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.createTeam);
            return true;
        }
        if (id == R.id.menu_companies) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.companies);
            return true;
        }
        if (id == R.id.menu_my_projects) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.myProjects);
            return true;
        }
        if (id == R.id.menu_my_tracking) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.myTracking);
            return true;
        }

        if (id == R.id.menu_log_out) {
            // Perform logout operation
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void logout() {
        try {
            // Clear user session data (e.g., remove user credentials from SharedPreferences)
            // Example:
            SharedPreferences.Editor editor = getSharedPreferences("user_session", MODE_PRIVATE).edit();
            editor.clear();
            editor.apply();

            // Navigate to the login screen
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.FirstFragment);
            finish(); // Optional: Finish the current activity to prevent going back to it using the back button
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAccountType() {
        // Retrieve the account type from SharedPreferences or any other source
        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        return preferences.getString("account_type", ""); // Replace "account_type" with the key you use to store the account type
    }



}