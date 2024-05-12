package com.example.collab.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.collab.R;
import com.example.collab.databinding.CompanyRegisterBinding;

public class CompanyRegister extends Fragment {

    private LoginViewModel loginViewModel;
    private CompanyRegisterBinding binding;
    private FirebaseAuth mAuth;


    // Google ile giriş yapma işlemi
    void onGoogleLoginClicked() {
        // Google ile giriş yapma işlemini burada gerçekleştirin
    }

    // LinkedIn ile giriş yapma işlemi
    void onLinkedInLoginClicked() {
        // LinkedIn ile giriş yapma işlemini burada gerçekleştirin
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = CompanyRegisterBinding.inflate(inflater, container, false);
        mAuth = FirebaseAuth.getInstance();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final Button googleLoginButton = binding.googleLoginButton;
        googleLoginButton.setOnClickListener(v -> {
            onGoogleLoginClicked();
        });

        final Button linkedinLoginButton = binding.linkedinLoginButton;
        linkedinLoginButton.setOnClickListener(v -> {
            onLinkedInLoginClicked();
        });

        final EditText usernameEditText = binding.companyName;
        final EditText passwordEditText = binding.password;
        final Button registerButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;

        registerButton.setOnClickListener(v -> {
            String email = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(getActivity(), "Email and password cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), task -> {
                            if (task.isSuccessful()) {
                                // Sign up success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getActivity(), "Registration Successful!", Toast.LENGTH_SHORT).show();
                                NavHostFragment.findNavController(CompanyRegister.this)
                                        .navigate(R.id.dashBoard);
                            } else {
                                // If sign up fails, display a message to the user.
                                Toast.makeText(getActivity(), "Registration failed.", Toast.LENGTH_SHORT).show();
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