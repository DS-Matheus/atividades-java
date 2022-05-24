package Collections.List.Lista4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

    public class Main {
        public static void main(String[] args) {

/*
                Dadas as seguintes informações sobre meus gatos, crie uma lista
                e ordene esta lista exibindo:
                (nome - idade - cor);
                ArrayList.Lista1.Lista4.Gato 1 = nome: Jon, idade: 18, cor: preto
                ArrayList.Lista1.Lista4.Gato 2 = nome: Simba, idade: 6, cor: tigrado
                ArrayList.Lista1.Lista4.Gato 3 = nome: Jon, idade: 12, cor: amarelo
*/
            List<Gato> listGatos = new ArrayList<>(){{
                add(new Gato("Jon", 12, "preto"));
                add(new Gato("Simba", 6, "tigrado"));
                add(new Gato("Jon", 18, "amarelo"));
            }};
            listGatos.sort(Comparator.comparing(Gato::getNome));


            System.out.println("\n* Em Ordem de Inserção:");
            System.out.println(listGatos);

            System.out.println("\n* Em Ordem aleatória");
            Collections.shuffle(listGatos);
            System.out.println(listGatos);

            System.out.println("\n* Ordem Natural (Nome)");
            Collections.sort(listGatos);
            System.out.println(listGatos);

            System.out.println("\n* Ordem Idade");
//        Collections.sort(meusGatos, new ArrayList.Lista1.Lista4.ComparatorIdade());
            listGatos.sort(new ComparatorIdade());
            System.out.println(listGatos);

            System.out.println("\n* Ordem cor");
//        Collections.sort(meusGatos, new ArrayList.Lista1.Lista4.ComparatorCor());
            listGatos.sort(new ComparatorCor());
            System.out.println(listGatos);

            System.out.println("\n* Ordem Nome/Cor/Idade");
//        Collections.sort(meusGatos, new ArrayList.Lista1.Lista4.ComparatorNomeCorIdade());
            listGatos.sort(new ComparatorNomeCorIdade());
            System.out.println(listGatos);
        }
    }

    class Gato implements Comparable<Gato>{
        private String nome;
        private Integer idade;
        private String cor;

        public Gato(String nome, Integer idade, String cor) {
            this.nome = nome;
            this.idade = idade;
            this.cor = cor;
        }

        public String getNome() {
            return nome;
        }

        public Integer getIdade() {
            return idade;
        }

        public String getCor() {
            return cor;
        }

        @Override
        public String toString() {
            return "ArrayList.Lista1.Lista4.Gato: {" +
                    "nome='" + nome + '\'' +
                    ", idade=" + idade +
                    ", cor='" + cor + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Gato gato) {
            return this.getNome().compareToIgnoreCase(gato.getNome());
        }
    }

    class ComparatorIdade implements Comparator<Gato> {
        @Override
        public int compare(Gato g1, Gato g2) {
            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }

    class ComparatorCor implements Comparator<Gato> {

        @Override
        public int compare(Gato g1, Gato g2) {
            return g1.getCor().compareToIgnoreCase(g2.getCor());
        }
    }

    class ComparatorNomeCorIdade implements Comparator<Gato> {

        @Override
        public int compare(Gato g1, Gato g2) {
            int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
            if (nome != 0) return nome;

            int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
            if(cor !=0) return cor;

            return Integer.compare(g1.getIdade(), g2.getIdade());

        }
    }