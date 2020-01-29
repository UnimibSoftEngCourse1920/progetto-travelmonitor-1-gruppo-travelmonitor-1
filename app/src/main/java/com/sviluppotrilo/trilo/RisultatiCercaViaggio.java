package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.Controller.ViaggioController;
import com.sviluppotrilo.trilo.Domain.Soluzione;
import com.sviluppotrilo.trilo.Domain.Stazione;
import com.sviluppotrilo.trilo.Domain.Viaggio;

import java.util.ArrayList;


public class RisultatiCercaViaggio extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<Soluzione> soluzioni;
    RecyclerView.Adapter adapter;
    ImageView back;
    ImageView backmenu;
    ProgressBar caricamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizzaviaggi);

        back = findViewById(R.id.backpage);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(RisultatiCercaViaggio.this, CercaViaggio.class);
                RisultatiCercaViaggio.this.startActivity(goBack);
            }
        });

        backmenu = findViewById(R.id.backhome);
        backmenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(RisultatiCercaViaggio.this, Preferiti.class);
                RisultatiCercaViaggio.this.startActivity(goBack);
            }
        });

        caricamento = findViewById(R.id.caricamento);

        Intent intent = getIntent();
        final String stazionePartenza = intent.getStringExtra("stazionePartenza");
        final String stazioneArrivo = intent.getStringExtra("stazioneArrivo");
        String idStazionePartenza = intent.getStringExtra("idStazionePartenza");
        String idStazioneArrivo = intent.getStringExtra("idStazioneArrivo");
        String idStazionePartenzaT = idStazionePartenza.replace("S0", "");
        String idStazioneArrivoT = idStazioneArrivo.replace("S0", "");
        final String dataScelta = intent.getStringExtra("dataScelta");
        final String oraScelta = intent.getStringExtra("oraScelta");
        recyclerView = findViewById(R.id.recyclerView);

        final Stazione partenza = new Stazione(stazionePartenza, idStazionePartenzaT);
        final Stazione arrivo = new Stazione(stazioneArrivo,  idStazioneArrivoT);
        new Thread(new Runnable() {
            public void run(){
                ViaggioController c = new ViaggioController();
                Viaggio viaggio = c.cercaViaggio(partenza, arrivo, dataScelta, "T"+oraScelta+":00");
                soluzioni = (ArrayList<Soluzione>) viaggio.getSoluzioni();
                System.out.println(soluzioni);
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        recyclerView.setHasFixedSize(true);
                        adapter = new MyAdapterViaggio(RisultatiCercaViaggio.this, soluzioni, stazionePartenza, stazioneArrivo);
                        caricamento.setVisibility(View.GONE);
                        recyclerView.setLayoutManager(new GridLayoutManager(RisultatiCercaViaggio.this,1));
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();

    }
}
