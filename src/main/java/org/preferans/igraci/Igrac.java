package org.preferans.igraci;

import org.preferans.exceptions.BrojPotezaOutOfBounds;
import org.preferans.igra.*;
import org.preferans.pribor.Karta;

import java.util.ArrayList;

public abstract class Igrac implements UzimacKarata {
    private String ime;
    private Tabela tabela;
    private ArrayList<Karta> mojSpiel;

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

    protected ArrayList<Potez.Akcije> getValidneAkcije(Potez ap) {
        try {
            ArrayList<Potez.Akcije> listaValidnihAkcija = new ArrayList<>();
            switch (Sesija.getInstance().getAktivnaPartija().getStanje()) {
                case START:
                    listaValidnihAkcija.add(Potez.Akcije.DALJE);
                    listaValidnihAkcija.add(Potez.Akcije.IGRA);
                    switch (ap.getListaAkcija().size()) {
                        case 0:
                            listaValidnihAkcija.add(Potez.Akcije.DVA);
                            break;
                        case 1:
                            listaValidnihAkcija.add( ap.getListaAkcija().get(0).nextAction() );
                            break;
                        case 2:
                            listaValidnihAkcija.add( ap.getListaAkcija().get(1).nextAction() );
                            break;
                        default:
                            throw new BrojPotezaOutOfBounds();
                    }
                    break;
                case KRAJ:
                    break;
                case LICITACIJA:
                    break;
                case IGRA:
                    break;
                case ODIGRAVANJE:
                    break;
                case KONTRIRANJE:
                    break;
                case DOLAZENJE:
                    break;
                case ISHOD:
                    break;
            }
            return listaValidnihAkcija;
        }catch (BrojPotezaOutOfBounds e){
            System.out.println(e);
            return null;
        }
    }
}
