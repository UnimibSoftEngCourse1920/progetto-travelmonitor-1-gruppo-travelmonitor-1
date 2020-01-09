package com.sviluppotrilo.trilo;

import java.util.List;

public class Soluzione {

    public List<Tratta> vehicles;
    public String durata;

    public List<Tratta> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Tratta> vehicles) {
        this.vehicles = vehicles;
    }
    public String getDurata() {
        return durata;
    }
    public void setDurata(String durata) {
        this.durata = durata;
    }

    public int numeroCambi() {
        int numeroCambi = vehicles.size();
        return numeroCambi;
    }

    public boolean prevedeCambi() {
        if(numeroCambi() != 1)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Soluzione [vehicles=" + vehicles + ", durata=" + durata + "]";
    }

}
