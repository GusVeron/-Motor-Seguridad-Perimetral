package ar.edu.unahur.obj2.motor.excepciones;

public class PaqueteMalformadoException extends RuntimeException{

    public PaqueteMalformadoException(String mensaje) {
        super(mensaje);
    }    
}
