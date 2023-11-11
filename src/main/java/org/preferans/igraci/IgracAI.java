package org.preferans.igraci;


import org.preferans.igra.Partija;
import org.preferans.igra.Potez;
import org.test.preferans.Main;

public class IgracAI extends Igrac implements Runnable{
    public IgracAI(String ime, short bule) {
        super(ime, bule);
    }

    @Override
    public void run() {
        while(!Partija.getInstance().isFinished()){

            System.out.println(super.getIme() + ": "+ Potez.Akcije.DALJE);
            Partija.getInstance().getAktivnoDeljenje().getAktivanPotez().getListaAkcija().add(Potez.Akcije.DALJE);
            
        }

    }
}
