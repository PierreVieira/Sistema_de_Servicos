package Sistema;

import Concretos.Administrador;
import Concretos.Cliente;
import Concretos.Profissional;

import java.util.ArrayList;

public class DadosDoSistema {
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Profissional> profissionais = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private LogicaArquivos arq;
    public DadosDoSistema(){
        arq = new LogicaArquivos("usuarios.txt");
        inicializarDadosDoSistema();
    }
    private void inicializarDadosDoSistema(){
        String nome, endereco, email, telefone, nome_usuario, senha, tipo;

        ArrayList<String[]> string_dados = arq.pegaDoArquivo();
        for (String[] s : string_dados){
            nome = s[0];
            endereco = s[1];
            email = s[2];
            telefone = s[3];
            nome_usuario = s[4];
            senha = s[5];
            tipo = s[6];
            if(tipo.equals("ADM")){
                administradores.add(new Administrador(nome, endereco, email, telefone, nome_usuario, senha));
            }
            else if(tipo.equals("PROF")){
                profissionais.add(new Profissional(nome, endereco, email, telefone, nome_usuario, senha));
            }
            else{
                clientes.add(new Cliente(nome, endereco, email, telefone, nome_usuario, senha));
            }
        }
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public ArrayList<Profissional> getProfissionais() {
        return profissionais;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

}
