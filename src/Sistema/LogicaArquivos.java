package Sistema;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class LogicaArquivos {
    private String nome_arquivo;
    LogicaArquivos(String nome_arquivo){
        this.nome_arquivo = nome_arquivo;
    }
    boolean temNoArquivo(String nome, String senha){
        Scanner scanner = null;
        String leitura_do_arquivo;
        String[] vetor_leitura = new String[7];
        try {
            scanner = new Scanner(new FileReader(this.nome_arquivo));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        assert scanner != null;
        while (scanner.hasNext()) {
            leitura_do_arquivo = scanner.nextLine();
            System.out.println(leitura_do_arquivo);
            vetor_leitura = leitura_do_arquivo.split(";");
            System.out.println(vetor_leitura[5]);
            if (vetor_leitura[5].equals(nome) && vetor_leitura[6].equals(senha)) {
                return true;
            }
        }
        return false;
    }
    String pegaDoArquivo(String nome, String senha){
        return "oi";
    }
}
