package ar.edu.unahur.obj2.motor;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.motor.excepciones.PaqueteMalformadoException;

public class PaqueteRedTest {

    // Test 1)
    @Test
    public void unPaqueteConPuertoValidoSeCreaCorrectamente() {

         
        String ipOrigen = "192.168.1.10";
        String ipDestino = "8.8.8";
        Integer puertoValido = 80;

        
        PaqueteRed unPaquete = new PaqueteRed(ipOrigen, ipDestino, puertoValido);

        
        assertEquals(puertoValido, unPaquete.puerto());
    }

    // Test 2)
    public void unPaqueteConPuertoFueraDeRangoLanzaExcepcion() {

        Integer puertoInvalido = 65536;

        assertThrows(
                PaqueteMalformadoException.class,
                () -> new PaqueteRed(
                        "192.168.1.10",
                        "8.8.8.8",
                        puertoInvalido
                )
        );
    }

}
