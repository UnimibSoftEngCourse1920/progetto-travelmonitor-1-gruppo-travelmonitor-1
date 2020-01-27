package com.sviluppotrilo.trilo.Domain;

import android.os.AsyncTask;
import android.util.Log;

import com.preference.PowerPreference;

import java.util.HashSet;
import java.util.Set;

public class Giorno{

    private int id;
    private String nome;
    private Set<Soluzione> preferiti;

    public Giorno(int id, String nome) {
        this.id = id;
        this.nome = nome;
        preferiti = new HashSet<Soluzione>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<Soluzione> getPreferiti() {
        return preferiti;
    }

    public void aggiungiPreferito(Soluzione preferito) throws Exception{
        if(preferito == null)
            return;
        preferiti.add(preferito);
        update();
    }

    public void rimuoviPreferito(Soluzione preferito) throws Exception{
        if(preferito == null)
            return;
        preferiti.remove(preferito);
        update();
    }

    private void update() throws Exception{
        boolean result = PowerPreference.getDefaultFile().setObject(getNome(), this);
        if(!result)
            throw new Exception("Update dei preferiti fallito");
    }

    @Override
    public String toString() {
        return "Giorno [id=" + id + ", nome=" + nome + ", preferiti=" + preferiti + "]";
    }

    public void controllaSoluzioni(){
        for (Soluzione s: preferiti) {
            s.controllaTratte();
        }
    }

}
