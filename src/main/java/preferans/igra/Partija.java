package preferans.igra;

import java.util.ArrayList;

public class Partija {
    public static enum Stanja {
        START,
        KRAJ,
        LICITACIJA,
        IGRA,
        ODIGRAVANJE,
        KONTRIRANJE,
        DOLAZENJE,
        ISHOD}
    private Stanja stanje;
    private ArrayList<Potez> listaPoteza;

    private static Partija partija_instanca=null;

    public static Partija getPartija(){
        if(partija_instanca==null){
            partija_instanca = new Partija();
        }
        return partija_instanca;
    }

    public static Partija getNewPartija(){
        partija_instanca = new Partija();
        return partija_instanca;
    }

    private Partija() {
        this.stanje = Stanja.START;
        this.listaPoteza = new ArrayList<>();
    }
}
