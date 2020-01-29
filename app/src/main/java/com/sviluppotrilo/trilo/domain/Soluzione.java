package com.sviluppotrilo.trilo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Soluzione {

    public List<Tratta> tratte;
    private String durata;

    public Soluzione() {
        tratte = new ArrayList<>();
    }

    public String getDurata() {
        return durata;
    }
    public void setDurata(String durata) {
        this.durata = durata;
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }

    public int numeroCambi() {
        return tratte.size() - 1;
    }

    @Override
    public String toString() {
        return "Soluzione [tratte=" + tratte + ", durata=" + durata + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soluzione)) return false;
        Soluzione soluzione = (Soluzione) o;
        return Objects.equals(getTratte(), soluzione.getTratte()) &&
                Objects.equals(getDurata(), soluzione.getDurata());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTratte(), getDurata());
    }

    public void controllaTratte() throws ViaggioException {
        for (Tratta t : getTratte()) {
            if(t.countObservers() == 0)
                t.addObserver(new NotificaObserver());
            t.update();
        }
    }
}
