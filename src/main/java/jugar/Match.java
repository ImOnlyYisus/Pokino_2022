package jugar;

import pokino.Baraja;
import pokino.Carta;
import pokino.Carton;

public class Match {
    private Baraja barajaJuego = new Baraja();

    public Match() {
    }

    public boolean comprobarPokino(Carton carton){
        return carton.checkPremioPokino();
    }

    public String premio(Carton carton){
        return carton.recorrerMap();
    }

    public Carta nextCarta(){
        Carta cartaRonda = barajaJuego.obtenerCartaAleatoria();
        barajaJuego.remove(cartaRonda);
        return cartaRonda;
    }


}
