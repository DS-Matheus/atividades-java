package Map.Lista13;

import java.util.*;

public class Main {
    public static void main(String[] args) {

            /*Dadas as seguintes informações  de id e contato, crie um dicionário e
            ordene este dicionário exibindo (Nome id - Nome contato);
            id = 1 - Contato = nome: Simba, numero: 2222;
            id = 4 - Contato = nome: Cami, numero: 5555;
            id = 3 - Contato = nome: Jon, numero: 1111;*/

        System.out.println("\n--\tOrdem aleatória\t--");

        Map<Integer, Contato> agendaContatos = new HashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        for (Map.Entry<Integer, Contato> contato: agendaContatos.entrySet()){
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());
        }


        System.out.println("\n--\tOrdem Inserção\t--");

        LinkedHashMap<Integer, Contato> agendaContatos2 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        for (Map.Entry<Integer, Contato> contato: agendaContatos2.entrySet()){
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());
        }


        System.out.println("\n--\tOrdem id\t--");
        TreeMap<Integer, Contato> agendaContatos3 = new TreeMap<>(agendaContatos2);
        for (Map.Entry<Integer, Contato> contato: agendaContatos3.entrySet()){
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome());
        }


        System.out.println("\n--\tOrdem número telefone\t--");
        Set<Map.Entry<Integer, Contato>> agendaContatos4 = new TreeSet<>(new ComparatorNumero());
        agendaContatos4.addAll(agendaContatos3.entrySet());
        for (Map.Entry<Integer, Contato> entry: agendaContatos4) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("\n--\tOrdem nome contato\t--");
        agendaContatos4 = new TreeSet<>(new ComparatorNome());
        agendaContatos4.addAll(agendaContatos3.entrySet());
        for (Map.Entry<Integer, Contato> entry: agendaContatos4) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

    }
}

class ComparatorNumero implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
    }
}

class ComparatorNome implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}