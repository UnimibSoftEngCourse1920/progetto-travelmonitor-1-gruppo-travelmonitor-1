package com.sviluppotrilo.trilo.gui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.controllers.PreferitiController;
import com.sviluppotrilo.trilo.domain.Soluzione;

import java.util.ArrayList;
import java.util.HashSet;

public class Preferiti extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    
    private TabLayout tabLayout;
    private HashSet<Soluzione> soluzioni;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private PreferitiController preferitiController = new PreferitiController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferiti);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.navigation);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        tabLayout = findViewById(R.id.tabLayout);
        Button cercaviaggio = findViewById(R.id.cercabt);
        Button myprofilo = findViewById(R.id.mytrilo);
        recyclerView = findViewById(R.id.recyclerView);

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
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                soluzioni = (HashSet<Soluzione>) preferitiController.visualizzaPreferiti(tab.getPosition()+1);
                recyclerView.setHasFixedSize(true);
                adapter = new MyAdapterPreferiti(Preferiti.this, soluzioni);
                recyclerView.setLayoutManager(new GridLayoutManager(Preferiti.this,1));
                recyclerView.setAdapter(adapter);
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
            @Override
            public void onClick(View view, final int position) {
                // Auto-generated method
            }

            @Override
            public void onLongClick(View view, final int position) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Preferiti.this, R.style.bannereliminapreferito);
                builder1.setMessage("Vuoi eliminare questo preferito?");
                builder1.setCancelable(true);
                final ArrayList<Soluzione> preferiti = new ArrayList<>();
                for(Soluzione s : soluzioni){
                    preferiti.add(s);
                }
                builder1.setPositiveButton(
                        "Elimina",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if(tabLayout.getSelectedTabPosition() == 0) {
                                    preferitiController.eliminaPreferito(1,preferiti.get(position));
                                    adapter.notifyDataSetChanged();
                                }
                                if(tabLayout.getSelectedTabPosition() == 1) {
                                    preferitiController.eliminaPreferito(2,preferiti.get(position));
                                    adapter.notifyDataSetChanged();
                                }
                                if(tabLayout.getSelectedTabPosition() == 2) {
                                    preferitiController.eliminaPreferito(3,preferiti.get(position));
                                    adapter.notifyDataSetChanged();
                                }
                                if(tabLayout.getSelectedTabPosition() == 3) {
                                    preferitiController.eliminaPreferito(4,preferiti.get(position));
                                    adapter.notifyDataSetChanged();
                                }
                                if(tabLayout.getSelectedTabPosition() == 4) {
                                    preferitiController.eliminaPreferito(5,preferiti.get(position));
                                    adapter.notifyDataSetChanged();
                                }
                                if(tabLayout.getSelectedTabPosition() == 5) {
                                    preferitiController.eliminaPreferito(6,preferiti.get(position));
                                    adapter.notifyDataSetChanged();
                                }
                                if(tabLayout.getSelectedTabPosition() == 6) {
                                    preferitiController.eliminaPreferito(7,preferiti.get(position));
                                    adapter.notifyDataSetChanged();
                                }
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

        //tutorial del primo avvio
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart) {
            showStartDialog();
        }
        //fine del tutorial

    }

    //tutorial del primo avvio
    private void showStartDialog(){
        new AlertDialog.Builder(this, R.style.bannerscegligiornipreferiti)
                .setTitle("BENVENUTO IN TRILO")
                .setMessage("Trilo è un'app che ti permette di avere sotto controllo i tuoi viaggi. Cerca un viaggio, clicca il cuore e salvalo nei giorni che vuoi!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
    //fine metodo tutorial


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