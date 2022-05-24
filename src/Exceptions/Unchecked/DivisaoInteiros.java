package Exceptions.Unchecked;

import javax.swing.*;

public class DivisaoInteiros {
    public static void main(String[] args) {

        boolean continuarLacoRepeticao = true;

        do {

            String a = JOptionPane.showInputDialog("Insira o numerador: ");
            String b = JOptionPane.showInputDialog("Insira o denominador: ");

            try{
                int resultado = divisao(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continuarLacoRepeticao = false;
            } catch (NumberFormatException e) {
                e.printStackTrace(); //exibir o erro no console
                JOptionPane.showMessageDialog(null, "Entrada inválida, informe um número inteiro! " + e.getMessage());
            } catch (ArithmeticException e) {
                e.printStackTrace(); //exibir o erro no console
                JOptionPane.showMessageDialog(null, "Impossível dividir um número por 0!");
            }
            finally {
                System.out.println("Finally");
                //executado sempre após o try, independente se houve erro ou não
            }

        } while(continuarLacoRepeticao);


        System.out.println("Continuação do código");
    }

    public static int divisao(int a, int b) {
        return a/b;
    }

}
