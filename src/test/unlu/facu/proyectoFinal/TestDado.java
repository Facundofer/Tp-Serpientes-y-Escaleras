package test.unlu.facu.proyectoFinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import modelo.unlu.facu.proyectoFinal.Dado;

public class TestDado {
    private Dado primerDado;

    @BeforeEach
    void setUp(){
        primerDado = new Dado();
        primerDado.tirarDado();
    }


    @Test
    void testDado(){
        assertNotNull(primerDado);
    }

    @Test
    void testTirarDado(){
        assertTrue(primerDado.getCara() > 0 && primerDado.getCara() < 7 );
    }


}
