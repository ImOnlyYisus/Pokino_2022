package pokino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Baraja {
    //attributes
    private ArrayList<Carta> cartas = new ArrayList<>();

    //constrictor
    public Baraja() {
        inicializarBaraja();
    }

    //Method that fill the list with 48 cards
    private void inicializarBaraja(){
        for (int i = 0; i <Simbolo.values().length ; i++) {
            for (int j = 0; j <12 ; j++) {
                switch (i){
                    case 0://COPAS
                        cartas.add(new Carta(Simbolo.COPAS,j+1,false));
                        break;
                    case 1://OROS
                        cartas.add(new Carta(Simbolo.OROS,j+1,false));
                        break;
                    case 2://ESPADAS
                        cartas.add(new Carta(Simbolo.ESPADAS,j+1,false));
                        break;
                    case 3://SOTA
                        cartas.add(new Carta(Simbolo.SOTA,j+1,false));
                        break;
                }
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    //Print baraja in console
    public void imprimirCartas(){
        cartas.forEach(System.out::println);
    }

    //Mixing the baraja
    public void shuffleBaraja(){
        Collections.shuffle(cartas);
    }

    //Remove a card from list by passing specific card
    public void remove(Carta carta){
        cartas.remove(carta);
    }

    //Method that search a card by passing the number as parameter
    public Carta buscarCartaNumero(int numero){
       Carta cartaBuscada=null;
       Comparator<Carta> criterioNumero = (c1,c2)-> Integer.compare(c1.getNumero(),c2.getNumero());
       Collections.sort(cartas,criterioNumero);
       int index = Collections.binarySearch(cartas,new Carta(null,numero,false),criterioNumero);

       if(index>-1){
           cartaBuscada=cartas.get(index);
       }

        return cartaBuscada;
    }

    //Method that search all cards in the baraja by passing the number as parameter
    public ArrayList<Carta> buscarCartasNumeros(int numero){
        ArrayList<Carta> cartasBuscadas=new ArrayList<>();
        for (int i = 0; i <cartas.size() ; i++) {
            if(cartas.get(i).getNumero()==numero){
                cartasBuscadas.add(cartas.get(i));
            }
        }

        return cartasBuscadas;
    }

    //Return the size of the actual baraja
    public int numeroCartas(){
        return cartas.size();
    }

    //Return a random card of baraja
    public Carta obtenerCartaAleatoria(){
        Random rd = new Random();
        if(!cartas.isEmpty()) {
            return cartas.get(rd.nextInt(numeroCartas()));
        }

        return null;
    }

    @Override
    public String toString() {
        return "Baraja{" +
                "cartas=" + cartas +
                '}';
    }
}
