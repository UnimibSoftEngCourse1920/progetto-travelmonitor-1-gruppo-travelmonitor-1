package com.sviluppotrilo.trilo.controllers;

import com.preference.PowerPreference;

public class ProfiloController {
    private static final String FILENAME ="profilo";
    private static final String NOME ="nome";
    private static final String COGNOME ="cognome";
    private static final String DATA_NASCITA = "dataDiNascita";

public boolean setNome(String nome){
    return PowerPreference.getFileByName(FILENAME).setString(NOME, nome);
}
public boolean setCognome(String cognome){
    return PowerPreference.getFileByName(FILENAME).setString(COGNOME, cognome);
}
public boolean setDataDiNascita(String dataDiNascita){
    return PowerPreference.getFileByName(FILENAME).setString(DATA_NASCITA, dataDiNascita);
}
public String getNome(){
    return PowerPreference.getFileByName(FILENAME).getString(NOME);
}
public String getCognome(){
    return PowerPreference.getFileByName(FILENAME).getString(COGNOME);
}
public String getDataDiNascita(){
    return PowerPreference.getFileByName(FILENAME).getString(DATA_NASCITA);
}
}
