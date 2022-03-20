package pokino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Baraja {
    private ArrayList<Carta> cartas = new ArrayList<>();

    public Baraja() {
        inicializarBaraja();
    }

    private void inicializarBaraja(){
        for (int i = 0; i <Simbolo.values().length ; i++) {
            for (int j = 0; j <12 ; j++) {
                switch (i){
                    case 0://COPAS
                        cartas.add(new Carta(Simbolo.COPAS,j+1));
                        break;
                    case 1://OROS
                        cartas.add(new Carta(Simbolo.OROS,j+1));
                        break;
                    case 2://ESPADAS
                        cartas.add(new Carta(Simbolo.ESPADAS,j+1));
                        break;
                    case 3://SOTA
                        cartas.add(new Carta(Simbolo.SOTA,j+1));
                        break;
                }
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void imprimirCartas(){
        cartas.forEach(System.out::println);
    }

    public void shuffleBaraja(){
        Collections.shuffle(cartas);
    }

    public void remove(Carta carta){
        cartas.remove(carta);
    }

    public Carta buscarCartaNumero(int numero){
       Carta cartaBuscada=null;
       Comparator<Carta> criterioNumero = (c1,c2)-> Integer.compare(c1.getNumero(),c2.getNumero());
       Collections.sort(cartas,criterioNumero);
       int index = Collections.binarySearch(cartas,new Carta(null,numero),criterioNumero);

       if(index>-1){
           cartaBuscada=cartas.get(index);
       }

        return cartaBuscada;
    }

    public ArrayList<Carta> buscarCartasNumeros(int numero){
        ArrayList<Carta> cartasBuscadas=new ArrayList<>();
        for (int i = 0; i <cartas.size() ; i++) {
            if(cartas.get(i).getNumero()==numero){
                cartasBuscadas.add(cartas.get(i));
            }
        }

        return cartasBuscadas;
    }

    public int numeroCartas(){
        return cartas.size();
    }

    public Carta obtenerCartaAleatoria(){
        Random rd = new Random();
        if(!cartas.isEmpty()) {
            return cartas.get(rd.nextInt(numeroCartas()));
        }

        return null;
    }
}
