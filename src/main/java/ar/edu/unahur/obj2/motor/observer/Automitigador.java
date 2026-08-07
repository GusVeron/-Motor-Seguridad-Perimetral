package ar.edu.unahur.obj2.motor.observer;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.motor.PaqueteRed;

public class Automitigador implements IObservador {

    private final List<String> ipsBloqueadas = new ArrayList<>();


    @Override
    public void notificar(PaqueteRed paquete) {
        ipsBloqueadas.add(paquete.ipOrigen());
    }
    

    public List<String> ipsBloqueadas() {
        return List.copyOf(ipsBloqueadas);
    }

}
