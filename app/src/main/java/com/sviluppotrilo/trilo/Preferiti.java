package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//Classe relativa ai activity_preferiti dell'utente
public class Preferiti extends AppCompatActivity {

    Button cercaviaggio;
    Button prova;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferiti);

        cercaviaggio = findViewById(R.id.cercabt);
        cercaviaggio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul bottone viene aperta la pagina dei ricerca viaggio
                Intent goToCercaViaggio = new Intent(Preferiti.this, CercaViaggio.class);
                Preferiti.this.startActivity(goToCercaViaggio);
            }
        });

        //bottone prova
        prova = findViewById(R.id.prova);
        prova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainActivity = new Intent(Preferiti.this, MainActivity.class);
                Preferiti.this.startActivity(goToMainActivity);
                Log.d("SONO IN prefe ultim", "MSG");
            }
        });

    }

}