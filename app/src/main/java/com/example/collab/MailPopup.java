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
import android.widget.ImageView;
import android.widget.TextView;
public class MailPopup extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mail_popup, container, false);

        ImageView closeButton = view.findViewById(R.id.close_button);
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
        dialog.setCancelable(false); // Kullanıcı dışarıya tıklayarak kapatamaz
        return dialog;
    }
}

 /*   Button sendMailButton = findViewById(R.id.send_mail_button);
sendMailButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        MailSentDialogFragment dialogFragment = new MailSentDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mailSentDialog");
        }
        });
*/