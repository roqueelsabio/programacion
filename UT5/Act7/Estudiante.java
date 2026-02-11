package Act7;

public class Estudiante implements Comparable<Estudiante>{
    private String nombre;
    private int edad;
    private int altura;

    public Estudiante(String nombre, int edad, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }

    @Override
    public int compareTo(Estudiante e) {
        //Guardamos en resultado la diferencia de altura de estudiante A y estudiante B
        int resultado = Integer.compare(e.getAltura(), this.altura);

        //Si son iguales, devuelve la diferencia de edad, y el mayor va primero
        if (resultado == 0) {
            resultado = Integer.compare(e.getEdad(), this.edad);
        }

        return resultado;
    }
}
