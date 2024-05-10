package com.example.collab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EditProfileAdvisor extends Fragment {

        // ImageView for displaying the selected image
        private ImageView imageView;

        // Request code for selecting image
        private static final int PICK_IMAGE_REQUEST = 1;

        public EditProfileAdvisor() {

                // Required empty public constructor
            }

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
            }

            @SuppressLint("MissingInflatedId")
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                // Inflate the layout for this fragment

                View view = inflater.inflate(R.layout.edit_profile_advisor, container, false);


                // Initialize the ImageView
                imageView = view.findViewById(R.id.imageView14);

                // Initialize the button for uploading photo
                Button uploadButton = view.findViewById(R.id.uploadPhotobutton);
                uploadButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openGallery();
                    }
                });

                return view;
            }

            // Method to open gallery for selecting image
            private void openGallery() {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }

            @Override
            public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                super.onActivityResult(requestCode, resultCode, data);

                if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
                    // Get the Uri of the selected image
                    Uri imageUri = data.getData();

                    try {
                        // Get the bitmap from the Uri
                        InputStream inputStream = getActivity().getContentResolver().openInputStream(imageUri);
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                        // Set the bitmap to the ImageView
                        imageView.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
