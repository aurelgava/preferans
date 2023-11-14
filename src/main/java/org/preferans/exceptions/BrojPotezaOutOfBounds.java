package org.preferans.exceptions;

public class BrojPotezaOutOfBounds extends IndexOutOfBoundsException{
    @Override
    public String toString() {
        return "Maksimalan broj poteza je tri!";
    }
}
