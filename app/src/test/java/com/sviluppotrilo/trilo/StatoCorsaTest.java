package com.sviluppotrilo.trilo;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatoCorsaTest {

    @Test
    public void treniInPartenza() {
        try {
            Partenze[] p = new Partenze().find(new Stazione("Cesano Maderno","S01086"));
            for (Partenze partenza : p)
                System.out.println(partenza.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void treniInArrivo(){
        try{
            Arrivi[] a = new Arrivi().find(new Stazione("P Garibaldi-passante","S01647"));
            for(Arrivi arrivo : a)
                System.out.println(arrivo.toString());
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}