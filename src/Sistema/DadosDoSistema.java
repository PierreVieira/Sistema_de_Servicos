package Sistema;

import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Profissional;
import Servicos.*;

import java.util.ArrayList;

public class DadosDoSistema {
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Profissional> profissionais = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<ServicoInativo> servicos_inativos = new ArrayList<>();//Serviços que ainda não ativos por um administrador e já tem usuário pedindo.
    private ArrayList<ServicoValido> servicos_validos = new ArrayList<>();//Serviços que já foram confirmados, mas ainda não tem prestador
    private ArrayList<ServicoValidoComPrestador> servicos_confirmados_com_prestador = new ArrayList<>();//Serviços que já foram confirmados, tem prestador, mas ainda não tem requisição de um cliente
    private ArrayList<ServicoPreExecutado> servicos_pre_executados = new ArrayList<>();//Serviços que já tem cliente e prestador, mas que ainda não foram executados pelo prestador
    private ArrayList<ServicoExecutado> servicos_executados = new ArrayList<>();//Serviços que já tem cliente, prestador e já foram executados pelo prestador
    private LogicaArquivos arq;

    public DadosDoSistema(){
        arq = new LogicaArquivos();
        inicializarDadosDoSistemaUsuarios();
        inicializarDadosDoSistemaServicosInativosEValidos();
        inicializarDadosDoSistemaServicosComPrestador();
    }

    private void inicializarDadosDoSistemaServicosComPrestador() {
        //Vai inicializar o array de serviços com prestadores
        String tipo_servico, nick_profissional;
        double preco;
        ArrayList<String[]> strings_servicos_com_profissionais = arq.pegaDoArquivo("TextFiles/servicos_confirmados_com_prestador.txt");
        for(String[] s: strings_servicos_com_profissionais){
            tipo_servico = s[0];
            nick_profissional = s[1];
            preco = Double.parseDouble(s[2]);
            this.servicos_confirmados_com_prestador.add(new ServicoValidoComPrestador(tipo_servico, nick_profissional, preco));
        }
    }

    private void inicializarDadosDoSistemaServicosInativosEValidos() {
        //Vai inicializar os arrays inativos e validos
        String nome_servico;
        ArrayList<String[]> strings_servicos_inativos = arq.pegaDoArquivo("TextFiles/servicos_inativos.txt");
        ArrayList<String[]> strings_servicos_ativos = arq.pegaDoArquivo("TextFiles/servicos_validos.txt");
        for(String[] s: strings_servicos_inativos){
            nome_servico = s[0];
            this.servicos_inativos.add(new ServicoInativo(nome_servico));
        }
        for (String[] s: strings_servicos_ativos){
            nome_servico = s[0];
            this.servicos_validos.add(new ServicoValido(nome_servico));
        }
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
    void deslogarDiferentes(String nome, String senha){
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

    public ArrayList<ServicoInativo> getServicos_inativos() {
        return servicos_inativos;
    }

    public void setServicos_inativos(ArrayList<ServicoInativo> servicos_inativos) {
        this.servicos_inativos = servicos_inativos;
    }

    public ArrayList<ServicoValido> getServicos_validos() {
        return servicos_validos;
    }

    public void setServicos_validos(ArrayList<ServicoValido> servicos_validos) {
        this.servicos_validos = servicos_validos;
    }

    public ArrayList<ServicoValidoComPrestador> getServicos_confirmados_com_prestador() {
        return servicos_confirmados_com_prestador;
    }

    public void setServicos_confirmados_com_prestador(ArrayList<ServicoValidoComPrestador> servicos_confirmados_com_prestador) {
        this.servicos_confirmados_com_prestador = servicos_confirmados_com_prestador;
    }

    public ArrayList<ServicoPreExecutado> getServicos_pre_executados() {
        return servicos_pre_executados;
    }

    public void setServicos_pre_executados(ArrayList<ServicoPreExecutado> servicos_pre_executados) {
        this.servicos_pre_executados = servicos_pre_executados;
    }

    public ArrayList<ServicoExecutado> getServicos_executados() {
        return servicos_executados;
    }

    public void setServicos_executados(ArrayList<ServicoExecutado> servicos_executados) {
        this.servicos_executados = servicos_executados;
    }
}
