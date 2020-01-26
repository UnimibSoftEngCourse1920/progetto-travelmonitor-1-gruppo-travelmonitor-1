package com.sviluppotrilo.trilo;

import com.sviluppotrilo.trilo.Controller.ViaggioController;
import com.sviluppotrilo.trilo.Domain.Arrivi;
import com.sviluppotrilo.trilo.Domain.Corsa;
import com.sviluppotrilo.trilo.Domain.CorsaState;
import com.sviluppotrilo.trilo.Domain.InRitardo;
import com.sviluppotrilo.trilo.Domain.NonPartito;
import com.sviluppotrilo.trilo.Domain.Partenze;
import com.sviluppotrilo.trilo.Domain.Stazione;

import org.junit.Test;

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
        CorsaState s = new InRitardo();
        CorsaState s1=s.statoCorsa(corsa);
        System.out.println(s1.getClass());
    }

}