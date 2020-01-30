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

import com.sviluppotrilo.trilo.data.DataBaseHelper;
import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.domain.Stazione;

public class CercaStazione extends AppCompatActivity {

    private DataBaseHelper myDbHelper;
    private String[] myData;
    private AutoCompleteTextView autoCom;
    private ArrayAdapter arrayAdapter;
    private Button cerca;
    private String stringaStazione;
    private String idStazione;
    private ImageView back;
    private Boolean valida = false;
    private Stazione stazione;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


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
                if (Boolean.TRUE.equals(valida)) {
                    stringaStazione = getStazione();
                    //visualizzazione risultati
                    idStazione = getIdStazione(stringaStazione);
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
                //Auto generated method
            }
        }));




    }

    public String getStazione() {
        return String.valueOf(autoCom.getText());
    }

    public String getIdStazione(String stazione) {
        return myDbHelper.selectIdStazione(stazione);
    }


}
