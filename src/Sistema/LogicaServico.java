package Sistema;

import Servicos.ServicoValido;
import Servicos.ServicoInativo;

import java.util.Scanner;

import static Menu.ExibeMenu.exibeMenuNovoNome;
import static Menu.TrataMenu.tratarMenuNovoNome;

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
}
