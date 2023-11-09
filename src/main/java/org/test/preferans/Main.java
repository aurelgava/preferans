package org.test.preferans;

import org.preferans.Igrac;
import org.preferans.igra.Partija;
import org.preferans.igraci.IgracAI;

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
        Partija s = Partija.getNewInstance();
        s.getAktivnoDeljenje().podeliKarte(igraci);

    }
}