package pokino;

public class Casilla {
    //atributos
    private int i;
    private int j;

    //constrectores
    public Casilla(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Casilla() {

    }

    //getters y setters
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    //to String

    @Override
    public String toString() {
        return "Casilla{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
