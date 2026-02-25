import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;
    public enum TipoCuerpoCeleste {
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE
    }

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        this.satelites = new HashSet<CuerpoCeleste>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPeriodoOrbital() {
        return this.periodoOrbital;
    }

    public Set<CuerpoCeleste> getSatelites() {
        Set<CuerpoCeleste> satelitesCopia = this.satelites;
        return satelitesCopia;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return this.tipoCuerpo;
    }

    public boolean addSatelite(CuerpoCeleste cuerpoCeleste) {
        if (this.satelites.equals(cuerpoCeleste.getNombre())) {
            return false;
        } else {
            this.satelites.add(cuerpoCeleste);
            return true;
        }
    }

    public boolean equals(CuerpoCeleste cuerpo1, CuerpoCeleste cuerpo2) {
        if (cuerpo1.getNombre().equals(cuerpo2.getNombre())) {
            if (cuerpo1.getTipoCuerpo().equals(cuerpo2.getTipoCuerpo())) {
                if (cuerpo1.getClass().equals("CuerpoCeleste") && (cuerpo2.getClass().equals("CuerpoCeleste"))) {
                    System.out.println("Ambos son iguales.");
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode(CuerpoCeleste cuerpoCeleste) {
        return cuerpoCeleste.getNombre().hashCode() + cuerpoCeleste.getTipoCuerpo().hashCode() + 2;
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{" +
                "nombre='" + nombre + '\'' +
                ", tipoCuerpo=" + tipoCuerpo +
                ", periodoOrbital=" + periodoOrbital +
                '}';
    }
}
