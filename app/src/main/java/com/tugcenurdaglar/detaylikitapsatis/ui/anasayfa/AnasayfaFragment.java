package com.tugcenurdaglar.detaylikitapsatis.ui.anasayfa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tugcenurdaglar.detaylikitapsatis.YorumlaFragment;
import com.tugcenurdaglar.detaylikitapsatis.adapter.KitapAdapter;
import com.tugcenurdaglar.detaylikitapsatis.controller.BaseFragment;
import com.tugcenurdaglar.detaylikitapsatis.controller.KitapCallback;
import com.tugcenurdaglar.detaylikitapsatis.model.KitaplarModel;
import com.tugcenurdaglar.detaylikitapsatis.R;

import java.util.ArrayList;

public class AnasayfaFragment extends BaseFragment implements KitapCallback {
    private RecyclerView rv;
    private ArrayList<KitaplarModel> kitaplarModelArrayList;
    private KitapAdapter adapter;


    public static AnasayfaFragment newInstance() {//fragmentler arası geçiş için yardımcı olacak

        Bundle args = new Bundle();

        AnasayfaFragment fragment = new AnasayfaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



     
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_anasayfa, container, false);
        rv = root.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        KitaplarModel k1 = new KitaplarModel(1,"Bir Çöküşün Öyküsü",R.drawable.bircokusunoykusu,12.99);
        KitaplarModel k2 = new KitaplarModel(2,"Bir İdam Mahkumunun Son Günü",R.drawable.biridammahkumu,14.99);
        KitaplarModel k3 = new KitaplarModel(3,"Dava",R.drawable.dava,10.99);
        KitaplarModel k4 = new KitaplarModel(4,"Fareler Ve İnsanlar",R.drawable.farelerveinsanlar,16.99);
        KitaplarModel k5 = new KitaplarModel(5,"Hayvan Çiftliği",R.drawable.hayvanciftligi,17.99);
        KitaplarModel k6 = new KitaplarModel(6,"İnsancıklar",R.drawable.insanciklar,12.99);
        KitaplarModel k7 = new KitaplarModel(7,"Körlük",R.drawable.korluk,23.99);
        KitaplarModel k8 = new KitaplarModel(8,"Otomatik Portakal",R.drawable.otomatikportakal,15.99);
        KitaplarModel k9 = new KitaplarModel(1,"Şeker Portakalı",R.drawable.sekerportakali,22.99);
        KitaplarModel k10 = new KitaplarModel(1,"Sineklerin Tanrısı",R.drawable.sineklerintanrisi,12.99);

        kitaplarModelArrayList = new ArrayList<>();

        kitaplarModelArrayList.add(k1);
        kitaplarModelArrayList.add(k2);
        kitaplarModelArrayList.add(k3);
        kitaplarModelArrayList.add(k4);
        kitaplarModelArrayList.add(k5);
        kitaplarModelArrayList.add(k6);
        kitaplarModelArrayList.add(k7);
        kitaplarModelArrayList.add(k8);
        kitaplarModelArrayList.add(k9);
        kitaplarModelArrayList.add(k10);

        adapter = new KitapAdapter(getContext(), kitaplarModelArrayList, this);
        rv.setAdapter(adapter);
        return root;



    }

    @Override
    public void didSelectKitap(KitaplarModel kitaplarModel) {
        changeFragment(YorumlaFragment.newInstance(kitaplarModel),true);

    }
}