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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste c = (CuerpoCeleste) o;
        return Objects.equals(nombre, c.nombre) && tipoCuerpo == c.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoCuerpo) + 1;
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
