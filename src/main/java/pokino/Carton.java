package pokino;

import java.util.*;

public class Carton {
    //attributes
    private Carta[][] carton = new Carta[5][5];
    private Map<String, ArrayList<Casilla>> map = new HashMap<>();

    //constrictor
    public Carton() {
    //temporar,solo para probar
      carton = new Carta[][]{
                {new Carta(Simbolo.COPAS, 1, true), new Carta(Simbolo.ESPADAS, 1, true), new Carta(Simbolo.SOTA, 1, true), new Carta(Simbolo.OROS, 1, true), new Carta(Simbolo.OROS, 12, false)},
               {new Carta(Simbolo.SOTA, 1, false), new Carta(Simbolo.SOTA, 2, false), new Carta(Simbolo.COPAS, 3, false), new Carta(Simbolo.SOTA, 3, false), new Carta(Simbolo.OROS, 9, false)},
               {new Carta(Simbolo.OROS, 1, false), new Carta(Simbolo.OROS, 3, false), new Carta(Simbolo.COPAS, 4, false), new Carta(Simbolo.SOTA, 5, false), new Carta(Simbolo.OROS, 3, false)},
              {new Carta(Simbolo.COPAS, 2, false), new Carta(Simbolo.COPAS, 4, false), new Carta(Simbolo.COPAS, 6, false), new Carta(Simbolo.SOTA, 8, false), new Carta(Simbolo.OROS, 4, false)},
               {new Carta(Simbolo.ESPADAS, 1, false), new Carta(Simbolo.ESPADAS, 5, true), new Carta(Simbolo.COPAS, 8, false), new Carta(Simbolo.SOTA, 6, true), new Carta(Simbolo.OROS, 5, false)}
      };
      //calling a methode for filling up the map
        this.map = rellenarElMap();
    }

    //getters
    public Map<String, ArrayList<Casilla>> getMap() {
        return map;
    }
    public Carta[][] getCarton() {
        return carton;
    }

    //toString
    @Override
    public String toString() {
        return "Carton{" +
                "carton=" + Arrays.toString(carton) +
                ", map=" + map +
                '}';
    }

    //method for display the carton
    public void imprimirCarton() {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                System.out.print(carton[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //metodo para marcar la carta
    public void marcarCarta(int fila, int columna) {
        //if the state is true then carte is marked
        carton[fila][columna].setEstaMarcado(true);
    }

    //method looking if a cart exist in a carton or not
    public boolean isCartaExist(Carta carta) {
        boolean exist = false;
        //loop travers the carton and check if the carte we pass as parametre
        //match with any carte in the carton
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (carton[i][j].equals(carta)) {
                    marcarCarta(i, j);
                    return true;
                }
            }
        }
        return false;
    }


    //go along vertically in carton and check if any column have marked cards
    public boolean coincidenciaVertical() {
        boolean allSame = true;
        for (int i = 0; i < carton[0].length; i++) {
            allSame=true;
            for (int j = 0; j < carton.length ; j++) {
                //if carton [rows][columns] not marked so not all same return false
                if(!carton[j][i].isEstaMarcado()){
                    allSame=false;
                    break;
                }
            }
            if (allSame){//otherwise, all same
                return true;
            }
        }
        return false;
    }

    //go along horizontally in carton and check if any rows have marked cards
    //same as before
    public boolean coincidenciaLinea() {
        boolean allSame = true;

        for (int i = 0; i <carton.length ; i++) {
            allSame=true;
            for (int j = 0; j <carton[i].length ; j++) {
                if(!carton[i][j].isEstaMarcado()){
                    allSame=false;
                    break;
                }
            }
            if(allSame){
                return true;
            }
        }
        return false;
    }

    //go along Diagonally in carton and check if in diagonal all cards marked
    public boolean coincidenciaDiagonal() {
        int i = 0;
        int j = 0;
        for (int k = i; k <carton.length; k++) {
            for (int l = j; l < carton[k].length; l++) {
                if (k == i && j == l) {
                    if(!carton[k][l].isEstaMarcado()){
                        return false;
                    }
                }
            }
            i++;
            j++;
        }
        return true;
    }

    //go along Diagonally reversed in carton and check if in diagonal reversed all cards marked
    public boolean coincidenciaDiagonalInversa() {
        int i = 0;
        int j = carton.length -1;
        for (int k = i; k < carton.length; k++) {
            for (int l = j; l >= 0; l--) {
                if (k == i && j == l) {
                    if(!carton[k][l].isEstaMarcado()){
                        return false;
                    }

                }
            }
            i++;
            j--;
        }
        return true;
    }


    //method check premio pokino
    //if there is any coincidence of the for methods then is pokino otherwise, not pokino
    public boolean checkPremioPokino() {
        if (coincidenciaVertical() || coincidenciaDiagonal() || coincidenciaDiagonalInversa() || coincidenciaLinea()) {
            return true;
        }
        return false;

    }

    //fill up the Map with the positions of every pokino (centro,Esquina,Estampa,Poker,Full)
    public Map<String, ArrayList<Casilla>> rellenarElMap() {
        //loop in the map
        for (int i = 0; i < 5; i++) {
            switch (i) {
                //put the position of square center in array
                case 0:
                    ArrayList<Casilla> centro = new ArrayList<>();
                    centro.add(new Casilla(2, 2));
                    map.put("Centro", centro);
                    break;
                case 1:
                    //put the position of square Esquina in array
                    ArrayList<Casilla> esquina = new ArrayList<>(Arrays.asList(new Casilla(0, 0), new Casilla(0, 4), new Casilla(4, 0), new Casilla(4, 0), new Casilla(4, 4)));
                    map.put("Esquina", esquina);
                    break;
                case 2:
                    //put the position of square Estampa in array
                    ArrayList<Casilla> estampa = new ArrayList<>(Arrays.asList(new Casilla(0, 0), new Casilla(0, 1), new Casilla(1, 0), new Casilla(1, 1), new Casilla(0, 3),
                            new Casilla(0, 4), new Casilla(1, 3), new Casilla(1, 4), new Casilla(3, 0), new Casilla(3, 1),
                            new Casilla(4, 0), new Casilla(4, 1), new Casilla(3, 3), new Casilla(3, 4), new Casilla(4, 3), new Casilla(4, 4)));
                    map.put("Estampa", estampa);
                    break;
                case 3:
                    //Put the position of square poker in array
                    //In poker we compare first carte with others if it Equals then I increase the counter
                    ArrayList<Casilla> poker = new ArrayList<>();
                    int cont = 0;
                    for (int j = 0; j <carton[0].length ; j++) {
                        if(carton[0][0].getNumero()==carton[0][j].getNumero()){
                            cont++;
                        }
                    }
                     //if counter is 0 then first carte different
                    //so i add the cards with same number
                    if(cont==0){
                        for (int j = 1; j <carton[0].length ; j++) {
                            poker.add(new Casilla(0,j));
                        }
                    }else if(cont>0){//else
                        for (int j = 0; j <carton[0].length ; j++) {
                            if(carton[0][0].getNumero() == carton[0][j].getNumero()){ //I check if the number is Equal in other carts similar
                                poker.add(new Casilla(0,j));
                            }
                        }
                    }

                    map.put("Poker", poker);
                    break;
                case 4:
                    //same as before
                    ArrayList<Casilla> full = new ArrayList<>(Arrays.asList(new Casilla(1, 0), new Casilla(1, 1), new Casilla(1, 2), new Casilla(1, 3), new Casilla(1, 4)));
                    map.put("Full", full);
                    break;
                default:
                    break;
            }
        }
        return map;
    }

    //display the Map
    public void mostrar() {
        map.forEach((premio, casilla) -> {
            System.out.println("Iterating list number - " + premio);
            System.out.println("PosicionCasillas - " + casilla.toString());
        });
    }

    //travers the map and see if there is any premio (centro, esquina, estampa, poker, full)
    public String recorrerMap() {
        Map<String, Boolean> comprobacion = new HashMap<>();
        //loop in the map and check which premio is it then
        map.forEach((premio, casilla) -> {
            //if estampa, i check that the positions of casillas match with casillas estampa are marked
            //if yes then we have premio estampa
            if(premio.equals("Estampa")){
                  if(carton[casilla.get(0).getI()][casilla.get(0).getJ()].isEstaMarcado()&& carton[casilla.get(1).getI()][casilla.get(1).getJ()].isEstaMarcado() && carton[casilla.get(2).getI()][casilla.get(2).getJ()].isEstaMarcado() &&  carton[casilla.get(3).getI()][casilla.get(3).getJ()].isEstaMarcado()
                  || carton[casilla.get(4).getI()][casilla.get(4).getJ()].isEstaMarcado()&&carton[casilla.get(5).getI()][casilla.get(5).getJ()].isEstaMarcado() && carton[casilla.get(6).getI()][casilla.get(6).getJ()].isEstaMarcado()&&carton[casilla.get(7).getI()][casilla.get(7).getJ()].isEstaMarcado()
                  || carton[casilla.get(8).getI()][casilla.get(8).getJ()].isEstaMarcado()&&carton[casilla.get(9).getI()][casilla.get(9).getJ()].isEstaMarcado() && carton[casilla.get(10).getI()][casilla.get(10).getJ()].isEstaMarcado()&&carton[casilla.get(11).getI()][casilla.get(11).getJ()].isEstaMarcado() ||
                     carton[casilla.get(12).getI()][casilla.get(12).getJ()].isEstaMarcado()&& carton[casilla.get(13).getI()][casilla.get(13).getJ()].isEstaMarcado() && carton[casilla.get(14).getI()][casilla.get(14).getJ()].isEstaMarcado()&& carton[casilla.get(15).getI()][casilla.get(15).getJ()].isEstaMarcado()){
                      comprobacion.put(premio, true);
             }
            }else if(premio.equals("Poker")){
                //for poker, we check which card is different
                Carta cartaDistinta = null;
                for (int i = 0; i <carton[0].length ; i++) {
                    if(carton[casilla.get(0).getI()][casilla.get(0).getJ()].getNumero()!= carton[0][i].getNumero()){
                        cartaDistinta=carton[0][i];
                        System.out.println(carton[0][i]);
                        break;
                    }
                }
                //then if the different card is not marked we check if others are marked if yes then there is poker
                //and if not we break the loop no poker possible in this case
                boolean esPoker = true;
                if(cartaDistinta!=null){
                    if(!cartaDistinta.isEstaMarcado()){
                        for (int i = 0; i <carton[0].length ; i++) {
                            if(!carton[casilla.get(0).getI()][casilla.get(0).getI()].isEstaMarcado()){
                                esPoker=false;
                                break;
                            }
                        }
                        if(esPoker){
                            comprobacion.put(premio,true);
                        }
                    }
                }
            }
            else{
                //else the lets check if is premio
                //if it is any premio we put it in the new map comprobacion and later... NEXT COMMENT
                for (int i = 0; i < casilla.size(); i++) {
                    if (!carton[casilla.get(i).getI()][casilla.get(i).getJ()].isEstaMarcado()) {
                        comprobacion.put(premio, false);
                        break;
                    } else {
                        comprobacion.put(premio, carton[casilla.get(i).getI()][casilla.get(i).getJ()].isEstaMarcado());
                    }
                }
            }
        });

        //Yes HERE :D, loop using Entry and get the key to know which premio it is if the value(boolean) is true
        //otherwise, no luck no premio
        for(Map.Entry<String, Boolean> entry : comprobacion.entrySet()) {
            if(entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }

    //look for a card for next rond
    public Carta buscarCarta(Carta cartaRonda){
        for (int i = 0; i < carton.length ; i++) {
            for (int j = 0; j <carton[i].length ; j++) {
                if(cartaRonda.equals(carton[i][j])){
                    return carton[i][j];
                }
            }
        }

        return null;
    }
}