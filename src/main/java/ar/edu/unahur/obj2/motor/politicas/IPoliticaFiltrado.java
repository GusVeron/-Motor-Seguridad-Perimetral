package ar.edu.unahur.obj2.motor.politicas;

import ar.edu.unahur.obj2.motor.PaqueteRed;

public interface IPoliticaFiltrado {

     Boolean rechaza(PaqueteRed unPaquete);
}
