package org.preferans.pribor;

import org.preferans.igra.UzimacKarata;

import java.util.ArrayList;
import java.util.Arrays;

public class Talon implements UzimacKarata {
    public static final int BROJ_TALONSKIH_KARATA = 3;
    private ArrayList<Karta> talonKarte;

    public Talon() {
        this.talonKarte = new ArrayList<>();
    }
    public void reset(){
        this.talonKarte = new ArrayList<>();
    }

    public ArrayList<Karta> getTalonKarte() {
        return talonKarte;
    }

    @Override
    public void uzmiKartu(Karta karta) {
        this.talonKarte.add(karta);
    }
}
