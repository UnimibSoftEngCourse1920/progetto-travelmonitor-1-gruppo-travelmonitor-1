package com.sviluppotrilo.trilo.Domain;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.annotations.JsonAdapter;
import com.sviluppotrilo.trilo.ViaggioException;


@JsonAdapter(TrattaAdapter.class)
public class Tratta extends AsyncTask<Void, Void, Void> {
    private Stazione origine;
    private Stazione destinazione;
    private String orarioPartenza;
    private String orarioArrivo;
    private int categoria;
    private String categoriaDescrizione;
    private String numeroTreno;

    private Corsa corsa;

    private CorsaState stato;


    public void update() throws ViaggioException {
        if(stato == null)
            stato = new NonPartito();
        setCorsa(cercaCorsa());
        stato = stato.statoCorsa((Corsa) corsa);
    }

    public Corsa cercaCorsa() throws ViaggioException {
        Stazione stazionePartenza = Stazione.findStazionePartenza(numeroTreno);
        return Corsa.find(stazionePartenza, numeroTreno);
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
    public String getOrarioPartenza() {
        return orarioPartenza;
    }

    public void setOrarioPartenza(String orarioPartenza) {
        this.orarioPartenza = orarioPartenza;
    }

    public String getOrarioArrivo() {
        return orarioArrivo;
    }

    public void setOrarioArrivo(String orarioArrivo) {
        this.orarioArrivo = orarioArrivo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaDescrizione() {
        return categoriaDescrizione;
    }

    public void setCategoriaDescrizione(String categoriaDescrizione) {
        this.categoriaDescrizione = categoriaDescrizione;
    }

    public String getNumeroTreno() {
        return numeroTreno;
    }

    public void setNumeroTreno(String numeroTreno) {
        this.numeroTreno = numeroTreno;
    }

    public Corsa getCorsa() {
        return corsa;
    }

    public void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }

    @Override
    public String toString() {
        return "Tratta [origine=" + origine + ", destinazione=" + destinazione + ", orarioPartenza=" + orarioPartenza
                + ", orarioArrivo=" + orarioArrivo + ", categoria=" + categoria + ", categoriaDescrizione="
                + categoriaDescrizione + ", numeroTreno=" + numeroTreno + "]";
    }

    @Override
    protected Void doInBackground(Void... voids) {
        do{
            try {
                update();
                Thread.sleep(5000);
                System.out.println(stato.getClass());
            } catch (ViaggioException | InterruptedException e) {
                e.printStackTrace();
            }
        }while(!(stato instanceof Soppresso) && !(stato instanceof InRitardo)
            && !(stato instanceof Arrivato));
        System.out.println("Ok");
        return null;
    }
}