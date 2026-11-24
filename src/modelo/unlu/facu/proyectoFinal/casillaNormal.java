package modelo.unlu.facu.proyectoFinal;

public class casillaNormal extends casilla {

    public casillaNormal(int numeroCasilla, String unTipoDeCasilla) {
        super.Casilla(numeroCasilla, unTipoDeCasilla);
    }

    @Override
    public Integer getDestino() {
        return this.getnumeroDeCasilla();
    }
}
