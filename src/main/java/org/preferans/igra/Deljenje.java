package org.preferans.igra;

import org.preferans.igraci.Igrac;
import org.preferans.pribor.Karta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Deljenje {
    //public static final byte BROJ_KARATA_U_SHPILU = 32;
    public static enum Stanje {
        START,
        KRAJ,
        LICITACIJA,
        IGRA,
        ODIGRAVANJE,
        KONTRIRANJE,
        DOLAZENJE,
        ISHOD}

    private Stanje stanje;
    private LinkedList<Potez> listaPoteza;
    private ArrayList<Karta> shpil;
    public Deljenje() {
        this.shpil = new ArrayList<>();
        //redjanje karata u spilu
        for(Karta.Broj broj : Karta.Broj.values())
            for(Karta.Znak znak : Karta.Znak.values())
                this.shpil.add(new Karta(broj,znak));
        this.stanje = Stanje.START;
        this.listaPoteza = new LinkedList<>();
    }

    public void podeliKarte(Igrac[] igraci) {
        //for(Karta k : this.shpil) System.out.println(k);
        int index;
        while(!this.shpil.isEmpty()) {
            index = (new Random()).nextInt(this.shpil.size());
            System.out.println(this.shpil.get(index));
            this.shpil.remove(index);
        }
        //todo
    }
}
