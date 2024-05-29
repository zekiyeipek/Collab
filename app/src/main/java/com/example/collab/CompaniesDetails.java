package com.example.collab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CompaniesDetails extends Fragment {


    private static final String ARG_COMPANY_NAME = "company_name";

    private ImageView companyLogo;
    private TextView companyName, companyFounded, companyType, companyAddress, companyPhone, companyHRInfo;
    private Button btnZoomMeeting, btnZoomMeeting2;


    public CompaniesDetails() {
        // Required empty public constructor
    }

    public static CompaniesDetails newInstance(String companyName) {
        CompaniesDetails fragment = new CompaniesDetails();
        Bundle args = new Bundle();
        args.putString(ARG_COMPANY_NAME, companyName);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.companies_details, container, false);

        companyLogo = view.findViewById(R.id.companyLogo);
        companyName = view.findViewById(R.id.companyName);
        companyFounded = view.findViewById(R.id.companyFounded);
        companyType = view.findViewById(R.id.companyType);
        companyAddress = view.findViewById(R.id.companyAddress);
        companyPhone = view.findViewById(R.id.companyPhone);
        companyHRInfo = view.findViewById(R.id.companyHRInfo);
        btnZoomMeeting = view.findViewById(R.id.btnZoomMeeting);
        btnZoomMeeting2 = view.findViewById(R.id.btnZoomMeeting2);

        // Get the company name from arguments
        if (getArguments() != null) {
            String companyName = getArguments().getString(ARG_COMPANY_NAME);
            // Set the received company name
            this.companyName.setText(companyName);
            // Additional logic to set other details based on the company name
            setCompanyDetails(companyName);
        }

        // Set click listeners for buttons
        btnZoomMeeting.setOnClickListener(v -> {
            // Implement Zoom meeting setup logic here
        });

        btnZoomMeeting2.setOnClickListener(v -> {
            // Implement add to list logic here
        });

        return view;
    }

    private void setCompanyDetails(String companyName) {
        // TODO: Set other company details dynamically based on the company name
        // For example:
        // companyFounded.setText("Founded in 1997");
        // companyType.setText("Technology");
        // companyAddress.setText("123 Main Street, City, Country");
        // companyPhone.setText("+1 (123) 456-7890");
        // companyHRInfo.setText("Join our team!");
    }

}