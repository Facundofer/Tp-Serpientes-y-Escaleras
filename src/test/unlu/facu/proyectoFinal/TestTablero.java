package test.unlu.facu.proyectoFinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.unlu.facu.proyectoFinal.Tablero;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestTablero {
    Tablero unTablero;
    @BeforeEach
    void setUp(){
        unTablero = new Tablero();
    }

    @Test
    void testInicializacionTblero(){
        unTablero.llenarTablero();
        assertNotNull(unTablero);
        System.out.println("primera casilla " + unTablero.getUnaCasilla(20).getTipoCasilla() + " con numero " + unTablero.getUnaCasilla(20).getnumeroDeCasilla() + " destino " + unTablero.getUnaCasilla(20).getDestino());
        System.out.println("casilla destino de tipo " + unTablero.getUnaCasilla(unTablero.getUnaCasilla(20).getDestino()).getTipoCasilla() +" numero " + unTablero.getUnaCasilla(unTablero.getUnaCasilla(20).getDestino()).getnumeroDeCasilla());
    }
}
