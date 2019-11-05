package Sistema;
import Concretos.Administrador;
import Concretos.Cliente;
import Concretos.Profissional;
import java.util.Scanner;
import static Principal.Main.main;


public class LogicaSistema {
    private boolean administradorLogado;
    private DadosDoSistema dados;
    public LogicaSistema(DadosDoSistema dados){
        administradorLogado = false;
        this.dados = dados;
    }

    public void tratarCadastro(int opcao){
        switch (opcao){
            case 1: //Cadastrar Administrador
                if(!administradorLogado){
                    System.out.println("Não há nenhum adminsitrador logado no sistema!");
                }
                else {
                    cadastrar("ADM");
                }
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
        System.out.print("Informe o nome de usuario: ");
        nome_usuario = teclado.nextLine();
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
            tratarLoginContinuacao(nome, senha);
        }
    }

    private void tratarLoginContinuacao(String nome, String senha) {
        if(temCliente(nome, senha)){
            //oi
        }
        else if(temAdministrador(nome, senha)){
            //ola
        }
        else if(temProfissional(nome, senha)){
            //kkkk
        }
    }

    private boolean temAdministrador(String nome, String senha) {
        for(int i = 0; i < dados.getAdministradores().size(); ++i){
            if(dados.getAdministradores().get(i).equals(nome, senha)){
                dados.getAdministradores().get(i).setLogado(true);
                this.administradorLogado = true;
                return true;
            }
        }
        return false;
    }

    private boolean temProfissional(String nome, String senha) {
        for(int i = 0; i < dados.getProfissionais().size(); ++i){
            if(dados.getProfissionais().get(i).equals(nome, senha)){
                dados.getProfissionais().get(i).setLogado(true);
                this.administradorLogado = false;
                return true;
            }
        }
        return false;
    }

    private boolean temCliente(String nome, String senha) {
        for(int i = 0; i < dados.getClientes().size(); ++i){
            if(dados.getClientes().get(i).equals(nome, senha)){
                dados.getClientes().get(i).setLogado(true);
                this.administradorLogado = false;
                return true;
            }
        }
        return false;
    }

    public void systemLeave(){
        LogicaArquivos arq = new LogicaArquivos("usuarios.txt");
        arq.escreveNoArquivo(dados.getAdministradores(), dados.getProfissionais(), dados.getClientes());
        System.exit(0);
    }
}
