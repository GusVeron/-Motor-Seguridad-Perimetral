package ar.edu.unahur.obj2.motor.motor;

import ar.edu.unahur.obj2.motor.PaqueteRed;
import ar.edu.unahur.obj2.motor.observer.CentroNotificaciones;
import ar.edu.unahur.obj2.motor.politicas.IPoliticaFiltrado;

public class MotorFrontera extends MotorInspeccion {

    public MotorFrontera(IPoliticaFiltrado unaPolitica, CentroNotificaciones unCentro) {
        super(unaPolitica, unCentro);
    }


    @Override
    protected void inspeccionProfunda(PaqueteRed unPaquete) {
        
    }

}
