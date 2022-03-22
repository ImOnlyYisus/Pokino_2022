package pokino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Carton {
    private Carta[][] carton = new Carta[5][5];

    public Carton() {
    }

    public void imprimirCarton() {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                System.out.print(carton[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public Carta[][] getCarton() {
        return carton;
    }

    //method looking if a cart exist in a carton or not
    public boolean isCartaExist(Carta carta){
        boolean exist=false;
        for (int i = 0; i <carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if(carton[i][j].equals(carta)){
                    return true;
                }
            }
        }
        return false;
    }

    //method check premio centro
    public void checkPremioCentro(){

    }
}
