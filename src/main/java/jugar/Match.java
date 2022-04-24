package jugar;

import pokino.Baraja;
import pokino.Carta;
import pokino.Carton;

import java.util.ArrayList;

public class Match { //Class to play, use methods from other class
    private Baraja barajaJuego = new Baraja();
    private ArrayList<String> premios = new ArrayList<>();

    public Match() {
    }

    //Check pokino prize, return true if you won and false if you lose
    public boolean comprobarPokino(Carton carton){
        return carton.checkPremioPokino();
    }

    //Check other pokinos prizes like poker, estampa.. , return the prize that you won
    public String premio(Carton carton){
        return carton.recorrerMap();
    }

    //Return a random card and remove to the baraja
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

    //Method that add on the array the prize, to check if the prize is won before or not
    public void añadirPremio(String premio){
        premios.add(premio);
    }
}
