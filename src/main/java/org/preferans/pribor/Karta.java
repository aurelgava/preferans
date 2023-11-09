package org.preferans.pribor;

public class Karta {
    public static enum Broj { SEDAM, OSAM, DEVET, DESET, ZANDAR, DAMA, KRALJ, KEC }
    public static enum Znak { PIK, KARO, HERC, TREF }

    private Broj broj;
    private Znak znak;
    public Karta() {
    }
    public Karta(Broj broj, Znak znak) {
        this.broj = broj;
        this.znak = znak;
    }

    @Override
    public String toString() {
        String cardSymbol="";
        switch (this.broj){
            case KEC: cardSymbol = String.valueOf('A');break;
            case KRALJ: cardSymbol = String.valueOf('K');break;
            case DAMA: cardSymbol = String.valueOf('D');break;
            case ZANDAR: cardSymbol = String.valueOf('J');break;
            case DESET: cardSymbol = String.valueOf(10);break;
            case DEVET: cardSymbol = String.valueOf('9');break;
            case OSAM: cardSymbol = String.valueOf('8');break;
            case SEDAM: cardSymbol = String.valueOf('7');break;
        }
        switch(this.znak){
            case PIK:  cardSymbol += String.valueOf('♠');break;
            case KARO:  cardSymbol += String.valueOf('♢');break;
            case HERC:  cardSymbol += String.valueOf('♡');break;
            case TREF:  cardSymbol += String.valueOf('♣');break;
        }
        //return  this.broj + " " + this.znak;
        return cardSymbol;
    }
}
