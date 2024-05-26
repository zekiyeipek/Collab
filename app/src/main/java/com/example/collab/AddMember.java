package com.example.collab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.collab.Member;

public class AddMember extends Fragment {

    private FirebaseAuth mAuth;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private EditText editTextName, editTextSurname, editTextEmail, editTextPhone, editTextUniversity, editTextYear;

    private DatabaseReference membersRef;


    public AddMember() {
        // Required empty public constructor
    }

    public static AddMember newInstance(String param1, String param2) {
        AddMember fragment = new AddMember();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Get reference to the "members" node in the Firebase Realtime Database
        membersRef = FirebaseDatabase.getInstance().getReference().child("members");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_member, container, false);

        // Initialize EditText fields
        editTextName = view.findViewById(R.id.editTextName);
        editTextSurname = view.findViewById(R.id.editTextSurname);
        editTextEmail = view.findViewById(R.id.editTextTextEmailAddress);
        editTextPhone = view.findViewById(R.id.editTextPhone);
        editTextUniversity = view.findViewById(R.id.editTextText);
        editTextYear = view.findViewById(R.id.editTextNumber);

        // Initialize buttons and set click listeners
        Button approveButton = view.findViewById(R.id.approveButton);
        approveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action on "Approve" button click
                // Example: Add member to database
                addMemberToDatabase();
            }
        });

        Button clearButton = view.findViewById(R.id.clearbutton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action on "Clear" button click
                clearFields();
            }
        });

        return view;
    }
    private void addMemberToDatabase() {
        // Here you can implement the logic to add the member to your database
        // Example: Get values from EditText fields and save them to your database
        String name = editTextName.getText().toString();
        String surname = editTextSurname.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String university = editTextUniversity.getText().toString();
        String year = editTextYear.getText().toString();

        // Create a new member object
        Member member = new Member(name, surname, email, phone, university, year);

        // Add the new member to the "members" node in the Firebase Realtime Database
        membersRef.push().setValue(member);

        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.createTeam);

        // After getting the values, you can perform database operations
        // For example, you can use Firebase Realtime Database or Firestore to save the member details
        // Firebase Realtime Database example: DatabaseReference ref = FirebaseDatabase.getInstance().getReference("members");
        // ref.child("member1").setValue(new Member(name, surname, email, phone, university, year));
    }

    private void clearFields() {
        // Clear all EditText fields
        editTextName.setText("");
        editTextSurname.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextUniversity.setText("");
        editTextYear.setText("");
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            // User is signed in
            // TODO: Handle the signed in user
        } else {
            // User is signed out
            // TODO: Handle the signed out user
        }
    }
}