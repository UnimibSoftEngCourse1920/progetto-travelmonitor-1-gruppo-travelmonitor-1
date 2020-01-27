package com.sviluppotrilo.trilo.Domain;

import com.sviluppotrilo.trilo.ViaggioException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stazione {
    private String nome;
    private String id;

    public Stazione(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }
    public Stazione() {
        super();
    }
    public static Stazione findStazionePartenza(String numeroTreno) throws ViaggioException {
        String url = "http://www.viaggiatreno.it/"
                + "viaggiatrenonew/"
                + "resteasy/"
                + "viaggiatreno/"
                + "cercaNumeroTrenoTrenoAutocomplete/"
                + numeroTreno;
        String stazionePartenza = new UrlLoader(url).getUrlResponse();
        if(stazionePartenza == null || stazionePartenza.length() == 0)
            throw new ViaggioException("Impossibile trovare la stazione di partenza dal numero del treno");
        String nome = estraiNome(stazionePartenza);
        String id = estraiId(stazionePartenza);
        return new Stazione(nome, id);
    }
    private static String estraiNome(String string) {
        String regexNome = "[-].+[|]";
        string = estraiRegex(string, regexNome);
        string = string.substring(1).trim();
        string = string.substring(0, string.length() - 1);
        return string;
    }
    private static String estraiId(String string) {
        String regexId = "[|][0-9]+[-].*";
        string = estraiRegex(string, regexId);
        regexId = "[-].*";
        string = estraiRegex(string, regexId);
        string = string.substring(1).trim();
        return string;
    }
    private static String estraiRegex(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find())
            string = matcher.group(0);
        return string;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Stazione [nome=" + nome + ", id=" + id + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stazione)) return false;
        Stazione stazione = (Stazione) o;
        return Objects.equals(getNome(), stazione.getNome()) ||
                Objects.equals(getId(), stazione.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getId());
    }
}