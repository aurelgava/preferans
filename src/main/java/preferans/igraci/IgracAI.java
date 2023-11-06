package preferans.igraci;

import preferans.Igrac;
import preferans.igra.Partija;

public class IgracAI extends Igrac implements Runnable{


    public IgracAI(String ime, short bule) {
        super(ime, bule);
    }

    @Override
    public void run() {
        //todo
        Partija.getPartija();
    }
}
