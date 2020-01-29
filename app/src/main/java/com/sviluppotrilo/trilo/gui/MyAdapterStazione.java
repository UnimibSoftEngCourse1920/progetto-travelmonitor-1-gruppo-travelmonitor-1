package com.sviluppotrilo.trilo.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.domain.Stazione;


public class MyAdapterStazione extends RecyclerView.Adapter<MyCardStazione> {

    Context context;
    Stazione datiStazione;

    public MyAdapterStazione(Context c, Stazione datiStazione) {
        this.context = c;
        this.datiStazione = datiStazione;
    }

    @NonNull
    @Override
    public MyCardStazione onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_stazione, null);
        return new MyCardStazione(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCardStazione holder, final int i) {
        String stazione = datiStazione.getNome();
        String idStazione = datiStazione.getId();

        holder.nomeStazione.setText(stazione);
        holder.idStazione.setText(idStazione);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}

