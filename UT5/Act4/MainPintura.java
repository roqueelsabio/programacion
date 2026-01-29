package Act4;

public class MainPintura {
    public static void main(String[] args) {
        Pintura pintura = new Pintura(250);
        Rectangulo rectangulo = new Rectangulo("Rectángulo",20, 35);
        Esfera esfera = new Esfera("Esfera", 15);
        Cilindro cilindro = new Cilindro("Cilindro", 10, 30);

        /*
        Aquí observamos el polimorfismo, ya que se le llama a pintura para calcular la pintura y se le pasa una forma,
        y dependiendo de la forma que sea, llamará a su propio método para calcular el área y devolverlo al método
        calcPintura
         */

        System.out.println("Ejemplo de polimorfismo: ");
        System.out.println("Cantidad necesaria de pintura para el Rectángulo: " + pintura.calcPintura(rectangulo));
        System.out.println("Cantidad necesaria de pintura para la Esfera: " + pintura.calcPintura(esfera));
        System.out.println("Cantidad necesaria de pintura para el Cilindro: " + pintura.calcPintura(cilindro));

        System.out.println("\nEjemplo también de polimorfismo, en este caso, por ejemplo en un toString, que es distinto en cada forma (atributos y el nombre de la forma): ");
        System.out.println("toString del Rectángulo: " + rectangulo.toString());
        System.out.println("toString de la Esfera: " + esfera.toString());
        System.out.println("toString del Cilindro: " + cilindro.toString());
    }
}
