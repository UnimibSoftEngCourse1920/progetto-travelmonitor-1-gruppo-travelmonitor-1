package com.sviluppotrilo.trilo.domain;

import com.preference.PowerPreference;

import org.threeten.bp.LocalDate;

public class RoutineSettimanale{

    private static Giorno lunedi;
    private static Giorno martedi;
    private static Giorno mercoledi;
    private static Giorno giovedi;
    private static Giorno venerdi;
    private static Giorno sabato;
    private static Giorno domenica;

    private RoutineSettimanale(){
    }

    public static synchronized Giorno getLunedi(){
        if(lunedi == null){
            lunedi = PowerPreference.getDefaultFile().getObject("Lunedi", Giorno.class);
        }
        return lunedi;
    }

    public static synchronized  Giorno getMartedi(){
        if(martedi == null){
            martedi = PowerPreference.getDefaultFile().getObject("Martedi", Giorno.class);
        }
        return martedi;
    }

    public static synchronized  Giorno getMercoledi(){
        if(mercoledi == null){
            mercoledi = PowerPreference.getDefaultFile().getObject("Mercoledi", Giorno.class);
        }
        return mercoledi;
    }

    public static synchronized  Giorno getGiovedi(){
        if(giovedi == null){
            giovedi = PowerPreference.getDefaultFile().getObject("Giovedi", Giorno.class);
        }
        return giovedi;
    }

    public static synchronized  Giorno getVenerdi(){
        if(venerdi == null){
            venerdi = PowerPreference.getDefaultFile().getObject("Venerdi", Giorno.class);
        }
        return venerdi;
    }

    public static synchronized  Giorno getSabato(){
        if(sabato == null){
            sabato = PowerPreference.getDefaultFile().getObject("Sabato", Giorno.class);
        }
        return sabato;
    }

    public static synchronized  Giorno getDomenica(){
        if(domenica == null){
            domenica = PowerPreference.getDefaultFile().getObject("Domenica", Giorno.class);
        }
        return domenica;
    }

    public static synchronized  Giorno giornoAttuale() throws GiornoException{
        int idGiornoAttuale = LocalDate.now().getDayOfWeek().getValue();
        return getGiorno(idGiornoAttuale);
    }

    public static synchronized  Giorno getGiorno(int idGiorno) throws GiornoException{
        switch(idGiorno) {
            case 1: return getLunedi();
            case 2: return getMartedi();
            case 3: return getMercoledi();
            case 4: return getGiovedi();
            case 5: return getVenerdi();
            case 6: return getSabato();
            case 7: return getDomenica();
            default: throw new GiornoException("L'id del giorno non esiste");
        }
    }

    public synchronized void controllaSoluzioniDelGiorno() throws GiornoException{
        giornoAttuale().controllaSoluzioni();
    }
}
