package org.preferans.igraci;


import org.preferans.igra.Akcija;
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
        ArrayList<Akcija> lva = super.getValidneAkcije(ap);

        //igraj nesto
        int i = new Random().nextInt(lva.size());
        System.out.print(super.getIme() + ": " + lva.get(i) + "             ");
        lva.forEach( (e)-> System.out.print(e+",") );
        System.out.println("");
        ap.dodajAkciju(  lva.get(i) );





    }
}
