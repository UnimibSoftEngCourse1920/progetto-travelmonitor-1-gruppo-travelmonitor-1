package com.sviluppotrilo.trilo;

import java.util.List;
import com.google.gson.Gson;

public class Corsa {

    public String idDestinazione;
    public String idOrigine;
    public String origine;
    public String destinazione;
    public String orarioPartenza; // formato timestamp unix
    public String orarioArrivo;
    public String compOrarioPartenza; // "comp" è il formato HH:MM
    public String compOrarioArrivo;
    public String oraUltimoRilevamento;
    public String compOraUltimoRilevamento;
    public String stazioneUltimoRilevamento; //null se non è partito oppure è soppresso
    public String tipoTreno;
    public int provvedimento;
    public String subTitle;
    public int codiceCliente;
    public List<Fermata> fermate;
    public String dataPartenza;
    public int numeroTreno;
    public String categoria;
    public boolean inStazione;
    public boolean nonPartito;

    public static Corsa find(Stazione stazionePartenza, int numeroTreno) throws Exception {
        String jsonCorsa = new UrlLoader("http://www.viaggiatreno.it/"
                + "viaggiatrenonew/"
                + "resteasy/"
                + "viaggiatreno/"
                + "andamentoTreno/"
                + stazionePartenza.getId() + "/"
                + numeroTreno).getUrlResponse();
        Corsa corsa = new Gson().fromJson(jsonCorsa, Corsa.class);
        return corsa;
    }

    @Override
    public String toString() {
        return "Corsa [idDestinazione=" + idDestinazione + ", idOrigine=" + idOrigine + ", origine=" + origine
                + ", destinazione=" + destinazione + ", orarioPartenza=" + orarioPartenza + ", orarioArrivo="
                + orarioArrivo + ", compOrarioPartenza=" + compOrarioPartenza + ", compOrarioArrivo=" + compOrarioArrivo
                + ", oraUltimoRilevamento=" + oraUltimoRilevamento + ", compOraUltimoRilevamento="
                + compOraUltimoRilevamento + ", stazioneUltimoRilevamento=" + stazioneUltimoRilevamento + ", tipoTreno="
                + tipoTreno + ", provvedimento=" + provvedimento + ", subTitle=" + subTitle + ", codiceCliente="
                + codiceCliente + ", fermate=" + fermate + ", dataPartenza=" + dataPartenza + ", numeroTreno="
                + numeroTreno + ", categoria=" + categoria + ", inStazione=" + inStazione + ", nonPartito=" + nonPartito
                + "]";
    }
}