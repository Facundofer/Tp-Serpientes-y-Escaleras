package observers.unlu.facu.proyectoFinal;

public interface Observable {

    void agregarObservador(Observador observador);

    void notificarObservadores();
}
