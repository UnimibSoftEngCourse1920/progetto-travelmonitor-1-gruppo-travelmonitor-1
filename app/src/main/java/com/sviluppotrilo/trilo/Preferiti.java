package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.sviluppotrilo.trilo.Controller.PreferitiController;
import com.sviluppotrilo.trilo.Domain.RoutineSettimanale;
import com.sviluppotrilo.trilo.Domain.Soluzione;

import java.util.ArrayList;

public class Preferiti extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button cercaviaggio;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    TabLayout tabLayout;
    ArrayList<Soluzione> soluzioni;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferiti);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer);
        tabLayout = findViewById(R.id.tabLayout);
        cercaviaggio = findViewById(R.id.cercabt);


        cercaviaggio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToCercaViaggio = new Intent(Preferiti.this, CercaViaggio.class);
                Preferiti.this.startActivity(goToCercaViaggio);
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int count = tabLayout.getSelectedTabPosition();
                if(count == 0) {

                }
                else {

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.gestiscipreferiti:
                Intent goToPreferiti = new Intent(Preferiti.this, Preferiti.class);
                startActivity(goToPreferiti);
                break;
            case R.id.gestiscinotifiche:
                //Intent goToNotifiche = new Intent(Preferiti.this, Preferiti.class);
                //startActivity(goToNotifiche);
                break;
            case R.id.impostazioni:
                Intent goToImpostazioni = new Intent(Preferiti.this, Impostazioni.class);
                startActivity(goToImpostazioni);
                break;
            case R.id.socialnetwork:
                Intent goToSocial = new Intent(Preferiti.this, Social.class);
                startActivity(goToSocial);
                break;
            case R.id.profilo:
                Intent goToProfilo = new Intent(Preferiti.this, Profilo.class);
                startActivity(goToProfilo);
                break;
            case R.id.mappe:
                Intent goToMappe = new Intent(Preferiti.this, Mappa.class);
                startActivity(goToMappe);
                break;
            case R.id.aboutus:
                //Intent goToAboutUs = new Intent(Preferiti.this, Preferiti.class);
                //startActivity(goToAboutUs);
                break;
            default:
                break;
        }
        return false;
    }
}