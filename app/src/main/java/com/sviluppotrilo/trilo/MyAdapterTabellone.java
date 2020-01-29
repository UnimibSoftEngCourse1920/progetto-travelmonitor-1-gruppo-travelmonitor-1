package com.sviluppotrilo.trilo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.Domain.Arrivi;
import com.sviluppotrilo.trilo.Domain.Partenze;
import com.sviluppotrilo.trilo.Domain.Stazione;

import java.util.ArrayList;


public class MyAdapterTabellone extends RecyclerView.Adapter<MyCardTabellone> {

    Context context;
    Arrivi[] datiTabelloneArrivi;
    Partenze[] datiTabellonePartenze;
    Stazione stazione;

    public MyAdapterTabellone(Context c, Stazione stazione, Arrivi[] datiTabelloneArrivi, Partenze[] datiTabellonePartenze) {
        this.context = c;
        this.datiTabelloneArrivi = datiTabelloneArrivi;
        this.datiTabellonePartenze = datiTabellonePartenze;
        this.stazione = stazione;
    }

    @NonNull
    @Override
    public MyCardTabellone onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tabellone, null);
        return new MyCardTabellone(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCardTabellone holder, final int i) {
        ArrayList<Arrivi> arrivi = new ArrayList<>();
        System.out.println("PROVA: "+datiTabelloneArrivi);


        holder.treno1.setText(datiTabelloneArrivi[0].getOrigine());
        holder.treno2.setText(datiTabelloneArrivi[1].getOrigine());
        holder.treno3.setText(datiTabelloneArrivi[2].getOrigine());
        holder.treno4.setText(datiTabelloneArrivi[3].getOrigine());
        holder.treno5.setText(datiTabelloneArrivi[4].getOrigine());
        holder.treno6.setText(datiTabelloneArrivi[5].getOrigine());
        holder.treno7.setText(datiTabelloneArrivi[6].getOrigine());
        holder.treno8.setText(datiTabelloneArrivi[7].getOrigine());
        /*
        holder.ora1.setText((int) arrivi.get(0).getOrarioArrivo());
        holder.ora2.setText((int) arrivi.get(1).getOrarioArrivo());
        holder.ora3.setText((int) arrivi.get(2).getOrarioArrivo());
        holder.ora4.setText((int) arrivi.get(3).getOrarioArrivo());
        holder.ora5.setText((int) arrivi.get(4).getOrarioArrivo());
        holder.ora6.setText((int) arrivi.get(5).getOrarioArrivo());
         */
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
