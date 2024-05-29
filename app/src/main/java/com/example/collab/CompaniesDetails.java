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

    private ImageView companyLogo;
    private TextView companyName, companyFounded, companyType, companyAddress, companyPhone, companyHRInfo;
    private Button btnZoomMeeting, btnZoomMeeting2;

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

        btnZoomMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        btnZoomMeeting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicked add button.", Toast.LENGTH_SHORT).show();
            }
        });

        // API den gelen bilgiler

        return view;
    }
}