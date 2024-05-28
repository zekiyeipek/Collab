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

public class StudentRegisterActivity extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;
    private EditText mNameField;
    private EditText mDateOfBirthField;
    private EditText mStudentNumberField;
    private Button mRegisterButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_register);

        // Firebase Authentication instance'ı al
        mAuth = FirebaseAuth.getInstance();

        // View'leri bağla
        mNameField = findViewById(R.id.name);
        mEmailField = findViewById(R.id.username);
        mPasswordField = findViewById(R.id.password);
        mDateOfBirthField = findViewById(R.id.dateOfBirth);
        mStudentNumberField = findViewById(R.id.studentNumber);
        mRegisterButton = findViewById(R.id.login);

        // Kayıt butonuna tıklama olayını ekle
        // Register button click listener
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }
    private void registerUser() {
        String name = mNameField.getText().toString().trim();
        String email = mEmailField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();
        String dateOfBirth = mDateOfBirthField.getText().toString().trim();
        String studentNumber = mStudentNumberField.getText().toString().trim();

        // Validate inputs
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || dateOfBirth.isEmpty() || studentNumber.isEmpty()) {
            Toast.makeText(StudentRegisterActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        // Register user with Firebase Authentication
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(StudentRegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // User successfully registered
                            Log.d("RegisterActivity", "createUserWithEmail:success");
                            Toast.makeText(StudentRegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

                            // Here you can add additional steps, such as saving other user information to Firestore or Realtime Database
                            // For example:
                            // saveAdditionalUserInfo(name, dateOfBirth, studentNumber);
                        } else {
                            // If sign in fails, display a message to the user
                            Log.w("RegisterActivity", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(StudentRegisterActivity.this, "Registration failed. " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Example method to save additional user information
    private void saveAdditionalUserInfo(String name, String dateOfBirth, String studentNumber) {
        // Implement this method to save additional user information to Firestore or Realtime Database
    }
}
