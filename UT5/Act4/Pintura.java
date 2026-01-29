package Act4;

/*
Clase Pintura que devuelve la cantidad de pintura necesaria para pintar el área de una figura
 */
public class Pintura {
    private double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }

    public double calcPintura(Forma forma) {
        return forma.area()/this.cobertura;
    }
}
