package Act3;

public class MainEncapsulacion {
    public static void main(String[] args) {
        /*
        Creamos el objeto impresora para poder utilizar sus métodos y probamos entradas de datos
         */
        System.out.println("Impresora creada por ejemplo, con 80 de nivel de Tóner, 0 páginas impresas e impresión a doble cara.");
        Impresora imp1 = new Impresora(80, 0, true);
        System.out.println(imp1.getNivelToner() + ", " + imp1.getNumPagImp() + ", " + imp1.isImpDobleCara());
        System.out.println("\nAñadimos 20 de nivel de Tóner.");
        imp1.anadirToner(20);
        System.out.println(imp1.getNivelToner());
        System.out.println("\nColocamos un 1 en nivel de Tóner para que dé -1 (nivel de Tóner=101, ERROR).");
        imp1.anadirToner(1);
        System.out.println(imp1.getNivelToner());
        System.out.println("\nAhora colocamos con el setter por ejemplo, 10 de nivel de Tóner:");
        imp1.setNivelToner(10);
        System.out.println(imp1.getNivelToner());
        System.out.println("\nAhora imprimimos las páginas. Primero, 5 páginas sin impresión a doble cara (5 páginas impresas).");
        System.out.println(imp1.imprimirPag(5, false));
        System.out.println("\nPor último, imprimimos 20 páginas pero a doble cara esta vez, lo que nos da que se añaden 10 páginas a las 5 que ya había (20/2 = 10 + 5 = 15).");
        System.out.println(imp1.imprimirPag(20, true));
    }
}
