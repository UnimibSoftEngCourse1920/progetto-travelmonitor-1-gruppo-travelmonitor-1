package com.sviluppotrilo.trilo;

import java.util.Observable;
import java.util.Observer;

public class Notifica implements Observer {
    //Qui dovrei controllare se
    // 1) corsa.tipoTreno.equals("PG") && provvedimento == 0 allora è regolare
    // 2) corsa.tipoTreno.euqals("ST") e provvedimento==1: treno soppresso
    // 3) corsa.tipoTreno.equals("PP") oppure 'SI' oppure 'SF' e provvedimento vale 0 oppure 2:
    //     allora il treno è parzialmente soppresso
    // Quindi se sono nello stato "regolare" e durante l'update cambia stato allora invia
    // la notifica

    public Corsa corsa;

    @Override
    public void update(Observable o, Object corsa) {
        this.setCorsa((Corsa) corsa);
        //Qui controllo se devo cambiare stato e nel caso lo cambio
    }

    public Corsa getCorsa() {
        return corsa;
    }

    public void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }
}
