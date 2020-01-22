package com.sviluppotrilo.trilo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

//Classe relativa ai activity_preferiti dell'utente
public class Preferiti extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button prova;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferiti);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //menu
        switch (menuItem.getItemId()) {
            case R.id.gestiscipreferiti:
                Toast.makeText(Preferiti.this, "Gestione preferiti Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gestiscinotifiche:
                Toast.makeText(Preferiti.this, "Gestisci notifiche Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.impostazioni:
                Intent goToImpostazioni = new Intent(Preferiti.this, Impostazioni.class);
                Preferiti.this.startActivity(goToImpostazioni);
                break;
            case R.id.profilo:
                Intent goToProfilo = new Intent(Preferiti.this, Profilo.class);
                Preferiti.this.startActivity(goToProfilo);
                break;
            case R.id.socialnetwork:
                Toast.makeText(Preferiti.this, "Social Network Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mappe:
                Intent goToMap = new Intent(Preferiti.this, Mappa.class);
                Preferiti.this.startActivity(goToMap);
                break;
            case R.id.aboutus:
                Toast.makeText(Preferiti.this, "About us Selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }
}