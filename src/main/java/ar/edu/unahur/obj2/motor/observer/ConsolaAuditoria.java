package ar.edu.unahur.obj2.motor.observer;

import ar.edu.unahur.obj2.motor.PaqueteRed;

public class ConsolaAuditoria implements IObservador {


    @Override
    public void notificar(PaqueteRed paquete) {
        System.out.println("Alerta de seguridad: Paquete rechazado desde la IP " + paquete.ipOrigen());
    }

}
