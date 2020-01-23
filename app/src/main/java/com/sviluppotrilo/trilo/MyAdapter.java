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

    Context c;
    ArrayList<Soluzione> datiViaggio;
    CercaViaggio viaggio;

    public void getDati(){
        Controller c = new Controller ();
    };

    public MyAdapter(Context c, ArrayList<Soluzione> datiViaggio) {
        this.c = c;
        this.datiViaggio = datiViaggio;
    }

    @NonNull
    @Override
    public MyCard onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_viaggio,null);
        return new MyCard(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyCard holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

