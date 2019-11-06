package Menu;

import Sistema.*;
import static Menu.ExibeMenu.exibeMenuCadastro;
import static Menu.ExibeMenu.exibeMenuCliente;
import static Sistema.LogicaServico.cadastraServico;

public abstract class TrataMenu {
    public static void tratarMenuGeral(int opcao, LogicaSistema sistema){
        switch (opcao){
            case 1:
                sistema.tratarLogin();
                break;
            case 2:
                int opcao_menu_geral = exibeMenuCadastro();
                sistema.tratarCadastro(opcao_menu_geral);
                break;
            case 3:
                sistema.systemLeave();
        }
    }

    public static void tatarMenuCliente(int opcao) {
        switch(opcao){
            case 1:
                cadastraServico();
                break;
        }
    }

    public static void tratarMenuProfissional(int opcao){

    }

    public static void tratarMenuAdministrador(int opcao){

    }
}
