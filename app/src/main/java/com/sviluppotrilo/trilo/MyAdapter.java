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
    String partenza;
    String arrivo;

    public MyAdapter(Context c, ArrayList<Soluzione> datiSoluzione, String partenza, String arrivo) {
        this.context = c;
        this.datiSoluzione = datiSoluzione;
        this.partenza = partenza;
        this.arrivo = arrivo;
    }

    @NonNull
    @Override
    public MyCard onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_viaggio,null);
        return new MyCard(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCard holder, int i) {
        int numeroUltimTratta = datiSoluzione.get(i).getTratte().size() - 1;
        String orarioPartenza = datiSoluzione.get(i).getTratte().get(0).getOrarioPartenza();
        String orarioArrivo = datiSoluzione.get(i).getTratte().get(numeroUltimTratta).getOrarioArrivo();

        holder.oraPartenza.setText(orarioPartenza.substring((orarioPartenza.indexOf("T")+1),orarioPartenza.indexOf(":00")));
        holder.oraArrivo.setText(orarioArrivo.substring((orarioArrivo.indexOf("T")+1),orarioArrivo.indexOf(":00")));
        holder.stazionePartenza.setText(partenza);
        holder.stazioneArrivo.setText(arrivo);
        holder.numeroTreno.setText("Treno N: "+datiSoluzione.get(i).getTratte().get(0).getNumeroTreno());
        holder.orarioViaggio.setText(orarioPartenza.substring((orarioPartenza.indexOf("T")+1),orarioPartenza.indexOf(":00"))+" - "
                        +orarioArrivo.substring((orarioArrivo.indexOf("T")+1),orarioArrivo.indexOf(":00")));
    }

    @Override
    public int getItemCount() {
        return datiSoluzione.size();
    }
}

