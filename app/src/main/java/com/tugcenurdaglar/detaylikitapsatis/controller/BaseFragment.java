package com.tugcenurdaglar.detaylikitapsatis.controller;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    private FragmentCallback fragmentCallback;
    public Activity nActivity;
    public void changeFragment(Fragment fragment, Boolean isAdded){

        fragmentCallback.changeFragment(fragment, isAdded);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.fragmentCallback = (FragmentCallback) context;
    }
}
