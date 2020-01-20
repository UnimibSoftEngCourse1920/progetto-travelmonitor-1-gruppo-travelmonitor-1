package com.sviluppotrilo.trilo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ViaggioTest {

    @Test
    public void cercaViaggio() {
        Stazione origine = new Stazione("Baruccana", "1929");
        Stazione destinazione = new Stazione("Camnago", "1316");
        String data = "2020-01-20";
        String ora = "T" + "10:00:00";
        Controller c = new Controller();
        Viaggio v = c.cercaViaggio(origine, destinazione, data, ora);
        System.out.println(v);
    }

    @Test
    public void findStazionePartenza() {
        try {
            Stazione partenza = Stazione.findStazionePartenza(31437);
            System.out.println(partenza);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void find() {
        try {
            Stazione partenza = new Stazione("Bho", "S00228");
            Corsa c = Corsa.find(partenza, 4640);
            System.out.println(c);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}