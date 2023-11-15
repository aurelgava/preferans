package org.preferans.igra;

import java.util.ArrayList;

public  class Potez {

    public static enum Akcija {DALJE,IGRA,DVA,TRI,CETIRI,PET,SEST,SEDAM,DOBAR,
                                PIK,KARO,HERC,TREF,BETL,SANS,PRATIM,NE_PRATIM,
                                KONTRA,REKONTRA,SUBKONTRA,MORTKONTRA,MOZE,
                                P7,P8,P9,P10,PJ,PD,PK,PA,
                                K7,K8,K9,K10,KJ,KD,KK,KA,
                                H7,H8,H9,H10,HJ,HD,HK,HA,
                                T7,T8,T9,T10,TJ,TD,TK,TA;
                                private static final Akcija[] vals = values();
                                public Akcija nextAction(){
                                    if(this.ordinal()==DOBAR.ordinal()) return DOBAR;
                                    return vals[(this.ordinal() + 1) % vals.length];
                                }
    }

    private ArrayList<Akcija> listaAkcija;

    public Potez() {
        this.listaAkcija = new ArrayList<>();
    }

    public ArrayList<Akcija> getListaAkcija() {
        return this.listaAkcija;
    }

    public void odigrajAkciju(Akcija a){
        this.listaAkcija.add(a);
        if(listaAkcija.size()==3){
            Sesija.getInstance().getAktivnaPartija().zavrsnicaPoteza(this);
        }
    }


}
