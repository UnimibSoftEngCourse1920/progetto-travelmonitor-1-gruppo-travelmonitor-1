package com.sviluppotrilo.trilo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

//classe relativa al menu contenente varie funzionalita
public class Menu extends AppCompatActivity {

    private Button cercaViaggio;
    private Button cercaStazione;
    private Button gestisciPreferiti;
    private Button impostazioni;
    private Button mappe;
    private Button profilo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cercaViaggio = findViewById(R.id.linkcercaviaggio);
        cercaViaggio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul link viene aperta la pagina di ricerca del viaggio
                Intent goToCercaViaggio = new Intent(Menu.this, Soluzione.class); //ATT!
                Menu.this.startActivity(goToCercaViaggio);
            }
        });

        cercaStazione = findViewById(R.id.linkcercastazione);
        cercaStazione.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul link viene aperta la pagina di ricerca di una singola stazione
                Intent goToCercaStazione = new Intent(Menu.this, Stazione.class); //ATT!
                Menu.this.startActivity(goToCercaStazione);
            }
        });

        gestisciPreferiti = findViewById(R.id.linkgestiscipreferiti);
        gestisciPreferiti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul link viene aperta la pagina di gestione dei activity_preferiti
                Intent goToGestisciPreferiti = new Intent(Menu.this, Preferiti.class); //ATT -> rif sbagliato
                Menu.this.startActivity(goToGestisciPreferiti);
            }
        });

        impostazioni = findViewById(R.id.linkimpostazioni);
        impostazioni.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul link viene aperta la pagina di gestione delle impostazioni
                Intent goToImpostazioni = new Intent(Menu.this, Impostazioni.class); //ATT!
                Menu.this.startActivity(goToImpostazioni);
            }
        });

        mappe = findViewById(R.id.linkmappe);
        mappe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul link viene aperta la pagina di visualizzazione delle mappe
                setContentView(R.layout.activity_map);
            }
        });

        profilo = findViewById(R.id.linkprofilo);
        profilo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al click sul link viene aperta la pagina di gestione delle impostazioni
                Intent goToProfilo = new Intent(Menu.this, Profilo.class); //ATT!
                Menu.this.startActivity(goToProfilo);
            }
        });
    }
}
