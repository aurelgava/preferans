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
        try {
            while(!Sesija.getInstance().isFinished()) {
                synchronized (this) {
                    //vidi sta se desava u aktivnom potezu
                    Potez ap = Sesija.getInstance().getAktivnaPartija().getAktivanPotez();

                    //vidi sta mozes da odigras
                    ArrayList<Potez.Akcija> lva = super.getValidneAkcije(ap);

                    //igraj nesto
                    System.out.println(super.getIme() + ": " + lva.get(0));
                    ap.odigrajAkciju(  lva.get(0) );

                    //odigrao si. Cekaj sad
                    this.wait();

                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
