package com.sviluppotrilo.trilo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyCard> {

    Context context;
    ArrayList<Soluzione> datiSoluzione;

    public MyAdapter(Context c, ArrayList<Soluzione> datiSoluzione) {
        this.context = c;
        this.datiSoluzione = datiSoluzione;
    }

    @NonNull
    @Override
    public MyCard onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_viaggio,null);
        return new MyCard(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCard holder, int i) {
        holder.oraPartenza.setText(datiSoluzione.get(i).getTratte().get(0).getOrarioPartenza());
        int numeroUltimTratta = datiSoluzione.get(i).getTratte().size() - 1;
        holder.oraArrivo.setText(datiSoluzione.get(i).getTratte().get(numeroUltimTratta).getOrarioArrivo());
        /*
        holder.stazionePartenza.setText();
        holder.stazioneArrivo.setText();

         */
    }

    @Override
    public int getItemCount() {
        return datiSoluzione.size();
    }
}

