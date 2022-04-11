package pokino;

import java.util.*;

public class Carton {
    private Carta[][] carton = new Carta[5][5];
    private Map<String,ArrayList<Casilla>> map=new HashMap<>();

    public Carton() {
        //temporar
        carton = new Carta[][]{
                {new Carta(Simbolo.COPAS, 1,true), new Carta(Simbolo.COPAS, 0,false), new Carta(Simbolo.SOTA, 0,false), new Carta(Simbolo.SOTA, 9,false), new Carta(Simbolo.OROS, 0,false)},
                {new Carta(Simbolo.SOTA, 1,false), new Carta(Simbolo.SOTA, 2,true), new Carta(Simbolo.COPAS, 3,false), new Carta(Simbolo.SOTA, 3,false), new Carta(Simbolo.OROS, 9,false)},
                {new Carta(Simbolo.OROS, 1,false), new Carta(Simbolo.OROS, 3,false), new Carta(Simbolo.COPAS, 4,true), new Carta(Simbolo.SOTA, 5,false), new Carta(Simbolo.OROS, 3,false)},
                {new Carta(Simbolo.COPAS, 2,false), new Carta(Simbolo.COPAS, 4,false), new Carta(Simbolo.COPAS, 6,false), new Carta(Simbolo.SOTA, 8,true), new Carta(Simbolo.OROS, 4,false)},
                {new Carta(Simbolo.ESPADAS, 1,false), new Carta(Simbolo.ESPADAS, 5,false), new Carta(Simbolo.COPAS, 8,false), new Carta(Simbolo.SOTA, 6,false), new Carta(Simbolo.OROS, 5,true)}
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
        for (int i = 0; i < carton[0].length; i++) { //recorre columnas fila 1
            for (int j = 0; j < carton.length; j++) { //recorrer columnas
                for (int k = j + 1; k < carton.length; k++) { //recorrer columnas + 1
                    if (!((carton[i][j].isEstaMarcado())&&(carton[i][k].isEstaMarcado()))) {
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
                    if (!((carton[i][j].isEstaMarcado())&&(carton[i][k].isEstaMarcado()))) {
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
        boolean allSame = false;
        for (int i = 0; i < carton.length; i++) {
                for (int k = i + 1; k < carton.length; k++) {
                       if (!((carton[i][i].isEstaMarcado())&&(carton[k][k].isEstaMarcado()))) {
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
        return allSame;
    }

    public boolean coincidenciaDiagonalInversa() {
        //Diagonal inversa
        boolean allSame = false;
        for (int i = carton.length-1; i >0; i--) {
            for (int j = 0; j < carton.length; j++) {
                for (int k = i - 1; k >0; k--) {
                    if (!((carton[i][j].isEstaMarcado())&&(carton[k][j+1].isEstaMarcado()))) {
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


    //method check premio pokino
    public boolean checkPremioPokino(){
        boolean premio=true;
     if(coincidenciaVertical() || coincidenciaDiagonal() || coincidenciaDiagonalInversa() || coincidenciaLinea() ){
         return premio;
     }
     return false;

    }

    //rellenar el array de Casillas
    public ArrayList<ArrayList<Casilla>> rellenarElArrayList(){
        ArrayList<ArrayList<Casilla>> casillaList=new ArrayList<>();
       for (int i=0;i<5;i++){
           if(i==0){
               casillaList.add(new ArrayList<>(Arrays.asList(new Casilla(2,2))));
           }else if(i==1){
               casillaList.add(new ArrayList<>(Arrays.asList(new Casilla(0,0),new Casilla(0,4),new Casilla(4,0),new Casilla(4,0),new Casilla(4,4))));
           }else if(i==2){
               casillaList.add(new ArrayList<>(Arrays.asList
                              (new Casilla(0,0),new Casilla(0,1),new Casilla(0,3),new Casilla(0,4),new Casilla(1,0),
                               new Casilla(1,1),new Casilla(1,3),new Casilla(1,4),new Casilla(3,0),new Casilla(3,1),
                               new Casilla(3,3),new Casilla(3,4),new Casilla(4,0),new Casilla(4,1),new Casilla(4,3),new Casilla(4,4))));
           }else if(i==3){

           }else if(i==4){
               casillaList.add(new ArrayList<>(Arrays.asList(new Casilla(1,0),new Casilla(1,1),new Casilla(1,2),new Casilla(1,3),new Casilla(1,4))));
           }

       }
         //casillaList.forEach(System.out::println);
        return casillaList;
    }

    //rellenar el Map
    public Map<String, ArrayList<Casilla>> rellenarElMap(ArrayList<ArrayList<Casilla>> lista){
        String text = null;
        for (int i=0;i< map.size();i++){
            if(i==0){
                text="Centro";
            }else if(i==1){
                text="Esquina";
            }else if(i==2){
                text="Estampa";
            }else if (i==3) {
                text = "Poker";
            } else if (i==4){
                text="Full";
            }
            map.put(text,lista.get(i));
        }
       return map;
    }


}
