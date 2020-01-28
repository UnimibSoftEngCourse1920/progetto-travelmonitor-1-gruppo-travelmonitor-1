package com.sviluppotrilo.trilo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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
import com.sviluppotrilo.trilo.Domain.Soluzione;

import java.util.HashSet;

public class Preferiti extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button cercaviaggio, myprofilo;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    TabLayout tabLayout;
    HashSet<Soluzione> soluzioni;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    PreferitiController preferitiController = new PreferitiController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferiti);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer);
        tabLayout = findViewById(R.id.tabLayout);
        cercaviaggio = findViewById(R.id.cercabt);
        myprofilo = findViewById(R.id.mytrilo);
        recyclerView = findViewById(R.id.recyclerView);

        soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(1);
        recyclerView.setHasFixedSize(true);
        adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
        recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
        recyclerView.setAdapter(adapter);

        cercaviaggio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToCercaViaggio = new Intent(Preferiti.this, CercaViaggio.class);
                Preferiti.this.startActivity(goToCercaViaggio);
            }
        });

        myprofilo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToMyProfilo = new Intent(Preferiti.this, Profilo.class);
                Preferiti.this.startActivity(goToMyProfilo);
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
                    soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(1);
                    recyclerView.setHasFixedSize(true);
                    adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
                    recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
                    recyclerView.setAdapter(adapter);
                }
                if(count == 1) {
                    soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(2);
                    recyclerView.setHasFixedSize(true);
                    adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
                    recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
                    recyclerView.setAdapter(adapter);
                }
                if(count == 2) {
                    soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(3);
                    recyclerView.setHasFixedSize(true);
                    adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
                    recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
                    recyclerView.setAdapter(adapter);
                }
                if(count == 3) {
                    soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(4);
                    recyclerView.setHasFixedSize(true);
                    adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
                    recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
                    recyclerView.setAdapter(adapter);
                }
                if(count == 4) {
                    soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(5);
                    recyclerView.setHasFixedSize(true);
                    adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
                    recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
                    recyclerView.setAdapter(adapter);
                }
                if(count == 5) {
                    soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(6);
                    recyclerView.setHasFixedSize(true);
                    adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
                    recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
                    recyclerView.setAdapter(adapter);
                }
                if(count == 6) {
                    soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(7);
                    recyclerView.setHasFixedSize(true);
                    adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
                    recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Auto-generated method
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Auto-generated method
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerOnTouchListener(this,
                recyclerView, new ClickListener() {
            int count = tabLayout.getSelectedTabPosition();
            @Override
            public void onClick(View view, final int position) {

            }

            @Override
            public void onLongClick(View view, int position) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Preferiti.this, R.style.bannereliminapreferito);
                builder1.setMessage("Vuoi eliminare questo preferito?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Elimina",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                builder1.setNegativeButton(
                        "Annulla",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        }));

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.cercaViaggio:
                Intent goToCercaViaggio = new Intent(Preferiti.this, CercaViaggio.class);
                startActivity(goToCercaViaggio);
                break;
            case R.id.cercaStazione:
                Intent goToCercaStazione = new Intent(Preferiti.this, CercaStazione.class);
                startActivity(goToCercaStazione);
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
                Intent goToAboutUs = new Intent(Preferiti.this, AboutUs.class);
                startActivity(goToAboutUs);
                break;
            default:
                break;
        }
        return false;
    }
}