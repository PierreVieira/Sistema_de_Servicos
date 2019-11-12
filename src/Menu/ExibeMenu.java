//Antônio Pierre Maritns Vieira
//Eduardo Vinícius Silva de Lima
//Thiago Danilo Souza Pereira
package Menu;

import Servicos.ServicoPreExecutado;
import Servicos.ServicoValido;
import Servicos.ServicoValidoComPrestador;
import java.util.ArrayList;
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
        System.out.println("[1] Cadastrar profissional");
        System.out.println("[2] Cadastrar cliente");
        System.out.println("[3] Voltar");
        System.out.println("[4] Sair");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt() + 1;
            System.out.println("---------------------------------");
            if(opcao > 5 || opcao < 2){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 5 || opcao < 2);//Se a opção escolhida não for válida
        return opcao;
    }

    public static int exibeMenuAdministrador(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ ADMINISTRADOR =========");
        System.out.println("[1] Cadastrar administrador");
        System.out.println("[2] Cadastrar serviço");
        System.out.println("[3] Validar serviço");
        System.out.println("[4] Listar pedidos");
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

    public static int exibeMenuCliente(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ CLIENTE =========");
        System.out.println("[1] Cadastrar serviço");
        System.out.println("[2] Cadastrar pedido");
        System.out.println("[3] Meus pedidos");
        System.out.println("[4] Sair");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 4 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 4 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    public static int exibeMenuPrestador(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ PRESTADOR =========");
        System.out.println("[1] Cadastrar serviço");
        System.out.println("[2] Dar preço em um serviço");
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

    static int exibeMenuServicos(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ SERVIÇOS =========");
        System.out.println("[1] Manutenção preventiva");
        System.out.println("[2] Formatação");
        System.out.println("[3] Backup");
        System.out.println("[4] Recuperação de arquivos");
        System.out.println("[5] Instalação de programas");
        System.out.println("[6] Troca de peças de desktops");
        System.out.println("[7] Troca de peças de notebooks");
        System.out.println("[8] Troca de peças de celulares");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 8 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 8 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    static int exibeMenuValidacao(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= MENÚ VALIDAÇÃO =========");
        System.out.println("[1] Validar um serviço inativo");
        System.out.println("[2] Renomear um serviço inativo");
        System.out.println("[3] Remover um serviço inativo");
        System.out.println("[4] Sair");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 4 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 4 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    public static int exibeMenuNovoNome(){
        int opcao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("========= NOVO NOME =========");
        System.out.println("[1] Manutenção preventiva");
        System.out.println("[2] Formatação");
        System.out.println("[3] Backup");
        System.out.println("[4] Recuperação de arquivos");
        System.out.println("[5] Instalação de programas");
        System.out.println("[6] Troca de peças de desktops");
        System.out.println("[7] Troca de peças de notebooks");
        System.out.println("[8] Troca de peças de celulares");
        System.out.println("=================================");
        do {
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > 8 || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > 8 || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    public static int exibeMenuServicosAtivos(ArrayList<ServicoValido> validos){
        Scanner teclado = new Scanner(System.in);
        int t_validos, opcao, cont = 1;
        t_validos = validos.size();
        System.out.println("====== SERVIÇOS VÁLIDOS ======");
        for(ServicoValido valido: validos){
            System.out.printf("[%d] %s\n", cont, valido.getTipoServico());
            cont++;
        }
        System.out.println("==============================");
        do{
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            System.out.println("---------------------------------");
            if(opcao > t_validos || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > t_validos || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    public static int exibeMenuServicosComPrestador(ArrayList<ServicoValidoComPrestador> servico){
        Scanner teclado = new Scanner(System.in);
        int t_servico, opcao, cont = 1;
        t_servico = servico.size();
        System.out.println("====== SERVIÇOS DISPONÍVEIS ======");
        for(ServicoValidoComPrestador valido: servico){
            System.out.printf("[%d] %s\n", cont, valido.getTipoServico());
            System.out.println("R$ "+valido.getPreco());
            System.out.println("---------------------------------");
            cont++;
        }
        System.out.println("==============================");
        do{
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            if(opcao > t_servico || opcao < 1){
                System.out.println("Opção inválida, por favor escolha uma opção válida");
            }
        }while(opcao > t_servico || opcao < 1);//Se a opção escolhida não for válida
        return opcao;
    }

    public static ServicoPreExecutado exibeMenuPreExecutados(ArrayList<ServicoPreExecutado> pre_executados, String nick_profissional){
        /*O que deve-se fazer: percorrer o arraylist dos pre_executados jogando em um novo arraylist só de executados os
        * que o profissional tem nome
        */
        ArrayList<ServicoPreExecutado> pre_executados_pelo_profissional = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int t_servico, opcao, cont = 1;
        for(ServicoPreExecutado valido: pre_executados){
            if(valido.getNome_usuario_profissional().equals(nick_profissional)){
                pre_executados_pelo_profissional.add(valido);
            }
        }
        t_servico = pre_executados_pelo_profissional.size();
        if(t_servico == 0){
            System.out.println("Não há serviços disponíveis para você");
            return null;
        }
        else{
            System.out.println("====== SERVIÇOS DISPONÍVEIS ======");
            for(ServicoPreExecutado valido: pre_executados_pelo_profissional){
                System.out.printf("[%d] %s\n", cont, valido.getTipoServico());
                System.out.println("Valor cobrado: R$ "+valido.getPreco());
                System.out.println("Nome de usuário do cliente: "+valido.getNome_usuario_cliente());
                cont++;
                System.out.println("---------------------------------");
            }
            System.out.println("==============================");
            do{
                System.out.print("Escolha uma opção: ");
                opcao = teclado.nextInt();
                System.out.println("---------------------------------");
                if(opcao > t_servico || opcao < 1){
                    System.out.println("Opção inválida, por favor escolha uma opção válida");
                }
            }while(opcao > t_servico || opcao < 1);//Se a opção escolhida não for válida
            return pre_executados_pelo_profissional.get(t_servico-1);
        }
    }
}
