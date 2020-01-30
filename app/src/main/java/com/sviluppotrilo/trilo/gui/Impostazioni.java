package com.sviluppotrilo.trilo.gui;

import android.content.Intent;
import android.content.pm.LauncherApps;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.preference.PowerPreference;
import com.sviluppotrilo.trilo.R;

public class Impostazioni extends AppCompatActivity {

    ImageView back;
    Switch notificaRitardo;
    Switch notificaCancellazione;
    Switch notificaFuoriCitta;
    Switch notificaPromemoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);

        findViewById(R.id.textView2).setSelected(true);
        findViewById(R.id.textView3).setSelected(true);
        findViewById(R.id.textView6).setSelected(true);
        findViewById(R.id.textView8).setSelected(true);


        notificaRitardo = findViewById(R.id.switch1);
        notificaCancellazione = findViewById(R.id.switch2);
        notificaFuoriCitta = findViewById(R.id.switch3);
        notificaPromemoria = findViewById(R.id.switch4);

        notificaRitardo.setChecked(PowerPreference.getFileByName("impostazioni").getBoolean("notificaRitardo", false));
        notificaCancellazione.setChecked(PowerPreference.getFileByName("impostazioni").getBoolean("notificaCancellazione", false));
        notificaFuoriCitta.setChecked(PowerPreference.getFileByName("impostazioni").getBoolean("notificaFuoriCitta", false));
        notificaPromemoria.setChecked(PowerPreference.getFileByName("impostazioni").getBoolean("notificaPromemoria", false));

        notificaRitardo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    PowerPreference.getFileByName("impostazioni").setBoolean("notificaRitardo", true);
                }else {
                    PowerPreference.getFileByName("impostazioni").setBoolean("notificaRitardo", false);
                }
            }
        });

        notificaCancellazione.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    PowerPreference.getFileByName("impostazioni").setBoolean("notificaCancellazione",true);
                else
                    PowerPreference.getFileByName("impostazioni").setBoolean("notificaCancellazione",false);
            }
        });

        notificaFuoriCitta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    PowerPreference.getFileByName("impostazioni").setBoolean("notificaFuoriCitta",true);
                else
                    PowerPreference.getFileByName("impostazioni").setBoolean("notificaFuoriCitta",false);
            }
        });

        notificaPromemoria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    PowerPreference.getFileByName("impostazioni").setBoolean("notificaPromemoria",true);
                else
                    PowerPreference.getFileByName("impostazioni").setBoolean("notificaPromemoria",false);
            }
        });

        back = findViewById(R.id.backpage);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Impostazioni.this, Preferiti.class);
                Impostazioni.this.startActivity(goBack);
            }
        });
    }
}
