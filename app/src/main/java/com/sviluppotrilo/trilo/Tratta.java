package com.sviluppotrilo.trilo;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(TrattaAdapter.class)
public class Tratta {
    private Stazione origine;
    private Stazione destinazione;
    private String orarioPartenza;
    private String orarioArrivo;
    private int categoria;
    private String categoriaDescrizione;
    private int numeroTreno;

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

    public int getNumeroTreno() {
        return numeroTreno;
    }

    public void setNumeroTreno(int numeroTreno) {
        this.numeroTreno = numeroTreno;
    }

    @Override
    public String toString() {
        return "Tratta [origine=" + origine + ", destinazione=" + destinazione + ", orarioPartenza=" + orarioPartenza
                + ", orarioArrivo=" + orarioArrivo + ", categoria=" + categoria + ", categoriaDescrizione="
                + categoriaDescrizione + ", numeroTreno=" + numeroTreno + "]";
    }
}