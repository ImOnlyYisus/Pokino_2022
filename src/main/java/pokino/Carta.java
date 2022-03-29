package pokino;

import java.util.Objects;

public class Carta {
    private Simbolo simbolo;
    private int numero;
    private boolean estaMarcado;

    public Carta(Simbolo simbolo, int numero,boolean estaMarcado) {
        this.simbolo = simbolo;
        this.numero = numero;
        this.estaMarcado=estaMarcado;
    }

    public Simbolo getSimbolo() {
        return simbolo;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEstaMarcado() {
        return estaMarcado;
    }

    public void setEstaMarcado(boolean estaMarcado) {
        this.estaMarcado = estaMarcado;
    }

    //Equals is when a card simbol and card number is the same than the other
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
        return "Carta{" +
                "simbolo=" + simbolo +
                ", numero=" + numero +
                ", estaMarcado=" + estaMarcado +
                '}';
    }
}
