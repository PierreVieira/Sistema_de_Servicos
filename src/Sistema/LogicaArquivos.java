package Sistema;

import Concretos.Administrador;
import Concretos.Cliente;
import Concretos.Profissional;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class LogicaArquivos {
    private String caminho;
    LogicaArquivos(){
    }

    ArrayList<String[]> pegaDoArquivo(String caminho){
        Scanner scanner = null;
        this.caminho = caminho;
        ArrayList<String[]> string_dados = new ArrayList<>();
        String leitura_do_arquivo;
        try {
            scanner = new Scanner(new FileReader(this.caminho));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        while (scanner.hasNext()) {
            leitura_do_arquivo = scanner.nextLine();
            string_dados.add(leitura_do_arquivo.split(";"));
        }
        scanner.close();
        return string_dados;
    }

    void escreveNoArquivo(ArrayList<Administrador> administradores, ArrayList<Profissional> profissionais, ArrayList<Cliente> clientes){
        String mensagem = null;
        try {
            FileWriter escritor = new FileWriter(this.caminho);
            BufferedWriter bw = new BufferedWriter(escritor);
            bw.flush();
            for(Administrador administrador: administradores){
                bw.write(administrador.toString()+"ADM;");
                bw.newLine();
            }
            for(Profissional profissional: profissionais){
                bw.write(profissional.toString()+"PROF;");
                bw.newLine();
            }
            for(int i = 0; i < clientes.size(); ++i){
                if(i != clientes.size()-1) {
                    bw.write(clientes.get(i).toString() + "CLI;");
                    bw.newLine();
                }
                else{
                    bw.write(clientes.get(i).toString() + "CLI;");
                }
            }
            bw.close();
            mensagem = "Volte sempre!\n---------------------------------";
        } catch (IOException e) {
            mensagem = "Erro de escrita no arquivo" + this.caminho;
        }finally {
            System.out.println(mensagem);
        }
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
