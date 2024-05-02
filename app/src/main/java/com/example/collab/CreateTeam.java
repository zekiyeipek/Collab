package com.example.collab;

import static com.example.collab.R.id.editTextTextMultiLine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateTeam#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateTeam extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateTeam() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateTeamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateTeam newInstance(String param1, String param2) {
        CreateTeam fragment = new CreateTeam();
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
        View view = inflater.inflate(R.layout.create_team, container, false);

        Button addMemberButton = view.findViewById(R.id.createTeambutton);
        final EditText teamNameEditText = view.findViewById(editTextTextMultiLine);
        final EditText infoEditText = view.findViewById(editTextTextMultiLine);

        addMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamName = teamNameEditText.getText().toString();
                String info = infoEditText.getText().toString();

                if (teamName.isEmpty() || info.isEmpty()) {
                    Toast.makeText(getActivity(), "Cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    // Navigate to the AddMemberFragment using NavController
                    Navigation.findNavController(v).navigate(R.id.addMember);
                }
            }
        });

        return view;
    }
}