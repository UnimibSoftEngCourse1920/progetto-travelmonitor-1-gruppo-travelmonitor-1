package com.sviluppotrilo.trilo.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Viaggio{

    private Stazione origine;
    private Stazione destinazione;
    public List<Soluzione> soluzioni;

    public Viaggio() {
        soluzioni = new ArrayList<>();
    }

    public static Viaggio find(Stazione origine, Stazione destinazione, String data, String ora) throws ViaggioException {
        String url = "http://www.viaggiatreno.it/"
                + "viaggiatrenonew/resteasy/viaggiatreno/"
                + "soluzioniViaggioNew/"
                + origine.getId() + "/"
                + destinazione.getId() + "/"
                + data
                + ora;
        String jsonViaggio = new UrlLoader(url).getUrlResponse();
        if(jsonViaggio == null || jsonViaggio.length() == 0)
            throw new ViaggioException("Impossibile trovare il viaggio");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Viaggio.class, new ViaggioAdapter());
        Gson gson = builder.create();
        return gson.fromJson(jsonViaggio, Viaggio.class);
    }

    public Stazione getOrigine() {
        return origine;
    }

    public void setOrigine(Stazione origine) {
        this.origine = origine;
    }

    public Stazione getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(Stazione destinazione) {
        this.destinazione = destinazione;
    }

    public List<Soluzione> getSoluzioni() {
        return soluzioni;
    }

    public void setSoluzioni(List<Soluzione> soluzioni) {
        this.soluzioni = soluzioni;
    }

    @Override
    public String toString() {
        return "Viaggio [origine=" + origine + ", destinazione="
                + destinazione + ", soluzioni=" + soluzioni + "]";
    }
}
