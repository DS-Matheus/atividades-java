package Exceptions.Checked;

import javax.swing.*;
import java.io.*;

public class ImprimirArquivo {
    public static void main(String[] args) {
        String nomeDoArquivo = "arquivo.txt";

        try {
            imprimirArquivo(nomeDoArquivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Revise o nome do arquivo que você deseja imprimir! " + e.getCause());
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado! Entre em contato com o suporte! " + e.getCause());
        } finally {
            System.out.println("Finally!");
        }

        System.out.println("Continuação do código");
    }

    public static void imprimirArquivo(String arquivoNome) throws IOException {

        File file = new File(arquivoNome);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //laço para ler e escrever arquivos com mais de uma linha
        do{
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        } while(line != null);

        bw.flush();
        br.close();

    }
}

