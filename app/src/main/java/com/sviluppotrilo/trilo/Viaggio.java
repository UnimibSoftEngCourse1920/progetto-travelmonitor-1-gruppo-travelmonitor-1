package com.sviluppotrilo.trilo;

import java.util.List;
import com.google.gson.Gson;

public class Viaggio{
    private String origine;
    private String destinazione;
    private List<Soluzione> soluzioni;

    public Viaggio(Stazione origine, Stazione destinazione, String data, String ora) throws Exception {
        setOrigine(origine.nome);
        setDestinazione(destinazione.nome);
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
        Viaggio viaggio = new Gson().fromJson(jsonViaggio, Viaggio.class);
        return viaggio;
    }

    public List<Soluzione> getSoluzioni() {
        return soluzioni;
    }

    public void setSoluzioni(List<Soluzione> soluzioni) {
        this.soluzioni = soluzioni;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public String toString() {
        return "Viaggio [origine=" + origine + ", destinazione="
                + destinazione + ", soluzioni=" + soluzioni + "]";
    }
}
