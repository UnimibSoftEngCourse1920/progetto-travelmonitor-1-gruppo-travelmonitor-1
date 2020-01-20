package com.sviluppotrilo.trilo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
@JsonAdapter(SoluzioneAdapter.class)
public class Soluzione {

    public List<Tratta> tratte;
    private String durata;

    public Soluzione() {
        tratte = new ArrayList<>();
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
        return tratte.size();
    }

    @Override
    public String toString() {
        return "Soluzione [tratte=" + tratte + ", durata=" + durata + "]";
    }

}
