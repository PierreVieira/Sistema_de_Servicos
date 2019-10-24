package Principal;

import Sistema.DadosDoSistema;

import static Menu.ExibeMenu.exibeMenuGeral;
import static Menu.TrataMenu.tratarMenuGeral;


public class Main {
    public static void main(String[] args) {
        int opcao;
        DadosDoSistema dados = new DadosDoSistema();
        opcao = exibeMenuGeral();
        tratarMenuGeral(opcao);
    }
}
