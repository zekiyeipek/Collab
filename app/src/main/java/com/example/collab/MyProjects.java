package com.example.collab;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProjects#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProjects extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final int REQUEST_ADD_PROJECT = 1;

    // UI elements
    private TextView projectNameTextView;
    private TextView projectHistoryTextView;
    private TextView projectDurationTextView;
    private TextView projectTeamTextView;

    private View rootView;
    private LinearLayout parentContainer;

    public MyProjects() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyProjectsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProjects newInstance(String param1, String param2) {
        MyProjects fragment = new MyProjects();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.my_projects, container, false);

        // Initialize UI elements
        projectNameTextView = rootView.findViewById(R.id.projectNameText);
        projectHistoryTextView = rootView.findViewById(R.id.historyText);
        projectDurationTextView = rootView.findViewById(R.id.projectDurationText);
        projectTeamTextView = rootView.findViewById(R.id.projectTeamText);

        // Initialize parent container
        parentContainer = rootView.findViewById(R.id.linearLayout);

        // Button click listener for adding project
        Button addProjectButton = rootView.findViewById(R.id.button4);
        addProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProjectDetailsPopup(inflater); // Open pop-up on button click
            }
        });

        return rootView;
    }

    // Method to inflate and handle pop-up for project details
    private void showProjectDetailsPopup(LayoutInflater inflater) {
        // Inflate pop-up layout
        View popupView = inflater.inflate(R.layout.project_details_popup, null);

        // Get references to input fields and submit button
        EditText projectNameInput = popupView.findViewById(R.id.projectNameInput);
        EditText projectHistoryInput = popupView.findViewById(R.id.projectHistoryInput);
        EditText projectDurationInput = popupView.findViewById(R.id.projectDurationInput);
        EditText projectTeamInput = popupView.findViewById(R.id.projectTeamInput);
        Button submitButton = popupView.findViewById(R.id.submitButton);

        // Build the alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(popupView);
        AlertDialog alertDialog = builder.create();


        // Submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String projectName = projectNameInput.getText().toString();
                String projectHistory = projectHistoryInput.getText().toString();
                String projectDuration = projectDurationInput.getText().toString();
                String projectTeam = projectTeamInput.getText().toString();

                // Basic validation (check for empty fields)
                if (TextUtils.isEmpty(projectName) || TextUtils.isEmpty(projectHistory) || TextUtils.isEmpty(projectDuration) || TextUtils.isEmpty(projectTeam)) {
                    // Show error message (optional)
                    return;
                }

                // Create a new view to display project details
                View projectView = inflater.inflate(R.layout.project_entry, null);

                // Set project details to the new view
                TextView projectNameTextView = projectView.findViewById(R.id.projectNameText);
                TextView projectHistoryTextView = projectView.findViewById(R.id.historyText);
                TextView projectDurationTextView = projectView.findViewById(R.id.projectDurationText);
                TextView projectTeamTextView = projectView.findViewById(R.id.projectTeamText);


                // Update UI with new project details
                projectNameTextView.setText(projectName);
                projectHistoryTextView.setText(projectHistory);
                projectDurationTextView.setText(projectDuration);
                projectTeamTextView.setText(projectTeam);

                // Create LayoutParams for the new container
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, // Width
                        LinearLayout.LayoutParams.WRAP_CONTENT // Height
                );


                // Add a margin between project entries
                //layoutParams.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()), 0, 0);


                LinearLayout parentContainer = rootView.findViewById(R.id.projectLayout);
                parentContainer.addView(projectView,layoutParams);


                // Dismiss the dialog
                alertDialog.dismiss();
            }
        });

        // Show the dialog
        alertDialog.show();
    }

}