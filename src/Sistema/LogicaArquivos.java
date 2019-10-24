package Sistema;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

class LogicaArquivos {
    private String nome_arquivo;
    LogicaArquivos(String nome_arquivo){
        this.nome_arquivo = nome_arquivo;
    }

    ArrayList<String[]> pegaDoArquivo(){
        Scanner scanner = null;
        ArrayList<String[]> string_dados = new ArrayList<>();
        String leitura_do_arquivo;
        try {
            scanner = new Scanner(new FileReader(this.nome_arquivo));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        while (scanner.hasNext()) {
            leitura_do_arquivo = scanner.nextLine();
            string_dados.add(leitura_do_arquivo.split(";"));
        }
        return string_dados;
    }
}
