package com.sviluppotrilo.trilo.Domain;

import com.sviluppotrilo.trilo.ViaggioException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tratta {

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

    private String orario(String dataOra) throws NullPointerException{
        String s = null;
        Pattern pattern = Pattern.compile("[T].*");
        Matcher matcher = pattern.matcher(getOrarioPartenza());
        if (matcher.find())
            s = matcher.group(0);
        s = s.substring(1);
        return s;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tratta)) return false;
        Tratta tratta = (Tratta) o;
        return Objects.equals(getOrigine(), tratta.getOrigine()) &&
                Objects.equals(getDestinazione(), tratta.getDestinazione()) &&
                Objects.equals(orario(getOrarioPartenza()), orario(tratta.getOrarioPartenza())) &&
                Objects.equals(orario(getOrarioArrivo()), orario(tratta.getOrarioArrivo()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigine(), getDestinazione(), orario(getOrarioPartenza()), orario(getOrarioArrivo()));
    }
}