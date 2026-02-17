import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    private Cancion findSong(String titulo) {
        /*
        Recorremos las canciones y si hay alguna canción y existe la canción pasada por parámetro,
        devuelve la canción y si no, null
         */
        for (Cancion canc : this.canciones) {
            if (canc != null && titulo.equalsIgnoreCase(canc.getTitulo())) {
                return canc;
            }
        }

        return null;
    }

    public boolean addSong(String titulo, double duracion) {
        /*
        Recorremos la canción y si el título coincide con el de la canción, entonces no la añade
         */
        Cancion cancion = new Cancion(titulo, duracion);
        for (Cancion canc : this.canciones) {
            if (canc.getTitulo().equalsIgnoreCase(titulo)) {
                return false;
            }
        }
        /*
        Si no, añade esa canción
         */
        this.canciones.add(cancion);
        return true;
    }

    public boolean addToPlaylist(int numPista, LinkedList<Cancion> playlist) {
        /*
        Se guarda el número de pista (la pista 1 sería el índice 0) y luego se recorre la lista de canciones
        y si no existe la canción, se añade a la playlist pasada por parámetro
         */
        int index = numPista - 1;
            if (index >= 0 && index < this.canciones.size()) {
                Cancion cancion = this.canciones.get(index);

                if (!playlist.contains(cancion)) {
                    playlist.add(cancion);
                    return true;
                }
            }
        return false;
    }

    public boolean addToPlaylist(String nombre, LinkedList<Cancion> playlist) {
        /*
        Si existe la canción (que no devuelve nulo), comprueba que no exista ya en la playlist,
        y la añade
         */
        Cancion cancion = findSong(nombre);

        if (cancion != null && !playlist.contains(cancion)) {
            playlist.add(cancion);
            return true;
        }
        return false;
    }
}
