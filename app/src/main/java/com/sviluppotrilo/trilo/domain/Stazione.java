package com.sviluppotrilo.trilo.domain;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stazione {
    public final String DATEFORMAT = "E%20MMM%20dd%20yyyy%20HH:mm:ss";
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

    public Arrivi[] cercaArrivi(){
            String jsonPartenza = new UrlLoader("http://www.viaggiatreno.it/"
                    + "viaggiatrenonew/"
                    + "resteasy/"
                    + "viaggiatreno/"
                    + "arrivi/"
                    + getId() + "/" // solo get id
                    + now()).getUrlResponse();
            Arrivi[] arrivi = new Gson().fromJson(jsonPartenza, Arrivi[].class);
            Arrays.sort(arrivi, new SortTabelloneArrivi());
            return arrivi;
    }

    public Partenze[]  cercaPartenze(){
        String jsonPartenza = new UrlLoader("http://www.viaggiatreno.it/"
                + "viaggiatrenonew/"
                + "resteasy/"
                + "viaggiatreno/"
                + "partenze/"
                + getId() + "/" // solo get id
                + now()).getUrlResponse();
        Partenze[] partenze = new Gson().fromJson(jsonPartenza, Partenze[].class);
        Arrays.sort(partenze, new SortTabellonePartenze());
        return partenze;
    }

    public String now(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT, new Locale("EN"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today) + "%20GMT+0100";
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