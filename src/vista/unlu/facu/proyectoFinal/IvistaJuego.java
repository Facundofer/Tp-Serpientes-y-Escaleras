package vista.unlu.facu.proyectoFinal;

import modelo.unlu.facu.proyectoFinal.Jugador;
import modelo.unlu.facu.proyectoFinal.Tablero;

public interface IvistaJuego {

    void mostrarBienvenida();


    void mostrarTablero(Tablero tablero, Jugador jugadorUno, Jugador jugadorDos);

    void mostrarGanador(String nombreGanador);

    void esperarTirada(String nombreJugador);

    public void mostrarResultadoTurno(String nombreJugador, int valorDado, int casillaProvisoria, int posicionFinal, String tipoCasilla) ;
}
