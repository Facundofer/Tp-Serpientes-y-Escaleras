package test.unlu.facu.proyectoFinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.unlu.facu.proyectoFinal.Dado;
import modelo.unlu.facu.proyectoFinal.Jugador;

import static org.junit.jupiter.api.Assertions.*;

public class TestJugador {
    Dado unDado;
    Dado DosDado;
    Jugador unJugador;

    @BeforeEach
    void setUp(){
        unDado = new Dado();
        unJugador = new Jugador("Facu");
    }

    @Test
    void TestExistencia(){
        assertNotNull(unJugador);
    }

    @Test
    void TestGetPosicionActual(){
        assertEquals(0, unJugador.getPsosicionActual());
    }

    @Test
    void TestSetPosicionActual(){
        unJugador.setPosicionActual(2);
        assertEquals(2, unJugador.getPsosicionActual());
    }

    @Test
    void TestGetultimaTirada(){
       assertEquals(unJugador.tirarDado(unDado), unJugador.getUltimaTirada() );
        System.out.println("Los dados saliron " + unJugador.getUltimaTirada());
    }

}
