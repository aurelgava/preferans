package org.test.preferans;


import org.preferans.igraci.Igrac;
import org.preferans.igra.Sesija;
import org.preferans.igraci.IgracAI;

import java.util.ArrayList;

public class Main {

    //public static final byte BROJ_IGRACA = 3;
    public static void main(String[] args) {
        zapocniNovuSesiju((short)100);
    }
    private static void zapocniNovuSesiju(short bule) {
        Sesija sesija = Sesija.getNewInstance();
        ArrayList<Igrac> igraci = new ArrayList<>();
        IgracAI i1 =  new IgracAI("Predrag",bule);
        IgracAI i2 =  new IgracAI("Frantz",bule);
        IgracAI i3 =  new IgracAI("Eintz",bule);
        igraci.add(i1);
        igraci.add(i2);
        igraci.add(i3);

        sesija.getAktivnaPartija().podeliKarte(igraci,sesija.getKup());

        new Thread(i1).start();
        new Thread(i2).start();
        new Thread(i3).start();

    }
}