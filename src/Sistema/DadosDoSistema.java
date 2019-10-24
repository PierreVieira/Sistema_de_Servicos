package Sistema;

import Concretos.Administrador;
import Concretos.Cliente;
import Concretos.Profissional;

import java.util.ArrayList;

public class DadosDoSistema {
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Profissional> profissionais = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    public DadosDoSistema(){
        inicializarDadosDoSistema();
    }
    private void inicializarDadosDoSistema(){
        String[][] dados;
        LogicaArquivos arq = new LogicaArquivos("dados.txt");
        ArrayList<String[]> string_dados = arq.pegaDoArquivo();
        for (String[] s : string_dados){
            System.out.println(s[3]);
        }
    }
}
