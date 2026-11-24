package modelo.unlu.facu.proyectoFinal;

import java.util.Random;

public class casillaSerpiente extends casilla{
    private Random generador = new Random();
    private Integer casillaDestinoMinimo;
    private Integer casillaDestinoMaximo;
    private Integer finalSerpiente;


    public casillaSerpiente(int numeroCasilla, String unTipoDeCasilla) {
        super.Casilla(numeroCasilla, unTipoDeCasilla);
        this.casillaDestinoMaximo = (super.getNivelActual() * 10);
        this.casillaDestinoMinimo = (Math.max(super.getNivelActual() - 2 , 0)  * 10) + 1;
        this.finalSerpiente = this.generador.nextInt((this.casillaDestinoMaximo - this.casillaDestinoMinimo) + 1) + this.casillaDestinoMinimo;
    }
    @Override
    public Integer getDestino() {
        return this.finalSerpiente;
    }

}
