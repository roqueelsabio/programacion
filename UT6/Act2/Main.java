import java.util.*;

public class Main {
    static void main() {
        ArrayList<Album> albumes = new ArrayList<>();
        Album album1 = new Album("P4", "Shihoko Hirata");
        Album album2 = new Album("P5", "Lyn");

        albumes.add(album1);
        albumes.add(album2);

        //Canción 1 del álbum 1
        album1.addSong("Never More", 6.40);
        //Canción 2 del álbum 1
        album1.addSong("Heaven", 3.00);
        //Canción 3 del álbum 1
        album1.addSong("Hearbeat, Heartbreak", 2.15);
        //Canción 4 del álbum 1
        album1.addSong("Your Affection", 2.52);

        //Canción 1 del álbum 2
        album2.addSong("I believe", 4.31);
        //Canción 2 del álbum 2
        album2.addSong("Life Will Change", 4.22);
        //Canción 3 del álbum 2
        album2.addSong("Last Surprise", 3.56);
        //Canción 4 del álbum 2
        album2.addSong("Throw Away Your Mask", 4.02);

        LinkedList<Cancion> playlist = new LinkedList<>();

        //Añadiendo canciones al azar, para luego ser ordenadas por el título
        //"Last Surprise"
        album2.addToPlaylist(3, playlist);
        //"Never More"
        album1.addToPlaylist(1, playlist);
        //"Life Will Change"
        album2.addToPlaylist("Life Will Change", playlist);
        //"I believe"
        album2.addToPlaylist(1, playlist);
        //"Heaven"
        album1.addToPlaylist("Heaven", playlist);
        //"Throw Away Your Mask"
        album2.addToPlaylist(4, playlist);

        //Ordenando la playlist por nombre
        playlist.sort(null);

        play(playlist);
    }

    public static void play(LinkedList<Cancion> playlist) {
        Scanner scan = new Scanner(System.in);
        ListIterator<Cancion> it = playlist.listIterator();
        boolean haciaAdelante = true;
        int opcion = -1;
        Cancion actual = null;

        do {
            try {
                System.out.println("Introduce una opción:");
                System.out.println("0. Salir.");
                System.out.println("1. Reproducir canción siguiente.");
                System.out.println("2. Reproducir canción anterior");
                System.out.println("3. Repetir canción actual.");
                System.out.println("4. Imprimir canciones de la playlist.");
                System.out.println("5. Volver a imprimir el menú.");
                System.out.println("6. Borrar la canción actual de la playlist.");
                opcion = scan.nextInt();
                if (opcion<0||opcion>6) {
                    throw new InputMismatchException();
                }

                switch (opcion) {
                    case 0:
                        /*
                        Salir del programa
                         */
                        System.out.println();
                        System.out.println("Saliendo del programa...");
                        opcion = 0;
                        break;

                    case 1:
                        scan.nextLine();

                        /*
                        Si no ha ido hacia adelante, reposiciona el cursor y cambia la variable haciaAdelante
                         */
                        if (!haciaAdelante) {
                            haciaAdelante = true;
                            if (it.hasNext()) {
                                it.next();
                            }
                        }

                        /*
                        Si tiene siguiente canción, la reproduce, y si no, es que ha llegado al final de la lista y no quedan canciones
                        por reproducir
                         */
                        if (it.hasNext()) {
                            actual = it.next();
                            System.out.println();
                            System.out.println("Reproduciendo la canción siguiente.");
                            System.out.println();
                        } else {
                            System.out.println();
                            System.out.println("Has llegado al final, no hay más canciones.");
                            haciaAdelante = false;
                            actual = null;
                            System.out.println();
                        }

                        /*
                        Si hay canción reproduciéndose la muestra, y si no, muestra que no se está reproduciendo ninguna canción
                         */
                        if (actual != null) {
                            System.out.println("Reproduciendo: " + actual.getTitulo());
                        } else {
                            System.out.println("No se está reproduciendo ninguna canción.");
                        }
                        System.out.println();
                        break;

                    case 2:
                        scan.nextLine();

                        /*
                        Si ha ido hacia adelante, reposiciona el cursor y asigna false a la variable haciaAdelante
                         */
                        if (haciaAdelante) {
                            haciaAdelante = false;
                            if (it.hasPrevious()) {
                                it.previous();
                            }
                        }

                        /*
                        Si tiene canción anterior, la reproduce y si no, es que el usuario ha llegado al inicio de la playlist
                         */
                        if (it.hasPrevious()) {
                            actual = it.previous();
                            System.out.println();
                            System.out.println("Reproduciendo la canción anterior.");
                            System.out.println();
                        } else {
                            System.out.println();
                            System.out.println("Has llegado al inicio de la playlist.");
                            haciaAdelante = true;
                            actual = null;
                            System.out.println();
                        }

                        /*
                        Si hay canción reproduciéndose, la muestra y si no, muestra que no se está reproduciendo ninguna canción
                         */
                        if (actual != null) {
                            System.out.println("Reproduciendo: " + actual.getTitulo());
                        } else {
                            System.out.println("No se está reproduciendo ninguna canción.");
                        }
                        System.out.println();
                        break;

                    case 3:
                        scan.nextLine();
                        /*
                        No hay canción seleccionada
                         */
                        if (actual == null) {
                            System.out.println("No hay canción seleccionada.");
                            System.out.println();
                            break;
                        }
                        /*
                        Si ha ido hacia adelante y tiene anterior, muestra el actual retrocediendo el
                        cursor y luego deja el cursor como estaba y si no, comprueba que hay siguiente
                        y hace lo mismo que antes pero al revés
                         */
                        if (haciaAdelante) {
                            if (it.hasPrevious()) {
                                actual = it.previous();
                                System.out.println("Repitiendo la canción actual.");
                                System.out.println();
                                it.next();
                            }
                        } else {
                            if (it.hasNext()) {
                                actual = it.next();
                                System.out.println("Repitiendo la canción actual.");
                                System.out.println();
                                it.previous();
                            }
                        }

                        /*
                        Si hay canción reproduciéndose la muestra, y si no, muestra que no se está reproduciendo ninguna canción
                         */
                        if (actual != null) {
                            System.out.println("Reproduciendo: " + actual.getTitulo());
                        } else {
                            System.out.println("No se está reproduciendo ninguna canción.");
                        }
                        System.out.println();
                        break;

                    case 4:
                        scan.nextLine();
                        /*
                        Imprime las canciones de la playlist
                         */
                        System.out.println();
                        printPlaylist(playlist);
                        System.out.println();
                        break;

                    case 5:
                        scan.nextLine();
                        /*
                        Solo muestra el menú
                         */
                        System.out.println();
                        break;

                    case 6:
                        scan.nextLine();
                        /*
                        Si hay canción reproduciéndose, la elimina y muestra mensaje y si no, muestra
                        mensaje de no hay una canción seleccionada
                         */
                        if (actual != null) {
                            it.remove();
                            System.out.println("La canción " + actual.getTitulo() + " ha sido eliminada de la playlist.");
                            actual = it.next();
                            if (it.hasNext()) {
                                System.out.println("Reproduciendo la siguiente canción: " + actual.getTitulo());
                            }
                            System.out.println();
                        } else {
                            System.out.println("No hay canción actual para eliminar.");
                            System.out.println();
                        }
                        break;
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                /*
                Recoge opciones inválidas
                 */
                System.out.println();
                System.out.println("Opción inválida introducida.");
            }
        } while (opcion != 0);
    }

    /*
    Método creado para imprimir cada canción dentro de la playlist
     */
    public static void printPlaylist(LinkedList<Cancion> playlist) {
        Iterator<Cancion> it = playlist.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
