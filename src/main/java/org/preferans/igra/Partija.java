package org.preferans.igra;

import org.preferans.pribor.Talon;
import org.preferans.pribor.Kup;

import java.util.ArrayList;

public class Partija {
    private ArrayList<Deljenje> listaPartija;
    private Talon talon;
    private Kup kup;
    private Deljenje aktivnoDeljenje;
    private static Partija instanca;
    public static Partija getInstance(){
        if(instanca==null) instanca = new Partija();
        return instanca;
    }
    public static Partija getNewInstance() {
        return instanca = new Partija();
    }
    private Partija() {
        this.listaPartija = new ArrayList<>();
        this.zapocniNovuPartiju();
    }



    public ArrayList<Deljenje> getListaPartija() {
        return listaPartija;
    }
    public void zapocniNovuPartiju() {
        this.talon = new Talon();
        this.kup = new Kup();
        this.aktivnoDeljenje = new Deljenje();
    }

    public Deljenje getAktivnoDeljenje() {
        return aktivnoDeljenje;
    }

    public Talon getTalon() {
        return talon;
    }

    public Kup getKup() {
        return kup;
    }
}
