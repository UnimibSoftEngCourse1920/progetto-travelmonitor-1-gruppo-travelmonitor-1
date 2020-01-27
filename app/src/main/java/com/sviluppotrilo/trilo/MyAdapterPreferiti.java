package com.sviluppotrilo.trilo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.Domain.Soluzione;

import java.util.ArrayList;
import java.util.HashSet;

public class MyAdapterPreferiti extends RecyclerView.Adapter<MyCard> {

    Context context;
    HashSet<Soluzione> datiSoluzione;

    public MyAdapterPreferiti(Context c, HashSet<Soluzione> datiSoluzione) {
        this.context = c;
        this.datiSoluzione = datiSoluzione;

    }

    @NonNull
    @Override
    public MyCard onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_viaggio, null);
        return new MyCard(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCard holder, final int i) {
        ArrayList<Soluzione> soluzione = new ArrayList<>();
        for(Soluzione s: datiSoluzione){
            soluzione.add(s);
        }
        int numeroUltimTratta = soluzione.get(i).getTratte().size() - 1;
        String orarioPartenza = soluzione.get(i).getTratte().get(0).getOrarioPartenza();
        String orarioArrivo = soluzione.get(i).getTratte().get(numeroUltimTratta).getOrarioArrivo();
        String partenza = soluzione.get(i).getTratte().get(0).getOrigine().getNome();
        String arrivo = soluzione.get(i).getTratte().get(0).getDestinazione().getNome();
        holder.oraPartenza.setText(orarioPartenza.substring((orarioPartenza.indexOf("T") + 1), orarioPartenza.indexOf(":00")));
        holder.oraArrivo.setText(orarioArrivo.substring((orarioArrivo.indexOf("T") + 1), orarioArrivo.indexOf(":00")));
        holder.stazionePartenza.setText(partenza);
        holder.stazioneArrivo.setText(arrivo);
        holder.numeroTreno.setText("Treno N: " + soluzione.get(i).getTratte().get(0).getNumeroTreno());
        holder.orarioViaggio.setText(orarioPartenza.substring((orarioPartenza.indexOf("T") + 1), orarioPartenza.indexOf(":00")) + " - "
                + orarioArrivo.substring((orarioArrivo.indexOf("T") + 1), orarioArrivo.indexOf(":00")));

    }

    @Override
    public int getItemCount() {
        return datiSoluzione.size();
    }
}