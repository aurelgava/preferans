package org.preferans.igra;

import org.preferans.igraci.Igrac;
import org.preferans.pribor.Karta;
import org.preferans.pribor.Kup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Partija {
    public static enum Stanje {
        START,
        KRAJ,
        LICITACIJA,
        IGRA,
        ODIGRAVANJE,
        KONTRIRANJE,
        DOLAZENJE,
        ISHOD
    }


    private Stanje stanje;
    private LinkedList<Potez> listaPoteza;
    private ArrayList<Karta> shpil;
    private Potez aktivanPotez;
    public Partija() {
        this.shpil = new ArrayList<>();
        //redjanje karata u spilu
        for(Karta.Broj broj : Karta.Broj.values())
            for(Karta.Znak znak : Karta.Znak.values())
                this.shpil.add(new Karta(broj,znak));
        this.stanje = Stanje.START;
        this.listaPoteza = new LinkedList<>();
        this.aktivanPotez = new Potez();
    }

    public void podeliKarte(ArrayList<Igrac> igraci, Kup k) {
        //for(Karta k : this.shpil) System.out.println(k);
        int index;
        while(this.shpil.size() > Kup.BROJ_KUP_KARATA) {
            for(Igrac igrac : igraci ){
                index = (new Random()).nextInt(this.shpil.size());
                //System.out.println(this.shpil.get(index));
                igrac.uzmiKartu(this.shpil.get(index));
                this.shpil.remove(index);
            }
        }
        while( !this.shpil.isEmpty() ){
            k.uzmiKartu(this.shpil.remove(this.shpil.size() - 1));
        }

        /*
        for(Igrac igrac : igraci ){
            for(Karta karta : igrac.getMojSpiel()){
                System.out.print(karta+" ");
            }
            System.out.println();
        }
        for(Karta karta : k.getKupKarte()){
            System.out.print(karta+" ");
        }*/
        //todo
    }

    public Potez getAktivanPotez() {
        return aktivanPotez;
    }
}
