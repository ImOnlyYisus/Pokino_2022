package pokino;

import java.util.*;

public class Carton {
    private Carta[][] carton = new Carta[5][5];
    private Map<String, ArrayList<Casilla>> map = new HashMap<>();

    public Carton() {
        //temporar
        carton = new Carta[][]{
                {new Carta(Simbolo.COPAS, 1, true), new Carta(Simbolo.COPAS, 0, true), new Carta(Simbolo.SOTA, 0, false), new Carta(Simbolo.SOTA, 9, false), new Carta(Simbolo.OROS, 0, false)},
                {new Carta(Simbolo.SOTA, 1, true), new Carta(Simbolo.SOTA, 2, true), new Carta(Simbolo.COPAS, 3, false), new Carta(Simbolo.SOTA, 3, false), new Carta(Simbolo.OROS, 9, false)},
                {new Carta(Simbolo.OROS, 1, false), new Carta(Simbolo.OROS, 3, true), new Carta(Simbolo.COPAS, 4, false), new Carta(Simbolo.SOTA, 5, false), new Carta(Simbolo.OROS, 3, false)},
                {new Carta(Simbolo.COPAS, 2, true), new Carta(Simbolo.COPAS, 4, false), new Carta(Simbolo.COPAS, 6, false), new Carta(Simbolo.SOTA, 8, false), new Carta(Simbolo.OROS, 4, false)},
                {new Carta(Simbolo.ESPADAS, 1, true), new Carta(Simbolo.ESPADAS, 5, true), new Carta(Simbolo.COPAS, 8, false), new Carta(Simbolo.SOTA, 6, false), new Carta(Simbolo.OROS, 5, false)}
        };
        this.map = rellenarElMap();
    }

    public Map<String, ArrayList<Casilla>> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "Carton{" +
                "carton=" + Arrays.toString(carton) +
                ", map=" + map +
                '}';
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
                    marcarCarta(i, j);
                    return true;
                }
            }
        }
        return false;
    }


    //recorrer vertical carton and check if any columna have marked cards
    public boolean coincidenciaVertical() {
        boolean allSame = true;
        for (int i = 0; i < carton[0].length; i++) {
            for (int j = 0; j < carton.length ; j++) {
                for (int k = j+1; k < carton.length ; k++) {
                    if(!(carton[j][i].isEstaMarcado() && carton[k][i].isEstaMarcado())){
                        allSame = false;
                        break;
                    }else{
                        allSame = true;
                    }
                }
                if(!allSame){
                    break;
                }else{
                    return allSame;
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
                    if (!((carton[i][j].isEstaMarcado()) && (carton[i][k].isEstaMarcado()))) {
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

    public boolean coincidenciaDiagonal() {
        boolean allSame = false;
        for (int i = 0; i < carton.length; i++) {
            for (int k = i + 1; k < carton.length; k++) {
                if (!((carton[i][i].isEstaMarcado()) && (carton[k][k].isEstaMarcado()))) {
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
        return allSame;
    }

    public boolean coincidenciaDiagonalInversa() {
        //Diagonal inversa
        boolean allSame = false;
        for (int i = carton.length - 1; i > 0; i--) {
            for (int j = 0; j < carton.length; j++) {
                for (int k = i - 1; k > 0; k--) {
                    if (!((carton[i][j].isEstaMarcado()) && (carton[k][j + 1].isEstaMarcado()))) {
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


    //method check premio pokino
    public boolean checkPremioPokino() {
        if (coincidenciaVertical() || coincidenciaDiagonal() || coincidenciaDiagonalInversa() || coincidenciaLinea()) {
            return true;
        }
        return false;

    }

    //rellenar el Map
    public Map<String, ArrayList<Casilla>> rellenarElMap() {
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    ArrayList<Casilla> centro = new ArrayList<>();
                    centro.add(new Casilla(2, 2));
                    map.put("Centro", centro);
                    break;
                case 1:
                    ArrayList<Casilla> esquina = new ArrayList<>(Arrays.asList(new Casilla(0, 0), new Casilla(0, 4), new Casilla(4, 0), new Casilla(4, 0), new Casilla(4, 4)));
                    map.put("Esquina", esquina);
                    break;
                case 2:
                    ArrayList<Casilla> estampa = new ArrayList<>(Arrays.asList(new Casilla(0, 0), new Casilla(0, 1), new Casilla(0, 3), new Casilla(0, 4), new Casilla(1, 0),
                            new Casilla(1, 1), new Casilla(1, 3), new Casilla(1, 4), new Casilla(3, 0), new Casilla(3, 1),
                            new Casilla(3, 3), new Casilla(3, 4), new Casilla(4, 0), new Casilla(4, 1), new Casilla(4, 3), new Casilla(4, 4)));
                    map.put("Estampa", estampa);
                    break;
                case 3:
                    ArrayList<Casilla> poker = new ArrayList<>();
                    map.put("Poker", poker);
                    break;
                case 4:
                    ArrayList<Casilla> full = new ArrayList<>(Arrays.asList(new Casilla(1, 0), new Casilla(1, 1), new Casilla(1, 2), new Casilla(1, 3), new Casilla(1, 4)));
                    map.put("Full", full);
                    break;
                default:
                    break;
            }
        }
        return map;
    }

    //mostrar el Map
    public void mostrar() {
        map.forEach((premio, casilla) -> {
            System.out.println("Iterating list number - " + premio);
            System.out.println("PosicionCasillas - " + casilla.toString());
        });
    }

    //recorrer el map y ver si hay algun premio (centro, esquina, estampa, poker, full)
    public String recorrerMap() {
        Map<String, Boolean> comprobacion = new HashMap<>();
        map.forEach((premio, casilla) -> {
            for (int i = 0; i < casilla.size(); i++) {
                if (!carton[casilla.get(i).getI()][casilla.get(i).getJ()].isEstaMarcado()) {
                    comprobacion.put(premio, false);
                    break;
                } else {
                    comprobacion.put(premio, carton[casilla.get(i).getI()][casilla.get(i).getJ()].isEstaMarcado());
                }
            }


        });

        for(Map.Entry<String, Boolean> entry : comprobacion.entrySet()) {
            if(entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }
}