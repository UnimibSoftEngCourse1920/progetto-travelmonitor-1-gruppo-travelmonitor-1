package com.sviluppotrilo.trilo.Domain;

import com.preference.PowerPreference;


import org.threeten.bp.LocalDate;

public class RoutineSettimanale extends Giorno{

    private static Giorno lunedi;
    private static Giorno martedi;
    private static Giorno mercoledi;
    private static Giorno giovedi;
    private static Giorno venerdi;
    private static Giorno sabato;
    private static Giorno domenica;

    private RoutineSettimanale(){
    }

    public static Giorno getLunedi(){
        if(lunedi == null){
            lunedi = (Giorno) PowerPreference.getDefaultFile().getObject("Lunedi",Giorno.class);
        }
        return lunedi;
    }

    public static Giorno getMartedi(){
        if(martedi == null){
            martedi = (Giorno) PowerPreference.getDefaultFile().getObject("Martedi", Giorno.class);
        }
        return martedi;
    }

    public static Giorno getMercoledi(){
        if(mercoledi == null){
            mercoledi = (Giorno) PowerPreference.getDefaultFile().getObject("Mercoledi", Giorno.class);
        }
        return mercoledi;
    }

    public static Giorno getGiovedi(){
        if(giovedi == null){
            giovedi = (Giorno) PowerPreference.getDefaultFile().getObject("Giovedi", Giorno.class);
        }
        return giovedi;
    }

    public static Giorno getVenerdi(){
        if(venerdi == null){
            venerdi = (Giorno) PowerPreference.getDefaultFile().getObject("Venerdi", Giorno.class);
        }
        return venerdi;
    }

    public static Giorno getSabato(){
        if(sabato == null){
            sabato = (Giorno) PowerPreference.getDefaultFile().getObject("Sabato", Giorno.class);
        }
        return sabato;
    }

    public static Giorno getDomenica(){
        if(domenica == null){
            domenica = (Giorno) PowerPreference.getDefaultFile().getObject("Domenica", Giorno.class);
        }
        return domenica;
    }

    public static Giorno giornoAttuale() throws Exception{
        int idGiornoAttuale = LocalDate.now().getDayOfWeek().getValue();
        return getGiorno(idGiornoAttuale);
    }

    public static Giorno getGiorno(int idGiorno) throws Exception{
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

    public void controllaSoluzioniDelGiorno() throws Exception{
        giornoAttuale().controllaSoluzioni();
    }
}
