package com.sviluppotrilo.trilo.Domain;

public class NonPartito implements CorsaState {

    @Override
    public CorsaState statoCorsa(Corsa corsa){
        if((corsa.getProvvedimento() == 0 || corsa.getProvvedimento() == 2) && (corsa.getTipoTreno().equals("PP") ||
                corsa.getTipoTreno().equals("SI") || corsa.getTipoTreno().equals("SF"))){
            return new ParzialmenteSoppresso().statoCorsa(corsa);
        }
        if(corsa.isPartito())
            return new InOrario().statoCorsa(corsa);
        if(corsa.getProvvedimento() == 1 && corsa.getTipoTreno().equals("ST")) {
            return new Soppresso().statoCorsa(corsa);
        }
        return this;
    }
}
