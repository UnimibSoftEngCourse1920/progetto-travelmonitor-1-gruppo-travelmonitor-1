package com.sviluppotrilo.trilo;

import com.sviluppotrilo.trilo.Controller.ViaggioController;
import com.sviluppotrilo.trilo.Domain.Corsa;
import com.sviluppotrilo.trilo.Domain.Stazione;
import com.sviluppotrilo.trilo.Domain.Viaggio;

import org.junit.Test;

public class ViaggioTest {

    @Test
    public void cercaViaggio() {
        Stazione origine = new Stazione("Seveso", "1925");
        Stazione destinazione = new Stazione("Affori", "1078");
        String data = "2020-01-25";
        String ora = "T" + "12:00:00";
        ViaggioController c = new ViaggioController();
        Viaggio v = c.cercaViaggio(origine, destinazione, data, ora);
        System.out.println(v);
    }
    @Test
    public void testProva() throws ViaggioException{
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
    @Test
    public void testCambioStato(){

    }
}