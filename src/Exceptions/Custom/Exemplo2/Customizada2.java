package Exceptions.Custom.Exemplo2;

import javax.swing.*;

public class Customizada2 {
    public static void main(String[] args) {
        int[] numerador = {4, 5, 8, 10};
        int[] denominador = {2, 4, 0, 2, 8};

        for (int i = 0; i < denominador.length; i++) {

            try {

                if(i == denominador.length || i == numerador.length)
                    throw new IndexInvalidoException(i, getElementoProblematico(numerador, denominador));

                if(denominador[i] == 0)
                    throw new DivisaoPorZeroException();

                if(numerador[i] %2 != 0)
                    throw new DivisaoNaoExataException(numerador[i], denominador[i]);

                int resultado = numerador[i] / denominador[i];
                System.out.println(resultado);

            } catch (DivisaoNaoExataException | DivisaoPorZeroException | IndexInvalidoException e) {
//                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

        System.out.println("Continuação do código");

    }

    public static String getElementoProblematico(int[] numerador, int[] denominador) {
        if (numerador.length < denominador.length)
            return "numerador";
        else
            return "denominador";
    }

}