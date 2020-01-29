package com.sviluppotrilo.trilo.domain;

import com.google.gson.Gson;

import java.util.Arrays;

public class Partenze {
    private String numeroTreno;
    private String categoria;
    private String codOrigine;
    private String destinazione;
    private boolean circolante;
    private int codiceCliente;
    private String binarioProgrammatoPartenzaDescrizione;
    private String binarioEffettivoPartenzaDescrizione;
    private boolean inStazione;
    private long orarioPartenza;
    private int ritardo;
    private String compOrarioPartenza;
    private String compNumeroTreno;

    public String getNumeroTreno() {
        return numeroTreno;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCodOrigine() {
        return codOrigine;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public boolean isCircolante() {
        return circolante;
    }

    public int getCodiceCliente() {
        return codiceCliente;
    }

    public String getBinarioProgrammatoPartenzaDescrizione() {
        return binarioProgrammatoPartenzaDescrizione;
    }

    public String getBinarioEffettivoPartenzaDescrizione() {
        return binarioEffettivoPartenzaDescrizione;
    }

    public boolean isInStazione() {
        return inStazione;
    }

    public long getOrarioPartenza() {
        return orarioPartenza;
    }

    public int getRitardo() {
        return ritardo;
    }

    public String getCompOrarioPartenza() {
        return compOrarioPartenza;
    }

    public String getCompNumeroTreno() {
        return compNumeroTreno;
    }


    @Override
    public String toString() {
        return "[IN PARTENZA, numeroTreno=" + numeroTreno + ", categoria=" + categoria
                +  ", codOrigine=" + codOrigine + ", destinazione=" + destinazione + ", circolante=" + circolante + ", codiceCliente="
                + codiceCliente + ", binarioProgrammatoPartenzaDescrizione=" + binarioProgrammatoPartenzaDescrizione
                + ", binarioEffettivoPartenzaDescrizione=" + binarioEffettivoPartenzaDescrizione + ", inStazione="
                + inStazione + ", orarioPartenza=" + orarioPartenza + ", ritardo="
                + ritardo + ", compOrarioPartenza=" + compOrarioPartenza + ", compNumeroTreno=" + compNumeroTreno + "]";
    }
}
