package com.sviluppotrilo.trilo;

public class Tratta {

    public String origine;
    public String destinazione;
    public String orarioPartenza;
    public String orarioArrivo;
    public int categoria;
    public String categoriaDescrizione;
    public int numeroTreno;

    public Corsa cercaCorsa() throws Exception {
        Stazione stazionePartenza = Stazione.findStazionePartenza(numeroTreno);
        Corsa corsa = Corsa.find(stazionePartenza, numeroTreno);
        stazionePartenza = null;
        return corsa;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
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
