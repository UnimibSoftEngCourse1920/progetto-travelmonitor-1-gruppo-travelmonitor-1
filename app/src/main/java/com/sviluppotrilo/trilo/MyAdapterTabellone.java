package com.sviluppotrilo.trilo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.sviluppotrilo.trilo.Domain.Arrivi;
import com.sviluppotrilo.trilo.Domain.Partenze;
import com.sviluppotrilo.trilo.Domain.Stazione;

import java.util.ArrayList;


public class MyAdapterTabellone extends RecyclerView.Adapter<MyCardTabellone> {

    Context context;
    Arrivi[] datiTabelloneArrivi;
    Partenze[] datiTabellonePartenze;
    Stazione stazione;
    int pos = 0;

    public MyAdapterTabellone(Context c, Stazione stazione, Arrivi[] datiTabelloneArrivi, Partenze[] datiTabellonePartenze, int pos) {
        this.context = c;
        this.datiTabelloneArrivi = datiTabelloneArrivi;
        this.datiTabellonePartenze = datiTabellonePartenze;
        this.stazione = stazione;
        this.pos = pos;
    }

    @NonNull
    @Override
    public MyCardTabellone onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tabellone, null);
        return new MyCardTabellone(view);
    }

    @Override
    public void onBindViewHolder(final MyCardTabellone holder, final int i) {
        if(pos == 0) {
            holder.treno.setText(datiTabellonePartenze[i].getDestinazione());
            holder.ora.setText(datiTabellonePartenze[i].getCompOrarioPartenza());
            if(datiTabellonePartenze[i].isInStazione())
                holder.binario.setText("E' in stazione, binario "+datiTabellonePartenze[i].getBinarioEffettivoPartenzaDescrizione());
            else
                holder.binario.setText("Partirà dal binario "+datiTabellonePartenze[i].getBinarioProgrammatoPartenzaDescrizione());
        }else{
            holder.treno.setText(datiTabelloneArrivi[i].getOrigine());
            holder.ora.setText(datiTabelloneArrivi[i].getCompOrarioArrivo());
            if(datiTabelloneArrivi[i].isInStazione())
                holder.binario.setText("E' in stazione, binario "+datiTabelloneArrivi[i].getBinarioEffettivoArrivoDescrizione());
            else
                holder.binario.setText("Arriverà al binario "+datiTabelloneArrivi[i].getBinarioProgrammatoArrivoDescrizione());
        }
    }

    @Override
    public int getItemCount() {
        if(pos == 0)
            return datiTabellonePartenze.length;
        else
            return datiTabelloneArrivi.length;
    }
}
