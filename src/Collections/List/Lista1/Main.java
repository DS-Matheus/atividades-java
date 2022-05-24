package Collections.List.Lista1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

/*      Faça um programa que receba a temperatura média dos 6
        primeiros meses do ano e armazene-as em uma lista.

        Após isto, calcule a média semestral das temperaturas e
        mostre todas as temperaturas acima desta média, e em que
        mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2– Fevereiro e etc).*/

        Scanner input = new Scanner(System.in);
        ArrayList<Double> arrayTemp = new ArrayList<>();

        for (int i=1; i<=6; i++){
            System.out.println("Digite a temperatura do mês " + i + ": ");
            arrayTemp.add(input.nextDouble());
        }

        System.out.println("\n" + arrayTemp);

        double soma = 0d;

        for (double temp : arrayTemp){
            soma += temp;
        }

        double media = soma/6;

        System.out.println("\nMédia: " + String.format("%.1f",media) + "\n");
        System.out.println("Temperaturas acima da média:" + "\n");

        Iterator<Double> iteratorExibirMedia = arrayTemp.iterator();
        int countMes = 1;
        String mes = "";

        while (countMes<=6){

            switch (countMes){
                case 1: mes = "Janeiro";
                    break;
                case 2: mes = "Fevereiro";
                    break;
                case 3: mes = "Março";
                    break;
                case 4: mes = "Abril";
                    break;
                case 5: mes = "Maio";
                    break;
                case 6: mes = "Junho";
                    break;
            }

            double temp = iteratorExibirMedia.next();

            if (temp > media)
                System.out.println(mes + ": " + temp + "ºC");

            ++countMes;
        }

    }
}
