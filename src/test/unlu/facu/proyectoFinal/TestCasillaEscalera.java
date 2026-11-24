package test.unlu.facu.proyectoFinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import modelo.unlu.facu.proyectoFinal.casilla;
import modelo.unlu.facu.proyectoFinal.casillaEscalera;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCasillaEscalera {

    private casilla unaCasillaEscalera;

    @BeforeEach
    void setUp(){
        unaCasillaEscalera = new casillaEscalera(81, "Escalera");
    }

    @Test
    void testCasillaEscalera(){
        assertNotNull(unaCasillaEscalera);
    }
    @Test
    void testGetNumeroCasilla(){
        assertTrue(unaCasillaEscalera.getnumeroDeCasilla() > 0 && unaCasillaEscalera.getnumeroDeCasilla() < 100 );
        System.out.println("La casilla es nivel: " + unaCasillaEscalera.getnumeroDeCasilla());
    }
    @Test
    void testGetNivelCasilla(){
        assertTrue(unaCasillaEscalera.getNivelActual() > 0 && unaCasillaEscalera.getNivelActual() < 9 );
        System.out.println("Esta en el nivel: " + unaCasillaEscalera.getNivelActual());
    }

    @Test
    void testTipoCasilla(){
        assertEquals("Escalera", unaCasillaEscalera.getTipoCasilla());
        System.out.println("La casilla es del tipo: " + unaCasillaEscalera.getTipoCasilla());
    }
    @Test
    void testGetFinalEscalera(){
        assertTrue(unaCasillaEscalera.getDestino() < 100 && unaCasillaEscalera.getDestino() > unaCasillaEscalera.getnumeroDeCasilla());
        System.out.println("Este es el final: " + unaCasillaEscalera.getDestino());

    }
}