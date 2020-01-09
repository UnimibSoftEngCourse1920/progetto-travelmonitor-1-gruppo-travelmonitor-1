package com.sviluppotrilo.trilo;

public class Fermata {
    public String stazione;
    public String id;
    public String programmata;
    public String tipoFermata;
    public int ritardo;
    public int ritardoArrivo;
    public int ritardoPartenza;
    public String arrivoReale;
    public String partenzaReale;
    public String partenza_teorica;
    public String arrivo_teorico;
    public int actualFermataType;


    @Override
    public String toString() {
        return "Fermata [stazione=" + stazione + ", id=" + id + ", programmata=" + programmata + ", tipoFermata="
                + tipoFermata + ", ritardo=" + ritardo + ", ritardoArrivo=" + ritardoArrivo + ", ritardoPartenza="
                + ritardoPartenza + ", arrivoReale=" + arrivoReale + ", partenzaReale=" + partenzaReale
                + ", partenza_teorica=" + partenza_teorica + ", arrivo_teorico=" + arrivo_teorico
                + ", actualFermataType=" + actualFermataType + "]";
    }
}
