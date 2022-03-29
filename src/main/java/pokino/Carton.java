package pokino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Carton {
    private Carta[][] carton = new Carta[5][5];

    public Carton() {
        //temporar
        carton = new Carta[][]{
                {new Carta(Simbolo.COPAS, 1,true), new Carta(Simbolo.COPAS, 0,false), new Carta(Simbolo.SOTA, 0,false), new Carta(Simbolo.SOTA, 9,false), new Carta(Simbolo.OROS, 0,false)},
                {new Carta(Simbolo.SOTA, 1,true), new Carta(Simbolo.SOTA, 2,true), new Carta(Simbolo.COPAS, 3,false), new Carta(Simbolo.SOTA, 3,false), new Carta(Simbolo.OROS, 9,false)},
                {new Carta(Simbolo.OROS, 1,true), new Carta(Simbolo.OROS, 3,true), new Carta(Simbolo.COPAS, 4,true), new Carta(Simbolo.SOTA, 5,true), new Carta(Simbolo.OROS, 3,true)},
                {new Carta(Simbolo.COPAS, 2,true), new Carta(Simbolo.COPAS, 4,false), new Carta(Simbolo.COPAS, 6,false), new Carta(Simbolo.SOTA, 8,true), new Carta(Simbolo.OROS, 4,false)},
                {new Carta(Simbolo.ESPADAS, 1,true), new Carta(Simbolo.ESPADAS, 5,false), new Carta(Simbolo.COPAS, 8,false), new Carta(Simbolo.SOTA, 6,false), new Carta(Simbolo.OROS, 5,true)}
        };
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

    //metodo para marcar la carta
    public void marcarCarta(int fila, int columna) {
        carton[fila][columna].setEstaMarcado(true);
    }

    //method looking if a cart exist in a carton or not
    public boolean isCartaExist(Carta carta) {
        boolean exist = false;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (carton[i][j].equals(carta)) {
                    marcarCarta(i,j);
                    return true;
                }
            }
        }
        return false;
    }


    //recorrer vertical carton and check if any columna have marked cards
    public boolean coincidenciaVertical() {
        boolean allSame = false; //true
        //TODO revisar fuciona, lo unico que al igualar cartas algunas son distintas, deberiamos poner estados en cartas "estaMarcado=true or false"
        for (int i = 0; i < carton[0].length; i++) { //recorre columnas fila 1
            for (int j = 0; j < carton.length; j++) { //recorrer columnas
                for (int k = j + 1; k < carton.length; k++) { //recorrer columnas + 1
                    if (!((carton[i][j].isEstaMarcado()==true)==(carton[i][k].isEstaMarcado()==true))) {
                        allSame = false;
                        break;
                    } else {
                        allSame = true;
                        return allSame;
                    }
                }
                if (!allSame) {
                    break;
                }
            }
        }

        return allSame;
    }

    //recorrer horizontal carton and check if any linea have marked cards
    public boolean coincidenciaLinea() {
        boolean allSame = false;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                for (int k = i + 1; k < carton.length; k++) {
                    if (!((carton[i][j].isEstaMarcado()==true)==(carton[i][k].isEstaMarcado()==true))) {
                        allSame = false;
                        break;
                    }else {
                        allSame = true;
                        return allSame;
                    }
                }
                if (!allSame) {
                    break;
                }
            }
        }
        return allSame;
    }

    public boolean coincidenciaDiagonal() {
        Carta cartaRecojada;
        boolean coincidencia = true;

        //Diagonal principal
        cartaRecojada = carton[0][0];
        for (int i = 1; i < carton.length; i++) {
            if (cartaRecojada != carton[i][i]) {
                coincidencia = false;
            }
        }
        return coincidencia;
    }

    public boolean coincidenciaDiagonalInversa() {
        //Diagonal inversa
        boolean coincidencia = true;
        Carta cartaRecojada = carton[0][2];
        for (int i = 1, j = 1; i < carton.length; i++, j--) {
            if (cartaRecojada != carton[i][j]) {
                coincidencia = false;
            }
        }
        return coincidencia;
    }

    



    //method check premio pokino
   /* public String checkPremioPokino(){
        String premio="pokino";
     if(coincidenciaVertical() || coincidenciaDiagonal() || coincidenciaDiagonalInversa() || coincidenciaLinea() ){
         return premio;
     }
     return "noHayPremio";

    }*/

}
