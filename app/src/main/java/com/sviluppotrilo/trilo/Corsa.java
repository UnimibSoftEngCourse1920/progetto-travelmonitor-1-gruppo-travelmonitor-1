package com.sviluppotrilo.trilo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(CorsaAdapter.class)
public class Corsa{

    private Stazione origine;
    private Stazione destinazione;
    private Stazione stazioneUltimoRilevamento; //null se non è partito oppure è soppresso

    private String orarioPartenza; // formato HH:MM
    private String orarioArrivo;
    private String oraUltimoRilevamento;
    private String dataPartenza;

    private String tipoTreno;
    private int numeroTreno;
    private String categoria;

    private int provvedimento;
    private String descrizione; // subTitle - il messaggio sul tabellone
    private int codiceCliente;

    private boolean inStazione;
    private boolean partito;
    public List<Fermata> fermate;

    public Corsa() {
        super();
        fermate = new ArrayList<>();
    }

    public static Corsa find(Stazione stazionePartenza, int numeroTreno) throws ViaggioException {
        String url = "http://www.viaggiatreno.it/"
                + "viaggiatrenonew/"
                + "resteasy/"
                + "viaggiatreno/"
                + "andamentoTreno/"
                +  stazionePartenza.getId() + "/"
                + numeroTreno;
        String jsonCorsa = new UrlLoader(url).getUrlResponse();
        if(jsonCorsa == null || jsonCorsa.length() == 0)
            throw new ViaggioException("Impossibile trovare la corsa");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Corsa.class, new CorsaAdapter());
        Gson gson = builder.create();
        return gson.fromJson(jsonCorsa, Corsa.class);
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

    public Stazione getStazioneUltimoRilevamento() {
        return stazioneUltimoRilevamento;
    }

    public void setStazioneUltimoRilevamento(Stazione stazioneUltimoRilevamento) {
        this.stazioneUltimoRilevamento = stazioneUltimoRilevamento;
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

    public String getOraUltimoRilevamento() {
        return oraUltimoRilevamento;
    }

    public void setOraUltimoRilevamento(String oraUltimoRilevamento) {
        this.oraUltimoRilevamento = oraUltimoRilevamento;
    }

    public String getTipoTreno() {
        return tipoTreno;
    }

    public void setTipoTreno(String tipoTreno) {
        this.tipoTreno = tipoTreno;
    }

    public int getProvvedimento() {
        return provvedimento;
    }

    public void setProvvedimento(int provvedimento) {
        this.provvedimento = provvedimento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(int codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    public String getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(String dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public int getNumeroTreno() {
        return numeroTreno;
    }

    public void setNumeroTreno(int numeroTreno) {
        this.numeroTreno = numeroTreno;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isInStazione() {
        return inStazione;
    }

    public void setInStazione(boolean inStazione) {
        this.inStazione = inStazione;
    }

    public boolean isPartito() {
        return partito;
    }

    public void setPartito(boolean partito) {
        this.partito = partito;
    }

    public List<Fermata> getFermate() {
        return fermate;
    }

    public void setFermate(List<Fermata> fermate) {
        this.fermate = fermate;
    }

    @Override
    public String toString() {
        return "Corsa [origine=" + origine + ", destinazione=" + destinazione + ", stazioneUltimoRilevamento="
                + stazioneUltimoRilevamento + ", orarioPartenza=" + orarioPartenza + ", orarioArrivo=" + orarioArrivo
                + ", oraUltimoRilevamento=" + oraUltimoRilevamento + ", tipoTreno=" + tipoTreno + ", provvedimento="
                + provvedimento + ", descrizione=" + descrizione + ", codiceCliente=" + codiceCliente
                + ", dataPartenza=" + dataPartenza + ", numeroTreno=" + numeroTreno + ", categoria=" + categoria
                + ", inStazione=" + inStazione + ", partito=" + partito + ", fermate=" + fermate + "]";
    }

}