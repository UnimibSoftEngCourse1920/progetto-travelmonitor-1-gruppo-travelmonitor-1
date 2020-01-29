package com.sviluppotrilo.trilo;

import com.sviluppotrilo.trilo.controllers.ViaggioController;
import com.sviluppotrilo.trilo.domain.Corsa;
import com.sviluppotrilo.trilo.domain.Soluzione;
import com.sviluppotrilo.trilo.domain.Stazione;
import com.sviluppotrilo.trilo.domain.Tratta;
import com.sviluppotrilo.trilo.domain.Viaggio;
import com.sviluppotrilo.trilo.domain.ViaggioException;

import org.junit.Test;

import java.util.ArrayList;

public class ViaggioTest {

    @Test
    public void cercaViaggio() {
        Stazione origine = new Stazione("Seveso", "1925");
        Stazione destinazione = new Stazione("Affori", "1078");
        String data = "2020-01-27";
        String ora = "T" + "12:00:00";
        ViaggioController c = new ViaggioController();
        Viaggio v = c.cercaViaggio(origine, destinazione, data, ora);
        System.out.println(v);
        System.out.println("\n\n\n");
        ArrayList<Soluzione> soluzione;
        soluzione = (ArrayList<Soluzione>) v.getSoluzioni();
        ArrayList<Tratta> tratta = null;
        for(int i=0; i<soluzione.size(); i++){
            tratta = (ArrayList<Tratta>) soluzione.get(i).getTratte();
            System.out.println(tratta.get(0).getNumeroTreno());
        }
        System.out.println(v);
    }
    @Test
    public void testProva() throws ViaggioException {
        Stazione origine = new Stazione("Baruccana", "1918");
        Stazione destinazione = new Stazione("Camnago", "1316");
        String data = "2020-01-20";
        String ora = "T" + "10:00:00";
        Viaggio v = Viaggio.find(origine, destinazione, data, ora);
        System.out.println(v);
    }

    @Test
    public void findStazionePartenza() {
        try {
            Stazione partenza = Stazione.findStazionePartenza("31437");
            System.out.println(partenza);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void find() {
        try {
            Stazione partenza = new Stazione("Bho", "S00228");
            Corsa c = Corsa.find(partenza, "4640");
            System.out.println(c);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}