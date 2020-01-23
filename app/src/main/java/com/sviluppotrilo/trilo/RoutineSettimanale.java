package com.sviluppotrilo.trilo;

import java.time.LocalDate;

public class RoutineSettimanale {

    private static Giorno lunedi;
    private static Giorno martedi;
    private static Giorno mercoledi;
    private static Giorno giovedi;
    private static Giorno venerdi;
    private static Giorno sabato;
    private static Giorno domenica;

    private RoutineSettimanale(){}

    public static Giorno getLunedi(){
        if(lunedi == null){
            lunedi = new Giorno(1, "Lunedi");
        }
        return lunedi;
    }

    public static Giorno getMartedi(){
        if(martedi == null){
            martedi = new Giorno(2, "Martedi");
        }
        return martedi;
    }

    public static Giorno getMercoledi(){
        if(mercoledi == null){
            mercoledi = new Giorno(3, "Mercoledi");
        }
        return mercoledi;
    }

    public static Giorno getGiovedi(){
        if(giovedi == null){
            giovedi = new Giorno(4, "Giovedi");
        }
        return giovedi;
    }

    public static Giorno getVenerdi(){
        if(venerdi == null){
            venerdi = new Giorno(5, "Venerdi");
        }
        return venerdi;
    }

    public static Giorno getSabato(){
        if(sabato == null){
            sabato = new Giorno(6, "Sabato");
        }
        return sabato;
    }

    public static Giorno getDomenica(){
        if(domenica == null){
            domenica = new Giorno(7, "Domenica");
        }
        return domenica;
    }

    public static Giorno giornoAttuale() throws Exception{
        int idGiornoAttuale = LocalDate.now().getDayOfWeek().getValue();
        switch(idGiornoAttuale) {
            case 1: return getLunedi();
            case 2: return getMartedi();
            case 3: return getMercoledi();
            case 4: return getGiovedi();
            case 5: return getVenerdi();
            case 6: return getSabato();
            case 7: return getDomenica();
        }
        throw new Exception();
    }
}
