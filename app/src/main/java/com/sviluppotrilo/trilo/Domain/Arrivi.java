package com.sviluppotrilo.trilo.Domain;

import com.google.gson.Gson;

import java.util.Arrays;

public class Arrivi {

    private String numeroTreno;
    private String categoria;
    private String codOrigine;
    private String origine;
    private boolean circolante;
    private int codiceCliente;
    private String binarioProgrammatoArrivoDescrizione;
    private String binarioEffettivoArrivoDescrizione;
    private boolean inStazione;
    private long orarioArrivo; // orario di arrivo in formato intero
    private int ritardo;
    private String compOrarioArrivo;
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

    public String getOrigine() {
        return origine;
    }

    public boolean isCircolante() {
        return circolante;
    }

    public int getCodiceCliente() {
        return codiceCliente;
    }

    public String getBinarioProgrammatoArrivoDescrizione() {
        return binarioProgrammatoArrivoDescrizione;
    }

    public String getBinarioEffettivoArrivoDescrizione() {
        return binarioEffettivoArrivoDescrizione;
    }

    public boolean isInStazione() {
        return inStazione;
    }

    public long getOrarioArrivo() {
        return orarioArrivo;
    }

    public int getRitardo() {
        return ritardo;
    }

    public String getCompOrarioArrivo() {
        return compOrarioArrivo;
    }

    public String getCompNumeroTreno() {
        return compNumeroTreno;
    }

    public static Arrivi[] find(Stazione stazionePartenza) throws Exception {
        CurrentDateTime time = new CurrentDateTime();
        String jsonPartenza = new UrlLoader("http://www.viaggiatreno.it/"
                + "viaggiatrenonew/"
                + "resteasy/"
                + "viaggiatreno/"
                + "arrivi/"
                + stazionePartenza.getId() + "/" // solo get id
                + time.toString() + "%20GMT+0100").getUrlResponse();
        Arrivi[] arrivi = new Gson().fromJson(jsonPartenza, Arrivi[].class);
        Arrays.sort(arrivi, new SortTabelloneArrivi());
        return arrivi;
    }


    @Override
    public String toString() {
        return "[IN ARRIVO, numeroTreno=" + numeroTreno + ", categoria=" + categoria
                +  ", codOrigine=" + codOrigine + ", origine=" + origine + ", circolante=" + circolante + ", codiceCliente="
                + codiceCliente + ", binarioProgrammatoArrivoDescrizione=" + binarioProgrammatoArrivoDescrizione
                + ", binarioEffettivoArrivoDescrizione=" + binarioEffettivoArrivoDescrizione + ", inStazione="
                + inStazione + ", orarioArrivo=" + orarioArrivo + ", ritardo="
                + ritardo + ", compOrarioArrivo=" + compOrarioArrivo + ", compNumeroTreno=" + compNumeroTreno + "]";
    }
}