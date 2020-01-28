package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class VisualizzaStazione extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);

        back = findViewById(R.id.backbutton);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(VisualizzaStazione.this, Preferiti.class);
                VisualizzaStazione.this.startActivity(goBack);
            }
        });
    }
}
