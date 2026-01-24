package Act13;

public class Circulo {
    protected double radio;

    public Circulo(double radio) {
        if (radio<0) {
            this.radio = 0;
        } else {
            this.radio = radio;
        }
    }

    public double getRadio() {
        return this.radio;
    }

    public double getArea() {
        return (this.radio*this.radio*Math.PI);
    }
}
