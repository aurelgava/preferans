package org.preferans.igra;

import org.preferans.exceptions.NepostojeceStanje;
import org.preferans.igraci.Igrac;
import org.preferans.pribor.Karta;
import org.preferans.pribor.Kup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Partija {

    public void zavrsnicaPoteza(Potez potez) {
        try {
            Igrac i1 = Sesija.getInstance().getIgraci().get(0);
            Igrac i2 = Sesija.getInstance().getIgraci().get(1);
            Igrac i3 = Sesija.getInstance().getIgraci().get(2);

            Akcija a1 = potez.getListaAkcija().get(0);
            Akcija a2 = potez.getListaAkcija().get(1);
            Akcija a3 = potez.getListaAkcija().get(2);
            //System.out.println("Akcije: "+a1+","+a2+","+a3);
            switch (stanje){
                case START:
                    if(a1==Akcija.DVA || a2==Akcija.DVA || a3==Akcija.DVA){
                        stanje = Stanje.LICITACIJA;
                    }
                    if(a1==Akcija.IGRA || a2==Akcija.IGRA || a3==Akcija.IGRA){
                        stanje = Stanje.IGRA;
                    }
                    if(a1==Akcija.BETL || a2==Akcija.BETL || a3==Akcija.BETL){
                        stanje = Stanje.IGRA;
                    }
                    if(a1==Akcija.SANS || a2==Akcija.SANS || a3==Akcija.SANS){
                        stanje = Stanje.IGRA;
                    }
                    if(a1==Akcija.DALJE && a2==Akcija.DALJE && a3==Akcija.DALJE) {
                        i1.zapisi(new Beleska(true));
                        i2.zapisi(new Beleska(true));
                        i3.zapisi(new Beleska(true));
                        stanje = Stanje.KRAJ;
                    }
                    break;
                case IGRA:
                    //todo
                    break;
                case LICITACIJA:
                    //todo
                    break;
                case DOLAZENJE:
                    //todo
                    break;
                case KONTRIRANJE:
                    //todo
                    break;
                case ODIGRAVANJE:
                    //todo
                    break;
                case KRAJ:
                    //todo
                    break;
                default: throw new NepostojeceStanje();
            }
            System.out.println(">>>>>"+stanje+"<<<<<<");
            potez.getListaAkcija().clear();
        } catch (NepostojeceStanje e) {
            throw new RuntimeException(e);
        }
    }

    public Stanje getStanje() {
        return stanje;
    }


    public static enum Stanje {
        START,
        KRAJ,
        LICITACIJA,
        IGRA,
        ODIGRAVANJE,
        KONTRIRANJE,
        DOLAZENJE
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

    public void podeliKarte(ArrayList<Igrac> igraci) {
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
            Sesija.getInstance().getKup().uzmiKartu(this.shpil.remove(this.shpil.size() - 1));
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

    public void run(){
        ArrayList<Igrac> igraci = Sesija.getInstance().getIgraci();
        this.podeliKarte(igraci);
        while(this.stanje!=Stanje.KRAJ){
            igraci.get(0).odigraj();
            igraci.get(1).odigraj();
            igraci.get(2).odigraj();
            System.out.println("-------------");
        }
    }
}
