package Sistema;

import Concretos.Servico;

public abstract class LogicaServico {
    public static void cadastraServicoInativo(int choice, DadosDoSistema dados){
        String tipo_servico = "";
        switch (choice){
            case 1:
                tipo_servico = "manutenção preventiva";
                break;
            case 2:
                tipo_servico = "formatação";
                break;
            case 3:
                tipo_servico = "backup";
                break;
            case 4:
                tipo_servico = "recuperação de arquivos";
                break;
            case 5:
                tipo_servico = "instalação de programas";
                break;
            case 6:
                tipo_servico = "troca de peças de desktop";
                break;
            case 7:
                tipo_servico = "troca de peças de nootebook";
                break;
            case 8:
                tipo_servico = "troca de peças de celulares";
                break;
        }
        Servico servico = new Servico(tipo_servico);
        //Agora vem a parte chata...
    }


}
