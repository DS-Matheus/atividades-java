package Collections.List.Lista3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

 /*     Utilizando listas, faça um programa que faça 5 perguntas para uma
        pessoa sobre um crime. As perguntas são:

        1- "Telefonou para a vítima?"
        2- "Esteve no local do crime?"
        3- "Mora perto da vítima?"
        4- "Devia para a vítima?"
        5- "Já trabalhou com a vítima?"

        Se a pessoa responder positivamente a 2 questões ela deve ser
        classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como
        "Assassina". Caso contrário, ela será classificada como "Inocente".*/

        List<String> arrayRespostas = new ArrayList<>();

        System.out.println("Responda o questionário com 's' ou 'n':");
        System.out.println("\nTelefonou para a vítima?");
        arrayRespostas.add(getResp());

        System.out.println("Esteve no local do crime?");
        arrayRespostas.add(getResp());

        System.out.println("Mora perto da vítima?");
        arrayRespostas.add(getResp());

        System.out.println("Devia para a vítima?");
        arrayRespostas.add(getResp());

        System.out.println("Já trabalhou com a vítima?");
        arrayRespostas.add(getResp());

        int counter = 0;

        for (String resp: arrayRespostas) {
            if (resp.equalsIgnoreCase("s"))
                counter += 1;
        }

//        System.out.println(counter);

        System.out.print("\nResultado: ");

        switch (counter){
            case 0:
                System.out.print("inocente");
                break;
            case 1:
            case 2:
                System.out.print("suspeito");
                break;
            case 3:
            case 4:
                System.out.print("cúmplice");
                break;
            case 5:
                System.out.print("assassino");
                break;
        }

//        System.out.println("\n" + arrayRespostas);
    }

    public static String getResp(){
        Scanner input = new Scanner(System.in);

        String resp = input.next();

        while ( (!resp.equalsIgnoreCase("s")) & (!resp.equalsIgnoreCase("n")) ){
            System.out.println("Responda o questionário APENAS com 's' ou 'n'!");
            resp = input.next();
        }
        return resp;
    }
}
