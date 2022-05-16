import java.util.*;

public class Lista7 {
    public static void main(String[] args) {

        System.out.println("--\tArco-íris\t--");

        System.out.println("\n* Crie um conjunto contendo as cores do arco-íris");
        Set<String> cores = new LinkedHashSet<>(Arrays.asList("vermelho","laranja","amarelo","verde","azul","anil","violeta"));


        System.out.println("\n* Exiba todas as cores do arco-íris uma abaixo da outra");
        System.out.println("Cores:");
        for (String cor : cores) System.out.println("- " + cor);


        System.out.println("\n* Exiba a quantidade de cores que o arco-íris tem");
        System.out.println("Quantidade: " + cores.size());


        System.out.println("\n* Exiba as cores em ordem alfabética");
        Set<String> cores1 = new TreeSet<>(cores);
        System.out.println(cores1);


        System.out.println("\n* Exiba as cores na ordem inversa da que foi informada");
        List<String> coresInverso = new ArrayList<>(cores);
        Collections.reverse(coresInverso);
        System.out.println(coresInverso);


        System.out.println("\n* Exiba todas as cores que começam com a letra ”v”");
        for(String cor : cores) if(cor.startsWith("v")) {System.out.println(cor);}


        System.out.println("\n* Remova todas as cores que não começam com a letra “v”");
        Iterator<String> iterator = cores.iterator();
        while (iterator.hasNext()){
            if (!iterator.next().startsWith("v")) iterator.remove();
        }
        System.out.println(cores);

        System.out.println("\n* Limpe o conjunto");
        cores.clear();
        System.out.println(cores);

        System.out.println("\n* Confira se o conjunto está vazio");
        System.out.println("Vazio? " + cores.isEmpty());
    }
}
