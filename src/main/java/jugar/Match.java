package jugar;

import pokino.Baraja;
import pokino.Carta;
import pokino.Carton;

public class Match {
    private Baraja barajaJuego = new Baraja();

    public Match() {
    }

    public boolean comprobarPremios(Carton carton){
        if(carton.coincidenciaVertical() || carton.coincidenciaLinea() || carton.coincidenciaDiagonal() || carton.coincidenciaDiagonalInversa()){
            return true;
        }
        return false;
    }

    public Carta nextCarta(){
        Carta cartaRonda = barajaJuego.obtenerCartaAleatoria();
        barajaJuego.remove(cartaRonda);
        return cartaRonda;
    }
}
