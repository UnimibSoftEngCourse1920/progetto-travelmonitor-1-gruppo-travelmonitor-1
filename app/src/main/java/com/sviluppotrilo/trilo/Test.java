package com.sviluppotrilo.trilo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class Test extends Activity {

    DataBaseHelper myDbHelper;
    String[] myData;
    AutoCompleteTextView autoCom;
    ArrayAdapter arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        myDbHelper = new DataBaseHelper(getApplicationContext());
        myDbHelper.createDatabase();
        myData = myDbHelper.selectAllData();
        autoCom = findViewById(R.id.stazione);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, myData);
        autoCom.setAdapter(arrayAdapter);
    }
}
