package ar.edu.unahur.obj2.motor.motor;

import ar.edu.unahur.obj2.motor.PaqueteRed;
import ar.edu.unahur.obj2.motor.politicas.IPoliticaFiltrado;

public class MotorInterno extends MotorInspeccion {

    public MotorInterno(IPoliticaFiltrado unaPolitica) {
        super(unaPolitica);
    }


    @Override
    protected void inspeccionProfunda(PaqueteRed unPaquete) {
        
    }

}
