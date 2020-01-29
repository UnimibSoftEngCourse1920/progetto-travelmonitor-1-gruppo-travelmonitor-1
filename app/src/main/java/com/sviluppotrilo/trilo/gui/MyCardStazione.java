package com.sviluppotrilo.trilo.gui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.R;

public class MyCardStazione extends RecyclerView.ViewHolder {

    TextView nomeStazione;
    TextView idStazione;


    public MyCardStazione(@NonNull View itemView) {
        super(itemView);

        this.nomeStazione = itemView.findViewById(R.id.nomestazione);
        this.idStazione = itemView.findViewById(R.id.idstazione);
    }
}
