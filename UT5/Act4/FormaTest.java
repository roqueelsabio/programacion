package Act4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormaTest {
    @Test
    void testToString() {
        Cilindro cilindro = new Cilindro("Cilindro", 5, 10);
        Esfera esfera = new Esfera("Esfera", 10);
        Rectangulo rectangulo = new Rectangulo("Rectangulo", 5, 5);

        String c = "Cilindro{radio=5.0, altura=10.0}";
        String e = "Esfera{radio=10.0, area=0.0}";
        String r = "Rectangulo{longitud=5.0, ancho=5.0}";

        assertEquals(c, cilindro.toString());
        assertEquals(e, esfera.toString());
        assertEquals(r, rectangulo.toString());
    }

    @Test
    void testDevolverArea() {
        Cilindro cilindro = new Cilindro("Cilindro", 5, 10);
        Esfera esfera = new Esfera("Esfera", 10);
        Rectangulo rectangulo = new Rectangulo("Rectangulo", 5, 5);

        double c = cilindro.area();
        double e = esfera.area();
        double r = rectangulo.area();

        double cEsp = 785.4;
        double eEsp = 1256.7;
        double rEsp = 25.0;

        assertEquals(cEsp, c, 000.1);
        assertEquals(eEsp, e, 000.1);
        assertEquals(rEsp, r, 000.1);
    }

    @Test
    void testCalcularPintura() {
        Pintura pintura = new Pintura(250);
        Cilindro cilindro = new Cilindro("Cilindro", 5, 10);
        Esfera esfera = new Esfera("Esfera", 10);
        Rectangulo rectangulo = new Rectangulo("Rectangulo", 25, 15);

        double c = pintura.calcPintura(cilindro);
        double e = pintura.calcPintura(esfera);
        double r = pintura.calcPintura(rectangulo);

        double cEsp = 3.14;
        double eEsp = 5.02;
        double rEsp = 1.5;

        assertEquals(cEsp, c, 000.1);
        assertEquals(eEsp, e, 000.1);
        assertEquals(rEsp, r, 000.1);
    }
}