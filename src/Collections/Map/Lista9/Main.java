package Collections.Map.Lista9;

import java.util.*;

public class Main {
    public static void main(String[] args) {

/*          Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
            modelo = gol - consumo = 14,4km/l
            modelo = uno - consumo = 15,6 km/l
            modelo = mobi - consumo = 16,1 km/l
            modelo = hb20 - consumo = 14,5 km/l
            modelo = kwid - consumo = 15,6 km/l*/


        System.out.println("\n* Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> mapCarros = new HashMap<>(){{
            put("gol",14.4d);
            put("uno",15.6d);
            put("mobi",16.1d);
            put("hb20",14.5d);
            put("kwid",15.6d);
        }};
        System.out.println(mapCarros);


        System.out.println("\n* Substitua o consumo do gol por 15,2 km/l: ");
        mapCarros.put("gol",15.2d);
//        no map uma forma de se substituir um valor é adicionando esse valor desejado com a mesma chave
//        (pois não podem existir 2 "chaves" iguais)
        System.out.println(mapCarros);


        System.out.println("\n* Confira se o modelo tucson está no dicionário: ");
        System.out.println("Tucson está incluso? " + mapCarros.containsKey("tucson"));


        System.out.println("\n* Exiba o consumo do uno: ");
        System.out.println("Consumo: " + mapCarros.get("uno"));


//        System.out.println("\n* Exiba o terceiro modelo adicionado: ");
//        não é possivel, o map não trabalha com index

        
        System.out.println("\n* Exiba os modelos: ");
        for (String modelo: mapCarros.keySet()) {
            System.out.println(modelo);
        }


        System.out.println("\n* Exiba os consumos dos carros: ");
        for (Double consumo: mapCarros.values()) {
            System.out.println(consumo);
        }

        System.out.println("\n* Exiba o modelo mais econômico e seu consumo: ");
        Double melhorConsumo = Collections.max(mapCarros.values());
        Set<Map.Entry<String, Double>> entries = mapCarros.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry: entries) {
            if (entry.getValue().equals(melhorConsumo)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo: " + modeloMaisEficiente + " - Consumo: " + melhorConsumo);
            }
        }


        System.out.println("\n* Exiba o modelo menos econômico e seu consumo: " );
        Double menorConsumo = Collections.min(mapCarros.values());
        String modeloMenosEficiente = "";

        for (Map.Entry<String, Double> entry: entries) {
            if (entry.getValue().equals(menorConsumo)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo: " + modeloMenosEficiente + " - Consumo: " + menorConsumo);
            }
        }


        System.out.println("\n* Exiba a soma dos consumos: ");
        Double soma = 0d;
        for (Double consumo: mapCarros.values()) {
            soma += consumo;
        }
        System.out.println("Soma: " + soma);


        System.out.println("\n* Exiba a média dos consumos deste dicionário de carros: ");
        System.out.println("Média: " + soma/mapCarros.size());


        System.out.println("\n* Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator = mapCarros.values().iterator();
        while (iterator.hasNext()){
            if (iterator.next() == 15.6d){
                iterator.remove();
            }
        }
        System.out.println(mapCarros);


        System.out.println("\n* Exiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> mapCarros2 = new LinkedHashMap<>(){{
            put("gol",14.4d);
            put("uno",15.6d);
            put("mobi",16.1d);
            put("hb20",14.5d);
            put("kwid",15.6d);
        }};
        System.out.println(mapCarros2);

        System.out.println("\n* Exiba o dicionário ordenado pelo modelo: ");
        mapCarros = new TreeMap<>(mapCarros2);
        System.out.println(mapCarros);


        System.out.println("\n* Apague o dicionario de carros: ");
        mapCarros.clear();
        System.out.println(mapCarros);


        System.out.println("\n* Confira se o dicionário está vazio: ");
        System.out.println("Está vazio? " + mapCarros.isEmpty());

    }
}
