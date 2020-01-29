package com.sviluppotrilo.trilo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Impostazioni extends AppCompatActivity {

    ImageView back;
    TextView contestonotifica1;
    TextView contestonotifica2;
    TextView contestonotifica3;
    TextView contestonotifica4;


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
