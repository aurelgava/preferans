package org.preferans.igraci;


import org.preferans.igra.Sesija;
import org.preferans.igra.Potez;

import java.util.ArrayList;

public class IgracAI extends Igrac implements Runnable{
    public IgracAI(String ime, short bule) {
        super(ime, bule);
    }

    @Override
    public void run() {
        while(!Sesija.getInstance().isFinished()){
            System.out.println(super.getIme() + ": "+ Potez.Akcije.DALJE);
            ArrayList<Potez.Akcije> listaAkcija = Sesija.getInstance().getAktivnaPartija().getValidneAkcije();
            Sesija.getInstance().getAktivnaPartija().odigraj(listaAkcija.get(0));
        }

    }
}
