package com.example.collab;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyTracking#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyTracking extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyTracking() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyTrackingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyTracking newInstance(String param1, String param2) {
        MyTracking fragment = new MyTracking();
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
        View view = inflater.inflate(R.layout.my_tracking, container, false);

        // Find the RadioButton by its ID
        RadioButton evaluationPhaseButton = view.findViewById(R.id.evaluationPhaseButton);

        // Set an OnClickListener to the evaluationPhaseButton
        evaluationPhaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use NavController to navigate to the StudentEvaluation fragment
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.studentEvaluation);
            }
        });

        return view;
    }
}