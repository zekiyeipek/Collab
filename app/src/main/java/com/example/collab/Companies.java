package com.example.collab;
import android.content.Intent;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Companies#newInstance} factory method to
 * create an instance of this fragment.
 */

public class Companies extends Fragment {

    public Companies() {
        // Required empty public constructor
    }
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types and number of parameters
    public static Companies newInstance(String param1, String param2) {
        Companies fragment = new Companies();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.companies, container, false);

        // Initialize the buttons
        Button button1 = rootView.findViewById(R.id.button1);
        Button button2 = rootView.findViewById(R.id.button2);
        Button button3 = rootView.findViewById(R.id.button3);
        Button button4 = rootView.findViewById(R.id.button4);

        // Set onClick listeners to navigate to the company details
        button1.setOnClickListener(v -> openCompanyDetails("Netflix"));
        button2.setOnClickListener(v -> openCompanyDetails("Amazon"));
        button3.setOnClickListener(v -> openCompanyDetails("Apple"));
        button4.setOnClickListener(v -> openCompanyDetails("Instagram"));

        return rootView;

    }

    private void openCompanyDetails(String companyName) {
        CompaniesDetails companiesDetails = CompaniesDetails.newInstance(companyName);

        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, companiesDetails); // Ensure your main layout has an ID like fragment_container
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
