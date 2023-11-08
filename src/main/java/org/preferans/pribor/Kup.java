package org.preferans.pribor;

import java.util.Arrays;

public class Kup {
    public static final byte BROJ_KUP_KARATA = 2;
    private Karta[] kupKarte;

    public Kup(){
        kupKarte = new Karta[BROJ_KUP_KARATA];
    }
    public void reset(){
        Arrays.fill(kupKarte, null);
    }

    public Karta[] getKupKarte() {
        return kupKarte;
    }

}
