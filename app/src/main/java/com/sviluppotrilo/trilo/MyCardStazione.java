package com.sviluppotrilo.trilo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyCardStazione extends RecyclerView.ViewHolder {

    TextView nomeStazione;
    TextView idStazione;


    public MyCardStazione(@NonNull View itemView) {
        super(itemView);

        this.nomeStazione = itemView.findViewById(R.id.nomestazione);
        this.idStazione = itemView.findViewById(R.id.idstazione);
    }
}
