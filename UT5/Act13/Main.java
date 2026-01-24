package Act13;

public class Main {
    public static void main(String[] args) {
        Circulo cir1 = new Circulo(2);
        Cilindro cil1 = new Cilindro(3, 3);

        System.out.println("Círculo:");
        System.out.println("Radio: " + cir1.getRadio());
        System.out.println("Área: " + cir1.getArea());
        System.out.println();

        System.out.println("Cilindro:");
        System.out.println("Radio: " + cil1.getRadio());
        System.out.println("Volumen: " + cil1.getVolume());
        System.out.println("Área: " + cil1.getArea());
    }
}
