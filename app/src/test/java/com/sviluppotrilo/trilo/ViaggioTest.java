package com.sviluppotrilo.trilo;

import org.junit.Test;

import java.util.List;

public class ViaggioTest {

    @Test
    public void cercaViaggio() {
        Stazione origine = new Stazione("Seveso", "1925");
        Stazione destinazione = new Stazione("Affori", "1078");
        String data = "2020-01-25";
        String ora = "T" + "12:00:00";
        Controller c = new Controller();
        Viaggio v = c.cercaViaggio(origine, destinazione, data, ora);
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

    @Test
    public void provaObserver() throws Exception{
        Stazione origine = new Stazione("Baruccana", "1929");
        Stazione destinazione = new Stazione("Camnago", "1316");
        String data = "2020-01-20";
        String ora = "T" + "10:00:00";
        Controller c = new Controller();
        Viaggio v = c.cercaViaggio(origine, destinazione, data, ora);
        List<Soluzione> s = v.getSoluzioni();
        List<Tratta> t = s.get(0).getTratte();
        Tratta t1 = t.get(0);
        t1.addObserver(new NotificaObserver());
        t1.update();
    }
}