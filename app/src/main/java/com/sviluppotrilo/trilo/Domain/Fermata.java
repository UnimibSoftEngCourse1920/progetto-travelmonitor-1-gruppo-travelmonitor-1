package com.sviluppotrilo.trilo.Domain;
import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(FermataAdapter.class)
public class Fermata {

    private Stazione stazione;

    private String programmata;
    private String tipoFermata;
    private int ritardo;
    private int ritardoArrivo;
    private int ritardoPartenza;
    private String arrivoReale;
    private String partenzaReale;
    private String partenzaTeorica;
    private String arrivoTeorico;
    private int tipoFermataAttuale;

    public Stazione getStazione() {
        return stazione;
    }
    public void setStazione(Stazione stazione) {
        this.stazione = stazione;
    }
    public String getProgrammata() {
        return programmata;
    }
    public void setProgrammata(String programmata) {
        this.programmata = programmata;
    }
    public String getTipoFermata() {
        return tipoFermata;
    }
    public void setTipoFermata(String tipoFermata) {
        this.tipoFermata = tipoFermata;
    }
    public int getRitardo() {
        return ritardo;
    }
    public void setRitardo(int ritardo) {
        this.ritardo = ritardo;
    }
    public int getRitardoArrivo() {
        return ritardoArrivo;
    }
    public void setRitardoArrivo(int ritardoArrivo) {
        this.ritardoArrivo = ritardoArrivo;
    }
    public int getRitardoPartenza() {
        return ritardoPartenza;
    }
    public void setRitardoPartenza(int ritardoPartenza) {
        this.ritardoPartenza = ritardoPartenza;
    }
    public String getArrivoReale() {
        return arrivoReale;
    }
    public void setArrivoReale(String arrivoReale) {
        this.arrivoReale = arrivoReale;
    }
    public String getPartenzaReale() {
        return partenzaReale;
    }
    public void setPartenzaReale(String partenzaReale) {
        this.partenzaReale = partenzaReale;
    }
    public String getPartenzaTeorica() {
        return partenzaTeorica;
    }
    public void setPartenzaTeorica(String partenzaTeorica) {
        this.partenzaTeorica = partenzaTeorica;
    }
    public String getArrivoTeorico() {
        return arrivoTeorico;
    }
    public void setArrivoTeorico(String arrivoTeorico) {
        this.arrivoTeorico = arrivoTeorico;
    }
    public int getTipoFermataAttuale() {
        return tipoFermataAttuale;
    }
    public void setTipoFermataAttuale(int tipoFermataAttuale) {
        this.tipoFermataAttuale = tipoFermataAttuale;
    }
    @Override
    public String toString() {
        return "Fermata [stazione=" + stazione + ", programmata=" + programmata + ", tipoFermata=" + tipoFermata
                + ", ritardo=" + ritardo + ", ritardoArrivo=" + ritardoArrivo + ", ritardoPartenza=" + ritardoPartenza
                + ", arrivoReale=" + arrivoReale + ", partenzaReale=" + partenzaReale + ", partenzaTeorica="
                + partenzaTeorica + ", arrivoTeorico=" + arrivoTeorico + ", tipoFermataAttuale=" + tipoFermataAttuale
                + "]";
    }
}
