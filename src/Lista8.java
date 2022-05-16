import java.util.*;

public class Lista8 {
    public static void main(String[] args) {

        /*
        Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
        Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
        a) Ordem de inserção;
        b) Ordem natural(nome);
        c) IDE;
        d) Ano de criação e nome;
        e) Nome, ano de criação e IDE;
        Ao final, exiba as linguagens no console, um abaixo da outra.
        */

        Set<LinguagemFavorita> setLinguagens = new LinkedHashSet<>();
        setLinguagens.add(new LinguagemFavorita("python",1989,"pycharm"));
        setLinguagens.add(new LinguagemFavorita("sql",1974,"adminer"));
        setLinguagens.add(new LinguagemFavorita("java",1995,"intellij"));


        System.out.println("--\tOrdem de inserção\t--");
        for (LinguagemFavorita linguagem: setLinguagens) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getAnoCriacao() + " - " + linguagem.getIde());
        }


        System.out.println("\n--\tOrdem natural (nome)\t--");
        Set<LinguagemFavorita> setLinguagens2 = new TreeSet<>(setLinguagens);

        for (LinguagemFavorita linguagem: setLinguagens2) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getAnoCriacao() + " - " + linguagem.getIde());
        }


        System.out.println("\n--\tIDE\t--");
        setLinguagens2 = new TreeSet<>(new ComparatorIde());
        setLinguagens2.addAll(setLinguagens);
        for (LinguagemFavorita linguagem: setLinguagens2) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getAnoCriacao() + " - " + linguagem.getIde());
        }


        System.out.println("\n--\tAno de criação e nome\t--");
        setLinguagens2 = new TreeSet<>(new ComparatorAnoNome());
        setLinguagens2.addAll(setLinguagens);
        for (LinguagemFavorita linguagem: setLinguagens2) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getAnoCriacao() + " - " + linguagem.getIde());
        }


        System.out.println("\n--\tNome, ano de criação e IDE\t--");
        setLinguagens2 = new TreeSet<>(setLinguagens);
        for (LinguagemFavorita linguagem: setLinguagens2) {
            System.out.println(linguagem.getNome() + " - " + linguagem.getAnoCriacao() + " - " + linguagem.getIde());
        }

    }
}

    class LinguagemFavorita implements Comparable<LinguagemFavorita> {
        private String nome;
        private Integer anoCriacao;
        private String ide;

        public LinguagemFavorita(String nome, Integer anoCriacao, String ide) {
            this.nome = nome;
            this.anoCriacao = anoCriacao;
            this.ide = ide;
        }

        public String getNome() {
            return nome;
        }

        public Integer getAnoCriacao() {
            return anoCriacao;
        }

        public String getIde() {
            return ide;
        }

        @Override
        public String toString() {
            return "Linguagem: {" +
                    "nome='" + nome + '\'' +
                    ", anoCriacao=" + anoCriacao +
                    ", ide='" + ide + '\'' +
                    '}';
        }

        @Override
        public int compareTo(LinguagemFavorita linguagem) {
            int nome = this.getNome().compareToIgnoreCase(linguagem.getNome());
            if (nome != 0) return nome;

            int ano = Integer.compare(this.getAnoCriacao(), linguagem.getAnoCriacao());
            if (ano != 0) return ano;

            return this.getIde().compareToIgnoreCase(linguagem.getIde());
        }
    }

    class ComparatorIde implements Comparator<LinguagemFavorita>{
        @Override
        public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
            int ide = o1.getIde().compareToIgnoreCase(o2.getIde());
            if (ide != 0) return ide;

            int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
            if (nome != 0) return nome;

            return Integer.compare(o1.getAnoCriacao(), o2.getAnoCriacao());
        }
    }

    class ComparatorAnoNome implements Comparator<LinguagemFavorita>{
        @Override
        public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
            int ano = Integer.compare(o1.getAnoCriacao(), o2.getAnoCriacao());
            if (ano != 0) return ano;

            int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
            if (nome != 0) return nome;

            return o1.getIde().compareToIgnoreCase(o2.getIde());
        }
    }