package modelo.unlu.facu.proyectoFinal;

public class Jugador {
    private Integer psosicionActual;
    private Integer ultimaTirada;
    private String nombreJugador;

    public Jugador(String unNombreJugador){
        this.nombreJugador = unNombreJugador;
        this.psosicionActual = 0;
        this.ultimaTirada = 0;
    }

    public Integer getPsosicionActual(){
        return this.psosicionActual;
    }

    public Integer getUltimaTirada(){
        return this.ultimaTirada;
    }

    public String getNombreJugador() {
        return this.nombreJugador;
    }

    public void setPosicionActual(int psosicionActual) {
        this.psosicionActual = psosicionActual;
    }

    public Integer tirarDado(Dado unDado){
       unDado.tirarDado();
       return this.ultimaTirada = unDado.getCara();
    }

}
