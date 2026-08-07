package ar.edu.unahur.obj2.motor.motor;

import ar.edu.unahur.obj2.motor.PaqueteRed;
import ar.edu.unahur.obj2.motor.observer.CentroNotificaciones;
import ar.edu.unahur.obj2.motor.politicas.IPoliticaFiltrado;

public class MotorInterno extends MotorInspeccion {

    public MotorInterno(IPoliticaFiltrado unaPolitica, CentroNotificaciones unCentro) {
        super(unaPolitica, unCentro);
    }


    @Override
    protected void inspeccionProfunda(PaqueteRed unPaquete) {
        
    }

}
