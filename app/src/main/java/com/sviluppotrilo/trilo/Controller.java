package com.sviluppotrilo.trilo;

public class Controller {
    public Viaggio cercaViaggio(Stazione partenza, Stazione arrivo, String data, String ora){
        Viaggio viaggio = null;
        try {
            viaggio = Viaggio.find(partenza, arrivo, data, ora);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return viaggio;
    }
}
