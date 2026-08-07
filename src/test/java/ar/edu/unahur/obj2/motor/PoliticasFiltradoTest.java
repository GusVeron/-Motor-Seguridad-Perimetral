package ar.edu.unahur.obj2.motor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.motor.politicas.BloqueoPorIp;
import ar.edu.unahur.obj2.motor.politicas.BloqueoPorPuerto;
import ar.edu.unahur.obj2.motor.politicas.IPoliticaFiltrado;
import ar.edu.unahur.obj2.motor.politicas.PoliticaEstricta;
import ar.edu.unahur.obj2.motor.politicas.PoliticaPermisiva;

public class PoliticasFiltradoTest {

    // Test 1)
    @Test
    public void bloqueoPorIpRechazaPaqueteDeIpMaliciosa() {

        PaqueteRed unPaquete = new PaqueteRed(
                "192.168.1.100",
                "8.8.8.8",
                85
        );

        IPoliticaFiltrado politica = new BloqueoPorIp("192.168.1.100");

        Boolean resultado = politica.rechaza(unPaquete);

        assertTrue(resultado);
    }

    // Test 2)
    @Test
    public void bloqueoPorPuertoRechazaPuertoRestringido() {
        
        PaqueteRed paquete = new PaqueteRed(
                "192.168.1.100",
                "8.8.8.8",
                22
        );



        IPoliticaFiltrado politica = new BloqueoPorPuerto(22);

        Boolean resultado = politica.rechaza(paquete);


        assertTrue(resultado);
    }

    // Test 3)
    @Test
    public void politicaEstrictaRechazaSiAlMenosUnaPoliticaRechaza() {
        
        PaqueteRed paquete = new PaqueteRed(
                "192.168.1.100",
                "8.8.8.8",
                80
        );



        IPoliticaFiltrado porIp = new BloqueoPorIp("192.168.1.100");

        IPoliticaFiltrado porPuerto =  new BloqueoPorPuerto(22);

        IPoliticaFiltrado politicaEstricta = new PoliticaEstricta(List.of(porIp, porPuerto));

        Boolean resultado = politicaEstricta.rechaza(paquete);


        
        assertTrue(resultado);
    }

    // Test 4)
    @Test
    public void politicaPermisivaRechazaCuandoTodasLasPoliticasRechazan() {
        
        PaqueteRed paquete = new PaqueteRed(
                "192.168.1.100",
                "8.8.8.8",
                22
        );



        IPoliticaFiltrado porIp = new BloqueoPorIp("192.168.1.100");

        IPoliticaFiltrado porPuerto = new BloqueoPorPuerto(22);

        IPoliticaFiltrado politicaPermisiva = new PoliticaPermisiva( List.of(porIp, porPuerto));


        Boolean resultado = politicaPermisiva.rechaza(paquete);


        assertTrue(resultado);
    }

}
