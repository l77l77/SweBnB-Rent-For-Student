package com.example.swebnb.ui.personal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.swebnb.R;
import com.example.swebnb.ui.personal.PersonalViewModel;

public class PersonalFragment extends Fragment {
    private PersonalViewModel personalViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personalViewModel =
                ViewModelProviders.of(this).get(PersonalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_personal, container, false);
        final TextView textView = root.findViewById(R.id.text_Personal);
        personalViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
