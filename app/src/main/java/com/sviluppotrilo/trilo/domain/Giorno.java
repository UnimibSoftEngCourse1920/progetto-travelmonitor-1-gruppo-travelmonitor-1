package com.sviluppotrilo.trilo.domain;

import com.preference.PowerPreference;
import java.util.HashSet;
import java.util.Set;

public class Giorno{

    private int id;
    private String nome;
    private Set<Soluzione> preferiti;

    public Giorno(){

    }

    public Giorno(int id, String nome) {
        this.id = id;
        this.nome = nome;
        preferiti = new HashSet<>();
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized String getNome() {
        return nome;
    }

    public synchronized Set<Soluzione> getPreferiti() {
        return preferiti;
    }

    public synchronized void aggiungiPreferito(Soluzione preferito) throws PreferitiException{
        if(preferito == null)
            throw new PreferitiException("Non si può aggiungere un oggetto nullo ai preferiti");
        preferiti.add(preferito);
        update();
    }

    public synchronized void rimuoviPreferito(Soluzione preferito) throws PreferitiException{
        if(preferito == null)
            throw new PreferitiException("Non si può eliminare un oggetto nullo dai preferiti");
        preferiti.remove(preferito);
        update();
    }

    private synchronized void update() throws PreferitiException{
        boolean result = PowerPreference.getDefaultFile().setObject(getNome(), this);
        if(!result)
            throw new PreferitiException("Update dei preferiti fallito");
    }

    @Override
    public synchronized String toString() {
        return "Giorno [id=" + id + ", nome=" + nome + ", preferiti=" + preferiti + "]";
    }

    public synchronized void controllaSoluzioni(){
        for (Soluzione preferito: preferiti) {
            preferito.controllaTratte();
        }
    }
}
