package modelo.unlu.facu.proyectoFinal;

import java.util.Random;

public class casillaEscalera extends casilla{
    private Random generador = new Random();
    private Integer casillaDestinoMinimo;
    private Integer casillaDestinoMaximo;
    private Integer finalEscalera;

    public casillaEscalera(int numeroCasilla, String unTipoDeCasilla) {
        super.Casilla(numeroCasilla, unTipoDeCasilla);
        this.casillaDestinoMinimo = ((super.getNivelActual() + 1) * 10) + 1;
        this.casillaDestinoMaximo = Math.min( ((Math.min((super.getNivelActual() + 3), 9) + 1) * 10) , 99);
        this.finalEscalera = this.generador.nextInt((this.casillaDestinoMaximo - this.casillaDestinoMinimo) + 1) + this.casillaDestinoMinimo;

    }

    @Override
    public Integer getDestino() {
        return this.finalEscalera;
    }
}
