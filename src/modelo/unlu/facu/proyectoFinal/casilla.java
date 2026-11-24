package modelo.unlu.facu.proyectoFinal;

public abstract class casilla {
    private Integer numeroDeCasilla;
    private String TipoDeCasilla;
    private Integer nivelActual;

    public void Casilla(int numeroCasilla, String unTipoDeCasilla) {
        this.numeroDeCasilla = numeroCasilla;
        this.TipoDeCasilla = unTipoDeCasilla;
        this.nivelActual = (numeroCasilla - 1) / 10;
    }

    public String getTipoCasilla(){
        return this.TipoDeCasilla;
    }

    public Integer getNivelActual(){
        return this.nivelActual;
    }

    public Integer getnumeroDeCasilla(){
        return this.numeroDeCasilla;
    }
    public abstract Integer getDestino();

}
