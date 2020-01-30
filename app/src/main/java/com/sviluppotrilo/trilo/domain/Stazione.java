package com.sviluppotrilo.trilo.domain;

import com.google.gson.Gson;
import com.sviluppotrilo.trilo.controllers.ViaggioController;
import com.sviluppotrilo.trilo.data.UrlLoader;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stazione {
    private static final String URL = "http://www.viaggiatreno.it/"
            + "viaggiatrenonew/"
            + "resteasy/"
            + "viaggiatreno/";

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
        String url = Stazione.URL
                + "cercaNumeroTrenoTrenoAutocomplete/"
                + numeroTreno;
        String stazionePartenza = new UrlLoader(url).getUrlResponse();
        if(stazionePartenza == null || stazionePartenza.length() == 0)
            throw new ViaggioException("Impossibile trovare la stazione di partenza dal numero del treno");
        String nome = estraiNome(stazionePartenza);
        String id = estraiId(stazionePartenza);
        return new Stazione(nome, id);
    }

    public static Stazione findStazionePartenza(String numeroTreno, String fermata) throws ViaggioException {
        String url = Stazione.URL
                + "cercaNumeroTrenoTrenoAutocomplete/"
                + numeroTreno;
        String stazioniPartenza = new UrlLoader(url).getUrlResponse();
        if(stazioniPartenza == null || stazioniPartenza.length() == 0)
            throw new ViaggioException("Impossibile trovare la stazione di partenza dal numero del treno");
        String[] stazioni = stazioniPartenza.split(Pattern.quote("\n"));
        for(String stazione : stazioni) {
            Stazione stazionePartenzaCorsa = new Stazione(estraiNome(stazione), estraiId(stazione));
            List<Fermata> fermate = new ViaggioController().cercaCorsa(
                    stazionePartenzaCorsa, numeroTreno).getFermate();
            for(Fermata fermataCorsa : fermate)
                if(fermataCorsa.getStazione().getNome().equals(fermata))
                    return stazionePartenzaCorsa;
        }
        return null;
    }

    public Arrivi[] cercaArrivi(){
        String jsonPartenza = new UrlLoader(Stazione.URL
                    + "arrivi/"
                    + getId() + "/"
                    + now()).getUrlResponse();
        Arrivi[] arrivi = new Gson().fromJson(jsonPartenza, Arrivi[].class);
        Arrays.sort(arrivi, new Comparator<Arrivi>() {
            @Override
            public int compare(Arrivi a1, Arrivi a2) {
                long op1 = a1.getOrarioArrivo();
                long op2 = a2.getOrarioArrivo();
                return (int) (op1 - op2);
            }
        });
        return arrivi;
    }

    public Partenze[]  cercaPartenze(){
        String jsonPartenza = new UrlLoader(Stazione.URL
                + "partenze/"
                + getId() + "/" // solo get id
                + now()).getUrlResponse();
        Partenze[] partenze = new Gson().fromJson(jsonPartenza, Partenze[].class);
        Arrays.sort(partenze, new Comparator<Partenze>() {
            @Override
            public int compare(Partenze p1, Partenze p2) {
                long op1 = p1.getOrarioPartenza();
                long op2 = p2.getOrarioPartenza();
                return (int) (op1 - op2);
            }
        });
        return partenze;
    }

    private String now(){
        final String DATEFORMAT = "E%20MMM%20dd%20yyyy%20HH:mm:ss";
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