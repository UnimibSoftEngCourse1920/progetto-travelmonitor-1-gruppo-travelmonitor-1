package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizzaviaggi);
        Intent intent = getIntent();
        final String stazionePartenza = intent.getStringExtra("stazionePartenza");
        final String stazioneArrivo = intent.getStringExtra("stazioneArrivo");
        String IdStazionePartenza = intent.getStringExtra("IdStazionePartenza");
        String IdStazioneArrivo = intent.getStringExtra("IdStazioneArrivo");
        String IdStazionePartenzaT = IdStazionePartenza.replace("S0", "");
        String IdStazioneArrivoT = IdStazioneArrivo.replace("S0", "");
        final String dataScelta = intent.getStringExtra("dataScelta");
        final String oraScelta = intent.getStringExtra("oraScelta");
        recyclerView = findViewById(R.id.recyclerView);

        final Stazione partenza = new Stazione(stazionePartenza, IdStazionePartenzaT);
        final Stazione arrivo = new Stazione(stazioneArrivo,  IdStazioneArrivoT);
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
                        recyclerView.setLayoutManager(new GridLayoutManager(RisultatiCercaViaggio.this,1));
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();

    }
}
