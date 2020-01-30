package com.sviluppotrilo.trilo.gui;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sviluppotrilo.trilo.data.DataBaseHelper;
import com.sviluppotrilo.trilo.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CercaViaggio extends AppCompatActivity {

    private DataBaseHelper myDbHelper;
    private String[] myData;
    private AutoCompleteTextView autoCom1;
    private AutoCompleteTextView autoCom2;
    private ArrayAdapter arrayAdapter;
    private Button data;
    private Button ora;
    private Button cerca;
    private DatePickerDialog pickerDate;
    private TimePickerDialog pickerTime;
    private ImageView back;
    private Boolean primaValida = false;
    private Boolean secondaValida = false;

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

        back = findViewById(R.id.backpage);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(CercaViaggio.this, Preferiti.class);
                CercaViaggio.this.startActivity(goBack);
            }
        });

        //Data
        data = findViewById(R.id.data);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        data.setText(date);
        ora = findViewById(R.id.ora);
        DateFormat df = new SimpleDateFormat("HH:mm");
        String time = df.format(Calendar.getInstance().getTime());
        ora.setText(time);


        cerca = findViewById(R.id.cerca);
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (autoCom1.getText().toString().equals(autoCom2.getText().toString())) {
                    Toast.makeText(CercaViaggio.this, "Devi inserire due stazioni diverse", Toast.LENGTH_LONG).show();
                } else {
                    if ((autoCom1.getText().toString().equals("")) || (autoCom2.getText().toString().equals(""))) {
                        Toast.makeText(CercaViaggio.this, "Devi inserire entrambe le stazioni", Toast.LENGTH_LONG).show();
                    } else {
                        for(int i = 0; i<myData.length; i++){
                            if((myData[i].equals(autoCom1.getText().toString())))
                                primaValida = true;
                        }
                        for(int i = 0; i<myData.length; i++){
                            if((myData[i].equals(autoCom2.getText().toString())))
                                secondaValida = true;
                        }
                        if (primaValida && secondaValida) {
                            String stazionePartenza = getStazionePartenza();
                            String stazioneArrivo = getStazioneArrivo();
                            String idStazionePartenza = getIdStazione(stazionePartenza);
                            String idStazioneArrivo = getIdStazione(stazioneArrivo);
                            String dataScelta = (String) data.getText();
                            String oraScelta = (String) ora.getText();
                            Intent intent = new Intent(CercaViaggio.this, RisultatiCercaViaggio.class);
                            intent.putExtra("stazionePartenza", stazionePartenza);
                            intent.putExtra("stazioneArrivo", stazioneArrivo);
                            intent.putExtra("idStazionePartenza", idStazionePartenza);
                            intent.putExtra("idStazioneArrivo", idStazioneArrivo);
                            intent.putExtra("dataScelta", dataScelta);
                            intent.putExtra("oraScelta", oraScelta);
                            startActivity(intent);
                        } else {
                            Toast.makeText(CercaViaggio.this, "Seleziona stazioni proposte", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                final int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                pickerDate = new DatePickerDialog(CercaViaggio.this, R.style.MyDatePickerStyle,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String monthFix = String.valueOf(monthOfYear + 1);
                                if (monthFix.length() == 1)
                                    monthFix = "0" + (monthFix);
                                String dayFix = String.valueOf(dayOfMonth);
                                if (dayFix.length() == 1)
                                    dayFix = "0" + (dayFix);
                                data.setText(year + "-" + (monthFix) + "-" + dayFix);
                            }
                        }, year, month, day);
                pickerDate.show();
            }
        });
        ora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                pickerTime = new TimePickerDialog(CercaViaggio.this, R.style.MyTimePickerStyle,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                String sHourFix = String.valueOf(sHour);
                                if (sHourFix.length() == 1)
                                    sHourFix = "0" + (sHourFix);
                                String sMinuteFix = String.valueOf(sMinute);
                                if (sMinuteFix.length() == 1)
                                    sMinuteFix = "0" + (sMinuteFix);
                                ora.setText(sHourFix + ":" + sMinuteFix);
                            }
                        }, hour, minutes, true);
                pickerTime.show();
            }
        });

    }

    public String getStazionePartenza() {
        return String.valueOf(autoCom1.getText());
    }

    public String getStazioneArrivo() {
        return String.valueOf(autoCom2.getText());
    }

    public String getIdStazione(String stazione) {
        return myDbHelper.selectIdStazione(stazione);
    }



}
