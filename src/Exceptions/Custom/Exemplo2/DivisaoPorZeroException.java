package Exceptions.Custom.Exemplo2;

public class DivisaoPorZeroException extends Throwable {

    public DivisaoPorZeroException() {
        super("Impossível dividir por 0!");
    }

}
