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
            holder.treno1.setText(datiTabelloneArrivi[0].getOrigine());
            holder.treno2.setText(datiTabelloneArrivi[1].getOrigine());
            holder.treno3.setText(datiTabelloneArrivi[2].getOrigine());
            holder.treno4.setText(datiTabelloneArrivi[3].getOrigine());
            holder.treno5.setText(datiTabelloneArrivi[4].getOrigine());
            holder.treno6.setText(datiTabelloneArrivi[5].getOrigine());
            holder.treno7.setText(datiTabelloneArrivi[6].getOrigine());
            holder.treno8.setText(datiTabelloneArrivi[7].getOrigine());
            holder.treno9.setText(datiTabelloneArrivi[8].getOrigine());
            holder.treno10.setText(datiTabelloneArrivi[9].getOrigine());
            holder.ora1.setText(datiTabelloneArrivi[0].getCompOrarioArrivo());
            holder.ora2.setText(datiTabelloneArrivi[1].getCompOrarioArrivo());
            holder.ora3.setText(datiTabelloneArrivi[2].getCompOrarioArrivo());
            holder.ora4.setText(datiTabelloneArrivi[3].getCompOrarioArrivo());
            holder.ora5.setText(datiTabelloneArrivi[4].getCompOrarioArrivo());
            holder.ora6.setText(datiTabelloneArrivi[5].getCompOrarioArrivo());
            holder.ora7.setText(datiTabelloneArrivi[6].getCompOrarioArrivo());
            holder.ora8.setText(datiTabelloneArrivi[7].getCompOrarioArrivo());
            holder.ora9.setText(datiTabelloneArrivi[8].getCompOrarioArrivo());
            holder.ora10.setText(datiTabelloneArrivi[9].getCompOrarioArrivo());
        }else{
            holder.treno1.setText(datiTabellonePartenze[0].getDestinazione());
            holder.treno2.setText(datiTabellonePartenze[1].getDestinazione());
            holder.treno3.setText(datiTabellonePartenze[2].getDestinazione());
            holder.treno4.setText(datiTabellonePartenze[3].getDestinazione());
            holder.treno5.setText(datiTabellonePartenze[4].getDestinazione());
            holder.treno6.setText(datiTabellonePartenze[5].getDestinazione());
            holder.treno7.setText(datiTabellonePartenze[6].getDestinazione());
            holder.treno8.setText(datiTabellonePartenze[7].getDestinazione());
            holder.treno9.setText(datiTabellonePartenze[8].getDestinazione());
            holder.treno10.setText(datiTabellonePartenze[9].getDestinazione());
            holder.ora1.setText(datiTabellonePartenze[0].getCompOrarioPartenza());
            holder.ora2.setText(datiTabellonePartenze[1].getCompOrarioPartenza());
            holder.ora3.setText(datiTabellonePartenze[2].getCompOrarioPartenza());
            holder.ora4.setText(datiTabellonePartenze[3].getCompOrarioPartenza());
            holder.ora5.setText(datiTabellonePartenze[4].getCompOrarioPartenza());
            holder.ora6.setText(datiTabellonePartenze[5].getCompOrarioPartenza());
            holder.ora7.setText(datiTabellonePartenze[6].getCompOrarioPartenza());
            holder.ora8.setText(datiTabellonePartenze[7].getCompOrarioPartenza());
            holder.ora9.setText(datiTabellonePartenze[8].getCompOrarioPartenza());
            holder.ora10.setText(datiTabellonePartenze[9].getCompOrarioPartenza());
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
