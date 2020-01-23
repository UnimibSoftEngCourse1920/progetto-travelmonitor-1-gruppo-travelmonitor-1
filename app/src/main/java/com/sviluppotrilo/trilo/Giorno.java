package com.sviluppotrilo.trilo;

import java.util.HashSet;
import java.util.Set;

public class Giorno {

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

    public void aggiungiPreferito(Soluzione preferito) {
        if(preferito == null)
            return;
        preferiti.add(preferito);
    }

    public void rimuoviPreferito(Soluzione preferito) {
        if(preferito == null)
            return;
        preferiti.remove(preferito);
    }

    @Override
    public String toString() {
        return "Giorno [id=" + id + ", nome=" + nome + ", preferiti=" + preferiti + "]";
    }
}
