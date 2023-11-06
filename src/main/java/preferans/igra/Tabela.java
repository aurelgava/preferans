package preferans.igra;

public class Tabela {
    private byte brojPreostalihRefea, brojAktivnihRefea;
    private short supeLevi,supeDesni,bule;

    public Tabela(short bule) {
        this.supeLevi = 0;
        this.supeDesni = 0;
        this.bule = bule;
        this.brojPreostalihRefea = (byte)(this.bule/50);
        this.brojAktivnihRefea = 0;
    }

    public byte getBrojPreostalihRefea() {
        return brojPreostalihRefea;
    }

    public void setBrojPreostalihRefea(byte brojPreostalihRefea) {
        this.brojPreostalihRefea = brojPreostalihRefea;
    }

    public byte getBrojAktivnihRefea() {
        return brojAktivnihRefea;
    }

    public void setBrojAktivnihRefea(byte brojAktivnihRefea) {
        this.brojAktivnihRefea = brojAktivnihRefea;
    }

    public short getSupeLevi() {
        return supeLevi;
    }

    public void setSupeLevi(short supeLevi) {
        this.supeLevi = supeLevi;
    }

    public short getSupeDesni() {
        return supeDesni;
    }

    public void setSupeDesni(short supeDesni) {
        this.supeDesni = supeDesni;
    }

    public short getBule() {
        return bule;
    }

    public void setBule(short bule) {
        this.bule = bule;
    }
}
