package com.tugcenurdaglar.detaylikitapsatis.ui.kategoriler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;
import com.tugcenurdaglar.detaylikitapsatis.R;
import com.tugcenurdaglar.detaylikitapsatis.ui.anasayfa.AnasayfaFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class KategorilerFragment extends Fragment {
    private NavigationView navigationViewKategoriler;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_kategoriler,container,false);

        navigationViewKategoriler = root.findViewById(R.id.navigationViewKategoriler);
        return root;
    }
    public static KategorilerFragment newInstance() {//fragmentler arası geçiş için yardımcı olacak

        Bundle args = new Bundle();

        KategorilerFragment fragment = new KategorilerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
