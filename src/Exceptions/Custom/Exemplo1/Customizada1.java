package Exceptions.Custom.Exemplo1;

import javax.swing.*;
import java.io.*;

public class Customizada1 {
    public static void main(String[] args) {

        String nomeArquivo = JOptionPane.showInputDialog("Nome do arquivo a ser exibido: ");

        imprimirArquivo(nomeArquivo);
        System.out.println("\nContinuação do código");

    }

    public static void imprimirArquivo(String nomeArquivo) {

        try {
            BufferedReader br = lerArquivo(nomeArquivo);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//          laço para ler e escrever arquivos com mais de uma linha
            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            } while (line != null);

            bw.flush();
            br.close();
//            começar com o catch mais especifico e continuar com os mais genericos
        } catch (ImpossivelAbrirArquivoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //e.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro não esperado, por favor, fale com o suporte." + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static BufferedReader lerArquivo(String nomeArquivo) throws ImpossivelAbrirArquivoException {

        File file = new File(nomeArquivo);
        try {
            return new BufferedReader(new FileReader(nomeArquivo));
        } catch (FileNotFoundException e) {
            throw new ImpossivelAbrirArquivoException(file.getName(), file.getPath());
        }
    }
}

class ImpossivelAbrirArquivoException extends Exception {

    private String nomeDoArquivo, diretorio;
    public ImpossivelAbrirArquivoException(String nomeArquivo, String diretorio) {
        super("O arquivo " + nomeArquivo + " não foi encontrado no diretório " + diretorio);
        this.nomeDoArquivo = nomeArquivo;
        this.diretorio = diretorio;
    }

}