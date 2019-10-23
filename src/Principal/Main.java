package Principal;

import static Menu.ExibeMenu.exibeMenuGeral;
import static Menu.TrataMenu.tratarMenuGeral;


public class Main {
    public static void main(String[] args) {
        int opcao;
        opcao = exibeMenuGeral();
        tratarMenuGeral(opcao);
    }
}
