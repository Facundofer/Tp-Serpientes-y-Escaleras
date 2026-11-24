package modelo.unlu.facu.proyectoFinal;

import java.util.Random;

public class Dado {
    private Integer cara;
    private Random generador = new Random();

    public Dado(){

        this.cara = 0;
    }

    public void tirarDado(){

        this.cara = generador.nextInt(6) + 1;
    }

    public int getCara(){

        return cara;
    }

}
