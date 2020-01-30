package com.sviluppotrilo.trilo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.sviluppotrilo.trilo.R;

public class Mappa extends AppCompatActivity {

    private TabLayout tabLayout;
    private ImageView mappaTreni;
    private TextView titlemappa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        tabLayout = findViewById(R.id.tabLayout);
        mappaTreni = findViewById(R.id.imagemappa);
        titlemappa = findViewById(R.id.titolomappa);

        mappaTreni.setBackgroundResource(R.drawable.stibm);
        titlemappa.setText("MAPPA STIBM");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int count = tabLayout.getSelectedTabPosition();
                switch(count) {
                    case 0:
                        mappaTreni.setBackgroundResource(R.drawable.stibm);
                        titlemappa.setText("MAPPA STIBM");
                        break;
                    case 1:
                        mappaTreni.setBackgroundResource(R.drawable.linee_regionali);
                        titlemappa.setText("MAPPA LINEE REGIONALI");
                        break;
                    case 2:
                        mappaTreni.setBackgroundResource(R.drawable.metro_milano);
                        titlemappa.setText("METRO MILANO");
                        break;
                    default:
                        Log.d("error", "errore");
                        break;
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

        ImageView back = findViewById(R.id.backpage);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Mappa.this, Preferiti.class);
                Mappa.this.startActivity(goBack);
            }
        });
    }
}
