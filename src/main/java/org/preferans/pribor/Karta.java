package org.preferans.pribor;

public class Karta {
    public static enum Broj { SEDAM, OSAM, DEVET, DESET, ZANDAR, DAMA, KRALJ, KEC }
    public static enum Znak { PIK, KARO, HERC, TREF }

    private Broj broj;
    private Znak znak;
    public Karta() {
    }
    public Karta(Broj broj, Znak znak) {
        this.broj = broj;
        this.znak = znak;
    }

    @Override
    public String toString() {
        return  this.broj + " " + this.znak;
    }
}
