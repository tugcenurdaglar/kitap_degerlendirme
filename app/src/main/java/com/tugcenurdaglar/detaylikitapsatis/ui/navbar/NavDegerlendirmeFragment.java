package com.tugcenurdaglar.detaylikitapsatis.ui.navbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.tugcenurdaglar.detaylikitapsatis.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NavDegerlendirmeFragment extends Fragment  {
    private RatingBar ratingBar;
    private TextView textViewYildiz;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=  inflater.inflate(R.layout.fragment_nav_degerlendirme, container, false);

        ratingBar = root.findViewById(R.id.ratingBar);
        textViewYildiz = root.findViewById(R.id.textViewYildiz);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void  onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                textViewYildiz.setText("Verdiğiniz yıldız: "+rating);

                if (rating>3){
                    Toast.makeText(getContext(),"Değerlendirmeniz için teşekkürler..",Toast.LENGTH_LONG).show();
                }

            }
        });

        return root;





    }

    public static NavDegerlendirmeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NavDegerlendirmeFragment fragment = new NavDegerlendirmeFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
