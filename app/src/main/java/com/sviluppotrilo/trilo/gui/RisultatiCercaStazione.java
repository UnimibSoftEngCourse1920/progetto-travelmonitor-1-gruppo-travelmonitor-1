package com.sviluppotrilo.trilo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.domain.Arrivi;
import com.sviluppotrilo.trilo.domain.Partenze;
import com.sviluppotrilo.trilo.domain.Stazione;


public class RisultatiCercaStazione extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private String nomeStazione;
    private String idStazione;
    private TabLayout tabLayout;
    ProgressBar caricamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stazione);

        Button back = findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(RisultatiCercaStazione.this, Preferiti.class);
                RisultatiCercaStazione.this.startActivity(goBack);
            }
        });

        caricamento = findViewById(R.id.caricamento);
        recyclerView = findViewById(R.id.recicleviewtabellone);
        TextView nomeStazioneCorrente = findViewById(R.id.nomestazionecorrente);
        Intent intent = getIntent();
        nomeStazione = intent.getStringExtra("nomeStazione");
        idStazione = intent.getStringExtra("idStazione");
        nomeStazioneCorrente.setText(nomeStazione);
        tabLayout = findViewById(R.id.tabLayout);


        new Thread(new Runnable() {
            public void run(){
                final Stazione stazione = new Stazione(nomeStazione, idStazione);
                final Arrivi[] arrivi = stazione.cercaArrivi();
                final Partenze[] partenze = stazione.cercaPartenze();
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        int pos = 0;
                        recyclerView.setHasFixedSize(true);
                        adapter = new MyAdapterTabellone(RisultatiCercaStazione.this, stazione, arrivi, partenze, pos);
                        caricamento.setVisibility(View.GONE);
                        recyclerView.setLayoutManager(new GridLayoutManager(RisultatiCercaStazione.this, 1));
                        recyclerView.setAdapter(adapter);
                        try {
                            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                                @Override
                                public void onTabSelected(TabLayout.Tab tab) {
                                    int count = tabLayout.getSelectedTabPosition();
                                    if(count == 0) {
                                        int pos = 0;
                                        recyclerView.setHasFixedSize(true);
                                        adapter = new MyAdapterTabellone(RisultatiCercaStazione.this, stazione, arrivi, partenze, pos);
                                        recyclerView.setLayoutManager(new GridLayoutManager(RisultatiCercaStazione.this, 1));
                                        recyclerView.setAdapter(adapter);
                                    }
                                    else {
                                        int pos = 1;
                                        recyclerView.setHasFixedSize(true);
                                        adapter = new MyAdapterTabellone(RisultatiCercaStazione.this, stazione, arrivi, partenze, pos);
                                        recyclerView.setLayoutManager(new GridLayoutManager(RisultatiCercaStazione.this, 1));
                                        recyclerView.setAdapter(adapter);
                                    }
                                }
                                @Override
                                public void onTabUnselected(TabLayout.Tab tab) {
                                    // Auto-generated method
                                }

                                @Override
                                public void onTabReselected(TabLayout.Tab tab) {
                                    // Auto-generated method
                                }
                            });

                        }catch(Exception e){
                            Log.d("error", "errore, cattura dell'eccezione");
                        }
                    }
                });
            }
        }).start();

    }
}
