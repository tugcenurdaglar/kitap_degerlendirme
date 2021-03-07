package com.tugcenurdaglar.detaylikitapsatis.ui.hesabim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;
import com.tugcenurdaglar.detaylikitapsatis.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HesabimFragment extends Fragment {
    NavigationView navigationViewHesabim;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hesabim, container, false);
        navigationViewHesabim = root.findViewById(R.id.navigationViewHesabim);
        return root;
    }

    public static HesabimFragment newInstance() {

        Bundle args = new Bundle();

        HesabimFragment fragment = new HesabimFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
