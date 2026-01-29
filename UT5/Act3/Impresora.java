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
    El método para añadir Tóner a la impresora
     */
    public int anadirToner(int nivelToner) {
        int result = this.nivelToner+nivelToner;
        if (result>100 || result<0) {
            this.nivelToner = -1;
        }
        if (result>=0 && result<=100){
            this.nivelToner += nivelToner;
        }
        return result;
    }

    public int getNivelToner() {
        return this.nivelToner;
    }

    public void setNivelToner(int nivelToner) {
        this.nivelToner = nivelToner;
    }

    /*
    De las páginas impresas, solo coloco el getter, ya que el setter no tiene sentido
    si solo se devuelve el número de páginas que ha realizado, por lo que no deben
    modificarse
     */
    public int getNumPagImp() {
        return this.numPagImp;
    }

    public boolean isImpDobleCara() {
        return this.impDobleCara;
    }

    public void setImpDobleCara(boolean impDobleCara) {
        this.impDobleCara = impDobleCara;
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
