package pokino;

import java.util.ArrayList;
import java.util.Random;

public class Cartones {
    private ArrayList<Carton> cartones = new ArrayList<>();

    public Cartones() {
        inicializarDoceCartones();
    }

    //Method that inicializate the twelves Cartones in the list
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
            rellenarNullos(carton);

        }
    }

    //Method tha fill the first row with 4 of 5 same card, knowing that the four same cards can´t repeat in the others Cartones
    private void rellenarF1(Carta[][] carton, Baraja baraja) {//Coincidir 4 de 5
        Random rd = new Random();

        int posicionDistinta = rd.nextInt(carton[0].length); //Take a random position in the row (0-4), and this place gonna be null
        int cartaSelect = baraja.obtenerCartaAleatoria().getNumero(); //Take a random number in the Baraja, next this number gonna be repeat with all the simbols
        for (int i = 0; i < carton[0].length; i++) {
            if (i != posicionDistinta) {
                Carta carta = baraja.buscarCartaNumero(cartaSelect);
                carton[0][i] = carta;
                baraja.remove(carta);
            }
        }
    }

    //Method that fill the second row with a couple of same cards and the other with same 3 cards, seeing that the others Carton can´t repeat the same patron
    private void rellenarF2(Carta[][] carton, Baraja baraja, Baraja barajaPareja) {
        Random rd = new Random();

        int posicionDistintaPareja1 = rd.nextInt(carton[1].length); //Take a random position in the row (0-4), ant this place gonna be the first card of the couple
        int posicionDistintaPareja2;
        do {
            posicionDistintaPareja2 = rd.nextInt(carton[1].length);//Take a random position in the row (0-4), and this place gonna be the first card of the couple
        } while (posicionDistintaPareja1 == posicionDistintaPareja2);

        int numeroCarta1;
        do {
            numeroCarta1 = baraja.obtenerCartaAleatoria().getNumero(); //Take a random card number of the Baraja
        } while (baraja.buscarCartasNumeros(numeroCarta1).size() < 3);
        int numeroCarta2;
        do {
            numeroCarta2 = barajaPareja.obtenerCartaAleatoria().getNumero();//Take a random card number of the Baraja
        } while (numeroCarta1 == numeroCarta2);

        for (int i = 0; i < carton[1].length; i++) {
            if (posicionDistintaPareja1 != i && posicionDistintaPareja2 != i) { //3 same cards
                Carta carta = baraja.buscarCartaNumero(numeroCarta1);
                carton[1][i] = carta;
                baraja.remove(carta);
            } else {
                Carta carta = barajaPareja.buscarCartaNumero(numeroCarta2); //Couple of same cards
                carton[1][i] = carta;
                barajaPareja.remove(carta);
            }
        }

    }

    //Method that fill the center of the matrix, (in this case position [2][2]), seeing that the cards can´t be repeat in the Carton and in the others.
    private void rellenarCentro(Carta[][] carton) {
        Baraja baraja = new Baraja();
        int cartaSelect;

        boolean esIgual = false;
        do
        {//Bucle to see if the card is in the other Carton, the bucle will repeat with the card will be in the other Carton
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

        Carta carta = baraja.buscarCartaNumero(cartaSelect); //Fill the center of the matrix
        carton[2][2] = carta;
        baraja.remove(carta);
    }

    //Print Cartones
    public void mostrarCartones() {
        for (Carton carton : cartones) {
            System.out.println("*********************************************************");
            carton.imprimirCarton();
            System.out.println("*********************************************************");
        }
    }

    //Rellenar todos los null, introduciendo una carta aleatoria, sin que se repita en la baraja
    private void rellenarNullos(Carta[][] carton) {
        Baraja baraja = new Baraja();
        Carta cartaAleatoria;
        boolean esIgual = false;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {

                if (carton[i][j] == null) {
                    do {//loop repeated when one of the cards we generate equal to other card exist
                        cartaAleatoria = baraja.obtenerCartaAleatoria();
                        esIgual = false;
                        for (int k = 0; k < carton.length; k++) {
                            for (int l = 0; l < carton[k].length; l++) {

                                if (cartaAleatoria.equals(carton[k][l])) {
                                    esIgual = true;
                                    break;
                                }
                            }
                        }
                        carton[i][j] = cartaAleatoria;

                    } while (esIgual);
                }
            }
        }
    }
}



