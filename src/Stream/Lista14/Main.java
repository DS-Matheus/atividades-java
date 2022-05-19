package Stream.Lista14;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("\nImprima todos os elementos dessa lista de String: ");
        numerosAleatorios.forEach(System.out::println);


        System.out.println("\nPegue os 5 primeiros números e coloque dentro de um Set:");
        Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(numerosAleatorios5Primeiros);
//        um dos números "1" "some" pois o set não aceita numeros repetidos (ignora a inserção de novas copias)


        System.out.println("\nTransforme esta lista de String em uma lista de números inteiros.");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(numerosAleatoriosInteger);


        System.out.println("\nPegue os números pares e maiores que 2 e coloque em uma lista:");
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);


        System.out.println("\nMostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);


        System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante:");
        System.out.println(numerosAleatoriosInteger);
        numerosAleatoriosInteger.stream()
                .skip(3)
                .forEach(System.out::println);


        long countNumerosUnicos = numerosAleatoriosInteger.stream()
                .distinct()
                .count();
        System.out.println("\nRetirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);
        System.out.println(numerosAleatoriosInteger);


        System.out.print("\nMostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);
        System.out.println(numerosAleatoriosInteger);


        System.out.print("\nMostre o maior valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);;
        System.out.println(numerosAleatoriosInteger);


        int somaDosNumerosPares = numerosAleatoriosInteger.stream()
                .filter(i -> (i % 2 != 0))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("\nPegue apenas os números ímpares e some: " + somaDosNumerosPares);
        System.out.println(numerosAleatoriosInteger);


        System.out.println("\nMostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);


        System.out.println("\nAgrupe os valores ímpares múltiplos de 3 ou de 5:");
//        dica: collect(Collectors.groupingBy(new Function())
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(numerosAleatoriosInteger);
        System.out.println(collectNumerosMultiplosDe3E5);


        System.out.println("\nRemova os valores ímpares: ");
        numerosAleatoriosInteger.removeIf(integer -> integer % 2 != 0);
        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
        System.out.println(numerosAleatorios);
        System.out.println(numerosAleatoriosInteger);

    }
}