package Act4;

/*
Clase Cilindro que devuelve el área de un Cilindro (PI*radio^2*altura)
 */
public class Cilindro extends Forma {
    private double radio;
    private double altura;

    public Cilindro(String nombre, double radio, double altura) {
        super(nombre);
        this.radio = radio;
        this.altura = altura;
    }

    public double getRadio() {
        return this.radio;
    }

    public double getAltura() {
        return this.altura;
    }

    @Override
    public double area() {
        return Math.PI*(Math.pow(getRadio(), 2)*getAltura());
    }

    @Override
    public String toString() {
        return "Cilindro{" +
                "radio=" + radio +
                ", altura=" + altura +
                '}';
    }
}
