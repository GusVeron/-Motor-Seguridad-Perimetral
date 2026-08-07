package ar.edu.unahur.obj2.motor.observer;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.motor.PaqueteRed;

public class CentroNotificaciones {

    private final List<IObservador> observadores = new ArrayList<>();
    

    public void suscribir(IObservador observador) {
        observadores.add(observador);
    }

    public void desuscribir(IObservador observador) {
        observadores.remove(observador);
    }

    public void notificar(PaqueteRed paquete) {
        observadores.forEach(
                observador -> observador.notificar(paquete)
        );
    }
}
