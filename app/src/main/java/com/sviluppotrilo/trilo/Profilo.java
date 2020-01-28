package com.sviluppotrilo.trilo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.preference.PowerPreference;

public class Profilo extends AppCompatActivity {

    EditText nome;
    EditText cognome;
    EditText dataN;
    Button salva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);

        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        dataN = findViewById(R.id.datadinascita);
        salva = findViewById(R.id.salvadatiprofilo);

        nome.setText(PowerPreference.getDefaultFile().getString("nome",""));
        cognome.setText(PowerPreference.getDefaultFile().getString("cognome",""));

        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PowerPreference.getDefaultFile()
                        .putString("nome", nome.getText().toString())
                        .putString("cognome", cognome.getText().toString());
            }
        });


    }
}