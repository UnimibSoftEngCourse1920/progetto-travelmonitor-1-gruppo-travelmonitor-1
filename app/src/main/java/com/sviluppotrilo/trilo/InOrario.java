package com.sviluppotrilo.trilo;

public class InOrario implements CorsaState {
    @Override
    public CorsaState statoCorsa(Corsa corsa) {
        if(corsa.getStazioneUltimoRilevamento().equals(corsa.getDestinazione()))
            return new Arrivato().statoCorsa(corsa);
        Stazione sur = corsa.getStazioneUltimoRilevamento();
        for(Fermata fermata : corsa.getFermate())
            if(fermata.getStazione().getNome().equals(sur.getNome()) && fermata.getRitardo() >= 5)
                return new InRitardo().statoCorsa(corsa);
        return this;
    }
}
