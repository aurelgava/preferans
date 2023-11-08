package org.test.preferans;

import org.preferans.Igrac;
import org.preferans.igra.Sesija;
import org.preferans.igraci.IgracAI;

public class Main {
    public static final byte BROJ_IGRACA = 3;
    public static void main(String[] args) {
        zapocniNovuSesiju((short)100);
    }

    private static void zapocniNovuSesiju(short bule) {

        Sesija s = Sesija.getNewInstance();

        Igrac[] igraci = new Igrac[BROJ_IGRACA];
        igraci[0] = new IgracAI("Predrag",bule);
        igraci[1] = new IgracAI("Frantz",bule);
        igraci[2] = new IgracAI("Eintz",bule);

        s.getAktivnaPartija().podeliKarte(igraci);

    }
}