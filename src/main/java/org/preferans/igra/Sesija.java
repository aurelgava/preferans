package org.preferans.igra;

import org.preferans.igraci.Igrac;
import org.preferans.igraci.IgracAI;
import org.preferans.pribor.Talon;
import org.preferans.pribor.Kup;

import java.util.ArrayList;

public class Sesija {
    private ArrayList<Igrac> igraci;
    private ArrayList<Partija> listaPartija;
    private Talon talon;
    private Kup kup;
    private Partija aktivnaPartija;
    private static Sesija instanca;
    private boolean isFinished;
    public static Sesija getInstance(){
        return instanca;
    }
    public static void zapocniNovuSesiju(short bule) {
        ArrayList<Igrac> igraci = new ArrayList<>();
        IgracAI i1 =  new IgracAI("Predrag",bule);
        IgracAI i2 =  new IgracAI("Frantz",bule);
        IgracAI i3 =  new IgracAI("Eintz",bule);
        igraci.add(i1);
        igraci.add(i2);
        igraci.add(i3);
        instanca = new Sesija(igraci);
        instanca.getAktivnaPartija().podeliKarte(igraci);

        i1.setMojPotez(true);
        new Thread(i1).start();
        new Thread(i2).start();
        new Thread(i3).start();

    }
    private Sesija(ArrayList<Igrac> igraci) {
        this.isFinished = false;
        this.listaPartija = new ArrayList<>();
        this.igraci =igraci;
        this.zapocniNovuPartiju();
    }

    public ArrayList<Partija> getListaPartija() {
        return listaPartija;
    }
    public void zapocniNovuPartiju() {
        this.talon = new Talon();
        this.kup = new Kup();
        this.aktivnaPartija = new Partija();
    }

    public Partija getAktivnaPartija() {
        return aktivnaPartija;
    }

    public Talon getTalon() {
        return talon;
    }

    public Kup getKup() {
        return kup;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public ArrayList<Igrac> getIgraci() {
        return igraci;
    }


}
