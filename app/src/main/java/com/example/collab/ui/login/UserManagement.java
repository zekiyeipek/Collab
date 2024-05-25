package com.example.collab.ui.login;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserManagement {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public UserManagement() {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("users"); // Kullanıcı bilgilerini saklamak için bir "users" düğümü oluşturuyoruz.
    }

    // Yeni kullanıcı kaydı
    public void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        // Kullanıcı oluşturulduğunda, kullanıcının veritabanına kaydedilmesi
                        saveUserInfo(user.getUid(), "student"); // Örneğin, varsayılan olarak tüm kullanıcılar öğrenci olarak kaydedilir.
                    } else {
                        // Kayıt işlemi başarısız oldu
                    }
                });
    }

    // Kullanıcı bilgilerini veritabanına kaydetme
    private void saveUserInfo(String userId, String role) {
        User user = new User(userId, role);
        mDatabase.child(userId).setValue(user)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Kullanıcı bilgileri başarıyla kaydedildi
                    } else {
                        // Kullanıcı bilgilerini kaydetme işlemi başarısız oldu
                    }
                });
    }

    // Kullanıcı rollerini güncelleme
    public void updateUserRole(String userId, String newRole) {
        mDatabase.child(userId).child("role").setValue(newRole)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Kullanıcı rolü başarıyla güncellendi
                    } else {
                        // Kullanıcı rolünü güncelleme işlemi başarısız oldu
                    }
                });
    }

    // Kullanıcı rollerini alma
    public void getUserRole(String userId) {
        mDatabase.child(userId).child("role").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                String role = task.getResult().getValue(String.class);
                // Kullanıcının rolü başarıyla alındı
                System.out.println("User Role: " + role);
            } else {
                // Kullanıcı rolünü alma işlemi başarısız oldu
            }
        });
    }
}

class User {
    private String userId;
    private String role;

    public User() {}

    public User(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    // Getter ve setter metotları
}
