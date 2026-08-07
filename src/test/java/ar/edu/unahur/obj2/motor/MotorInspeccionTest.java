package ar.edu.unahur.obj2.motor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.motor.excepciones.ViolacionSegmentacionException;
import ar.edu.unahur.obj2.motor.motor.MotorFrontera;
import ar.edu.unahur.obj2.motor.observer.CentroNotificaciones;
import ar.edu.unahur.obj2.motor.politicas.BloqueoPorIp;
import ar.edu.unahur.obj2.motor.politicas.IPoliticaFiltrado;

public class MotorInspeccionTest {

    // Test 1)
    @Test
    public void motorMarcaComoAmenazaUnPaqueteRechazado() 
        throws ViolacionSegmentacionException {

        CentroNotificaciones centro = new CentroNotificaciones();

        IPoliticaFiltrado politica = new BloqueoPorIp("192.168.0.10");

        MotorFrontera motor = new MotorFrontera(politica, centro);

        PaqueteRed paquete = new PaqueteRed("192.168.0.10", "8.8.8.8", 80);

        motor.inspeccionar(paquete);

        assertEquals("Amenaza", paquete.estado());

    }

    // Test 2)
    @Test
    public void motorMarcaComoSeguroUnPaqueteAprobado()
        throws ViolacionSegmentacionException {

        CentroNotificaciones centro = new CentroNotificaciones();

        IPoliticaFiltrado politica = paquete -> false;  
        
        MotorFrontera motor = new MotorFrontera(politica, centro);

        PaqueteRed paquete = new PaqueteRed("192.168.1.10", "8.8.8.8", 45);

        motor.inspeccionar(paquete);
        
        assertEquals("Tráfico Seguro", paquete.estado());
    }

}
