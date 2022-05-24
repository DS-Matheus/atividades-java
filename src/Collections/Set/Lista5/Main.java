package Collections.Set.Lista5;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5d, 9.3d, 5d, 7d, 0d, 3.6d));
        System.out.println(notas);

//        Sets não armazenam valores repetidos, por isso aparece apenas um "7" na hora de exibir
//        HashSet = ordem aleatória
//        LinkedHashSet = ordem de inserção
//        TreeSet = ordem natural

//        System.out.println("\n* Exiba a posição da nota 5.0: ");
//        System.out.println("\n* Adicione na lista a nota 8.0 na posição 4: ");
//        System.out.println("\n* Exiba a terceira nota adicionada: ");
//        Não é possivel, Sets não usam index

        System.out.println("\n* Substitua a nota 5.0 pela nota 6.0: ");
        notas.remove(5d);
        notas.add(6d);
        System.out.println(notas);
//        aparentemente a única forma possível é removendo o valor inicial e adicionando o outro valor
//        acredito não haver um método "propriamente dito" para substituir um número de um Collections.Set

        System.out.println("\n* Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));


        System.out.println("\n* Exiba a menor nota: " + Collections.min(notas));


        System.out.println("\n* Exiba a maior nota: " + Collections.max(notas));


        System.out.println("\n* Exiba a soma dos valores");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Soma: " + String.format("%.1f",soma));


        System.out.println("\n* Exiba a média das notas: " + String.format("%.1f", soma/notas.size()) );


        System.out.println("\n* Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);


        System.out.println("\n* Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double valor = iterator1.next();
            if (valor < 7) iterator1.remove();
        }
        System.out.println(notas);


        System.out.println("\n* Exiba todas as notas na ordem em que foram informados: ");

        Set<Double> notas1 = new LinkedHashSet<>(Arrays.asList(7d, 8.5d, 9.3d, 5d, 7d, 0d, 3.6d));
        System.out.println(notas1);
//        é preciso usar o LinkedHashSet, o HashSet não armazena a ordem que foram informados os valores

        System.out.println("\n* Exiba todas as notas na ordem crescente: ");
        Set<Double> notas2 = new TreeSet<>(notas1);
        System.out.println(notas2);
//        é preciso usar o TreeSet, o LinkedHashSet não armazena a ordem natural dos valores

        System.out.println("\n* Apague todos os conjuntos");
        notas.clear();
        notas1.clear();
        notas2.clear();
        System.out.println(notas + "\n" + notas1 + "\n" + notas2);

        System.out.println("\n* Confira se os conjuntos estão vazios:" +
                "\nNotas: " + notas.isEmpty() + "\nNotas1: " + notas1.isEmpty() + "\nNotas2: " + notas2.isEmpty());
    }
}
