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
        System.out.println(carton.coincidenciaLinea());
        System.out.println(carton.coincidenciaVertical());
        System.out.println(carton.checkPremioPokino());
        System.out.println(carton.recorrerMap());
//        carton.mostrar();
//        carton.recorrerMap();

    }
}
