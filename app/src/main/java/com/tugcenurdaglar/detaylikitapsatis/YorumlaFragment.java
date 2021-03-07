package com.tugcenurdaglar.detaylikitapsatis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tugcenurdaglar.detaylikitapsatis.model.KitaplarModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class YorumlaFragment extends Fragment {
    private EditText editText;
    private KitaplarModel kitaplarModel;
    private Button buttonKaydet;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_yorumla, container,false);

        buttonKaydet = root.findViewById(R.id.buttonKaydet);
        editText = root.findViewById(R.id.editTextYorum);
        editText.setText(kitaplarModel.getKitap_ad()+",");

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"yorumunuzu kaydettiniz", Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }

    public static YorumlaFragment newInstance(KitaplarModel kitaplarModel) {

        Bundle args = new Bundle();

        YorumlaFragment fragment = new YorumlaFragment();
        fragment.setArguments(args);
        fragment.kitaplarModel = kitaplarModel;
        return fragment;
    }
}
