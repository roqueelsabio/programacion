import java.util.*;

public class Main {
    /*
    Creando el Map del sistema solar y el Set que alberga todos los planetas
     */
    private static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<String, CuerpoCeleste>();
    private static Set<CuerpoCeleste> planetas = new HashSet<CuerpoCeleste>();

    public static void main() {
        /*
        Creando un par de planetas
         */
        CuerpoCeleste mercurio = new Planeta("Mercurio", 88, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste venus = new Planeta("Venus", 225, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste tierra = new Planeta("La Tierra", 365, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste marte = new Planeta("Marte", 687, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste jupiter = new Planeta("Jupiter", 4332, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste saturno = new Planeta("Saturno", 10759, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste urano = new Planeta("Urano", 30660, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste neptuno = new Planeta("Neptuno", 165, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste pluton = new Planeta("Pluton", 248, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);

        /*
        Añadiendo al mapa del sistema solar los planetas, por el nombre
         */
        sistemaSolar.put("Mercurio", mercurio);
        sistemaSolar.put("Venus", venus);
        sistemaSolar.put("La Tierra", tierra);
        sistemaSolar.put("Marte", marte);
        sistemaSolar.put("Jupiter", jupiter);
        sistemaSolar.put("Saturno", saturno);
        sistemaSolar.put("Urano", urano);
        sistemaSolar.put("Neptuno", neptuno);
        sistemaSolar.put("Pluton", pluton);

        /*
        Luego los añadimos a los planetas
         */
        planetas.add(mercurio);
        planetas.add(venus);
        planetas.add(tierra);
        planetas.add(marte);
        planetas.add(jupiter);
        planetas.add(saturno);
        planetas.add(urano);
        planetas.add(neptuno);
        planetas.add(pluton);

        /*
        Creamos un objeto de tipo CuerpoCeleste que sea un Planeta y de tipo de cuerpo LUNA y lo añadimos al satélite de
        La Tierra y al sistema solar
         */
        CuerpoCeleste luna_tierra = new Planeta("Luna Tierra", 27, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Luna Tierra", luna_tierra);
        tierra.addSatelite(luna_tierra);

        /*
        Creamos 2 más y los añadimos al mapa del sistema solar y se los asignamos a Marte
         */
        CuerpoCeleste deimos = new Planeta("Deimos-1", 3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste phobos = new Planeta("Phobos-0", 3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Deimos-1", deimos);
        sistemaSolar.put("Phobos-0", phobos);

        marte.addSatelite(deimos);
        marte.addSatelite(phobos);

        /*
        Creamos 4 más y los añadimos al mapa del sistema solar y se los asignamos a Jupiter
         */
        CuerpoCeleste io = new Planeta("Io-1", 8, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste europa = new Planeta("Europa-3", 5, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste ganymede = new Planeta("Ganymede-7", 1, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste callisto = new Planeta("Callisto-16", 7, CuerpoCeleste.TipoCuerpoCeleste.LUNA);

        sistemaSolar.put("Io-1", io);
        sistemaSolar.put("Europa-3", europa);
        sistemaSolar.put("Ganymede-7", ganymede);
        sistemaSolar.put("Callisto-16", callisto);

        jupiter.addSatelite(io);
        jupiter.addSatelite(europa);
        jupiter.addSatelite(ganymede);
        jupiter.addSatelite(callisto);

        /*
        Recorremos todos los planetas y nos quedamos con el nombre
         */
        System.out.println("Todos los planetas:");
        for (CuerpoCeleste planetasSet : planetas) {
            System.out.println(planetasSet.getNombre());
        }

        /*
        Buscamos en el Map del sistema solar el planeta Marte, y mostramos todos sus planetas ya que getSatelites() nos
        devuelve un Set con todos sus satélites
         */
        System.out.println();
        CuerpoCeleste marte_satelites = sistemaSolar.get("Marte");
        System.out.println("Satélites de Marte:");
        for (CuerpoCeleste satelite : marte_satelites.getSatelites()) {
            System.out.println(satelite.getNombre());
        }

        /*
        Creamos un set con lunas y hacemos una unión de las lunas
         */
        Set<CuerpoCeleste> lunas = new HashSet<>();

        System.out.println();
        for (String lunas_for : sistemaSolar.keySet()) {
            if (!sistemaSolar.get(lunas_for).getTipoCuerpo().equals(CuerpoCeleste.TipoCuerpoCeleste.LUNA)) {
                lunas.addAll(sistemaSolar.get(lunas_for).getSatelites());
            }
        }

        /*
        Recorriendo el set de lunas
         */
        System.out.println("Todas las lunas con el set de lunas creado anteriormente:");
        for (CuerpoCeleste set_lunas : lunas) {
            System.out.println(set_lunas.getNombre());
        }

        /*
        Creando un nuevo planeta plutón
         */
        System.out.println();
        CuerpoCeleste pluton_nuevo = new Planeta("Pluton", 884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Plutón", pluton_nuevo);
        planetas.add(pluton_nuevo);

        System.out.println("Todos los planetas, y ahora con Plutón:");
        for (CuerpoCeleste planetasSet : planetas) {
            System.out.println(planetasSet.toString());
        }

        /*
        Ahora lo creamos pero de tipo PLANETA_ENANO
         */
        System.out.println();
        CuerpoCeleste pluton_enano = new PlanetaEnano("Pluton", 884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA_ENANO);
        sistemaSolar.put("Pluton", pluton_enano);
        planetas.add(pluton_enano);

        System.out.println("Todos los planetas, y ahora con Plutón pero es un PLANETA_ENANO:");
        for (CuerpoCeleste planetasSet : planetas) {
            System.out.println(planetasSet.toString());
        }

        /*
        Tampoco cambia nada, ya que solo ha sido creado y no lo hemos añadido a ningún lado
         */

        System.out.println();

        /*
        Utilizando la diferencia por ejemplo para mostrar planetas excepto los que aparezcan en otro set
         */

        Set<CuerpoCeleste> tierra_marte = new HashSet<>();
        tierra_marte.add(marte);
        tierra_marte.add(tierra);

        Set<CuerpoCeleste> planetas_diferencia = new HashSet<>(planetas);

        System.out.println("Mostrando la diferencia:");
        System.out.println("Aquí por ejemplo, tengo el set de planetas_diferencia que me va a quitar lo que coincida con tierra_marte, que en este caso me borrará tanto tierra como marte.");

        planetas_diferencia.removeAll(tierra_marte);

        for (CuerpoCeleste set_diferencia : planetas_diferencia) {
            System.out.println(set_diferencia.getNombre());
        }

        System.out.println();

        /*
        Utilizando la intersección, por ejemplo quiero mostrar los planetas que coinciden en 2 sets
         */

        Set<CuerpoCeleste> planetas_interseccion = new HashSet<>(planetas);

        planetas_interseccion.retainAll(tierra_marte);

        System.out.println("Mostrando una intersección:");
        System.out.println("Aquí, me muestra lo que coincide en ambos sets.");
        for (CuerpoCeleste set_interseccion : planetas_interseccion) {
            System.out.println(set_interseccion.getNombre());
        }
    }
}

