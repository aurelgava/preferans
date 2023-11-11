package org.test.preferans;

import org.preferans.igraci.Igrac;
import org.preferans.igra.Partija;
import org.preferans.igraci.IgracAI;

import java.util.ArrayList;

public class Main {
    //public static final byte BROJ_IGRACA = 3;
    public static void main(String[] args) {
        zapocniNovuPartiju((short)100);
    }

    private static void zapocniNovuPartiju(short bule) {

        Partija p = Partija.getNewInstance();

        ArrayList<Igrac> igraci = new ArrayList<>();
        igraci.add(new IgracAI("Predrag",bule));
        igraci.add( new IgracAI("Frantz",bule));
        igraci.add( new IgracAI("Eintz",bule));

        p.getAktivnoDeljenje().podeliKarte(igraci,p.getKup());

    }
}