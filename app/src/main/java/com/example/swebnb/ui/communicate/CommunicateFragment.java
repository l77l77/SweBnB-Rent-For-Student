package com.example.swebnb.ui.communicate;

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
import com.example.swebnb.ui.communicate.CommunicateViewModel;

public class CommunicateFragment extends Fragment {

    private CommunicateViewModel communicateViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        communicateViewModel =
                ViewModelProviders.of(this).get(CommunicateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_communicate, container, false);
        final TextView textView = root.findViewById(R.id.text_Communicate);
        communicateViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
