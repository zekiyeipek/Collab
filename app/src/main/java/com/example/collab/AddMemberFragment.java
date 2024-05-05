package com.example.collab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddMemberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMemberFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText editTextName, editTextSurname, editTextEmailAddress, editTextPhone, editTextUniversity, editTextYear;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddMemberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddMemberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddMemberFragment newInstance(String param1, String param2) {
        AddMemberFragment fragment = new AddMemberFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_add_member, container, false);

        // Initialize EditText views
        editTextName = rootView.findViewById(R.id.editTextName);
        editTextSurname = rootView.findViewById(R.id.editTextSurname);
        editTextEmailAddress = rootView.findViewById(R.id.editTextTextEmailAddress);
        editTextPhone = rootView.findViewById(R.id.editTextPhone);
        editTextUniversity = rootView.findViewById(R.id.editTextText);
        editTextYear = rootView.findViewById(R.id.editTextNumber);

        // Example of getting text from EditText
        String name = editTextName.getText().toString();
        String surname = editTextSurname.getText().toString();
        String email = editTextEmailAddress.getText().toString();
        String phone = editTextPhone.getText().toString();
        String university = editTextUniversity.getText().toString();
        String year = editTextYear.getText().toString();

        // You can now use these strings as needed

        return rootView;
    }
}