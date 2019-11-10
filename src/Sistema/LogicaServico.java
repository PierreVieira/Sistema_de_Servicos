package Sistema;

import Servicos.*;
import Usuarios.Cliente;
import Usuarios.Profissional;

import java.util.Scanner;

import static Menu.ExibeMenu.*;
import static Menu.TrataMenu.tratarMenuNovoNome;
import static Menu.TrataMenu.tratarMenuServicosComPrestador;

public abstract class LogicaServico {
    public static void cadastraServicoInativo(int choice, DadosDoSistema dados){
        String tipo_servico = "";
        switch (choice){
            case 1:
                tipo_servico = "Manutenção preventiva";
                break;
            case 2:
                tipo_servico = "Formatação";
                break;
            case 3:
                tipo_servico = "Backup";
                break;
            case 4:
                tipo_servico = "Recuperação de arquivos";
                break;
            case 5:
                tipo_servico = "Instalação de programas";
                break;
            case 6:
                tipo_servico = "Troca de peças de desktop";
                break;
            case 7:
                tipo_servico = "Troca de peças de nootebook";
                break;
            case 8:
                tipo_servico = "Troca de peças de celulares";
                break;
        }
        ServicoInativo servico_inativo = new ServicoInativo(tipo_servico);//Criamos um serviço inativo
        dados.getServicos_inativos().add(servico_inativo);
    }

    public static void validarUmServicoInativo(DadosDoSistema dados){
        ServicoInativo servico;
        servico = obterServico(dados, "validar");
        dados.getServicos_inativos().remove(servico);//Remove do banco de dados o serviço com o nome informado
        ServicoValido servico_ativo = new ServicoValido(servico.getTipoServico());
        dados.getServicos_validos().add(servico_ativo);//cofirma-se o pedido
    }

    public static void renomearUmServicoInativo(DadosDoSistema dados){
        ServicoInativo servico_a_ser_renomeado, servico_renomeado;
        servico_renomeado = new ServicoInativo("");
        int op;
        servico_a_ser_renomeado = obterServico(dados, "renomear");
        servico_renomeado.setTipoServico(servico_a_ser_renomeado.getTipoServico());
        op = exibeMenuNovoNome();
        servico_renomeado.setTipoServico(tratarMenuNovoNome(op));//Temos aqui um novo serviço
        //Renomeando
        dados.getServicos_inativos().remove(servico_a_ser_renomeado);//Remove
        dados.getServicos_inativos().add(servico_renomeado);//Adiciona
    }

    public static void removerUmServicoInativo(DadosDoSistema dados){
        ServicoInativo servico_inativo = obterServico(dados, "remover");
        dados.getServicos_inativos().remove(servico_inativo);
    }

    private static ServicoInativo obterServico(DadosDoSistema dados, String option) {
        Scanner teclado = new Scanner(System.in);
        ServicoInativo servico;
        String nome_servico;
        int index_fake;
        //O adminstrador informa o nome de um serviço que está inativo
        do{
            System.out.print("Informe o número do serviço que está inativo e deseja "+option+": ");
            index_fake = teclado.nextInt();
        }while(dados.getServicos_inativos().size() < index_fake || index_fake < 1);//Verfica se o serviço informado existe
        nome_servico = dados.getServicos_inativos().get(index_fake-1).getTipoServico();
        servico = new ServicoInativo(nome_servico);//Cria-se um serviço com o nome informado
        return servico;
    }

    public static void listarServicosInativos(DadosDoSistema dados){
        int cont = 1;
        if(dados.getServicos_inativos().size() != 0){
            System.out.println("====== SERVIÇOS INATIVOS ======");
            for(ServicoInativo inativo: dados.getServicos_inativos()){
                System.out.printf("[%d] %s\n", cont, inativo.getTipoServico());
                cont++;
            }
            System.out.println("================================");
        }
        else{
            System.out.println("Não existem serviços inativos na plataforma");
        }
    }

    public static void darPrecoNumServicoValido(LogicaSistema sistema) {
        Scanner teclado = new Scanner(System.in);
        int choice;
        double preco;
        if(sistema.getDados().getServicos_validos().size() == 0){
            System.out.println("Não há nenhum serviço aceito por um administrador para você dar o preço");
        }
        else{
            choice = escolheServicoAtivo(sistema);
            ServicoValido valido = obter_servico_valido(choice, sistema);
            removerUmServicoValido(valido, sistema);
            System.out.print("Informe um preço que irá cobrar para o serviço selecionado R$: ");
            preco = teclado.nextDouble();
            inserirUmServicoComPrestador(valido, preco, sistema);
        }
    }

    private static void inserirUmServicoComPrestador(ServicoValido valido, double preco, LogicaSistema sistema) {
        Profissional profissional;
        profissional = (Profissional) sistema.pegaUsuarioLogado();//Encontra o profissional que está logado no sistema
        assert profissional != null;
        ServicoValidoComPrestador valido_com_prestador = new ServicoValidoComPrestador(valido.getTipoServico(), profissional.getNomeUsuario(), preco);
        sistema.getDados().getServicos_confirmados_com_prestador().add(valido_com_prestador);//Insere um novo serviço com preço
    }

    public static void pesquisarPedidosComPrecosCadastradosENaoExecutados(LogicaSistema sistema) {
        Profissional profissional = (Profissional) sistema.pegaUsuarioLogado();
        assert profissional != null;
        //Pesquisa por serviços que não tem cliente
        for (ServicoValidoComPrestador servico: sistema.getDados().getServicos_confirmados_com_prestador()){
            if(servico.getNome_usuario_profissional().equals(profissional.getNomeUsuario())){
                System.out.println("[Serviço sem cliente]\nTipo de serviço: "+servico.getTipoServico()+"\nPreço cobrado R$: "+servico.getPreco());
                System.out.println("--------------------------------------------");
            }
        }
        //Pesquisa por seviços que já tem um cliente
        for (ServicoPreExecutado servico: sistema.getDados().getServicos_pre_executados()){
            if(servico.getNome_usuario_profissional().equals(profissional.getNomeUsuario())){
                System.out.println("[Serviço com cliente]\nTipo de serviço: "+servico.getTipoServico()+"\nPreço cobrado R$: "+servico.getPreco());
                System.out.println("Nome de usuário do cliente: "+servico.getNome_usuario_cliente());
                System.out.println("--------------------------------------------");
            }
        }
    }

    public static void consultarPedidosCliente(LogicaSistema sistema){
        Cliente cliente = (Cliente) sistema.pegaUsuarioLogado();
        assert cliente != null;
        //Pesquisar por serviços que ainda não foram finalizdos
        for (ServicoPreExecutado servico: sistema.getDados().getServicos_pre_executados()){
            if(servico.getNome_usuario_cliente().equals(cliente.getNomeUsuario())){
                System.out.println("[Não finalizado]");
                System.out.println("Tipo de serviço: "+servico.getTipoServico()+"\nPreço cobrado R$: "+servico.getPreco());
                System.out.println("Nome de usuário do profissional: "+servico.getNome_usuario_profissional());
                System.out.println("--------------------------------------------");
            }
        }
        //Pesquisa por pedidos que fez e já foram finalizados
        for (ServicoExecutado servico: sistema.getDados().getServicos_executados()){
            if(servico.getNome_usuario_cliente().equals(cliente.getNomeUsuario())){
                System.out.println("[Finalizado]");
                System.out.println("Tipo de serviço: "+servico.getTipoServico()+"\nPreço cobrado R$: "+servico.getPreco());
                System.out.println("Nome de usuário do profissional: "+servico.getNome_usuario_profissional());
                System.out.println("--------------------------------------------");
            }
        }
    }

    private static void removerUmServicoValido(ServicoValido valido, LogicaSistema sistema) {
        sistema.getDados().getServicos_validos().remove(valido);
    }

    private static ServicoValido obter_servico_valido(int choice, LogicaSistema sistema) {
        return sistema.getDados().getServicos_validos().get(choice-1);
    }

    private static int escolheServicoAtivo(LogicaSistema sistema) {
        return exibeMenuServicosAtivos(sistema.getDados().getServicos_validos());
    }

    public static void fazerPedido(LogicaSistema sistema){
        Cliente cliente = (Cliente) sistema.pegaUsuarioLogado();
        int option = exibeMenuServicosComPrestador(sistema.getDados().getServicos_confirmados_com_prestador());
        ServicoValidoComPrestador servico_com_prestador = tratarMenuServicosComPrestador(option);
        removerUmServicoComPrestador(servico_com_prestador, sistema);
        adicionarUmServicoComPrestadorECliente(servico_com_prestador, cliente.getNomeUsuario(), sistema);
    }

    private static void adicionarUmServicoComPrestadorECliente(ServicoValidoComPrestador servico_com_prestador, String nick_cliente, LogicaSistema sistema) {
        //                                                      (String tipo_servico, String nome_usuario_profissional, double preco, String nome_usuario_cliente)
        sistema.getDados().getServicos_pre_executados().add(new ServicoPreExecutado(servico_com_prestador.getTipoServico(), servico_com_prestador.getNome_usuario_profissional(), servico_com_prestador.getPreco(), nick_cliente));
    }

    private static void removerUmServicoComPrestador(ServicoValidoComPrestador servico_com_prestador, LogicaSistema sistema) {
        sistema.getDados().getServicos_confirmados_com_prestador().remove(servico_com_prestador);
    }

    public static ServicoValidoComPrestador encontrarServicoComPrestador(int op, LogicaSistema sistema){
        return sistema.getDados().getServicos_confirmados_com_prestador().get(op - 1);
    }
}
