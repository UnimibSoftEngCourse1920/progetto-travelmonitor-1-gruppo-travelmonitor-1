package com.sviluppotrilo.trilo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyCardTabellone extends RecyclerView.ViewHolder {

    TextView tipotabellone;
    TextView treno1;
    TextView treno2;
    TextView treno3;
    TextView treno4;
    TextView treno5;
    TextView treno6;
    TextView treno7;
    TextView treno8;
    TextView treno9;
    TextView treno10;
    TextView ora1;
    TextView ora2;
    TextView ora3;
    TextView ora4;
    TextView ora5;
    TextView ora6;
    TextView ora7;
    TextView ora8;
    TextView ora9;
    TextView ora10;


    public MyCardTabellone(@NonNull View itemView) {
        super(itemView);

        this.tipotabellone = itemView.findViewById(R.id.tipotabellone);
        this.treno1 = itemView.findViewById(R.id.treno1);
        this.treno2 = itemView.findViewById(R.id.treno2);
        this.treno3 = itemView.findViewById(R.id.treno3);
        this.treno4 = itemView.findViewById(R.id.treno4);
        this.treno5 = itemView.findViewById(R.id.treno5);
        this.treno6 = itemView.findViewById(R.id.treno6);
        this.treno7 = itemView.findViewById(R.id.treno7);
        this.treno8 = itemView.findViewById(R.id.treno8);
        this.treno9 = itemView.findViewById(R.id.treno9);
        this.treno10 = itemView.findViewById(R.id.treno10);
        this.ora1 = itemView.findViewById(R.id.ora1);
        this.ora2 = itemView.findViewById(R.id.ora2);
        this.ora3 = itemView.findViewById(R.id.ora3);
        this.ora4 = itemView.findViewById(R.id.ora4);
        this.ora5 = itemView.findViewById(R.id.ora5);
        this.ora6 = itemView.findViewById(R.id.ora6);
        this.ora7 = itemView.findViewById(R.id.ora7);
        this.ora8 = itemView.findViewById(R.id.ora8);
        this.ora9 = itemView.findViewById(R.id.ora9);
        this.ora10 = itemView.findViewById(R.id.ora10);


    }
}