package com.example.collab;

import androidx.fragment.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
public class ResetPassword extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mail_reset_popup, container, false);

        EditText emailInput = view.findViewById(R.id.email_input);
        Button sendButton = view.findViewById(R.id.send_button);
        ImageView closeButton = view.findViewById(R.id.close_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                if (!email.isEmpty()) {
                    Toast.makeText(getContext(), "Password reset email sent.", Toast.LENGTH_SHORT).show();
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setCancelable(false);
        return dialog;
    }
}

 /*   Button resetPasswordButton = findViewById(R.id.reset_password_button);
resetPasswordButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        ResetPasswordDialogFragment dialogFragment = new ResetPasswordDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "resetPasswordDialog");
        }
        });*/
