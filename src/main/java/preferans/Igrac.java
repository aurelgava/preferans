package preferans;

import preferans.igra.Tabela;

public abstract class Igrac {
    private String ime;
    private Tabela tabela;

    public Igrac(String ime, short bule) {
        this.ime = ime;
        this.tabela = new Tabela(bule);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
