package vista.unlu.facu.proyectoFinal;

import modelo.unlu.facu.proyectoFinal.Jugador;
import modelo.unlu.facu.proyectoFinal.Tablero;

import java.util.Scanner;

public class VistaConsola implements IvistaJuego{

    private final Scanner entradaConsola;

    public VistaConsola() {
        this.entradaConsola = new Scanner(System.in);
    }

    @Override
    public void mostrarBienvenida() {
        System.out.println("==================================================");
        System.out.println("      BIENVENIDO A SERPIENTES Y ESCALERAS         ");
        System.out.println("==================================================");
    }



    @Override
    public void mostrarTablero(Tablero tablero, Jugador jugadorUno, Jugador jugadorDos) {
        System.out.println("\n================ TABLERO DE JUEGO ================");

        for (int fila = 9; fila >= 0; fila--) {
            for (int columna = 1; columna <= 10; columna++) {
                int numeroCasilla;


                if (fila % 2 == 0) {
                    numeroCasilla = (fila * 10) + columna;
                } else {

                    numeroCasilla = (fila * 10) + (11 - columna);
                }


                if (jugadorUno.getPsosicionActual() == numeroCasilla && jugadorDos.getPsosicionActual() == numeroCasilla) {
                    System.out.print("[J1J2]\t");
                } else if (jugadorUno.getPsosicionActual() == numeroCasilla) {
                    System.out.print("[ J1 ]\t");
                } else if (jugadorDos.getPsosicionActual() == numeroCasilla) {
                    System.out.print("[ J2 ]\t");
                } else {

                    String tipoCasilla = tablero.getUnaCasilla(numeroCasilla).getTipoCasilla();
                    switch (tipoCasilla) {
                        case "Escalera":
                            System.out.print("[ E  ]\t");
                            break;
                        case "Serpiente":
                            System.out.print("[ S  ]\t");
                            break;
                        default:
                            System.out.printf("[%3d ]\t", numeroCasilla);
                            break;
                    }
                }
            }
            System.out.println();
        }

        System.out.println("==================================================\n");
    }

    @Override
    public void esperarTirada(String nombreJugador) {
        System.out.print("Turno de " + nombreJugador + ". Presioná ENTER para tirar el dado...");
        this.entradaConsola.nextLine();
    }

    @Override
    public void mostrarResultadoTurno(String nombreJugador, int valorDado, int casillaProvisoria, int posicionFinal, String tipoCasilla) {
        System.out.println("-> " + nombreJugador + " sacó un " + valorDado + " y avanzó hasta la casilla " + casillaProvisoria + ".");

        switch (tipoCasilla) {
            case "Escalera":
                System.out.println("   ¡ESCALERA! Subís hasta la casilla " + posicionFinal + ".");
                break;
            case "Serpiente":
                System.out.println("   ¡SERPIENTE! Bajás hasta la casilla " + posicionFinal + ".");
                break;
            default:
                System.out.println("   Casilla normal. Te quedás en la casilla " + posicionFinal + ".");
                break;
        }
    }

    @Override
    public void mostrarGanador(String nombreGanador) {
        System.out.println("\n**************************************************");
        System.out.println("   ¡FELICITACIONES " + nombreGanador.toUpperCase() + ", GANASTE LA PARTIDA!   ");
        System.out.println("**************************************************\n");
    }
}
