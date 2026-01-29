package Act4;

/*
Clase Forma para crear las formas del ejercicio, con 1 constructor con nombre, método área vacío
y un toString del nombre
 */
public class Forma {
    private String nombre;

    public Forma(String nombre) {
        this.nombre = nombre;
    }

    public double area() {
        return 0;
    }

    @Override
    public String toString() {
        return "Forma{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
