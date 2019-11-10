package Sistema;
import Servicos.ServicoPreExecutado;
import Servicos.ServicoValido;
import Servicos.ServicoValidoComPrestador;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Profissional;
import Usuarios.Usuario;

import java.util.Scanner;

import static Menu.ExibeMenu.*;
import static Menu.TrataMenu.*;
import static Principal.Main.main;


public class LogicaSistema {
    private DadosDoSistema dados;
    public LogicaSistema(DadosDoSistema dados){
        this.dados = dados;
    }
    
    public void tratarCadastro(int opcao){
        switch (opcao){
            case 1: //Cadastrar Administrador
                cadastrar("ADM");
                break;
            case 2://Cadastrar Profissional
                cadastrar("PROF");
                break;
            case 3://Cadastrar um cliente
                cadastrar("CLI");
            case 4:
                main(new String[]{"0"});
            case 5:
                systemLeave();
                System.exit(0);
        }
    }

    private void cadastrar(String tipo) {
        Scanner teclado = new Scanner(System.in);
        String nome, endereco, email, telefone, nome_usuario, senha;
        //nome completo,endereço, e-mail, telefone, nome de usuário e senha para efetuar seu cadastro.
        System.out.print("Informe o nome: ");
        nome = teclado.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = teclado.nextLine();
        System.out.print("Informe o e-mail: ");
        email = teclado.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = teclado.nextLine();
        do{
            System.out.print("Informe o nome de usuario: ");
            nome_usuario = teclado.nextLine();
        }while(jaTemUsuarioComNome(nome_usuario));
        System.out.print("Informe a senha: ");
        senha = teclado.nextLine();
        if(tipo.equals("ADM")){
            this.dados.getAdministradores().add(new Administrador(nome, endereco, email, telefone, nome_usuario, senha));
        }
        else if(tipo.equals("PROF")){
            this.dados.getProfissionais().add(new Profissional(nome, endereco, email, telefone, nome_usuario, senha));
        }
        else{
            this.dados.getClientes().add(new Cliente(nome, endereco, email, telefone, nome_usuario, senha));
        }
    }

    private boolean jaTemUsuarioComNome(String nome_usuario) {
        for(Cliente cliente: this.dados.getClientes()){
            if(cliente.getNome().equals(nome_usuario)){
                return true;
            }
        }
        for(Profissional profissional: this.dados.getProfissionais()){
            if(profissional.getNome().equals(nome_usuario)){
                return true;
            }
        }
        for(Administrador administrador: this.dados.getAdministradores()){
            if(administrador.getNome().equals(nome_usuario)){
                return true;
            }
        }
        return false;
    }

    public void tratarLogin(){
        Scanner teclado = new Scanner(System.in);
        String nome, senha;
        System.out.print("Informe seu nome de usuário: ");
        nome = teclado.nextLine();
        System.out.print("Informe sua senha: ");
        senha = teclado.nextLine();
        //Proucurando por clientes
        if(!temCliente(nome, senha) && !temProfissional(nome, senha) && !temAdministrador(nome, senha)){
            System.out.println("Não foi encontrado nenhum perfil com o nome e senha informados");
        }
        else{
            while(true){
                tratarLoginContinuacao(nome, senha);
            }
        }
    }

    private void tratarLoginContinuacao(String nome, String senha) {
        int opcao;
        dados.deslogarDiferentes(nome, senha);
        if(temCliente(nome, senha)){
            opcao = exibeMenuCliente();
            tatarMenuCliente(opcao);
        }
        else if(temAdministrador(nome, senha)){
            opcao = exibeMenuAdministrador();
            tratarMenuAdministrador(opcao);
        }
        else if(temProfissional(nome, senha)){
            opcao = exibeMenuPrestador();
            tratarMenuProfissional(opcao);

        }

    }

    private boolean temAdministrador(String nome, String senha) {
        for(int i = 0; i < dados.getAdministradores().size(); ++i){
            if(dados.getAdministradores().get(i).equals(nome, senha)){
                dados.getAdministradores().get(i).setLogado(true);
                return true;
            }
        }
        return false;
    }

    private boolean temProfissional(String nome, String senha) {
        for(int i = 0; i < dados.getProfissionais().size(); ++i){
            if(dados.getProfissionais().get(i).equals(nome, senha)){
                dados.getProfissionais().get(i).setLogado(true);
                return true;
            }
        }
        return false;
    }

    private boolean temCliente(String nome, String senha) {
        for(int i = 0; i < dados.getClientes().size(); ++i){
            if(dados.getClientes().get(i).equals(nome, senha)){
                dados.getClientes().get(i).setLogado(true);
                return true;
            }
        }
        return false;
    }

    public Usuario pegaUsuarioLogado(){
        for(Cliente cliente: dados.getClientes()){
            if(cliente.isLogado()){
                return cliente;//Retorna o cliente logado
            }
        }
        for(Profissional profissional: dados.getProfissionais()){
            if(profissional.isLogado()){
                return profissional;//Retorna o profissional logado
            }
        }
        for(Administrador administrador: dados.getAdministradores()){
            if(administrador.isLogado()){
                return administrador;//Retorna o administrador logado
            }
        }
        return null;//Não tem ninguem logado na plataforma (bugou)
    }


    public DadosDoSistema getDados() {
        return dados;
    }

    public void systemLeave(){
        LogicaArquivos arq = new LogicaArquivos();
        arq.setCaminho("TextFiles/servicos_inativos.txt");
        arq.escreveNoArquivoServicosInativos(dados.getServicos_inativos());
        arq.setCaminho("TextFiles/servicos_validos.txt");
        arq.escreveNoArquivoValidos(dados.getServicos_validos());
        arq.setCaminho("TextFiles/servicos_confirmados_com_prestador.txt");
        arq.escreveNoArquivoValidosComPrestador(dados.getServicos_confirmados_com_prestador());
        arq.setCaminho("TextFiles/servicos_pre_executados.txt");
        arq.escreveNoArquivoPreExecutados(dados.getServicos_pre_executados());
        arq.setCaminho("TextFiles/usuarios.txt");
        arq.escreveNoArquivoUsuarios(dados.getAdministradores(), dados.getProfissionais(), dados.getClientes());
        System.exit(0);
    }
}
