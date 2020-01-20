package com.sviluppotrilo.trilo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
@JsonAdapter(ViaggioAdapter.class)
public class Viaggio{

    private Stazione origine;
    private Stazione destinazione;
    public List<Soluzione> soluzioni;

    public Viaggio() {
        soluzioni = new ArrayList<Soluzione>();
    }

    public static Viaggio find(Stazione origine, Stazione destinazione, String data, String ora) throws Exception {
        String url = "http://www.viaggiatreno.it/"
                + "viaggiatrenonew/resteasy/viaggiatreno/"
                + "soluzioniViaggioNew/"
                + origine.getId() + "/"
                + destinazione.getId() + "/"
                + data
                + ora;
        String jsonViaggio = new UrlLoader(url).getUrlResponse();
        if(jsonViaggio.length() == 0 || jsonViaggio == null)
            throw new ViaggioException("Impossibile trovare il viaggio");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Viaggio.class, new ViaggioAdapter());
        Gson gson = builder.create();
        Viaggio viaggio = gson.fromJson(jsonViaggio, Viaggio.class);
        return viaggio;
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
