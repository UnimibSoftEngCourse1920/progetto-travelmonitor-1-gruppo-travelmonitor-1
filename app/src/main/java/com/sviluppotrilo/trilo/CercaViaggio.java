package com.sviluppotrilo.trilo;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class CercaViaggio extends AppCompatActivity{

    DataBaseHelper myDbHelper;
    String[] myData;
    AutoCompleteTextView autoCom1;
    AutoCompleteTextView autoCom2;
    ArrayAdapter arrayAdapter;
    Button data, ora,cerca;
    Calendar calendar;
    DatePickerDialog pickerDate;
    TimePickerDialog pickerTime;
    private int mYear, mMonth, mDay;


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
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        data.setText(date);
        ora = findViewById(R.id.ora);
        DateFormat df = new SimpleDateFormat("HH:mm");
        String time = df.format(Calendar.getInstance().getTime());
        ora.setText(time);


        new Thread(new Runnable() {
            public void run() {

            }
        }).start();

        cerca = findViewById(R.id.cerca);
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stazionePartenza = getStazionePartenza();
                String stazioneArrivo = getStazioneArrivo();
                String IdStazionePartenza = getIdStazionePartenza(stazionePartenza);
                String IdStazioneArrivo = getIdStazioneArrivo(stazioneArrivo);
                String dataScelta = (String) data.getText();
                String oraScelta = (String) ora.getText();
                Intent intent = new Intent(CercaViaggio.this, RisultatiCercaViaggio.class);
                intent.putExtra("stazionePartenza", stazionePartenza);
                intent.putExtra("stazioneArrivo", stazioneArrivo);
                intent.putExtra("IdStazionePartenza", IdStazionePartenza);
                intent.putExtra("IdStazioneArrivo", IdStazioneArrivo);
                intent.putExtra("dataScelta", dataScelta);
                intent.putExtra("oraScelta", oraScelta);
                startActivity(intent);
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
                pickerDate = new DatePickerDialog(CercaViaggio.this,R.style.MyDatePickerStyle,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String monthFix= String.valueOf(monthOfYear+1);
                                if(monthFix.length()==1)
                                    monthFix= "0"+(monthFix);
                                String dayFix= String.valueOf(dayOfMonth);
                                if(dayFix.length()==1)
                                    dayFix= "0"+(dayFix);
                                data.setText(year +"-"+(monthFix)+"-"+dayFix);
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
                pickerTime = new TimePickerDialog(CercaViaggio.this,R.style.MyTimePickerStyle,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                String sHourFix= String.valueOf(sHour);
                                if(sHourFix.length()==1)
                                    sHourFix= "0"+(sHourFix);
                                String sMinuteFix= String.valueOf(sMinute);
                                if(sMinuteFix.length()==1)
                                    sMinuteFix= "0"+(sMinuteFix);
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

    public String getIdStazionePartenza(String partenza) {
        String idPartenza = myDbHelper.selectIdPartenza(partenza);
        return idPartenza;
    }

    public String getIdStazioneArrivo(String arrivo) {
        String idArrivo = myDbHelper.selectIdArrivo(arrivo);
        return idArrivo;
    }


}
