package pokino;

import java.util.ArrayList;
import java.util.Random;

public class Cartones {
    private ArrayList<Carton> cartones = new ArrayList<>();

    public Cartones() {
        inicializarDoceCartones();
    }

    private void inicializarDoceCartones() {
        Baraja baraja1 = new Baraja();
        Baraja baraja2Trio = new Baraja();
        Baraja baraja2Pareja = new Baraja();
        for (int i = 0; i < 12; i++) {
            cartones.add(new Carton());
            Carta[][] carton = cartones.get(i).getCarton();
            rellenarF1(carton, baraja1);
            rellenarF2(carton, baraja2Trio, baraja2Pareja);
            rellenarCentro(carton);

        }
    }

    private void rellenarF1(Carta[][] carton, Baraja baraja) {//Coincidir 4 de 5
        Random rd = new Random();

        int posicionDistinta = rd.nextInt(carton[0].length);
        int cartaSelect = baraja.obtenerCartaAleatoria().getNumero();
        for (int i = 0; i < carton[0].length; i++) {
            if (i != posicionDistinta) {
                Carta carta = baraja.buscarCartaNumero(cartaSelect);
                carton[0][i] = carta;
                baraja.remove(carta);
            }
        }
    }

    private void rellenarF2(Carta[][] carton, Baraja baraja, Baraja barajaPareja) {
        Random rd = new Random();

        int posicionDistintaPareja1 = rd.nextInt(carton[1].length);
        int posicionDistintaPareja2;
        do {
            posicionDistintaPareja2 = rd.nextInt(carton[1].length);
        } while (posicionDistintaPareja1 == posicionDistintaPareja2);

        int numeroCarta1;
        do {
            numeroCarta1 = baraja.obtenerCartaAleatoria().getNumero();
        } while (baraja.buscarCartasNumeros(numeroCarta1).size() < 3);
        int numeroCarta2;
        do {
            numeroCarta2 = barajaPareja.obtenerCartaAleatoria().getNumero();
        } while (numeroCarta1 == numeroCarta2);

        for (int i = 0; i < carton[1].length; i++) {
            if (posicionDistintaPareja1 != i && posicionDistintaPareja2 != i) {
                Carta carta = baraja.buscarCartaNumero(numeroCarta1);
                carton[1][i] = carta;
                baraja.remove(carta);
            } else {
                Carta carta = barajaPareja.buscarCartaNumero(numeroCarta2);
                carton[1][i] = carta;
                baraja.remove(carta);
            }
        }

    }

    private void rellenarCentro(Carta[][] carton) {
        Baraja baraja = new Baraja();
        int cartaSelect;

        //Centro es la posicion [2][2]
        boolean esIgual = false;
        do {
            esIgual = false;
            cartaSelect = baraja.obtenerCartaAleatoria().getNumero();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < carton[i].length; j++) {
                    if (carton[i][j] != null) {
                        if (carton[i][j].getNumero() == cartaSelect) {
                            esIgual = true;
                        }
                    }

                }
            }
        } while (esIgual);

        Carta carta = baraja.buscarCartaNumero(cartaSelect);
        carton[2][2] = carta;
        baraja.remove(carta);
    }


    public void mostrarCartones() {
        for (Carton carton : cartones) {
            System.out.println("*********************************************************");
            carton.imprimirCarton();
            System.out.println("*********************************************************");
        }
    }
}
