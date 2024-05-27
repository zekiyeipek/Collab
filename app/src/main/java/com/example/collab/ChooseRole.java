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
        ImageButton cancelButton = view.findViewById(R.id.cancel_button); // Assuming the ID of the cancel button is cancel_button


        // Set click listeners for each checkbox
        radioButtonStudent.setOnClickListener(checkBoxClickListener);
        radioButtonCompany.setOnClickListener(checkBoxClickListener);
        radioButtonAdvisor.setOnClickListener(checkBoxClickListener);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);

                if (radioButtonStudent.isChecked()) {
                    navController.navigate(R.id.action_chooseRole_to_studentRegister);
                } else if (radioButtonCompany.isChecked()) {
                    navController.navigate(R.id.action_chooseRole_to_companyRegister);
                } else if (radioButtonAdvisor.isChecked()) {
                    navController.navigate(R.id.action_chooseRole_to_advisorRegister);
                } else {
                    Toast.makeText(getActivity(), "Please select a role", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.Login); // Assuming the ID of the action to navigate to the login page is action_chooseRole_to_login
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
