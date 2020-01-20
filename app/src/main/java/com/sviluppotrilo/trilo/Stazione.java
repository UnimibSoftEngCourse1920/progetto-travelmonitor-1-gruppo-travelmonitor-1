package com.sviluppotrilo.trilo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stazione {
    public String nome;
    public String id;

    public Stazione(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }
    public Stazione() {
        // TODO Auto-generated constructor stub
    }
    public static Stazione findStazionePartenza(int numeroTreno) throws Exception {
        String url = "http://www.viaggiatreno.it/"
                + "viaggiatrenonew/"
                + "resteasy/"
                + "viaggiatreno/"
                + "cercaNumeroTrenoTrenoAutocomplete/"
                + numeroTreno;
        String stazionePartenza = new UrlLoader(url).getUrlResponse();
        if(stazionePartenza.length() == 0 || stazionePartenza == null)
            throw new ViaggioException("Impossibile trovare la stazione di partenza dal numero del treno");
        String nome = estraiNome(stazionePartenza);
        String id = estraiId(stazionePartenza);
        Stazione stazione = new Stazione(nome, id);
        return stazione;
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
}