package Act4;

/*
Clase Esfera que devuelve el área de una esfera (4*PI*radio^2)
 */
public class Esfera extends Forma {
    private double radio;
    private double area;

    public Esfera(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    public double getRadio() {
        return this.radio;
    }

    @Override
    public double area() {
        return (4*Math.PI*(getRadio()*getRadio()));
    }

    @Override
    public String toString() {
        return "Esfera{" +
                "radio=" + radio +
                ", area=" + area +
                '}';
    }
}
