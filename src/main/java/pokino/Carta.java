package pokino;

import java.util.Objects;

public class Carta {
    private Simbolo simbolo;
    private int numero;

    public Carta(Simbolo simbolo, int numero) {
        this.simbolo = simbolo;
        this.numero = numero;
    }

    public Simbolo getSimbolo() {
        return simbolo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carta)) return false;
        Carta carta = (Carta) o;
        return numero == carta.numero && simbolo == carta.simbolo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(simbolo, numero);
    }

    @Override
    public String toString() {
        return this.numero + "-"+this.simbolo;
    }
}
