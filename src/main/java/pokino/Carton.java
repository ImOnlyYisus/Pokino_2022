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
}
