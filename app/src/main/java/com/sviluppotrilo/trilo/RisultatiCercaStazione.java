package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.CercaViaggio;
import com.sviluppotrilo.trilo.Controller.ViaggioController;
import com.sviluppotrilo.trilo.Domain.Arrivi;
import com.sviluppotrilo.trilo.Domain.Partenze;
import com.sviluppotrilo.trilo.Domain.Soluzione;
import com.sviluppotrilo.trilo.Domain.Stazione;
import com.sviluppotrilo.trilo.Domain.Viaggio;
import com.sviluppotrilo.trilo.MyAdapterViaggio;
import com.sviluppotrilo.trilo.Preferiti;
import com.sviluppotrilo.trilo.R;

import java.util.ArrayList;


public class RisultatiCercaStazione extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<Arrivi> soluzioniA;
    ArrayList<Partenze> soluzioniP;
    RecyclerView.Adapter adapter;
    Button back;
    TextView nomestazione;
    ProgressBar caricamento;
    String nomeStazione;
    String idStazione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stazione);

        back = findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(com.sviluppotrilo.trilo.RisultatiCercaStazione.this, Preferiti.class);
                com.sviluppotrilo.trilo.RisultatiCercaStazione.this.startActivity(goBack);
            }
        });

        caricamento = findViewById(R.id.caricamento);
        recyclerView = findViewById(R.id.recicleviewtabellone);

        Intent intent = getIntent();
        nomeStazione = intent.getStringExtra("nomeStazione");
        idStazione = intent.getStringExtra("idStazione");


        new Thread(new Runnable() {
            public void run(){
                final Stazione stazione = new Stazione(nomeStazione, idStazione);
                ViaggioController vc = new ViaggioController();
                final Arrivi[] arrivi = vc.cercaTabelloneArrivi(stazione);
                final Partenze[] partenze = vc.cercaTabellonePartenze(stazione);
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            recyclerView.setHasFixedSize(true);
                            adapter = new MyAdapterTabellone(RisultatiCercaStazione.this, stazione, arrivi, partenze);
                            recyclerView.setLayoutManager(new GridLayoutManager(RisultatiCercaStazione.this, 1));
                            recyclerView.setAdapter(adapter);
                        }catch(Exception e){

                        }
                    }
                });
            }
        }).start();

    }
}
