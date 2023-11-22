package org.preferans.igra;

public class Beleska {
    int levi,desni,ja;
    boolean refe;

    public Beleska(int levi, int desni, int ja) {
        this.levi = levi;
        this.desni = desni;
        this.ja = ja;
        this.refe = false;
    }

    public Beleska(boolean b) {
        this.refe = b;
    }

    public int getLevi() {
        return levi;
    }

    public int getDesni() {
        return desni;
    }

    public int getJa() {
        return ja;
    }

    public boolean isRefe() {
        return refe;
    }
}
