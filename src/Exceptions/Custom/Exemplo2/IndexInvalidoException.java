package Exceptions.Custom.Exemplo2;

public class IndexInvalidoException extends Throwable {

    private String elemento;
    public IndexInvalidoException(int i, String elemento) {
        super("O índice [" + i + "] informado para o " + elemento + " é inválido ou está fora dos limites!");
    }

}
