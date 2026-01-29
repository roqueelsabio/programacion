package Act4;

/*
Clase Rectángulo que devuelve el área de un Rectángulo (largo*ancho)
 */
public class Rectangulo extends Forma {
    private double longitud;
    private double ancho;

    public Rectangulo(String nombre, double longitud, double ancho) {
        super(nombre);
        this.longitud = longitud;
        this.ancho = ancho;
    }

    public double getLongitud() {
        return this.longitud;
    }

    public double getAncho() {
        return this.ancho;
    }

    @Override
    public double area() {
        return getLongitud()*getAncho();
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "longitud=" + longitud +
                ", ancho=" + ancho +
                '}';
    }
}
