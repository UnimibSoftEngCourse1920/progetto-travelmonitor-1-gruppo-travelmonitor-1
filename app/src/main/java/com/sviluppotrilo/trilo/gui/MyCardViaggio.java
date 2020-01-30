package com.sviluppotrilo.trilo.gui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.R;

public class MyCardViaggio extends RecyclerView.ViewHolder {

    TextView orarioViaggio;
    TextView oraPartenza;
    TextView oraArrivo;
    TextView stazionePartenza;
    TextView stazioneArrivo;
    TextView numeroTreno;
    TextView destinazioneTreno;
    TextView classeTreno;
    TextView binarioTrenoStazPart;
    TextView statoTreno;
    ImageView preferito;
    ImageView preferitoSi;
    ImageView trattaOk;
    ImageView trattaNonOk;
    ImageView statusOk;
    ImageView statusNonOk;


    public MyCardViaggio(@NonNull View itemView) {
        super(itemView);

        this.statoTreno = itemView.findViewById(R.id.statoTreno);
        this.orarioViaggio = itemView.findViewById(R.id.orarioViaggio);
        this.oraPartenza = itemView.findViewById(R.id.orapartenza);
        this.oraArrivo = itemView.findViewById(R.id.oraarrivo);
        this.stazionePartenza = itemView.findViewById(R.id.stazionepartenza);
        this.stazioneArrivo = itemView.findViewById(R.id.stazionearrivo);
        this.numeroTreno = itemView.findViewById(R.id.numerotreno);
        this.destinazioneTreno = itemView.findViewById(R.id.lineatreno);
        this.classeTreno= itemView.findViewById(R.id.stazionearrivo);
        this.binarioTrenoStazPart = itemView.findViewById(R.id.stazionearrivo);
        this.preferito = itemView.findViewById(R.id.preferito);
        this.preferitoSi = itemView.findViewById(R.id.setpreferito);
        this.trattaOk = itemView.findViewById(R.id.traccia);
        this.trattaNonOk = itemView.findViewById(R.id.traccia_notok);
        this.statusOk = itemView.findViewById(R.id.imagestato);
        this.statusNonOk = itemView.findViewById(R.id.imagestato_notok);

    }
}
