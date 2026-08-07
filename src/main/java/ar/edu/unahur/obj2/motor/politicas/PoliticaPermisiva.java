package ar.edu.unahur.obj2.motor.politicas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.motor.PaqueteRed;

public class PoliticaPermisiva  implements IPoliticaFiltrado {
    
    private final List<IPoliticaFiltrado> politicas;


    public PoliticaPermisiva(List<IPoliticaFiltrado> politicas) {
        this.politicas = new ArrayList<>(politicas);
    }

    
    @Override
    public Boolean rechaza(PaqueteRed unPaquete) {
        return politicas.stream()
                        .allMatch(politica -> politica.rechaza(unPaquete));
    }

}
