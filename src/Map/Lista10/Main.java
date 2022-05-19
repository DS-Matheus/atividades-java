package Map.Lista10;

import java.util.*;

public class Main {
    public static void main(String[] args) {

/*        Dadas as seguintes informações sobre meus livros favoritos e seus autores,
        crie um dicionário e ordene este dicionário:
        exibindo (Nome Autor - Nome Map.Lista10.Lista10.Livro);
        Autor = Hawking, Stephen  - Map.Lista10.Lista10.Livro = nome: Uma Breve História do Tempo. páginas: 256
        Autor = Duhigg, Charles - Map.Lista10.Lista10.Livro = nome: O Poder do Hábito, paginas: 408
        Autor = Harari, Yuval Noah  - Map.Lista10.Lista10.Livro = 21 Lições Para o Século 21, páginas: 432*/

        System.out.println("\n--\tOrdem aleatória\t--");
        Map<String, Livro> mapLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};
        for (Map.Entry<String, Livro> livro : mapLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());


        System.out.println("\n--\tOrdem Inserção\t--");
        mapLivros = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};
        for (Map.Entry<String, Livro> livro : mapLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());


        System.out.println("\n--\tOrdem alfabética autores\t--");
        Map<String, Livro> mapLivros2 = new TreeMap<>(mapLivros);
        for (Map.Entry<String, Livro> livro : mapLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());


        System.out.println("\n--\tOrdem alfabética nomes dos livros\t--");
        Set<Map.Entry<String, Livro>> mapLivros3 = new TreeSet<>(new ComparatorTitulo());
        mapLivros3.addAll(mapLivros.entrySet());
        for (Map.Entry<String, Livro> livro : mapLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());


        System.out.println("\n--\tOrdem número de página\t--");
        mapLivros3 = new TreeSet<>(new ComparatorQtdPaginas());
        mapLivros3.addAll(mapLivros.entrySet());
        for (Map.Entry<String, Livro> livro: mapLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo() + " - " + livro.getValue().getQtdPaginas());

    }
}

class Livro {

    private String titulo;
    private int qtdPaginas;

    public Livro(String titulo, int qtdPaginas) {
        this.titulo = titulo;
        this.qtdPaginas = qtdPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return qtdPaginas == livro.qtdPaginas && titulo.equals(livro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, qtdPaginas);
    }

    @Override
    public String toString() {
        return "Map.Lista10.Lista10.Livro{" +
                "titulo='" + titulo + '\'' +
                ", qtdPaginas=" + qtdPaginas +
                '}';
    }
}

class ComparatorTitulo implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getTitulo().compareToIgnoreCase(o2.getValue().getTitulo());
    }
}

class ComparatorQtdPaginas implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return Integer.compare(o1.getValue().getQtdPaginas(),o2.getValue().getQtdPaginas());
    }
}