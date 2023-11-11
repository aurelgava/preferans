package org.test.preferans;


import org.preferans.igraci.Igrac;
import org.preferans.igra.Partija;
import org.preferans.igraci.IgracAI;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    //public static final byte BROJ_IGRACA = 3;
    public static void main(String[] args) {
        zapocniNovuPartiju((short)100);
    }
    private static void zapocniNovuPartiju(short bule) {
        Partija p = Partija.getNewInstance();
        ArrayList<Igrac> igraci = new ArrayList<>();
        IgracAI i1 =  new IgracAI("Predrag",bule);
        IgracAI i2 =  new IgracAI("Frantz",bule);
        IgracAI i3 =  new IgracAI("Eintz",bule);
        igraci.add(i1);
        igraci.add(i2);
        igraci.add(i3);


        p.getAktivnoDeljenje().podeliKarte(igraci,p.getKup());

        new Thread(i1).start();
        new Thread(i2).start();
        new Thread(i3).start();

    }
}