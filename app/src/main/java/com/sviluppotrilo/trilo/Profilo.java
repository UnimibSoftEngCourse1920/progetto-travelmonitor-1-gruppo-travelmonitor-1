package com.sviluppotrilo.trilo;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.preference.PowerPreference;

import java.util.Calendar;

public class Profilo extends AppCompatActivity {

    EditText nome;
    EditText cognome;
    Button dataN;
    Button salva;
    DatePickerDialog pickerDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);

        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        dataN = findViewById(R.id.datanascita);
        salva = findViewById(R.id.salvadatiprofilo);

        nome.setText(PowerPreference.getDefaultFile().getString("nome",""));
        cognome.setText(PowerPreference.getDefaultFile().getString("cognome",""));
        dataN.setText(PowerPreference.getDefaultFile().getString("datanascita",""));

        dataN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                final int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                pickerDate = new DatePickerDialog(Profilo.this,R.style.MyDatePickerStyle,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String monthFix= String.valueOf(monthOfYear+1);
                                if(monthFix.length()==1)
                                    monthFix= "0"+(monthFix);
                                String dayFix= String.valueOf(dayOfMonth);
                                if(dayFix.length()==1)
                                    dayFix= "0"+(dayFix);
                                dataN.setText(year +"-"+(monthFix)+"-"+dayFix);
                            }
                        }, year, month, day);
                pickerDate.show();
            }
        });

        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PowerPreference.getDefaultFile()
                        .putString("nome", nome.getText().toString())
                        .putString("cognome", cognome.getText().toString())
                        .putString("dataNascita", dataN.getText().toString());
            }
        });


    }
}