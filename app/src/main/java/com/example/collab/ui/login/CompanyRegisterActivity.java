package com.example.collab.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.collab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CompanyRegisterActivity extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;
    private Button mRegisterButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_register);

        // Get Firebase Authentication instance
        mAuth = FirebaseAuth.getInstance();

        // Initialize views
        mEmailField = findViewById(R.id.email);
        mPasswordField = findViewById(R.id.password);
        mRegisterButton = findViewById(R.id.login);

        // Set click listener for register button
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailField.getText().toString();
                String password = mPasswordField.getText().toString();

                // Register user with Firebase Authentication
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(CompanyRegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // User successfully registered
                                    Log.d("RegisterActivity", "createUserWithEmail:success");
                                    Toast.makeText(CompanyRegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user
                                    Log.w("RegisterActivity", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(CompanyRegisterActivity.this, "Registration failed. " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
