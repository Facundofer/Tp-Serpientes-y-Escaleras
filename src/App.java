import controlador.unlu.facu.proyectoFinal.controladorJuego;
import modelo.unlu.facu.proyectoFinal.Dado;
import modelo.unlu.facu.proyectoFinal.Jugador;
import modelo.unlu.facu.proyectoFinal.Tablero;
import vista.unlu.facu.proyectoFinal.IvistaJuego;
import vista.unlu.facu.proyectoFinal.VistaConsola;

public class App {
    public static void main(String[] args) {

        Tablero tableroDeJuego = new Tablero();
        Dado primerDado = new Dado();
        tableroDeJuego.llenarTablero();

        Jugador jugadorUno = new Jugador("Jugador 1");
        Jugador jugadorDos = new Jugador("Jugador 2");


        IvistaJuego vistaConsola = new VistaConsola();

        controladorJuego controlador = new controladorJuego(tableroDeJuego, jugadorUno, jugadorDos, vistaConsola, primerDado);
        tableroDeJuego.agregarObservador(controlador);

        controlador.iniciarPartida();
    }
}
