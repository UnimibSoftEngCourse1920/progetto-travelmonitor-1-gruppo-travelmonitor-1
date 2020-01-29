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

    public synchronized static Giorno getLunedi(){
        if(lunedi == null){
            lunedi = PowerPreference.getDefaultFile().getObject("Lunedi", Giorno.class);
        }
        return lunedi;
    }

    public synchronized static Giorno getMartedi(){
        if(martedi == null){
            martedi = PowerPreference.getDefaultFile().getObject("Martedi", Giorno.class);
        }
        return martedi;
    }

    public synchronized static Giorno getMercoledi(){
        if(mercoledi == null){
            mercoledi = PowerPreference.getDefaultFile().getObject("Mercoledi", Giorno.class);
        }
        return mercoledi;
    }

    public synchronized static Giorno getGiovedi(){
        if(giovedi == null){
            giovedi = PowerPreference.getDefaultFile().getObject("Giovedi", Giorno.class);
        }
        return giovedi;
    }

    public synchronized static Giorno getVenerdi(){
        if(venerdi == null){
            venerdi = PowerPreference.getDefaultFile().getObject("Venerdi", Giorno.class);
        }
        return venerdi;
    }

    public synchronized static Giorno getSabato(){
        if(sabato == null){
            sabato = PowerPreference.getDefaultFile().getObject("Sabato", Giorno.class);
        }
        return sabato;
    }

    public synchronized static Giorno getDomenica(){
        if(domenica == null){
            domenica = PowerPreference.getDefaultFile().getObject("Domenica", Giorno.class);
        }
        return domenica;
    }

    public synchronized static Giorno giornoAttuale() throws Exception{
        int idGiornoAttuale = LocalDate.now().getDayOfWeek().getValue();
        return getGiorno(idGiornoAttuale);
    }

    public synchronized static Giorno getGiorno(int idGiorno) throws Exception{
        switch(idGiorno) {
            case 1: return getLunedi();
            case 2: return getMartedi();
            case 3: return getMercoledi();
            case 4: return getGiovedi();
            case 5: return getVenerdi();
            case 6: return getSabato();
            case 7: return getDomenica();
        }
        throw new Exception("L'id del giorno non esiste");
    }

    public synchronized void controllaSoluzioniDelGiorno() throws Exception{
        giornoAttuale().controllaSoluzioni();
    }
}
