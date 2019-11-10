package Menu;

import Servicos.ServicoPreExecutado;
import Servicos.ServicoValido;
import Servicos.ServicoValidoComPrestador;
import Sistema.*;
import static Menu.ExibeMenu.*;
import static Sistema.LogicaServico.*;
import static Sistema.LogicaSistema.identificaServicoASerExecutado;

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
                fazerPedidoCliente(); //Cliente faz pedido de algum serviço que esteja ativo.
                break;
            case 3:
                consultarPedidosCliente(master_sistema); //Cliente vê quais pedidos ele fez e que ainda não foram executados, por pedidos que ele já fez e já foram executados
                break;
            case 4:
                master_sistema.systemLeave(); //Sair
                break;
        }
    }

    private static void fazerPedidoCliente() {
        if(master_sistema.getDados().getServicos_confirmados_com_prestador().size() > 0){
            fazerPedido(master_sistema);
        }
        else{
            System.out.println("Não existe nenhum serviço para você realizar um pedido");
        }
    }


    public static void tratarMenuProfissional(int opcao){
        int choice;
        switch(opcao){
            case 1:
                choice = exibeMenuServicos();
                cadastraServicoInativo(choice, master_sistema.getDados());//Cadastrar um novo serviço como inativo
                break;
            case 2:
                darPrecoNumServicoValido(master_sistema);//Cadastrar um novo pedido com prestador
                break;
            case 3:
                //Executar pedidos que já tenha um cliente confirmado
                ServicoPreExecutado servico_pre_executado = identificaServicoASerExecutado(master_sistema);
                executarServico(master_sistema, servico_pre_executado);
                break;
            case 4:
                pesquisarPedidosComPrecosCadastradosENaoExecutados(master_sistema);//Pesquisar pedidos que cadastrou-se um preço
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

    public static ServicoValidoComPrestador tratarMenuServicosComPrestador(int op){
        return encontrarServicoComPrestador(op, master_sistema);
    }
}
