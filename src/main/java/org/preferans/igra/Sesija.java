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
        instanca = new Sesija();
        instanca.igraci = new ArrayList<>();
        IgracAI i1 =  new IgracAI("Predrag",bule);
        IgracAI i2 =  new IgracAI("Frantz",bule);
        IgracAI i3 =  new IgracAI("Eintz",bule);
        instanca.igraci.add(i1);
        instanca.igraci.add(i2);
        instanca.igraci.add(i3);

        instanca.run();

    }
    private void run(){
        while(!instanca.isFinished) {
            this.zapocniNovuPartiju();
            this.getAktivnaPartija().run();
        }
    }
    private Sesija() {
        this.isFinished = false;
        this.listaPartija = new ArrayList<>();
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
