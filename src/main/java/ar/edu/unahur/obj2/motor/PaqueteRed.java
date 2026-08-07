package ar.edu.unahur.obj2.motor;

import ar.edu.unahur.obj2.motor.excepciones.PaqueteMalformadoException;

public class PaqueteRed {

    private final String ipOrigen;
    private final String ipDestino;
    private final Integer puerto;
    private String estado;


    public PaqueteRed(String ipOrigen, String ipDestino, Integer unPuerto) {
        this.ipOrigen = ipOrigen;
        this.ipDestino = ipDestino;
        this.puerto = validarPuerto(unPuerto);
        this.estado = "Pendiente";
    }


    private Integer validarPuerto(Integer unPuerto) {
        if (unPuerto < 1 || unPuerto > 65535) {
            throw new PaqueteMalformadoException("El puerto debe estar entre 1 y 65535");
        }

        return unPuerto;
    }

    public String ipOrigen() {
        return ipOrigen;
    }

    public String ipDestino() {
        return ipDestino;
    }

    public Integer puerto() {
        return puerto;
    }

    public String estado() {
        return estado;
    }

    public void marcarComoAmenaza() {
        this.estado = "Amenaza";
    }

    public void marcarComoSeguro() {
        this.estado = "Tráfico Seguro";
    }
}
