package modelo.unlu.facu.proyectoFinal;


import observers.unlu.facu.proyectoFinal.Observable;
import observers.unlu.facu.proyectoFinal.Observador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Tablero implements Observable {

    private final List<Observador> observadores;
    private final List<casilla> tableroDeJuego;
    private final Random generador = new Random();
    int opcionCasilla;
    casilla unaCasilla;
    private Jugador ultimoJugadorMovido;
    private int ultimaTirada;
    private int ultimaCasillaProvisoria;
    private String ultimoTipoCasilla;

    public Tablero(){
        this.tableroDeJuego = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public void llenarTablero(){
        unaCasilla = new casillaNormal(0, "Normal");
        tableroDeJuego.add(unaCasilla);
        for (int i = 1; i <= 100; i++){
            opcionCasilla = this.generador .nextInt(100) + 1;
            if (i == 1 || i == 100){
                unaCasilla = new casillaNormal(i, "Normal");
                tableroDeJuego.add(unaCasilla);
            }
            else if(opcionCasilla <= 70 ){
                unaCasilla = new casillaNormal(i, "Normal");
                tableroDeJuego.add(unaCasilla);
            }
            else if (opcionCasilla <= 85 ){
                if (i >= 90){
                   unaCasilla = new casillaNormal(i, "Normal");
                   tableroDeJuego.add(unaCasilla);
                }else{
                   unaCasilla = new casillaEscalera(i, "Escalera");
                    tableroDeJuego.add(unaCasilla);
                }
            }
            else {
                if (i <= 10){
                    unaCasilla = new casillaNormal(i, "Normal");
                    tableroDeJuego.add(unaCasilla);
                }
                else {
                    boolean esFinDeEscalera = false;
                    for (int j = 1; j < i; j++) {
                        casilla casillaAnterior = tableroDeJuego.get(j);
                        if (casillaAnterior.getTipoCasilla().equals("Escalera") && casillaAnterior.getDestino() == i) {
                            esFinDeEscalera = true;
                            break;
                        }
                    }
                    if (esFinDeEscalera) {
                        unaCasilla = new casillaNormal(i, "Normal");
                        tableroDeJuego.add(unaCasilla);
                    }
                    else {
                        unaCasilla = new casillaSerpiente(i, "Serpiente");
                        int verificadorDeCasillaDestino = unaCasilla.getDestino();
                        while(!tableroDeJuego.get(verificadorDeCasillaDestino).getTipoCasilla().equals("Normal")) {
                            unaCasilla = new casillaSerpiente(i, "Serpiente");
                            verificadorDeCasillaDestino = unaCasilla.getDestino();

                        }
                        tableroDeJuego.add(unaCasilla);
                    }
                }
            }
        }
    }

    public casilla getUnaCasilla(int indice){
        return tableroDeJuego.get(indice);
    }

    public void jugar(Jugador unJugador, Dado unDado) {
        int tirarDado = unJugador.tirarDado(unDado);
        this.ultimoJugadorMovido = unJugador;
        this.ultimaTirada = tirarDado;

        int posicionDestinoProvisoria = unJugador.getPsosicionActual() + tirarDado;

        if (posicionDestinoProvisoria > 100) {
            this.ultimaCasillaProvisoria = unJugador.getPsosicionActual();
            this.ultimoTipoCasilla = "Normal";
        } else {
            this.ultimaCasillaProvisoria = posicionDestinoProvisoria;
            casilla casillaCaida = tableroDeJuego.get(posicionDestinoProvisoria);
            this.ultimoTipoCasilla = casillaCaida.getTipoCasilla();

            int posicionFinal = casillaCaida.getDestino();
            unJugador.setPosicionActual(posicionFinal);
        }

        this.notificarObservadores();
    }

    public Jugador getUltimoJugadorMovido() {
        return this.ultimoJugadorMovido;
    }

    public int getUltimaTirada() {
        return this.ultimaTirada;
    }

    public int getUltimaCasillaProvisoria() {
        return this.ultimaCasillaProvisoria;
    }

    public String getUltimoTipoCasilla() {
        return this.ultimoTipoCasilla;
    }

    @Override
    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }


    @Override
    public void notificarObservadores() {
        for (Observador observador : this.observadores) {
            observador.actualizar();
        }
    }
}
