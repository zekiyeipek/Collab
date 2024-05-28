package com.example.collab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditProfileStudent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditProfileStudent extends Fragment {

    private static final int PICK_PDF_FILE = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditProfileStudent() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditProfileStudentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditProfileStudent newInstance(String param1, String param2) {
        EditProfileStudent fragment = new EditProfileStudent();
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
        View rootView = inflater.inflate(R.layout.edit_profile_student, container, false);

        String linkedinLink = "https://www.linkedin.com/";
        String githubLink = "https://github.com/";


        EditText editGithubLink = rootView.findViewById(R.id.editGithubLink);
        EditText editLinkedinLink = rootView.findViewById(R.id.editLinkedinLink);
        editGithubLink.setText(githubLink);
        editLinkedinLink.setText(linkedinLink);

        Button uploadCVButton = rootView.findViewById(R.id.buttonUploadCV);
        uploadCVButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("application/pdf");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, PICK_PDF_FILE);
            }
        });

        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PDF_FILE && resultCode == getActivity().RESULT_OK) {
            Uri selectedPdf = data.getData();
            // selectedPdf Uri'sini kullanarak PDF dosyasını işleyin
            Toast.makeText(getActivity(), "Selected file: " + selectedPdf.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}