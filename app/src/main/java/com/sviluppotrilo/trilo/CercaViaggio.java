package com.sviluppotrilo.trilo;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CercaViaggio extends AppCompatActivity {

    DataBaseHelper myDbHelper;
    String[] myData;
    AutoCompleteTextView autoCom1;
    AutoCompleteTextView autoCom2;
    ArrayAdapter arrayAdapter;
    Button data;
    Calendar calendar;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cercaviaggio);
        myDbHelper = new DataBaseHelper(getApplicationContext());
        myDbHelper.createDatabase();
        myData = myDbHelper.selectAllData();

        //Stazionepartenza
        autoCom1 = findViewById(R.id.stazionepartenza);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, myData);
        autoCom1.setAdapter(arrayAdapter);

        //Stazionearrivo
        autoCom2 = findViewById(R.id.stazionearrivo);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, myData);
        autoCom2.setAdapter(arrayAdapter);

        //Data
        data = findViewById(R.id.data);
        String date = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new Date());
        data.setText(date);

        /*
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.getInstance();
                int giorno = calendar.get(Calendar.DAY_OF_MONTH);
                int mese = calendar.get(Calendar.MONTH);
                int anno = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(CercaViaggio.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int a, int m, int g) {
                        data.setText(g + "-" +(m+1)+ "-" + a);
                    }
                }, anno, mese, giorno);
                datePickerDialog.show();

            }
        });

        */

    }

    public String getStazionePartenza() {
        return String.valueOf(autoCom1.getText());
    }

    public String getStazioneArrivo() {
        return String.valueOf(autoCom2.getText());
    }


    Controller c = new Controller();
    //Viaggio v = new Viaggio(c.cercaViaggio(getStazionePartenza(), getStazioneArrivo(), "24-01-20", "11:00"));
}
