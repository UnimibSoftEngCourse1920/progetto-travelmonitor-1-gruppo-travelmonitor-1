package com.sviluppotrilo.trilo.controllers;

import com.sviluppotrilo.trilo.data.DataBaseHelper;

public class StazioniController {
    DataBaseHelper dataBaseHelper;

    public String[] getStazioni(){
        dataBaseHelper = new DataBaseHelper();
        return dataBaseHelper.selectAllData();
    }
    public String getIdStazione(String nomeStazione){
        return dataBaseHelper.selectIdStazione(nomeStazione);
    }
}
