package Exceptions.Custom.Exemplo2;

public class DivisaoNaoExataException extends Exception {

    private int numerador, denominador;

    public DivisaoNaoExataException(int numerador, int denominador) {
        super("Divisão não exata!   " + numerador + "/" + denominador);
        this.numerador = numerador;
        this.denominador = denominador;
    }
}
