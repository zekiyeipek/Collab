package com.example.collab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseRole#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseRole extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RadioButton radioButtonStudent, radioButtonCompany, radioButtonAdvisor;
    ImageButton submitButton;

    public ChooseRole() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseRoleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChooseRole newInstance(String param1, String param2) {
        ChooseRole fragment = new ChooseRole();
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
        View view = inflater.inflate(R.layout.choose_role, container, false);

        radioButtonStudent = view.findViewById(R.id.radioButtonStudent);
        radioButtonCompany = view.findViewById(R.id.radioButtonCompany);
        radioButtonAdvisor = view.findViewById(R.id.radioButtonAdvisor);
        ImageButton submitButton = view.findViewById(R.id.submit_button);

        // Set click listeners for each checkbox
        radioButtonStudent.setOnClickListener(checkBoxClickListener);
        radioButtonCompany.setOnClickListener(checkBoxClickListener);
        radioButtonAdvisor.setOnClickListener(checkBoxClickListener);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (radioButtonStudent.isChecked() || radioButtonCompany.isChecked() || radioButtonAdvisor.isChecked()) {
                    // Check which radio button is checked and navigate accordingly
                    if (radioButtonStudent.isChecked()) {
                        // Navigate to the StudentRegisterFragment using NavController
                        NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.studentRegisterFragment);
                    } else if (radioButtonCompany.isChecked()) {
                        NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.companyRegisterFragment);
                    } else if (radioButtonAdvisor.isChecked()) {

                        NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.advisorRegister);
                    }
                } else {
                    // Show a message that at least one radio button must be selected
                    Toast.makeText(getActivity(), "Please select a role", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    // Listener to handle checkbox clicks
    private View.OnClickListener checkBoxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Uncheck all checkboxes
            radioButtonStudent.setChecked(v.getId() == R.id.radioButtonStudent);
            radioButtonCompany.setChecked(v.getId() == R.id.radioButtonCompany);
            radioButtonAdvisor.setChecked(v.getId() == R.id.radioButtonAdvisor);
        }
    };
}
