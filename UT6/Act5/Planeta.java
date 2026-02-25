public class Planeta extends CuerpoCeleste {


    public Planeta(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        super(nombre, periodoOrbital, tipoCuerpo);
    }

    public boolean addSatelite(CuerpoCeleste cuerpoCeleste) {
        if (cuerpoCeleste.getTipoCuerpo().equals(TipoCuerpoCeleste.LUNA)) {
            super.addSatelite(cuerpoCeleste);
            return true;
        } else {
            return false;
        }
    }
}
