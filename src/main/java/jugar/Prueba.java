package jugar;

import pokino.Baraja;
import pokino.Carta;
import pokino.Carton;
import pokino.Simbolo;

public class Prueba {
    public static void main(String[] args) {
        Carton carton = new Carton();
        //imprimir carton
        carton.imprimirCarton();

        System.out.println(carton.checkPremioPokino());
//        carton.mostrar();
//        carton.recorrerMap();

    }
}
