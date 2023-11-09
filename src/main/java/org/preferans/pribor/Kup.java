package org.preferans.pribor;

import org.preferans.igra.UzimacKarata;

import java.util.ArrayList;
import java.util.Arrays;

public class Kup implements UzimacKarata {
    public static final byte BROJ_KUP_KARATA = 2;
    private ArrayList<Karta> kupKarte;

    public Kup(){
        this.kupKarte = new ArrayList<>();
    }
    public void reset(){
        this.kupKarte = new ArrayList<>();
    }

    public ArrayList<Karta> getKupKarte() {
        return kupKarte;
    }

    @Override
    public void uzmiKartu(Karta karta) {
        this.kupKarte.add(karta);
    }
}
