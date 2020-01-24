package com.sviluppotrilo.trilo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyCard extends RecyclerView.ViewHolder {

    TextView orarioViaggio;
    TextView oraPartenza;
    TextView oraArrivo;
    TextView stazionePartenza;
    TextView stazioneArrivo;
    TextView numeroTreno;
    TextView destinazioneTreno;
    TextView classeTreno;
    TextView binarioTrenoStazPart;


    public MyCard(@NonNull View itemView) {
        super(itemView);

        this.orarioViaggio = itemView.findViewById(R.id.orarioViaggio);
        this.oraPartenza = itemView.findViewById(R.id.orapartenza);
        this.oraArrivo = itemView.findViewById(R.id.oraarrivo);
        this.stazionePartenza = itemView.findViewById(R.id.stazionepartenza);
        this.stazioneArrivo = itemView.findViewById(R.id.stazionearrivo);
        this.numeroTreno = itemView.findViewById(R.id.numerotreno);
        this.destinazioneTreno = itemView.findViewById(R.id.lineatreno);
        this.classeTreno= itemView.findViewById(R.id.stazionearrivo);
        this.binarioTrenoStazPart = itemView.findViewById(R.id.stazionearrivo);
    }
}