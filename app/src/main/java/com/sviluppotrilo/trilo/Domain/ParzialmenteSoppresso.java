package com.sviluppotrilo.trilo.Domain;

public class ParzialmenteSoppresso implements CorsaState {
    public ParzialmenteSoppresso(){}
    @Override
    public CorsaState statoCorsa(Corsa corsa){
        Notifica n = new NotificaSoppressioneParziale(corsa);
        n.invia();
        if(corsa.isPartito() == true)
            return new InOrario().statoCorsa(corsa);
        if(corsa.getProvvedimento() == 1 && corsa.getTipoTreno().equals("ST")) {
            return new Soppresso().statoCorsa(corsa);
        }
        return this;
    }
}
