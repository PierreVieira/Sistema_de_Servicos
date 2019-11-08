package Menu;

import Sistema.*;
import static Menu.ExibeMenu.*;
import static Sistema.LogicaServico.cadastraServicoInativo;

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
        int choice;
        switch(opcao){
            case 1:
                choice = exibeMenuServicos();
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
        int choice;
        switch(opcao){
            case 1:
                choice = exibeMenuServicos();
                cadastraServicoInativo(choice, master_sistema.getDados());//Cadastrar um serviço como inativo
                break;
            case 2:
                //Selecionar um serviço informando o preço que cobra
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
        int choice;
        switch (opcao){
            case 1:
                master_sistema.tratarCadastro(1); //Cadastrar um novo administrador
                break;
            case 2:
                choice = exibeMenuServicos();
                cadastraServicoInativo(choice, master_sistema.getDados());//Cadastrar um serviço como inativo
                break;
            case 3:
                //Validar um serviço que já foi cadastrado
                break;
            case 4:
                //Listar pedidos
                break;
            case 5:
                master_sistema.systemLeave(); //Sair
                break;
        }
    }
}
