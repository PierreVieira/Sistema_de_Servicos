//Antônio Pierre Maritns Vieira
//Eduardo Vinícius Silva de Lima
//Thiago Danilo Souza Pereira
package Principal;

import Sistema.DadosDoSistema;
import Sistema.LogicaSistema;

import static Menu.ExibeMenu.exibeMenuGeral;
import static Menu.TrataMenu.tratarMenuGeral;


public class Main {
    public static void main(String[] args) {
        int opcao;
        DadosDoSistema dados = new DadosDoSistema();//Por enquanto tem como logar com varios usuarios ao mesmo tempo
        LogicaSistema sistema = new LogicaSistema(dados);
        while (true) {
            opcao = exibeMenuGeral();
            tratarMenuGeral(opcao, sistema);
        }
    }
}
