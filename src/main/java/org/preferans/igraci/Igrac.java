package org.preferans.igraci;

import org.preferans.igra.Tabela;
<<<<<<< HEAD
import org.preferans.igra.UzimacKarata;
import org.preferans.pribor.Karta;

import java.util.ArrayList;

public abstract class Igrac implements UzimacKarata {
    private String ime;
    private Tabela tabela;
    private ArrayList<Karta> mojSpiel;
=======

public abstract class Igrac {
    private String ime;
    private Tabela tabela;
>>>>>>> origin/master

    public Igrac(String ime, short bule) {
        this.ime = ime;
        this.tabela = new Tabela(bule);
<<<<<<< HEAD
        this.mojSpiel = new ArrayList<>();
=======
>>>>>>> origin/master
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
<<<<<<< HEAD

    public void uzmiKartu(Karta karta) {
        this.mojSpiel.add(karta);
    }

    public ArrayList<Karta> getMojSpiel() {
        return mojSpiel;
    }
=======
>>>>>>> origin/master
}
