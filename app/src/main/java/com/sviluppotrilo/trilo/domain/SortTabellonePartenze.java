package com.sviluppotrilo.trilo.domain;

import java.util.Comparator;

public class SortTabellonePartenze implements Comparator<Partenze>
{
    public int compare(Partenze p1, Partenze p2) {
        long op1 = p1.getOrarioPartenza();
        long op2 = p2.getOrarioPartenza();
        int res = (int) (op1 - op2);
        return res;
    }}