package com.sviluppotrilo.trilo.gui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.R;

public class MyCardTabellone extends RecyclerView.ViewHolder {

    TextView treno;
    TextView ora;
    TextView binario;


    public MyCardTabellone(@NonNull View itemView) {
        super(itemView);

        this.treno = itemView.findViewById(R.id.treno);
        this.ora = itemView.findViewById(R.id.ora);
        this.binario = itemView.findViewById(R.id.binario);
        itemView.findViewById(R.id.treno).setSelected(true);

    }
}