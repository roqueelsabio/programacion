package Act3;

public class Impresora {
    private int nivelToner;
    private int numPagImp;
    private boolean impDobleCara;

    /*
    Constructor por defecto para que se pueda crear un objeto impresora y que tome valores
    por defecto para ser utilizada
     */

    public Impresora() {
        this(0,0,false);
    }

    /*
    Constructor creado para saber el nivel de Tóner inicial (puede estar lleno o puede que no),
    también para saber el número de páginas que se van a imprimir y si es a doble cara o no,
    ya que si es a doble cara es la mitad de páginas a imprimir
     */
    public Impresora(int nivelToner, int numPagImp, boolean impDobleCara) {
        this.nivelToner = nivelToner;
        this.numPagImp = numPagImp;
        this.impDobleCara = impDobleCara;
    }

    /*
    El método para añadir Tóner a la impresora, que llama al método privado que recoge el nivel
    de Tóner
     */
    public int anadirToner(int nivelToner) {
        if (nivelToner>100 || nivelToner<0) {
            return -1;
        } else if (getNivelToner()>=100 && nivelToner>0) {
            return -1;
        } else if (getNivelToner()<0) {
            return -1;
        } else {
            int result = this.nivelToner+nivelToner;
            this.nivelToner += nivelToner;
            return result;
        }
    }

    /*
    Los métodos privados que se usan para recoger el valor del nivel de Tóner y el número de
    páginas impresas para usarse en otros métodos públicos
     */

    private int getNivelToner() {
        return this.nivelToner;
    }

    private int getNumPagImp() {
        return this.numPagImp;
    }

    /*
    El método que imprime páginas y se añade a la lista de páginas impresas en función de
    si es a doble cara o no (a doble cara es la mitad de hojas)
     */
    public int imprimirPag(int numPagImp, boolean impDobleCara) {
        int numPar = numPagImp%2;
        if (!impDobleCara) {
            this.numPagImp += numPagImp;
            return getNumPagImp();
        } else if (impDobleCara && numPar==0) {
            this.numPagImp += (numPagImp/2);
            return getNumPagImp();
        } else {
            return -1;
        }
    }
}
