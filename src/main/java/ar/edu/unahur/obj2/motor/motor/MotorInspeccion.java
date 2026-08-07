package ar.edu.unahur.obj2.motor.motor;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.motor.PaqueteRed;
import ar.edu.unahur.obj2.motor.excepciones.ViolacionSegmentacionException;
import ar.edu.unahur.obj2.motor.politicas.IPoliticaFiltrado;

public abstract class MotorInspeccion {

    private final IPoliticaFiltrado politica;
    private final List<String> historialIngresos = new ArrayList<>();

    public MotorInspeccion(IPoliticaFiltrado politica) {
        this.politica = politica;
    }

    public final void inspeccionar(PaqueteRed paquete)
            throws ViolacionSegmentacionException {

        validarSegmentacion(paquete);

        registrarIngreso(paquete);

        if (politica.rechaza(paquete)) {
            marcarAmenaza(paquete);
            return;
        }

        inspeccionProfunda(paquete);

        aprobar(paquete);
    }

    private void validarSegmentacion(PaqueteRed paquete)
    
        throws ViolacionSegmentacionException {

        if (paquete.ipDestino().startsWith("10.0.0.")
                && paquete.puerto().equals(22)) {

            throw new ViolacionSegmentacionException(
                    "Violación de segmentación");
        }
    }

    private void registrarIngreso(PaqueteRed paquete) {
        historialIngresos.add(paquete.ipOrigen());
    }

    private void marcarAmenaza(PaqueteRed paquete) {
        // marcar como amenaza
    }

    protected abstract void inspeccionProfunda(PaqueteRed paquete);

    private void aprobar(PaqueteRed paquete) {
        // marcar como tráfico seguro
    }

    public List<String> historialIngresos() {
        return List.copyOf(historialIngresos);
    }

}
