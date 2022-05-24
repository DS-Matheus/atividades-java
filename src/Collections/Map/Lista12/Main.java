package Collections.Map.Lista12;

import java.util.*;

public class Main {
    public static void main(String[] args) {

/*            Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
            Depois, mostre quantas vezes cada valor foi conseguido.*/

        List<Integer> valoresLancamentos = new ArrayList<>();
        Random numeroAleatorio = new Random();

        for (int i = 0; i < 100; i++) {
            int numero = numeroAleatorio.nextInt(6) + 1;
            valoresLancamentos.add(numero);
        }
//        +1 no numeroAleatorio para não haver valores = 0


        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valoresLancamentos) {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }
//        se já saiu um numero igual adicione +1 na contagem, senao crie um "contador" para esse numero diferente e conte ele


        System.out.println("\nValor " + " Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }

    }
}
