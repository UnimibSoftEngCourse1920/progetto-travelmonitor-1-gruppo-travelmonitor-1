package com.sviluppotrilo.trilo;

import com.sviluppotrilo.trilo.Controller.ViaggioController;
import com.sviluppotrilo.trilo.Domain.Corsa;
import com.sviluppotrilo.trilo.Domain.Giorno;
import com.sviluppotrilo.trilo.Domain.RoutineSettimanale;
import com.sviluppotrilo.trilo.Domain.Soluzione;
import com.sviluppotrilo.trilo.Domain.Stazione;
import com.sviluppotrilo.trilo.Domain.Tratta;
import com.sviluppotrilo.trilo.Domain.Viaggio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}