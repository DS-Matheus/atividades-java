import java.util.*;

public class Lista11 {
    public static void main(String[] args) {

        /*
        Dada a população estimada de alguns estados do nordeste brasileiro, faça:
        Estado = PE - população = 9.616.621
        Estado = AL - população = 3.351.543
        Estado = CE - população  = 9.187.103
        Estado = RN - população = 3.534.265
        */

        System.out.println("\n* Crie um dicionário que relacione os estados e suas respectivas populações: ");
        HashMap<String, Integer> mapEstados = new HashMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }};
        for (Map.Entry<String, Integer> estado: mapEstados.entrySet()) {
            System.out.println("UF: " + estado.getKey() + " - População: " + estado.getValue());
        }


        System.out.println("\n* Substitua a população do estado RN por : 3.534.165");
        mapEstados.put("RN",3534165);
        for (Map.Entry<String, Integer> estado: mapEstados.entrySet()) {
            System.out.println("UF: " + estado.getKey() + " - População: " + estado.getValue());
        }


        System.out.println("\n* Confira se o estado da Paraíba (PB) está no dicionário, caso não, adicione " +
                "PB - 4.039.277: ");
        if (!mapEstados.containsKey("PB")){
            mapEstados.put("PB",4039277);
            for (Map.Entry<String, Integer> estado: mapEstados.entrySet()) {
                System.out.println("UF: " + estado.getKey() + " - População: " + estado.getValue());
            }
        }
        else
            System.out.println("Já está no dicionário!");


        System.out.println("\n* Exiba a população do estado PE: ");
        System.out.println("UF: PE - População: " + mapEstados.get("PE"));


        System.out.println("\n* Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String, Integer> mapEstados2 = new LinkedHashMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
            put("PB",4039277);
        }};
        for (Map.Entry<String, Integer> estado: mapEstados2.entrySet()) {
            System.out.println("UF: " + estado.getKey() + " - População: " + estado.getValue());
        }


        System.out.println("\n* Exiba todos os estados e suas populações na ordem alfabética: ");
        Map<String, Integer> mapEstados3 = new TreeMap<>(mapEstados2);
        for (Map.Entry<String, Integer> estado: mapEstados3.entrySet()) {
            System.out.println("UF: " + estado.getKey() + " - População: " + estado.getValue());
        }


        System.out.println("\n* Exiba o estado com a menor população e seu respectivo valor");
        Collection<Integer> populacao = mapEstados3.values();
        Integer populacaoMin = Collections.min(populacao);
        String estadoMenorPopulacao = "";

        for (Map.Entry<String, Integer> entry : mapEstados3.entrySet()) {
            if (entry.getValue().equals(populacaoMin)) estadoMenorPopulacao = entry.getKey();
        }
        System.out.println("UF: " + estadoMenorPopulacao + " - População: " + populacaoMin);


        System.out.println("\n* Exiba o estado com a maior população e seu respectivo valor");
        Integer populacaoMax = Collections.max(populacao);
        String estadoMaiorPopulacao = "";

        for (Map.Entry<String, Integer> entry: mapEstados3.entrySet()) {
            if (entry.getValue().equals(populacaoMax)) estadoMaiorPopulacao = entry.getKey();
        }
        System.out.println("UF: " + estadoMaiorPopulacao + " - População: " + populacaoMax);


        System.out.println("\n* Exiba a soma da população dos estados: ");
        Integer soma = 0;
        for (Map.Entry<String, Integer> entry: mapEstados3.entrySet()) {
            soma += entry.getValue();
        }
        System.out.println("Soma: " + soma);


        System.out.println("\n* Exiba a média da população deste dicionário de estados: ");
        System.out.println("Média: " + soma/mapEstados3.size());


        System.out.println("\n* Remova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator = populacao.iterator();
        while (iterator.hasNext()){
            if (iterator.next() < 4000000){
                iterator.remove();
            }
        }
        for (Map.Entry<String, Integer> estado: mapEstados3.entrySet()) {
            System.out.println("UF: " + estado.getKey() + " - População: " + estado.getValue());
        }


        System.out.println("\n* Apague o dicionario de estados com suas respectivas populações estimadas: ");
        mapEstados3.clear();
        System.out.println(mapEstados3);


        System.out.println("\n* Confira se a lista está vazia: ");
        System.out.println("Está vazio? " + mapEstados3.isEmpty());

    }
}

class Estado{

    private String uf;
    private int populacao;

    public Estado(String uf, int populacao) {
        this.uf = uf;
        this.populacao = populacao;
    }

    public String getUf() {
        return uf;
    }

    public int getPopulacao() {
        return populacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return populacao == estado.populacao && uf.equals(estado.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uf, populacao);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "uf='" + uf + '\'' +
                ", populacao=" + populacao +
                '}';
    }
}