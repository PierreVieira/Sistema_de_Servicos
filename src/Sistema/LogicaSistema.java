package Sistema;

import java.util.Scanner;
import static Principal.Main.main;


public class LogicaSistema {
    private boolean administradorLogado;
    private LogicaArquivos arquivo;
    public LogicaSistema(){
        administradorLogado = false;
        arquivo = new LogicaArquivos("dados.txt");
    }

    public void tratarCadastro(int opcao){
        switch (opcao){
            case 1: //Cadastrar Administrador
                if(!administradorLogado){
                    System.out.println("Não há nenhum adminsitrador logado no sistema!");
                }
                else {
                    System.out.println("Cadastre um adm");
                }
                break;
            case 2://Cadastrar Profissional
                System.out.println("Cadastrar um profissional");
                break;
            case 3://Cadastrar um cliente
                System.out.println("Cadastrar um cliente");
            case 4:
                main(new String[]{"0"});
            case 5:
                System.out.println("Volte sempre");
                System.exit(0);
        }
    }

    public void tratarLogin(){
        Scanner teclado = new Scanner(System.in);
        String nome, senha;
        String saida_do_arquivo;
        System.out.print("Informe seu nome de usuário: ");
        nome = teclado.nextLine();
        System.out.print("Informe sua senha: ");
        senha = teclado.nextLine();

    }

}
