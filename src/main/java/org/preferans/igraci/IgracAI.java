package org.preferans.igraci;


import org.preferans.igra.Sesija;
import org.preferans.igra.Potez;

public class IgracAI extends Igrac implements Runnable{
    public IgracAI(String ime, short bule) {
        super(ime, bule);
    }

    @Override
    public void run() {
        while(!Sesija.getInstance().isFinished()){

            System.out.println(super.getIme() + ": "+ Potez.Akcije.DALJE);
            Sesija.getInstance().getAktivnoDeljenje().getAktivanPotez().getListaAkcija().add(Potez.Akcije.DALJE);
            
        }

    }
}
