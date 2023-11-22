package org.preferans.igraci;

import org.preferans.exceptions.BrojPotezaOutOfBounds;
import org.preferans.igra.*;
import org.preferans.pribor.Karta;

import java.util.ArrayList;

public abstract class Igrac implements UzimacKarata {

    protected String ime;
    protected Tabela tabela;
    protected ArrayList<Karta> mojSpiel;

    public Igrac(String ime, short bule) {
        this.ime = ime;
        this.tabela = new Tabela(bule);
        this.mojSpiel = new ArrayList<>();

    }



    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void uzmiKartu(Karta karta) {
        this.mojSpiel.add(karta);
    }

    public ArrayList<Karta> getMojSpiel() {
        return mojSpiel;
    }

    protected ArrayList<Akcija> getValidneAkcije(Potez ap) {
        try {
            ArrayList<Akcija> listaValidnihAkcija = new ArrayList<>();

            switch (Sesija.getInstance().getAktivnaPartija().getStanje()) {
                case START:
                    listaValidnihAkcija.addAll( DrvoAkcija.getInstance().getChildrenOfNode( ap.getListaAkcija() ));
                    break;
                case KRAJ:
                    break;
                case LICITACIJA:
                    //todo
                    break;
                case IGRA:
                    //todo
                    break;
                case ODIGRAVANJE:
                    //todo
                    break;
                case KONTRIRANJE:
                    //todo
                    break;
                case DOLAZENJE:
                    //todo
                    break;

            }
            return listaValidnihAkcija;
        }catch (BrojPotezaOutOfBounds e){
            System.out.println(e);
            return null;
        }
    }

    public void zapisi(Beleska beleska) {
        if(beleska.isRefe()){
            System.out.println("Dodao bih refe");
            this.tabela.dodajRefe();

        }

    }
    public abstract void odigraj();
}
