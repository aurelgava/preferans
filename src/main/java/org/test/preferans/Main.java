package org.test.preferans;

import org.preferans.igraci.Igrac;
import org.preferans.igra.Partija;
import org.preferans.igraci.IgracAI;
import org.preferans.pribor.Kup;
import org.preferans.pribor.Talon;

public class Main {
    public static final byte BROJ_IGRACA = 3;
    public static void main(String[] args) {
        short bule = 100;
        Igrac[] igraci = new Igrac[BROJ_IGRACA];
        igraci[0] = new IgracAI("Predrag",bule);
        igraci[1] = new IgracAI("Frantz",bule);
        igraci[2] = new IgracAI("Eintz",bule);
        zapocniNovuSesiju(igraci);
    }

    private static void zapocniNovuSesiju(Igrac[] igraci) {
        Partija p = Partija.getNewInstance();
        p.getAktivnoDeljenje().podeliKarte(igraci,p.getKup());

    }
}