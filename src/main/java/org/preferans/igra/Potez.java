package org.preferans.igra;

import java.util.ArrayList;

public  class Potez {



    private ArrayList<Akcija> listaAkcija;

    public Potez() {
        this.listaAkcija = new ArrayList<>();
    }

    public ArrayList<Akcija> getListaAkcija() {
        return this.listaAkcija;
    }

    public void dodajAkciju(Akcija a){
        this.listaAkcija.add(a);
        if(listaAkcija.size()==3){
            Sesija.getInstance().getAktivnaPartija().zavrsnicaPoteza(this);
        }
    }


}
