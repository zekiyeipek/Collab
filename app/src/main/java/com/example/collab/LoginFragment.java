package com.example.collab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.collab.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
        binding.login.setOnClickListener(v -> {
            String email = binding.username.getText().toString();
            if (email.endsWith("@cankaya.edu.tr") || email.endsWith("@student.cankaya.edu.tr")) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.login2);
            } else {
                Toast.makeText(getActivity(), "Inappropriate Format!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}