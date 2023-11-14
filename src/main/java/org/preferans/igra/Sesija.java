package org.preferans.igra;

import org.preferans.pribor.Talon;
import org.preferans.pribor.Kup;

import java.util.ArrayList;

public class Sesija {
    private ArrayList<Partija> listaPartija;
    private Talon talon;
    private Kup kup;
    private Partija aktivnaPartija;
    private static Sesija instanca;
    private boolean isFinished;
    public static Sesija getInstance(){
        if(instanca==null) instanca = new Sesija();
        return instanca;
    }
    public static Sesija getNewInstance() {
        return instanca = new Sesija();
    }
    private Sesija() {
        this.isFinished = false;
        this.listaPartija = new ArrayList<>();
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
}
