package ar.edu.unahur.obj2.motor.politicas;

import ar.edu.unahur.obj2.motor.PaqueteRed;

public class BloqueoPorIp implements IPoliticaFiltrado{

    private final String ipMaliciosa;


    public BloqueoPorIp(String unaIpMaliciosa) {
        this.ipMaliciosa = unaIpMaliciosa;
    }

    
    @Override
    public Boolean rechaza(PaqueteRed paquete) {
        return paquete.ipOrigen().equals(ipMaliciosa);
    }

}
