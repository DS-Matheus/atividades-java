package List.Lista2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("* Crie uma lista e adicione as notas do aluno");
//        Dados - notas do aluno: 7, 8.5, 9.3, 5, 7, 0, 3.6

        List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        System.out.println("\n* Exiba a posição da nota 5");
        System.out.println(notas);
        System.out.println("Posição: " + notas.indexOf(5d));


        System.out.println("\n* Adicione na lista a nota 8.0 na posição 4");
        notas.set(4, 8d);
        System.out.println(notas);


        System.out.println("\n* Substitua a nota 5.0 pela nota 6.0");
        notas.set(notas.indexOf(5d), 6d);
        System.out.println(notas);


        System.out.println("\n* Confira se a nota 5.0 está na lista");
        boolean listaContem = notas.contains(5d);
        System.out.println(notas);
        System.out.println("Está? " + listaContem);


        System.out.println("\n* Exiba a terceira nota adicionada");
        Double terceiraNota = notas.get(2);
        System.out.println(notas);
        System.out.println("Nota: " + terceiraNota);


        System.out.println("\n* Exiba a menor nota");
        Double menorNota = Collections.min(notas);
        System.out.println(notas);
        System.out.println("Nota: " + menorNota);


        System.out.println("\n* Exiba a maior nota");
        Double maiorNota = Collections.max(notas);
        System.out.println(notas);
        System.out.println("Nota: " + maiorNota);


        System.out.println("\n* Exiba a soma dos valores");
        Double soma = 0d;
        for (double nota : notas) {
            soma += nota;
        }
        System.out.println(notas);
        System.out.println("Soma: " + soma);


        System.out.println("\n* Exiba a média das notas");
        Iterator<Double> iteratorMedia = notas.iterator();
//        Obs: não precisava calcular a soma novamente, nesse caso, eu apenas queria treinar o uso do iterator
        soma = 0d;
        while (iteratorMedia.hasNext()){
            soma += iteratorMedia.next();
        }
        Double media = soma/notas.size();
        System.out.println(notas);
        System.out.println("Média: " + media);
        System.out.println("Arrendondamento: " + String.format("%.1f",media));


        System.out.println("\n* Remova a nota 0");
        notas.remove(notas.indexOf(0d));
        System.out.println(notas);


        System.out.println("\n* Remova a nota da posição 0");
        notas.remove(0);
        System.out.println(notas);


        System.out.println("\n* Remova as notas menores que 7 e exiba a lista");
//
//        # como eu fiz:
/*        Iterator<Double> iteratorRemoverMenor7 = notas.iterator();
        while (iteratorRemoverMenor7.hasNext()){
            Double nota = iteratorRemoverMenor7.next();
            if (nota < 7)
                iteratorRemoverMenor7.remove();
        }*/

//        # sugestão da IDE:
        notas.removeIf(nota -> nota < 7);
        System.out.println(notas);


        System.out.println("\n* Confira se a lista está vazia");
//        notas.clear();
        System.out.println(notas);
        System.out.println("Está vázia? " + notas.isEmpty());


//        Resolva esses exercícios utilizando os métodos da implementação LinkedList:

        System.out.println("\n* Crie uma lista chamada notas2 e coloque todos os elementos da list Arraylist nessa nova lista");
        LinkedList<Double> notas2 = new LinkedList<>();
        notas2.addAll(notas);
//        Fazendo direto:
//        LinkedList<Double> notas2 = new LinkedList<>(notas);
        System.out.println(notas2);


        System.out.println("\n* Mostre a primeira nota da nova lista sem removê-la");
        System.out.println("Nota: " + notas2.getFirst());
        System.out.println(notas2);


        System.out.println("\n* Mostre a primeira nota da nova lista removendo-a");
        System.out.println("Nota: " + notas2.getFirst());
        notas2.removeFirst();
        System.out.println(notas2);

    }
}