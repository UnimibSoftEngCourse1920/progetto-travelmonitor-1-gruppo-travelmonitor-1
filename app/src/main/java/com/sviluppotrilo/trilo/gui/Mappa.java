package com.sviluppotrilo.trilo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.sviluppotrilo.trilo.R;

public class Mappa extends AppCompatActivity {

    TabLayout tabLayout;
    ImageView mappa;
    TextView titlemappa;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        tabLayout = findViewById(R.id.tabLayout);
        mappa = findViewById(R.id.imagemappa);
        titlemappa = findViewById(R.id.titolomappa);

        mappa.setBackgroundResource(R.drawable.stibm);
        titlemappa.setText("MAPPA STIBM");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int count = tabLayout.getSelectedTabPosition();
                if(count == 0) {
                    mappa.setBackgroundResource(R.drawable.stibm);
                    titlemappa.setText("MAPPA STIBM");
                }
                else {
                    mappa.setBackgroundResource(R.drawable.linee_regionali);
                    titlemappa.setText("MAPPA LINEE REGIONALI");

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

        back = findViewById(R.id.backpage);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Mappa.this, Preferiti.class);
                Mappa.this.startActivity(goBack);
            }
        });
    }
}
