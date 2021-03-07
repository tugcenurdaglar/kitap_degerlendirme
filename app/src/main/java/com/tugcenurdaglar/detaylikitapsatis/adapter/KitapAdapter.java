package com.tugcenurdaglar.detaylikitapsatis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tugcenurdaglar.detaylikitapsatis.R;
import com.tugcenurdaglar.detaylikitapsatis.controller.KitapCallback;
import com.tugcenurdaglar.detaylikitapsatis.model.KitaplarModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KitapAdapter extends RecyclerView.Adapter<KitapAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext;
    //veri kümesi

    private List<KitaplarModel> kitaplarModelList;
    private KitapCallback kitapCallback;

    public KitapAdapter(Context mContext, List<KitaplarModel> kitaplarModelList, KitapCallback kitapCallback) {
        this.mContext = mContext;
        this.kitaplarModelList = kitaplarModelList;
        this.kitapCallback = kitapCallback;
    }

    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_kitap_tasarim, parent, false);
        return new CardViewTasarimNesneleriniTutucu(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, int position) {
        final KitaplarModel kitaplarModel = kitaplarModelList.get(position);
        Glide.with(mContext).load(kitaplarModel.getKitap_resim_ad()).into(holder.imageViewKitapResim);

        holder.textViewKitapBaslik.setText(kitaplarModel.getKitap_ad());
        holder.textViewKitapFiyat.setText(kitaplarModel.getKitap_fiyat() + " TL");
        holder.buttonDegerlendir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kitapCallback.didSelectKitap(kitaplarModel);

            }
        });
    }

    @Override
    public int getItemCount() {
        return kitaplarModelList.size();
    }

    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder {
        public ImageView imageViewKitapResim;
        public TextView textViewKitapBaslik;
        public TextView textViewKitapFiyat;
        public Button buttonDegerlendir;

        public CardViewTasarimNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);

            imageViewKitapResim = itemView.findViewById(R.id.imageViewKitapResim);
            textViewKitapBaslik = itemView.findViewById(R.id.textViewKitapBaslik);
            textViewKitapFiyat = itemView.findViewById(R.id.textViewKitapFiyat);
            buttonDegerlendir = itemView.findViewById(R.id.buttonDegerlendir);
        }
    }
}
