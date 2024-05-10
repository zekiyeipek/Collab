package com.example.collab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.collab.databinding.LoginBinding;

public class Login extends Fragment {

    private LoginBinding binding;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = LoginBinding.inflate(inflater, container, false);
        mAuth = FirebaseAuth.getInstance();
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.login.setOnClickListener(v -> {
            String email = binding.username.getText().toString();
            String password = binding.password.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(getActivity(), "Email and password cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), task -> {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getActivity(), "Authentication Successful!", Toast.LENGTH_SHORT).show();
                                NavHostFragment.findNavController(Login.this)
                                        .navigate(R.id.dashBoard);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}