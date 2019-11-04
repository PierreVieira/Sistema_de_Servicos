package Menu;

import java.util.Scanner;

public abstract class ExibeMenu {
    public static int exibeMenuGeral(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ PRINCIPAL =========");
        System.out.println("[1] Login");
        System.out.println("[2] Cadastro");
        System.out.println("[3] Sair");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 3 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 3 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    static int exibeMenuCadastro(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ CADASTRO =========");
        System.out.println("[1] Cadastrar administrador");
        System.out.println("[2] Cadastrar profissional");
        System.out.println("[3] Cadastrar cliente");
        System.out.println("[4] Voltar");
        System.out.println("[5] Sair");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 5 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 5 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    static int exibeMenuAdministrador(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ ADMINISTRADOR =========");
        System.out.println("[1] Cadastrar administrador");
        System.out.println("[2] Cadastrar serviço");
        System.out.println("[3] Validar serviço");
        System.out.println("[4] Listar pedidos");
        System.out.println("[5] Voltar");
        System.out.println("[6] Sair");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 6 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 6 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    static int exibeMenuCliente(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ CLIENTE =========");
        System.out.println("[1] Cadastrar serviço");
        System.out.println("[2] Cadastrar pedido");
        System.out.println("[3] Meus pedidos");
        System.out.println("[4] Voltar");
        System.out.println("[5] Sair");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 5 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 5 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    static int exibeMenuPrestador(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ PRESTADOR =========");
        System.out.println("[1] Cadastrar serviço");
        System.out.println("[2] Selecionar serviços");
        System.out.println("[3] Executar pedido");
        System.out.println("[4] Pesquisar pedidos");
        System.out.println("[5] Sair");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 5 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 5 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }
}
