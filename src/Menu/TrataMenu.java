package Menu;

import Sistema.*;
import static Menu.ExibeMenu.*;
import static Sistema.LogicaServico.*;

public abstract class TrataMenu {
    private static LogicaSistema master_sistema;
    public static void tratarMenuGeral(int opcao, LogicaSistema sistema){
        master_sistema = sistema;
        switch (opcao){
            case 1:
                master_sistema.tratarLogin();
                break;
            case 2:
                int opcao_menu_geral = exibeMenuCadastro();
                master_sistema.tratarCadastro(opcao_menu_geral);
                break;
            case 3:
                sistema.systemLeave();
        }
    }

    public static void tatarMenuCliente(int opcao) {
        switch(opcao){
            case 1:
                int choice = exibeMenuServicos();
                cadastraServicoInativo(choice, master_sistema.getDados());//Cadastrar um novo serviço como inativo
                break;
            case 2:
                //Cliente faz pedido de algum serviço que esteja ativo.
                break;
            case 3:
                //Cliente vê quais pedidos ele fez e que ainda não foram executados
                break;
            case 4:
                master_sistema.systemLeave(); //Sair
                break;
        }
    }


    public static void tratarMenuProfissional(int opcao){
        switch(opcao){
            case 1:
                int choice = exibeMenuServicos();
                cadastraServicoInativo(choice, master_sistema.getDados());//Cadastrar um novo serviço como inativo
                break;
            case 2:
                //Selecionar um serviço sem informando o preço que cobra
                break;
            case 3:
                //Executar pedidos que já tenha um cliente confirmado
                break;
            case 4:
                //Pesquisar pedidos que cadastrou-se um preço
                break;
            case 5:
                master_sistema.systemLeave(); //Sair
                break;
        }
    }

    public static void tratarMenuAdministrador(int opcao){
        switch (opcao){
            case 1:
                master_sistema.tratarCadastro(1); //Cadastrar um novo administrador
                break;
            case 2:
                int choice = exibeMenuServicos();
                cadastraServicoInativo(choice, master_sistema.getDados());//Cadastrar um serviço como inativo
                break;
            case 3:
                listarServicosInativos(master_sistema.getDados());
                int op = exibeMenuValidacao();
                tratarMenuValidacao(op);
                break;
            case 4:
                //Listar pedidos
                break;
            case 5:
                master_sistema.systemLeave(); //Sair
                break;
        }
    }

    private static void tratarMenuValidacao(int op) {
        listarServicosInativos(master_sistema.getDados());
        switch (op){
            case 1:
                validarUmServicoInativo(master_sistema.getDados());
                break;
            case 2:
                renomearUmServicoInativo(master_sistema.getDados());
                break;
            case 3:
                removerUmServicoInativo(master_sistema.getDados());
                break;
        }
    }

    public static String tratarMenuNovoNome(int op){
        System.out.println("[1] Manutenção preventiva");
        System.out.println("[2] Formatação");
        System.out.println("[3] Backup");
        System.out.println("[4] Recuperação de arquivos");
        System.out.println("[5] Instalação de programas");
        System.out.println("[6] Troca de peças de desktops");
        System.out.println("[7] Troca de peças de notebooks");
        System.out.println("[8] Troca de peças de celulares");
        String novo_nome = "";
        switch(op){
            case 1:
                novo_nome = "Manutenção preventiva";
                break;
            case 2:
                novo_nome = "Formatação";
                break;
            case 3:
                novo_nome = "Backup";
                break;
            case 4:
                novo_nome = "Recuperação de arquivos";
                break;
            case 5:
                novo_nome = "Instalação de programas";
                break;
            case 6:
                novo_nome = "Troca de peças de desktops";
                break;
            case 7:
                novo_nome = "Troca de peças de notebooks";
                break;
            case 8:
                novo_nome = "Troca de peças de celulares";
                break;
        }
        return novo_nome;
    }
}
