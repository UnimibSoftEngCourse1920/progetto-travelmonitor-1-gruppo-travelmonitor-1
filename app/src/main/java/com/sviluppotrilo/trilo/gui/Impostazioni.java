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

public class Impostazioni extends AppCompatActivity {

    public static final String FILENAME = "impostazioni";
    public static final String NOTIFICARITARDO = "notificaRitardo";
    public static final String NOTIFICACANCELLAZIONE = "notificaRitardo";
    public static final String NOTIFICAFUORICITTA= "notificaRitardo";
    public static final String NOTIFICAPROMEMORIA = "notificaRitardo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);

        findViewById(R.id.textView2).setSelected(true);
        findViewById(R.id.textView3).setSelected(true);
        findViewById(R.id.textView6).setSelected(true);
        findViewById(R.id.textView8).setSelected(true);

        Switch notificaRitardo = findViewById(R.id.switch1);
        Switch notificaCancellazione = findViewById(R.id.switch2);
        Switch notificaFuoriCitta = findViewById(R.id.switch3);
        Switch notificaPromemoria = findViewById(R.id.switch4);

        notificaRitardo.setChecked(PowerPreference.getFileByName(FILENAME).getBoolean(NOTIFICARITARDO, false));
        notificaCancellazione.setChecked(PowerPreference.getFileByName(FILENAME).getBoolean(NOTIFICACANCELLAZIONE, false));
        notificaFuoriCitta.setChecked(PowerPreference.getFileByName(FILENAME).getBoolean(NOTIFICAFUORICITTA, false));
        notificaPromemoria.setChecked(PowerPreference.getFileByName(FILENAME).getBoolean(NOTIFICAPROMEMORIA, false));

        notificaRitardo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICARITARDO, true);
                }else {
                    PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICARITARDO, false);
                }
            }
        });

        notificaCancellazione.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICACANCELLAZIONE,true);
                else
                    PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICACANCELLAZIONE,false);
            }
        });

        notificaFuoriCitta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICAFUORICITTA,true);
                else
                    PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICAFUORICITTA,false);
            }
        });

        notificaPromemoria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                    PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICAPROMEMORIA,true);
                else
                    PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICAPROMEMORIA,false);
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
