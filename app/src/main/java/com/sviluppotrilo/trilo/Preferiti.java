package com.sviluppotrilo.trilo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Classe relativa ai preferiti dell'utente
public class Preferiti extends AppCompatActivity {

    private Button profilebt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferiti);
        profilebt = findViewById(R.id.profilebt);
        profilebt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul bottone viene aperta la pagina del profilo
                //Intent goToProfile = new Intent(Preferiti.this, Profilo.class);
                //Preferiti.this.startActivity(goToProfile);
            }
        });
    }
}
