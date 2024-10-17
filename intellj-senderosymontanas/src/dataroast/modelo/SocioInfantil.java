package dataroast.modelo;

public class SocioInfantil extends Socio {
    static final double descuentoCuotaMensual = 0.5;
    private SocioAdulto socioAdulto;

    public SocioInfantil(String nombre, int numeroSocio) {
        super(nombre, numeroSocio);
        if (socioAdulto == null) {
            throw new IllegalArgumentException("El socio adulto no puede ser nulo.");
        }
        this.socioAdulto = socioAdulto;
    }

    public SocioAdulto getSocioAdulto() {
        return socioAdulto;
    }

    public void setSocioAdulto(SocioAdulto socioAdulto) {
        this.socioAdulto = socioAdulto;
    }

    public String toString() {
        return super.toString() + "\n" +
                "Numero de socio tutor: " + socioAdulto.getNumeroSocio();
    }
}
