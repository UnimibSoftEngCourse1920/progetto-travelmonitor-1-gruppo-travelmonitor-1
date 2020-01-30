package com.sviluppotrilo.trilo;

import com.sviluppotrilo.trilo.controllers.ViaggioController;
import com.sviluppotrilo.trilo.domain.Corsa;
import com.sviluppotrilo.trilo.domain.Giorno;
import com.sviluppotrilo.trilo.domain.Regolare;
import com.sviluppotrilo.trilo.domain.Stazione;
import com.sviluppotrilo.trilo.domain.Partenze;
import com.sviluppotrilo.trilo.domain.Arrivi;
import com.sviluppotrilo.trilo.domain.CorsaState;
import com.sviluppotrilo.trilo.domain.Soluzione;
import com.sviluppotrilo.trilo.domain.Viaggio;
import com.sviluppotrilo.trilo.domain.Tratta;
import com.sviluppotrilo.trilo.domain.ViaggioException;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class StatoCorsaTest {

    @Test
    public void treniInPartenza() {
        try {
            Partenze[] p = new Stazione("Cesano Maderno","S01086").cercaPartenze();
            for (Partenze partenza : p)
                System.out.println(partenza.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void treniInArrivo(){
        try{
            Arrivi[] a = new Stazione("P Garibaldi-passante","S01647").cercaArrivi();
            for(Arrivi arrivo : a)
                System.out.println(arrivo.toString());
        } catch(Exception e) {
            System.out.println(e);
        }
    }


    @Test
    public void cercaUnaCorsa(){
        ViaggioController c= new ViaggioController();
        Stazione origine = new Stazione("SEVESO", "S01925");
        String numeroTreno="20245";
        Corsa corsa = c.cercaCorsa(origine,numeroTreno);
        System.out.println(corsa.toString());
    }

    @Test
    public void cercaUnaStazioneDiPartenza() throws ViaggioException {
        Stazione fermata = new Stazione("SEVESO", "N00002");
        String numeroTreno="745";
        Stazione origine = Stazione.findStazionePartenza(numeroTreno, fermata.getNome());
        System.out.println(origine.toString());
    }

    @Test
    public void cercaUnaCorsaConStatoInRitardo(){
        ViaggioController c= new ViaggioController();
        Stazione origine = new Stazione("SEVESO", "S01925");
        String numeroTreno="20245";
        Corsa corsa = c.cercaCorsa(origine, numeroTreno);
        CorsaState s = new Regolare();
        CorsaState s1=s.statoCorsa(corsa);
        System.out.println(s1.getClass());
    }

    @Test
    public void cercaUnaCorsaConStatoInOrario(){
        ViaggioController c= new ViaggioController();
        Stazione origine = new Stazione("SEVESO", "S01925");
        String numeroTreno="20261";
        Corsa corsa = c.cercaCorsa(origine,numeroTreno);
        CorsaState s = new NonPartito();
        CorsaState s1=s.statoCorsa(corsa);
        System.out.println(s1.getClass());
    }

    @Test
    public void cercaUnaCorsaConStatoInOrario1(){
        ViaggioController c= new ViaggioController();
        Stazione origine = new Stazione("STRADELLA", "S01945");
        String numeroTreno="10578";
        Corsa corsa = c.cercaCorsa(origine,numeroTreno);
        System.out.println(corsa.toString());
        CorsaState s = new NonPartito();
        CorsaState s1=s.statoCorsa(corsa);
        System.out.println(s1.getClass());
    }

    @Test
    public void cercaUnaCorsaePreferiti(){
        Stazione origine = new Stazione("sev", "1925");
        Stazione destinazione = new Stazione("M aff", "1078");
        String data = "2020-01-30";
        String ora = "T" + "21:00:00";
        ViaggioController c = new ViaggioController();
        Viaggio v = c.cercaViaggio(origine, destinazione, data, ora);
        ArrayList<Soluzione> soluzione;
        soluzione = (ArrayList<Soluzione>) v.getSoluzioni();
        System.out.println(v);
        Giorno g = new Giorno(1, "Lunedì");
        try {
            for (Soluzione soluzione1 : soluzione)
                g.aggiungiPreferito(soluzione1);
        }catch(Exception e){
            System.out.println("Errore");
        }
        System.out.println(g.toString());
        System.out.println(soluzione.get(1).toString());
        List<Tratta> tratte = soluzione.get(2).getTratte();

        for(Tratta tratta : tratte) {
            try {
                String s = tratta.getOrigine().getNome();
                Stazione origineTreno = Stazione.findStazionePartenza(tratta.getNumeroTreno(),s);
                System.out.println(tratta.toString());
                System.out.println(tratta.cercaCorsa(s).getDestinazione().toString());
            } catch (ViaggioException e) {
                e.printStackTrace();
            }
        }
    }

}