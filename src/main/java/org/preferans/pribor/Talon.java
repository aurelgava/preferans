package org.preferans.pribor;

import java.util.Arrays;

public class Talon {
    public static final int BROJ_TALONSKIH_KARATA = 3;
    private Karta[] talonKarte;

    public Talon() {
        this.talonKarte = new Karta[3];
    }
    public void reset(){
        Arrays.fill(this.talonKarte,null);
    }

    public Karta[] getTalonKarte() {
        return talonKarte;
    }
}
