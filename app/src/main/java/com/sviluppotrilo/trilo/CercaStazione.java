package com.sviluppotrilo.trilo;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.Domain.Stazione;

public class CercaStazione extends AppCompatActivity{

    DataBaseHelper myDbHelper;
    String[] myData;
    AutoCompleteTextView autoCom;
    ArrayAdapter arrayAdapter;
    Button cerca;
    String stringaStazione;
    String idStazione;

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

        //Stazione
        autoCom = findViewById(R.id.stazionericercata);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, myData);
        autoCom.setAdapter(arrayAdapter);

        stringaStazione = getStazione();

        cerca = findViewById(R.id.inviocercastazione);
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringaStazione = getStazione();

                //visualizzazione risultati
                final String IdStazione= getIdStazione(stringaStazione);
                recyclerView = findViewById(R.id.recyclerView);

                final Stazione stazione = new Stazione(stringaStazione, IdStazione);

                new Thread(new Runnable() {
                    public void run(){
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                recyclerView.setHasFixedSize(true);
                                adapter = new MyAdapterStazione(CercaStazione.this, stazione);
                                recyclerView.setLayoutManager(new GridLayoutManager(CercaStazione.this,1));
                                recyclerView.setAdapter(adapter);
                            }
                        });
                    }
                }).start();
            }
        });




    }

    public String getStazione() {
        return String.valueOf(autoCom.getText());
    }

    public String getIdStazione(String stazione) {
        return idStazione = myDbHelper.selectIdStazione(stazione);
    }


}
