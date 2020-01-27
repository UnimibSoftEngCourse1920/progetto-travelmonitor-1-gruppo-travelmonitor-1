package com.sviluppotrilo.trilo;

import com.sviluppotrilo.trilo.Controller.ViaggioController;
import com.sviluppotrilo.trilo.Domain.Corsa;
import com.sviluppotrilo.trilo.Domain.Giorno;
import com.sviluppotrilo.trilo.Domain.Stazione;
import com.sviluppotrilo.trilo.Domain.Partenze;
import com.sviluppotrilo.trilo.Domain.Arrivi;
import com.sviluppotrilo.trilo.Domain.CorsaState;
import com.sviluppotrilo.trilo.Domain.NonPartito;
import com.sviluppotrilo.trilo.Domain.Soluzione;
import com.sviluppotrilo.trilo.Domain.Viaggio;
import com.sviluppotrilo.trilo.Domain.Tratta;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatoCorsaTest {

    @Test
    public void treniInPartenza() {
        try {
            Partenze[] p = new Partenze().find(new Stazione("Cesano Maderno","S01086"));
            for (Partenze partenza : p)
                System.out.println(partenza.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void treniInArrivo(){
        try{
            Arrivi[] a = new Arrivi().find(new Stazione("P Garibaldi-passante","S01647"));
            for(Arrivi arrivo : a)
                System.out.println(arrivo.toString());
        } catch(Exception e) {
            System.out.println(e);
        }
    }


    @Test
    public void arriviConController(){
        Stazione stazione = new Stazione("P Garibaldi-passante","S01647");
        ViaggioController c = new ViaggioController();
        try{
            Arrivi[] a = c.cercaTabelloneArrivi(stazione);
            for(Arrivi arrivo : a)
                System.out.println(arrivo.toString());
        }catch(Exception e){
            System.out.println("Errore");
        }
    }

    @Test
    public void partenzeConController(){
        Stazione stazione = new Stazione("P Garibaldi-passante","S01647");
        ViaggioController c = new ViaggioController();
        try{
            Partenze[] a = c.cercaTabellonePartenze(stazione);
            for(Partenze arrivo : a)
                System.out.println(arrivo.toString());
        }catch(Exception e){
            System.out.println("Errore");
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
    public void cercaUnaCorsaConStatoInRitardo(){
        ViaggioController c= new ViaggioController();
        Stazione origine = new Stazione("SEVESO", "S01925");
        String numeroTreno="20245";
        Corsa corsa = c.cercaCorsa(origine,numeroTreno);
        CorsaState s = new NonPartito();
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
    public void cercaUnaCorsaePreferiti(){
        Stazione origine = new Stazione("LECCO", "1520");
        Stazione destinazione = new Stazione("LECCO M", "1522");
        String data = "2020-01-26";
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
        List<Tratta> tratte = soluzione.get(1).getTratte();
        for(Tratta tratta : tratte)
            System.out.println(tratta.toString());
        Corsa cor = new Corsa();



    }

}