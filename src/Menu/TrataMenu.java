package Menu;

import Sistema.*;
import static Menu.ExibeMenu.exibeMenuCadastro;

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
}
