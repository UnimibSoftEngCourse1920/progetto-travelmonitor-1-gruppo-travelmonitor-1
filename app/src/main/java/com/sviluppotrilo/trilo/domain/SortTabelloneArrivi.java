package com.sviluppotrilo.trilo.domain;

import java.util.Comparator;

public class SortTabelloneArrivi implements Comparator<Arrivi> {
    public int compare(Arrivi a1, Arrivi a2) {
        long op1 = a1.getOrarioArrivo();
        long op2 = a2.getOrarioArrivo();
        int res = (int) (op1 - op2);
        return res;
    }
}
