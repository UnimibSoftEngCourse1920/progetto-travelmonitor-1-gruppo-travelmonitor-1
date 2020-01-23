package com.sviluppotrilo.trilo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.CacheRequest;

public class CercaViaggio extends AppCompatActivity {

    DataBaseHelper myDbHelper;
    String[] myData;
    AutoCompleteTextView autoCom1;
    AutoCompleteTextView autoCom2;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cercaviaggio);
        myDbHelper = new DataBaseHelper(getApplicationContext());
        myDbHelper.createDatabase();
        myData = myDbHelper.selectAllData();
        //stazionepartenza
        autoCom1 = findViewById(R.id.stazionepartenza);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, myData);
        autoCom1.setAdapter(arrayAdapter);
        //stazionearrivo
        autoCom2 = findViewById(R.id.stazionearrivo);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, myData);
        autoCom2.setAdapter(arrayAdapter);
        //data
        CalendarView data = findViewById(R.id.datapartenza);
        long dataSelezionata = data.getDate();
        //ora

    }

    public String getStazionePartenza(){
        return String.valueOf(autoCom1.getText());
    }
}
