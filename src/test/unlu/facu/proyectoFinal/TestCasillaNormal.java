package test.unlu.facu.proyectoFinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import modelo.unlu.facu.proyectoFinal.casilla;
import modelo.unlu.facu.proyectoFinal.casillaNormal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCasillaNormal {

    private casilla unaCasillaNormal;


    @BeforeEach
    void setUp(){
        unaCasillaNormal = new casillaNormal(54, "Normal");

    }

    @Test
    void testCasillaNormal(){
        assertNotNull(unaCasillaNormal);
    }
    @Test
    void testGetNumeroCasilla(){
        assertTrue(unaCasillaNormal.getnumeroDeCasilla() > 0 && unaCasillaNormal.getnumeroDeCasilla() < 100 );
        System.out.println("La casilla es nivel: " + unaCasillaNormal.getnumeroDeCasilla());
    }
    @Test
    void testGetNivelCasilla(){
        assertTrue(unaCasillaNormal.getNivelActual() > 0 && unaCasillaNormal.getNivelActual() < 9 );
        System.out.println("Esta en el nivel: " + unaCasillaNormal.getNivelActual());
    }
    @Test
    void testTipoCasilla(){
        assertEquals("Normal", unaCasillaNormal.getTipoCasilla());
    }
}
