package com.sviluppotrilo.trilo.gui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.DataBaseHelper;
import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.domain.Stazione;

public class CercaStazione extends AppCompatActivity {

    DataBaseHelper myDbHelper;
    String[] myData;
    AutoCompleteTextView autoCom;
    ArrayAdapter arrayAdapter;
    Button cerca;
    String stringaStazione;
    String idStazione;
    ImageView back;
    Boolean valida = false;
    Stazione stazione;

    //Visualizzazione
    RecyclerView recyclerView;
    Stazione soluzione;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cercastazione);

        myDbHelper = new DataBaseHelper(getApplicationContext());
        myDbHelper.createDatabase();
        myData = myDbHelper.selectAllData();

        back = findViewById(R.id.backpage);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(CercaStazione.this, Preferiti.class);
                CercaStazione.this.startActivity(goBack);
            }
        });

        //Stazione
        autoCom = findViewById(R.id.stazionericercata);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, myData);
        autoCom.setAdapter(arrayAdapter);

        stringaStazione = getStazione();

        recyclerView = findViewById(R.id.recyclerView);

        cerca = findViewById(R.id.inviocercastazione);
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < myData.length; i++) {
                    if ((myData[i].equals(autoCom.getText().toString())))
                        valida = true;
                }
                if (valida) {
                    stringaStazione = getStazione();
                    //visualizzazione risultati
                    final String idStazione = getIdStazione(stringaStazione);
                    stazione = new Stazione(stringaStazione, idStazione);
                    new Thread(new Runnable() {
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    recyclerView.setHasFixedSize(true);
                                    adapter = new MyAdapterStazione(CercaStazione.this, stazione);
                                    recyclerView.setLayoutManager(new GridLayoutManager(CercaStazione.this, 1));
                                    recyclerView.setAdapter(adapter);
                                }
                            });
                        }
                    }).start();
                }else {
                    Toast.makeText(CercaStazione.this, "Seleziona stazione proposte", Toast.LENGTH_LONG).show();
                }
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerOnTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Intent intent = new Intent(CercaStazione.this, RisultatiCercaStazione.class);
                intent.putExtra("nomeStazione", stringaStazione);
                intent.putExtra("idStazione", idStazione);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, final int position) {

            }
        }));




    }

    public String getStazione() {
        return String.valueOf(autoCom.getText());
    }

    public String getIdStazione(String stazione) {
        return idStazione = myDbHelper.selectIdStazione(stazione);
    }


}
