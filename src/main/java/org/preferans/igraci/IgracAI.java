package org.preferans.igraci;


import org.preferans.igra.Partija;
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
            Potez ap = Sesija.getInstance().getAktivnaPartija().getAktivanPotez();
            ArrayList<Potez.Akcije> lva = super.getValidneAkcije(ap);
            ap.getListaAkcija().add( lva.get(0) );
            for (Potez.Akcije a : lva){
               System.out.println(super.getIme() + ": " + a);
            }
            System.out.println("************");
            //todo
        }

    }
}
