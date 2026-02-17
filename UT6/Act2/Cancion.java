public class Cancion implements Comparable<Cancion> {
    private String titulo;
    private double duracion;

    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                '}';
    }

    /*
    Método añadido para ordenar por título, si son iguales no es necesario, ya que en teoría solo debería haber una canción
    con ese título
     */
    @Override
    public int compareTo(Cancion c) {
        int resultado = this.titulo.compareTo(c.getTitulo());
        return resultado;
    }
}
