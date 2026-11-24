package controlador.unlu.facu.proyectoFinal;

import modelo.unlu.facu.proyectoFinal.Jugador;
import modelo.unlu.facu.proyectoFinal.Dado;
import observers.unlu.facu.proyectoFinal.Observador;
import modelo.unlu.facu.proyectoFinal.Tablero;
import vista.unlu.facu.proyectoFinal.IvistaJuego;

public class controladorJuego implements Observador {

    private final Tablero tablero;
    private final Jugador jugadorUno;
    private final Jugador jugadorDos;
    private final IvistaJuego vista;
    private final Dado DadoUno;


    public controladorJuego(Tablero tablero, Jugador jugadorUno, Jugador jugadorDos, IvistaJuego vista, Dado unDado) {
        this.tablero = tablero;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.vista = vista;
        this.DadoUno = unDado;
    }

    public void iniciarPartida() {
        this.vista.mostrarBienvenida();
        this.vista.mostrarTablero(this.tablero, this.jugadorUno, this.jugadorDos);

        Jugador jugadorActual = this.jugadorUno;
        boolean hayGanador = false;

        while (!hayGanador) {
            this.vista.esperarTirada(jugadorActual.getNombreJugador());

            this.tablero.jugar(jugadorActual, DadoUno);

            if (jugadorActual.getPsosicionActual() == 100) {
                this.vista.mostrarGanador(jugadorActual.getNombreJugador());
                hayGanador = true;
            } else jugadorActual = (jugadorActual == this.jugadorUno) ? this.jugadorDos : this.jugadorUno;
        }
    }

    @Override
    public void actualizar() {
        Jugador jugadorMovido = this.tablero.getUltimoJugadorMovido();
        this.vista.mostrarResultadoTurno(
                jugadorMovido.getNombreJugador(),
                this.tablero.getUltimaTirada(),
                this.tablero.getUltimaCasillaProvisoria(),
                jugadorMovido.getPsosicionActual(),
                this.tablero.getUltimoTipoCasilla()
        );
        this.vista.mostrarTablero(this.tablero, this.jugadorUno, this.jugadorDos);
    }
}

