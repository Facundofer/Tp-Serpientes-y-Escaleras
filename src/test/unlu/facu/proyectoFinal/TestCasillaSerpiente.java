package test.unlu.facu.proyectoFinal;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import modelo.unlu.facu.proyectoFinal.casilla;
import modelo.unlu.facu.proyectoFinal.casillaSerpiente;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCasillaSerpiente {

    private casilla unaCasillaSerpiente;

    @BeforeEach
    void setUp(){
        unaCasillaSerpiente = new casillaSerpiente(11, "Serpiente");
    }

    @Test
    void testCasillaSerpiente(){
        assertNotNull(unaCasillaSerpiente);
    }
    @Test
    void testGetNumeroCasilla(){
        assertTrue(unaCasillaSerpiente.getnumeroDeCasilla() > 0 && unaCasillaSerpiente.getnumeroDeCasilla() < 100 );
        System.out.println("La casilla es nivel: " + unaCasillaSerpiente.getnumeroDeCasilla());
    }
    @Test
    void testGetNivelCasilla(){
        assertTrue(unaCasillaSerpiente.getNivelActual() > 0 && unaCasillaSerpiente.getNivelActual() < 9 );
        System.out.println("Esta en el nivel: " + unaCasillaSerpiente.getNivelActual());
    }

    @Test
    void testTipoCasilla(){
        assertTrue(unaCasillaSerpiente.getTipoCasilla() == "Serpiente");
        System.out.println("La casilla es del tipo: " + unaCasillaSerpiente.getTipoCasilla());
    }
    @Test
    void testGetFinalSerpeinte(){
        assertTrue(unaCasillaSerpiente.getDestino() > 0 && unaCasillaSerpiente.getDestino() < unaCasillaSerpiente.getnumeroDeCasilla());
        System.out.println("Este es el final: " + unaCasillaSerpiente.getDestino());

    }
}

