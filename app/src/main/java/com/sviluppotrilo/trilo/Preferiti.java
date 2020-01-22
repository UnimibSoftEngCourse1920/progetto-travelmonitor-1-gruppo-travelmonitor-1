package com.sviluppotrilo.trilo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Classe relativa ai activity_preferiti dell'utente
public class Preferiti extends AppCompatActivity {

    private Button profilebt;
    private Button menubt;
    private Button prova;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferiti);

        //bottone profilo
        profilebt = findViewById(R.id.profilebt);
        profilebt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul bottone viene aperta la pagina del profilo
                Intent goToProfile = new Intent(Preferiti.this, Profilo.class);
                Preferiti.this.startActivity(goToProfile);
            }
        });

        //bottone menu
        menubt = findViewById(R.id.menubt);
        menubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMenu = new Intent(Preferiti.this, Menu.class);
                Preferiti.this.startActivity(goToMenu);
            }
        });

        //bottone prova
        prova = findViewById(R.id.prova);
        prova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToProva = new Intent(Preferiti.this, MainActivity.class);
                Preferiti.this.startActivity(goToProva);
            }
        });
    }
}
