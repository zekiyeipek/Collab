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
import android.widget.Toast;

import com.example.collab.ui.login.StudentRegisterFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseRoleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseRoleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CheckBox checkBoxStudent, checkBoxCompany, checkBoxAdvisor;
    Button submitButton;

    public ChooseRoleFragment() {
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
    public static ChooseRoleFragment newInstance(String param1, String param2) {
        ChooseRoleFragment fragment = new ChooseRoleFragment();
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
        View view = inflater.inflate(R.layout.fragment_choose_role, container, false);

        checkBoxStudent = view.findViewById(R.id.checkBoxStudent);
        checkBoxCompany = view.findViewById(R.id.checkBoxCompany);
        checkBoxAdvisor = view.findViewById(R.id.checkBoxAdvisor);
        ImageButton submitButton = view.findViewById(R.id.submit_button);

        // Set click listeners for each checkbox
        checkBoxStudent.setOnClickListener(checkBoxClickListener);
        checkBoxCompany.setOnClickListener(checkBoxClickListener);
        checkBoxAdvisor.setOnClickListener(checkBoxClickListener);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxStudent.isChecked() || checkBoxCompany.isChecked() || checkBoxAdvisor.isChecked()) {
                    // Check which checkbox is checked and navigate accordingly
                    if (checkBoxStudent.isChecked()) {
                        // Navigate to the StudentRegisterFragment using NavController
                        NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.studentRegisterFragment);
                    } else if (checkBoxCompany.isChecked()) {
                        NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.companyRegisterFragment);
                    } else if (checkBoxAdvisor.isChecked()) {
                        NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.advisorRegisterFragment);
                    }
                } else {
                    // Show a message that at least one checkbox must be selected
                    Toast.makeText(getActivity(), "Please select at least one role", Toast.LENGTH_SHORT).show();
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
            checkBoxStudent.setChecked(v.getId() == R.id.checkBoxStudent);
            checkBoxCompany.setChecked(v.getId() == R.id.checkBoxCompany);
            checkBoxAdvisor.setChecked(v.getId() == R.id.checkBoxAdvisor);
        }
    };
}
