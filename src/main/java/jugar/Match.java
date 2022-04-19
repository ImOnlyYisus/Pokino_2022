package jugar;

import pokino.Baraja;
import pokino.Carta;
import pokino.Carton;

import java.util.ArrayList;

public class Match {
    private Baraja barajaJuego = new Baraja();
    private ArrayList<String> premios = new ArrayList<>();

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

    public Baraja getBarajaJuego() {
        return barajaJuego;
    }

    public ArrayList<String> getPremios() {
        return premios;
    }

    public void añadirPremio(String premio){
        premios.add(premio);
    }
}
