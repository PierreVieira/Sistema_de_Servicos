package Sistema;

import Concretos.Administrador;
import Concretos.Cliente;
import Concretos.Profissional;
import Concretos.Servico;

import java.util.ArrayList;

public class DadosDoSistema {
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Profissional> profissionais = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    //Eu poderia usar herança e polimorfismo para diferentes tipos de serviços, mas estou com preguiça de fazer isso então vai assim mesmo com vários serviços diferentes...
    private ArrayList<Servico> servicos_inativos = new ArrayList<>();//Serviços que ainda não ativos por um administrador
    private ArrayList<Servico> servicos_confirmados_sem_prestador = new ArrayList<>();//Serviços que já foram confirmados, mas ainda não tem prestador
    private ArrayList<Servico> servicos_confirmados_com_prestador = new ArrayList<>();//Serviços que já foram confirmados, tem prestador, mas ainda não tem requisição de um cliente
    private ArrayList<Servico> servicos_pre_executados = new ArrayList<>();//Serviços que já tem cliente e prestador, mas que ainda não foram executados pelo prestador
    private ArrayList<Servico> servicos_executados = new ArrayList<>();//Serviços que já tem cliente, prestador e já foram executados pelo prestador
    private LogicaArquivos arq;
    public DadosDoSistema(){
        arq = new LogicaArquivos();
        inicializarDadosDoSistemaUsuarios();
        inicializarDadosDoSistemaServicosNaoConfirmados();
    }

    private void inicializarDadosDoSistemaServicosNaoConfirmados() {
        ArrayList<String[]> strings_servicos_inativos;

    }

    private void inicializarDadosDoSistemaUsuarios(){
        String nome, endereco, email, telefone, nome_usuario, senha, tipo;

        ArrayList<String[]> string_dados = arq.pegaDoArquivo("TextFiles/usuarios.txt");
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
    public void deslogarDiferentes(String nome, String senha){
        deslogarClientesDiferentes(nome, senha);
        deslogarPrestadores(nome, senha);
        deslogarAdministradores(nome, senha);
    }

    private void deslogarAdministradores(String nome, String senha) {
        for(int i = 0; i < this.administradores.size(); i++){
            if(!(this.administradores.get(i).getNome().equals(nome) && this.administradores.get(i).getSenha().equals(senha))){
                this.administradores.get(i).setLogado(false);
            }
        }
    }

    private void deslogarPrestadores(String nome, String senha) {
        for(int i = 0; i < this.profissionais.size(); i++){
            if(!(this.profissionais.get(i).getNome().equals(nome) && this.profissionais.get(i).getSenha().equals(senha))){
                this.profissionais.get(i).setLogado(false);
            }
        }
    }

    private void deslogarClientesDiferentes(String nome, String senha) {
        for(int i = 0; i < this.clientes.size(); i++){
            if(!(this.clientes.get(i).getNome().equals(nome) && this.clientes.get(i).getSenha().equals(senha))){
                this.clientes.get(i).setLogado(false);
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

    public ArrayList<Servico> getServicos_inativos() {
        return servicos_inativos;
    }

    public void setServicos_inativos(ArrayList<Servico> servicos_inativos) {
        this.servicos_inativos = servicos_inativos;
    }

    public ArrayList<Servico> getServicos_confirmados_sem_prestador() {
        return servicos_confirmados_sem_prestador;
    }

    public void setServicos_confirmados_sem_prestador(ArrayList<Servico> servicos_confirmados_sem_prestador) {
        this.servicos_confirmados_sem_prestador = servicos_confirmados_sem_prestador;
    }

    public ArrayList<Servico> getServicos_confirmados_com_prestador() {
        return servicos_confirmados_com_prestador;
    }

    public void setServicos_confirmados_com_prestador(ArrayList<Servico> servicos_confirmados_com_prestador) {
        this.servicos_confirmados_com_prestador = servicos_confirmados_com_prestador;
    }

    public ArrayList<Servico> getServicos_pre_executados() {
        return servicos_pre_executados;
    }

    public void setServicos_pre_executados(ArrayList<Servico> servicos_pre_executados) {
        this.servicos_pre_executados = servicos_pre_executados;
    }

    public ArrayList<Servico> getServicos_executados() {
        return servicos_executados;
    }

    public void setServicos_executados(ArrayList<Servico> servicos_executados) {
        this.servicos_executados = servicos_executados;
    }

}
