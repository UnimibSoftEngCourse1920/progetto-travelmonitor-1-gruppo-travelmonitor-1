package com.sviluppotrilo.trilo.controllers;

import com.preference.PowerPreference;

public class NotificheController {
    private static final String FILENAME ="impostazioni";
    private static final String NOTIFICARITARDO ="notificaRitardo";
    private static final String NOTIFICACANCELLAZIONE ="notificaCancellazione";
    private static final String NOTIFICAFUORICITTA ="notificaFuoriCitta";
    private static final String NOTIFICAPROMEMORIA ="notificaPromemoria";

    public boolean setNotificaRitardo(boolean notifica){
        return PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICARITARDO, notifica);
    }
    public boolean setNotificaCancellazione(boolean notifica){
        return PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICACANCELLAZIONE, notifica);
    }
    public boolean setNotificaFuoriCitta(boolean notifica){
        return PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICAFUORICITTA, notifica);
    }
    public boolean setNotificaPromemoria(boolean notifica){
        return PowerPreference.getFileByName(FILENAME).setBoolean(NOTIFICAPROMEMORIA, notifica);
    }
    public boolean getNotificaRitardo(){
        return PowerPreference.getFileByName(FILENAME).getBoolean(NOTIFICARITARDO, false);
    }
    public boolean getNotificaCancellazione(){
        return PowerPreference.getFileByName(FILENAME).getBoolean(NOTIFICACANCELLAZIONE, false);
    }
    public boolean getNotificaFuoriCitta(){
        return PowerPreference.getFileByName(FILENAME).getBoolean(NOTIFICAFUORICITTA, false);
    }
    public boolean getNotificaPromemoria(){
        return PowerPreference.getFileByName(FILENAME).getBoolean(NOTIFICAPROMEMORIA, false);
    }
}
