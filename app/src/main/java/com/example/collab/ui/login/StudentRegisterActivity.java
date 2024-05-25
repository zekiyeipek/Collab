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
    private Button mRegisterButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_register);

        // Firebase Authentication instance'ı al
        mAuth = FirebaseAuth.getInstance();

        // View'leri bağla
        mEmailField = findViewById(R.id.username);
        mPasswordField = findViewById(R.id.password);
        mRegisterButton = findViewById(R.id.login);

        // Kayıt butonuna tıklama olayını ekle
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailField.getText().toString();
                String password = mPasswordField.getText().toString();

                // Firebase Authentication ile kullanıcı kaydı yap
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(StudentRegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Kullanıcı başarıyla kaydedildi
                                    Log.d("RegisterActivity", "createUserWithEmail:success");
                                    Toast.makeText(StudentRegisterActivity.this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Kayıt sırasında bir hata oluştu
                                    Log.w("RegisterActivity", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(StudentRegisterActivity.this, "Kayıt başarısız, lütfen tekrar deneyin.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
