package com.sviluppotrilo.trilo.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.sviluppotrilo.trilo.R;

public class Impostazioni extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);

        findViewById(R.id.textView2).setSelected(true);
        findViewById(R.id.textView3).setSelected(true);
        findViewById(R.id.textView6).setSelected(true);
        findViewById(R.id.textView8).setSelected(true);

        back = findViewById(R.id.backpage);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Impostazioni.this, Preferiti.class);
                Impostazioni.this.startActivity(goBack);
            }
        });
    }
}
