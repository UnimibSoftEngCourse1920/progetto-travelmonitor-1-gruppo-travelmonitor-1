package com.sviluppotrilo.trilo.gui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.domain.Arrivi;
import com.sviluppotrilo.trilo.domain.Partenze;
import com.sviluppotrilo.trilo.domain.Stazione;


public class MyAdapterTabellone extends RecyclerView.Adapter<MyCardTabellone> {

    Context context;
    private Arrivi[] datiTabelloneArrivi;
    private Partenze[] datiTabellonePartenze;
    Stazione stazione;

    private int pos = 0;

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
        switch(pos) {
            case 0:
                holder.treno.setText(datiTabellonePartenze[i].getDestinazione());
                holder.ora.setText(datiTabellonePartenze[i].getCompOrarioPartenza());
                if (datiTabellonePartenze[i].isInStazione()){
                    if (datiTabellonePartenze[i].getBinarioEffettivoPartenzaDescrizione() == null)
                        holder.binario.setText("Binario sconosciuto");
                    else
                        holder.binario.setText("E' in stazione, binario " + datiTabellonePartenze[i].getBinarioEffettivoPartenzaDescrizione());
                } else {
                    if (datiTabellonePartenze[i].getBinarioProgrammatoPartenzaDescrizione() == null)
                        holder.binario.setText("Binario sconosciuto");
                    else
                        holder.binario.setText("Partirà dal binario " + datiTabellonePartenze[i].getBinarioProgrammatoPartenzaDescrizione());
                }
                break;
            case 1:
                holder.treno.setText(datiTabelloneArrivi[i].getOrigine());
                holder.ora.setText(datiTabelloneArrivi[i].getCompOrarioArrivo());
                if(datiTabelloneArrivi[i].isInStazione()) {
                    if (datiTabelloneArrivi[i].getBinarioEffettivoArrivoDescrizione() == null)
                        holder.binario.setText("Binario sconosciuto");
                    else
                        holder.binario.setText("E' in stazione, binario " + datiTabelloneArrivi[i].getBinarioEffettivoArrivoDescrizione());
                } else {
                    if (datiTabelloneArrivi[i].getBinarioProgrammatoArrivoDescrizione() == null)
                        holder.binario.setText("Binario sconosciuto");
                    else
                        holder.binario.setText("Arriverà al binario " + datiTabelloneArrivi[i].getBinarioProgrammatoArrivoDescrizione());
                }
                break;
            default:
                Log.d("error", "errore");
                break;
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
