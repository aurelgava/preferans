package org.preferans.igraci;


import org.preferans.igra.Sesija;
import org.preferans.igra.Potez;

import java.util.ArrayList;
import java.util.Random;

public class IgracAI extends Igrac{
    public IgracAI(String ime, short bule) {
        super(ime, bule);
    }

    @Override
    public void odigraj() {

        //vidi sta se desava u aktivnom potezu
        Potez ap = Sesija.getInstance().getAktivnaPartija().getAktivanPotez();

        //vidi sta mozes da odigras
        ArrayList<Potez.Akcija> lva = super.getValidneAkcije(ap);

        //igraj nesto
        int i = new Random().nextInt(lva.size());
        System.out.println(super.getIme() + ": " + lva.get(i));
        ap.odigrajAkciju(  lva.get(i) );





    }
}
