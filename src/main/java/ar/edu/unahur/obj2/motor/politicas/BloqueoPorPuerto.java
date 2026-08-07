package ar.edu.unahur.obj2.motor.politicas;

import ar.edu.unahur.obj2.motor.PaqueteRed;

public class BloqueoPorPuerto implements IPoliticaFiltrado {

    private final Integer puertoRestringido;


    public BloqueoPorPuerto(Integer unPuertoRestringido) {
        this.puertoRestringido = unPuertoRestringido;
    }


    @Override
    public Boolean rechaza(PaqueteRed unPaquete) {
        return unPaquete.puerto().equals(puertoRestringido);
    }
}
