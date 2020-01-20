package com.sviluppotrilo.trilo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
@JsonAdapter(SoluzioneAdapter.class)
public class Soluzione {

    public List<Tratta> tratte;
    public String durata;

    public Soluzione() {
        tratte = new ArrayList<Tratta>();
    }

    public String getDurata() {
        return durata;
    }
    public void setDurata(String durata) {
        this.durata = durata;
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }

    public int numeroCambi() {
        int numeroCambi = tratte.size();
        return numeroCambi;
    }

    public boolean prevedeCambi() {
        if(numeroCambi() != 1)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Soluzione [tratte=" + tratte + ", durata=" + durata + "]";
    }

}
