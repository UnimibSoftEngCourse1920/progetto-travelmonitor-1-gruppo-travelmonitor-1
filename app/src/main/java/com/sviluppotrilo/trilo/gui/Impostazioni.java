package com.sviluppotrilo.trilo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.preference.PowerPreference;
import com.sviluppotrilo.trilo.R;
import com.sviluppotrilo.trilo.controllers.NotificheController;

public class Impostazioni extends AppCompatActivity {
    NotificheController notificheController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);

        notificheController = new NotificheController();

        findViewById(R.id.textView2).setSelected(true);
        findViewById(R.id.textView3).setSelected(true);
        findViewById(R.id.textView6).setSelected(true);
        findViewById(R.id.textView8).setSelected(true);

        Switch notificaRitardo = findViewById(R.id.switch1);
        Switch notificaCancellazione = findViewById(R.id.switch2);
        Switch notificaFuoriCitta = findViewById(R.id.switch3);
        Switch notificaPromemoria = findViewById(R.id.switch4);

        notificaRitardo.setChecked(notificheController.getNotificaRitardo());
        notificaCancellazione.setChecked(notificheController.getNotificaCancellazione());
        notificaFuoriCitta.setChecked(notificheController.getNotificaFuoriCitta());
        notificaPromemoria.setChecked(notificheController.getNotificaPromemoria());

        notificaRitardo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    notificheController.setNotificaRitardo(true);
                }else {
                    notificheController.setNotificaRitardo(false);
                }
            }
        });

        notificaCancellazione.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    notificheController.setNotificaCancellazione(true);
                else
                    notificheController.setNotificaCancellazione(false);
            }
        });

        notificaFuoriCitta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    notificheController.setNotificaFuoriCitta(true);
                else
                    notificheController.setNotificaFuoriCitta(false);
            }
        });

        notificaPromemoria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    notificheController.setNotificaPromemoria(true);
                else
                    notificheController.setNotificaPromemoria(false);
            }
        });

        ImageView back = findViewById(R.id.backpage);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Impostazioni.this, Preferiti.class);
                Impostazioni.this.startActivity(goBack);
            }
        });
    }
}
